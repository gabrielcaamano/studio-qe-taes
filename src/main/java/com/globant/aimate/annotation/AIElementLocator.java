package com.globant.aimate.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.globant.aimate.model.LocatorModel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.globant.aimate.storage.LocatorsDAO;
import io.appium.java_client.pagefactory.locator.CacheableLocator;

public class AIElementLocator implements CacheableLocator {

	private final Logger logger = LoggerFactory.getLogger(AIElementLocator.class);

	private boolean shouldCache;
	private WebDriver driver;
	private SearchContext context;
	private List<LocatorModel> locators;
	private List<LocatorModel> iframeLocators;
	private final String identifier;
	private WebElement cachedElement;
	private static WebElement result2;
	private List<WebElement> cachedElementList;
	private int countUnsuccessfulIntervention;
	private List<Integer> countUnsuccessfulInterventionList = new ArrayList<Integer>();

	public AIElementLocator(WebDriver driver, SearchContext context, Field field) {
		super();
		this.cachedElement = null;
		this.shouldCache = false;
		this.driver = driver;
		this.context = context;
		this.shouldCache = field.getAnnotation(CacheLookup.class) != null;

		AIFindBy annotation = field.getAnnotation(AIFindBy.class);
		By by = AIFindBy.AIFindByUtils.buildBy(annotation);
		locators = new ArrayList<>();
		LocatorModel locator = new LocatorModel();
		locator.setBy(by);
		locator.setOriginalBy(by);
		locators.add(locator);
		identifier = (field.getDeclaringClass().getCanonicalName() + "$" + field.getName());
	}

	@Override
	public boolean isLookUpCached() {
		return shouldCache;
	}

	@Override
	public WebElement findElement() {
		if (cachedElement != null && shouldCache) {
			return cachedElement;
		}

		updateDBLocators();

		WebElement iframe = getWebElementIframe();

		if (iframe != null) {
			driver.switchTo().frame(iframe);
		}
		int countFoundLocators = 0;
		for (LocatorModel locator : locators) {
			try {
				long startTime = System.currentTimeMillis();
				logger.debug("Execution timestamp: " + startTime);
				result2 = context.findElement(locator.getBy());
				long endTime = System.currentTimeMillis();

				locator.setResponseTime(endTime - startTime);
				if (locator.getBy() != locator.getOriginalBy()) {
				locator.setFound(locator.getFound() + 1);
				}
				logger.info("The Strategy used to locate this element was: " + locator.getStrategyClass());

				updateDBBysOfLocators();

				if (shouldCache) {
					cachedElement = result2;
				}

				logger.info("Element " + identifier + " found with locator " + locator.getBy());
				countFoundLocators++;
				//return result;

			} catch (NoSuchElementException e) {
				if (locator.getBy() != locator.getOriginalBy()) {
					locator.setNonFound(locator.getNonFound() + 1);
				}
				logger.info("Element " + identifier + " not found with locator " + locator.getBy());
			}
		}

		if (locators.size() > 0 && countFoundLocators==0) {
			countUnsuccessfulIntervention = countUnsuccessfulIntervention + 1;
			countUnsuccessfulInterventionList.add(countUnsuccessfulIntervention);
			updateDBBysOfLocators();
		}

		return result2;
		//throw new NoSuchElementException("Could not find element " + identifier);
	}

	@Override
	public List<WebElement> findElements() {
		if (cachedElementList != null && shouldCache) {
			return cachedElementList;
		}

		updateDBLocators();

		WebElement iframe = getWebElementIframe();

		if (iframe != null) {
			driver.switchTo().frame(iframe);
		}

		for (LocatorModel locator : locators) {
			try {
				long startTime = System.currentTimeMillis();
				logger.debug("Execution timestamp: " + startTime);
				List<WebElement> results = context.findElements(locator.getBy());
				long endTime = System.currentTimeMillis();

				locator.setResponseTime(endTime - startTime);
				if (locator.getBy() != locator.getOriginalBy()) {
				locator.setFound(locator.getFound() + 1);
				}				
				logger.info("The Strategy used to locate this element was: " + locator.getStrategyClass());

				updateDBBysOfLocators();

				if (shouldCache) {
					cachedElementList = results;
				}

				logger.info("Element " + identifier + " found with locator " + locator.getBy());

				return results;
			} catch (NoSuchElementException e) {
				if (locator.getBy() != locator.getOriginalBy()) {
					locator.setNonFound(locator.getNonFound() + 1);
				}
				logger.info("Element " + identifier + " not found with locator " + locator.getBy());
			}
		}

		if (locators.size() > 0) {
			countUnsuccessfulIntervention = countUnsuccessfulIntervention + 1;
			countUnsuccessfulInterventionList.add(countUnsuccessfulIntervention);
			updateDBBysOfLocators();
		}

		throw new NoSuchElementException("Could not find elements: " + identifier);
	}

	private void updateDBLocators() {
		try {
			LocatorsDAO locatorsDao = LocatorsDAO.getInstance();
			// Check if element needs to be added to the DB or updated
			locatorsDao.createOrUpdateWebElement(identifier, locators.get(0).getBy(), (WebDriver) context);
			locators = new ArrayList<>();
			iframeLocators = new ArrayList<>();
			locators.addAll(locatorsDao.getElementLocatorsFromDB(identifier));
			iframeLocators.addAll(locatorsDao.getLocatorsFromIframeFromDB(identifier));
		} catch (Exception e) {
			logger.error("Alternative locators couldn't be retrieved from database", e);
		}
	}

	private void updateDBBysOfLocators() {
		try {
			if (!locators.isEmpty()) {
				LocatorsDAO locatorsDao = LocatorsDAO.getInstance();
				locatorsDao.updateDBBysOfLocators(identifier, locators, countUnsuccessfulInterventionList);
			}
		} catch (Exception e) {
			logger.error("Alternative locators couldn't be retrieved from database", e);
		}
	}

	private WebElement getWebElementIframe() {
		if (iframeLocators != null && !iframeLocators.isEmpty()) {
			for (LocatorModel iframe : iframeLocators) {
				try {
					WebElement result = driver.findElement(iframe.getBy());

					logger.info("Element " + identifier + " found with locator " + iframe.getBy());
					return result;
				} catch (NoSuchElementException e) {
					logger.info("Element " + identifier + " not found with locator " + iframe.getBy());
				}
			}
		}

		return null;
	}

}
