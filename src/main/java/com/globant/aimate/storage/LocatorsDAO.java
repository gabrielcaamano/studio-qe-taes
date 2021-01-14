package com.globant.aimate.storage;

import com.globant.aimate.model.CachedElementAttributes;
import com.globant.aimate.model.LocatorModel;
import com.globant.aimate.utils.AIMateProperties;
import com.globant.aimate.generator.LocatorGenerator;
import com.globant.aimate.model.AIMateException;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocatorsDAO {

	private final Logger logger = LoggerFactory.getLogger(LocatorsDAO.class);

	private static final String IDENTIFIER = "identifier";
	private static final String TIMESTAMP = "timestamp";
	private static final String TIMESUSED = "timesUsed";
	private static final String BYS = "bys";
	private static final String CONTEXT = "context";
	private static final String UNSUCCESSFUL_INTERVENTION = "UnsuccessfulIntervention";

	private static final String DRIVER_CLASS = "driverClass";
	private static final String PLATFORM = "platform";
	private static final String ORIENTATION = "orientation";
	private static final String APP_TYPE = "appType";
	private static final String NODE_TAG = "nodeTag";
	private static final String PARENT = "parent";
	private static final String IFRAME = "iframe";
	private static final String SIBLING = "sibling";
	private static final String CHILDREN = "children";
	private static final String AMOUNT_OF_NODE_LEVELS = "amountOfNodeLevels";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String TYPE = "type";
	private static final String STYLE = "style";
	private static final String VALUE = "value";
	private static final String ALT = "alt";
	private static final String CLAZZ = "clazz";
	private static final String HREF = "href";
	private static final String OUTER_HTML = "outerHtml";
	private static final String SRC = "src";
	private static final String TEXT = "text";
	private static final String URL = "url";
	

	private static String firestoreFileName = "/FirestoreKeys.json";
	private static LocatorsDAO instance;
	private Duration cacheTimeToLiveMillis;
	private int cacheUsagesExpiration;
	private AIMateProperties properties;
	private Firestore db;
	private String userDir;
	private String firestoreKeysDir;

	private LocatorsDAO() throws IOException, AIMateException {
	    userDir = System.getProperty("user.dir");
	    firestoreKeysDir = userDir.concat(firestoreFileName);

	    if(!new File(firestoreKeysDir).isFile()){
	        Writer writer = new FileWriter(firestoreKeysDir);
	        Gson gson = new GsonBuilder().create();
	        gson.toJson(new DefaultFirestoreKeys(), writer);
	        writer.flush();
	        writer.close();
	    }

	    InputStream serviceAccount = new FileInputStream(firestoreKeysDir);
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
				.setCredentials(credentials).setProjectId("iamate").build();
		Firestore fsDb = firestoreOptions.getService();
		this.db = fsDb;

		properties = AIMateProperties.getInstance();
		cacheTimeToLiveMillis = Duration.ofMillis(properties.getInteger("aimate.cache.timetolive"));
		cacheUsagesExpiration = properties.getInteger("aimate.cache.usagesexpiration");
	}
	
	public static synchronized LocatorsDAO getInstance() throws IOException, AIMateException {
		if(instance == null) {
			instance = new LocatorsDAO();
		}
		return instance;
	}

	public void createOrUpdateWebElement(String identifier, By by, WebDriver driver)
			throws InterruptedException, ExecutionException, AIMateException {

		if (!doesElementExist(identifier)) {
			addNewWebElement(identifier, by, driver);
		} else if (isTimestampCacheExpired(identifier) || isTimesUsedCacheExpired(identifier)) {
			updateWebElementLocators(identifier, by, driver);
		} else {
			updateWebElementTimesUsed(identifier);
		}
	}

	private void addNewWebElement(String identifier, By by, WebDriver driver) throws AIMateException, ExecutionException, InterruptedException {
		Date date = new Date();
		long timestamp = date.getTime();

		Map<String, Object> dataToInsert = new HashMap<>();
		dataToInsert.put(IDENTIFIER, identifier);
		dataToInsert.put(TIMESTAMP, timestamp);
		dataToInsert.put(TIMESUSED, 0);
		dataToInsert.put(UNSUCCESSFUL_INTERVENTION, 0);

		CachedElementAttributes cachingElement = getElementAttributes(by, driver);
		dataToInsert.put(CONTEXT, getElementContext(driver, cachingElement));
		
		logger.debug("The context of the element is: " + dataToInsert.get(CONTEXT));

		ArrayList<String> bysSerialized = serialize(cachingElement, driver);
		dataToInsert.put(BYS, bysSerialized);

		db.collection("objects").add(dataToInsert);
		logger.info("Alternative locators for " + identifier +" are : "+ bysSerialized);
	}

	private Map<String, Object> getElementContext(WebDriver driver, CachedElementAttributes cachingElement) throws AIMateException {
		Map<String, Object> context = new HashMap<>();
		context.put(DRIVER_CLASS, driver.getClass().getCanonicalName());
		Dimension windowSize = driver.manage().window().getSize();
		context.put(ORIENTATION, windowSize.getHeight() > windowSize.getWidth()? "portrait" : "landscape");
		context.put(NODE_TAG, cachingElement.getTag());

		CachedElementAttributes iframeElementAttributes = cachingElement.getIframelement();
		if(iframeElementAttributes != null) {
			driver.switchTo().defaultContent();

			Map<String, Object> iframeMap = mapCachedElementAttributes(iframeElementAttributes);
			iframeMap.put(BYS, serializeLocatorsToJson(iframeElementAttributes.getLocators()));
			context.put(IFRAME, iframeMap);

			driver.switchTo().frame(cachingElement.getWebElementIframe());
		}else{
			context.put(IFRAME, null);
		}

		context.put(PARENT, mapCachedElementAttributes(cachingElement.getParentElement()));
		context.put(SIBLING, mapCachedElementAttributesList(cachingElement.getSiblingElements()));
		context.put(CHILDREN, mapCachedElementAttributesList(cachingElement.getChildElements()));
		context.put(AMOUNT_OF_NODE_LEVELS, cachingElement.getAmountOfNodeLevels());

		if(driver instanceof AndroidDriver) {
			AndroidDriver androidDriver = (AndroidDriver) driver;
			context.put(PLATFORM, androidDriver.getCapabilities().getPlatform().toString());
			context.put(APP_TYPE, androidDriver.getContextHandles().size() == 1? "native" : "hybrid");
		} else if(driver instanceof IOSDriver) {
			IOSDriver iosDriver = (IOSDriver) driver;
			context.put(PLATFORM, iosDriver.getCapabilities().getPlatform().toString());
			context.put(APP_TYPE, iosDriver.getContextHandles().size() == 1? "native" : "hybrid");
		} else if(driver instanceof ChromeDriver) {
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			context.put(PLATFORM, chromeDriver.getCapabilities().getPlatform().toString());
			context.put(APP_TYPE, "web");
		} else if(driver instanceof FirefoxDriver) {
			FirefoxDriver ffDriver = (FirefoxDriver) driver;
			context.put(PLATFORM, ffDriver.getCapabilities().getPlatform().toString());
			context.put(APP_TYPE, "web");
		}
		return context;
	}

	private List<Map<String, Object>> mapCachedElementAttributesList(List<CachedElementAttributes> cachingElement){
		List<Map<String, Object>> childMapList = new ArrayList<>();

		for(CachedElementAttributes childElement: cachingElement){
			childMapList.add(mapCachedElementAttributes(childElement));
		}

		return childMapList;
	}

	private Map<String, Object> mapCachedElementAttributes(CachedElementAttributes cachingElement){
		Map<String, Object> cachingElementMap = new HashMap<>();
		cachingElementMap.put(ID, cachingElement.getId());
		cachingElementMap.put(NAME, cachingElement.getName());
		cachingElementMap.put(NODE_TAG, cachingElement.getTag());
		cachingElementMap.put(TYPE, cachingElement.getType());
		cachingElementMap.put(STYLE, cachingElement.getStyle());
		cachingElementMap.put(VALUE, cachingElement.getValue());
		cachingElementMap.put(ALT, cachingElement.getAlt());
		cachingElementMap.put(CLAZZ, cachingElement.getClazz());
		cachingElementMap.put(HREF, cachingElement.getHref());
		cachingElementMap.put(OUTER_HTML, cachingElement.getOuterhtml());
		cachingElementMap.put(SRC, cachingElement.getSrc());
		cachingElementMap.put(TEXT, cachingElement.getText());
		cachingElementMap.put(URL, cachingElement.getUrl());
		return cachingElementMap;
	}

	public ArrayList<LocatorModel> getElementLocatorsFromDB(String identifier)
			throws InterruptedException, ExecutionException {

		CollectionReference objects = db.collection("objects");
		Query query = objects.whereEqualTo(IDENTIFIER, identifier);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();

		ArrayList<LocatorModel> locatorsArray = new ArrayList<>();
		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

			@SuppressWarnings("unchecked")
			ArrayList<String> locators = (ArrayList<String>) document.get(BYS);
			locatorsArray.addAll(serializeLocatorsFromJson(locators));
		}
		return locatorsArray;
	}

	public ArrayList<LocatorModel> getLocatorsFromIframeFromDB(String identifier)
			throws InterruptedException, ExecutionException {

		CollectionReference objects = db.collection("objects");
		Query query = objects.whereEqualTo(IDENTIFIER, identifier);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();

		ArrayList<LocatorModel> locatorsArray = new ArrayList<>();
		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

			@SuppressWarnings("unchecked")
			Map<String, Object> context = (Map<String, Object>) document.get(CONTEXT);
			@SuppressWarnings("unchecked")
			Map<String, Object> iframeMap = (Map<String, Object>) context.get(IFRAME);

			if (iframeMap!=null) {
				locatorsArray.addAll(serializeLocatorsFromJson((ArrayList<String>) iframeMap.get(BYS)));
			}
		}
		return locatorsArray;
	}

	private List<LocatorModel> returnLocatorsListBy(CachedElementAttributes cachingElement, WebDriver driver) throws AIMateException {
		LocatorGenerator generator = new LocatorGenerator(driver);
		return generator.generateAlternativeLocators(cachingElement);
	}

	private void updateWebElementLocators(String identifier, By by, WebDriver driver)
			throws InterruptedException, ExecutionException, AIMateException {

		Date date = new Date();
		long timestamp = date.getTime();

		CollectionReference objects = db.collection("objects");
		Query query = objects.whereEqualTo(IDENTIFIER, identifier);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();

		CachedElementAttributes cachingElement = getElementAttributes(by, driver);
		ArrayList<String> bysSerialized = serialize(cachingElement, driver);

		Map<String, Object> updates = new HashMap<>();
		updates.put(TIMESTAMP, timestamp);
		updates.put(BYS, bysSerialized);
		updates.put(TIMESUSED, 0);

		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
			DocumentReference docRef = db.collection("objects").document(document.getId());
			docRef.update(updates);
		}

		logger.info("Alternative locators for " + identifier +" are : "+ bysSerialized);
		
	}

	private boolean doesElementExist(String identifier) throws InterruptedException, ExecutionException {
		boolean elementExists = false;

		CollectionReference objects = db.collection("objects");
		Query query = objects.whereEqualTo(IDENTIFIER, identifier);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
			String documentId = document.getId();
			if (!documentId.isEmpty()) {
				elementExists = true;
			}
		}
		return elementExists;
	}

	private long getElementTimestamp(String identifier) throws InterruptedException, ExecutionException {
		long timestamp = 0;

		CollectionReference objects = db.collection("objects");
		Query query = objects.whereEqualTo(IDENTIFIER, identifier);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
			timestamp = document.getLong(TIMESTAMP);
		}
		return timestamp;
	}

	private long getElementTimesUsed(String identifier) throws InterruptedException, ExecutionException {
		long timesUsed = 0;
		CollectionReference objects = db.collection("objects");
		Query query = objects.whereEqualTo(IDENTIFIER, identifier);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
			String documentId = document.getId();
			if (!documentId.isEmpty()) {
				timesUsed = document.getLong(TIMESUSED);
			}
		}
		return timesUsed;
	}

	private boolean isTimestampCacheExpired(String identifier) throws InterruptedException, ExecutionException {
		long elementTimestamp = getElementTimestamp(identifier);
		Date date = new Date();
		long actualTimestamp = date.getTime();
		return actualTimestamp - elementTimestamp > cacheTimeToLiveMillis.toMillis();
	}

	private boolean isTimesUsedCacheExpired(String identifier) throws InterruptedException, ExecutionException {
		long timesUsed = getElementTimesUsed(identifier);
		return timesUsed >= cacheUsagesExpiration;
	}

	private void updateWebElementTimesUsed(String identifier) throws InterruptedException, ExecutionException {
		CollectionReference objects = db.collection("objects");
		Query query = objects.whereEqualTo(IDENTIFIER, identifier);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
			DocumentReference docRef = db.collection("objects").document(document.getId());
			long currentTimesUsed = (long) document.get(TIMESUSED);
			docRef.update(TIMESUSED, currentTimesUsed + 1);
		}
	}

	private ArrayList<String> serialize(CachedElementAttributes cachingElement, WebDriver driver) throws AIMateException, ExecutionException, InterruptedException {
		List<LocatorModel> locatorsList = returnLocatorsListBy(cachingElement, driver);
		return serializeLocatorsToJson(locatorsList);
	}

	private ArrayList<String> serializeLocatorsToJson(List<LocatorModel> locatorsList)  {
		ArrayList<String> bysSerialized = new ArrayList<>();
		for (LocatorModel locator: locatorsList){
			GsonBuilder gsonBilder = new GsonBuilder();
			gsonBilder.registerTypeHierarchyAdapter(By.class, new InterfaceAdapter<By>());
			gsonBilder.setPrettyPrinting();
			Gson gson = gsonBilder.create();
			String bySerialized = gson.toJson(locator);
			bysSerialized.add(bySerialized);
		}
		return bysSerialized;
	}

	private ArrayList<LocatorModel> serializeLocatorsFromJson(List<String> locatorsList)  {
		ArrayList<LocatorModel> bysSerialized = new ArrayList<>();
		for (String locatorString: locatorsList){
			GsonBuilder gsonBilder = new GsonBuilder();
			gsonBilder.registerTypeAdapter(By.class, new InterfaceAdapter<By>());
			gsonBilder.setPrettyPrinting();
			Gson gson = gsonBilder.create();
			LocatorModel locator = gson.fromJson(locatorString, LocatorModel.class);
			bysSerialized.add(locator);
		}

		return bysSerialized;
	}

	public void updateDBBysOfLocators(String identifier, List<LocatorModel> locators, List<Integer> countUnsuccessfulInterventionList) throws InterruptedException, ExecutionException {
		ArrayList<String> bysSerialized = serializeLocatorsToJson(locators);

		CollectionReference objects = db.collection("objects");
		Query query = objects.whereEqualTo(IDENTIFIER, identifier);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
			DocumentReference docRef = db.collection("objects").document(document.getId());
			docRef.update(BYS, bysSerialized);
			long currentUnsuccessfulIntev = (long) document.get(UNSUCCESSFUL_INTERVENTION);
			if (countUnsuccessfulInterventionList.size()==1) {
				docRef.update(UNSUCCESSFUL_INTERVENTION, currentUnsuccessfulIntev + 1);
			}
		}	
	}

	private CachedElementAttributes getElementAttributes(By by, WebDriver driver) throws AIMateException {
		LocatorGenerator generator = new LocatorGenerator(driver);
		return generator.getElementAttributes(driver, by);
	}

}