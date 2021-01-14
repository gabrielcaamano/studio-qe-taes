package com.globant.aimate.generator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.globant.aimate.model.ElementDto;
import com.globant.aimate.model.LocatorModel;
import com.globant.aimate.generator.strategies.LocatorStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.aimate.model.AIMateException;
import com.globant.aimate.model.CachedElementAttributes;
import com.globant.aimate.utils.AIMateProperties;
import com.globant.aimate.utils.SeleniumUtils;

public class LocatorGenerator {
	
	private final Logger logger = LoggerFactory.getLogger(LocatorGenerator.class);
	private AIMateProperties properties;
	private List<LocatorStrategy> strategies;

	private static final Integer TEN_SECONDS = 10;
	private static final String IFRAME = "iframe";
	private static final String PARENT = "..";
	private static final String CHILD = "./child::*";
	private static final String PRECEDING_SIBLING = "preceding-sibling::*";
	private static final String FOLLOWING_SIBLING = "following-sibling::*";
	private static final String ANCESTOR = "ancestor::*";

	public LocatorGenerator(WebDriver driver) throws AIMateException {
		properties = AIMateProperties.getInstance();
		strategies = new ArrayList<>();
		
		String strategiesNames = properties.getString("aimate.strategies");
		if (strategiesNames == null || strategiesNames.isEmpty()) {
			strategiesNames = "IdStrategy,NameStrategy,AltStrategy,ClassStrategy,HrefStrategy,TextStrategy,InnerTextAndClassStrategy,InnerTextStrategy,SrcStrategy,StyleStrategy,TextAndClassStrategy,TypeStrategy,ValueStrategy";
		}
		logger.info("Using strategies {}", strategiesNames);
		
		for (String strategyName : strategiesNames.split(",")) {
			LocatorStrategy strategy = null;
			try {
				strategy = (LocatorStrategy) Class.forName("com.globant.aimate.generator.strategies." + strategyName)
						.getConstructor(WebDriver.class).newInstance(driver);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				logger.error("Strategy with name {} not found", strategyName, e);
			}
			strategies.add(strategy);
		}
	}

	private WebElement searchWebElement(WebDriver driver, By locator){
		return SeleniumUtils.getWebElement(driver, locator, TEN_SECONDS);
	}

	/**
	 * Obtains relevant attributes from a WebElement(using the provided param By locator)
	 * in order to be used later in the alternative xpath/css generation.
	 * @param driver Webdriver
	 * @param locator Main locator strategy
	 * @return
	 */
	public CachedElementAttributes getElementAttributes(WebDriver driver, By locator) {
	    WebElement element = searchWebElement(driver, locator);
		WebElement webElementIframe = null;
		ElementDto elementDto = new ElementDto();
		if(element == null) {
			searchInIframe(elementDto, driver, locator);
			if(elementDto.getElementFound() != null) {
				element = elementDto.getElementFound();
				webElementIframe = elementDto.getIframeElement();
			}else{
				return null;
			}
		}

		CachedElementAttributes iframeElement = null;

		if(webElementIframe != null) {
			driver.switchTo().defaultContent();
			iframeElement = getCachedElementAttributes(webElementIframe, driver);
			List<LocatorModel> webElementIframeList = generateAlternativeLocators(iframeElement);
			iframeElement.setLocators(webElementIframeList);
			driver.switchTo().frame(webElementIframe);
		}

		CachedElementAttributes cachingElement = getCachedElementAttributes(element, driver);
		CachedElementAttributes parentElement = getParentElement(element, driver);
		List<CachedElementAttributes> siblingElementList = getSiblingElement(element, driver);
		List<CachedElementAttributes> childElementList = getChildElement(element, driver);
		List<WebElement> ancestorElements = getAncestorElements(element);

		cachingElement.setParentElement(parentElement);
		cachingElement.setIframelement(iframeElement);
		cachingElement.setSiblingElements(siblingElementList);
		cachingElement.setChildElements(childElementList);
		cachingElement.setWebElementIframe(webElementIframe);
		cachingElement.setAmountOfNodeLevels(ancestorElements.size());

		return cachingElement;
	}

	private void searchInIframe(ElementDto elementDto, WebDriver driver, By locator){
		List<WebElement> iframes = driver.findElements(By.tagName(IFRAME));

		WebElement element;

		for(WebElement iframeElement: iframes){
			driver.switchTo().frame(iframeElement);
			element = searchWebElement(driver, locator);
			if(element != null) {
				elementDto.setElementFound(element);
				elementDto.setIframeElement(iframeElement);
				break;
			}
			driver.switchTo().defaultContent();
		}
	}

	/**
	 * Generates and tests alternative locators based on the usable attributes contained in the
	 * WebElementAttributes returned by getElementAttributes() method.
	 * @param cachingElement cachingElement
	 * @return return
	 */
	public List<LocatorModel> generateAlternativeLocators(CachedElementAttributes cachingElement) {
		ArrayList<LocatorModel> locators = new ArrayList<>();

		if(cachingElement == null) {
			return locators;
		}

		for (LocatorStrategy strategy : strategies) {
			LocatorModel locator = new LocatorModel();
			locator.setBy(strategy.generate(cachingElement));

			if(locator.getBy() != null){
				locator.setStrategyClass(strategy.getClass().getSimpleName());
				if (locator.getFound() == null) {
					locator.setFound(0);
				}

				if (locator.getNonFound() == null) {
					locator.setNonFound(0);
				}

				locators.add(locator);
			}
		}

		return locators;
	}

	private CachedElementAttributes getCachedElementAttributes(WebElement element, WebDriver driver){
		CachedElementAttributes cachingParentElement = new CachedElementAttributes(element);
		Dimension windowSize = driver.manage().window().getSize();
		cachingParentElement.setRelativePosition(SeleniumUtils.getRelativePositionFromAbsolute(element.getRect().getPoint(),windowSize));
		return cachingParentElement;
	}

	private CachedElementAttributes getParentElement(WebElement element, WebDriver driver){
		WebElement parentElement = element.findElement(By.xpath(PARENT));
		CachedElementAttributes cachingParentElement = getCachedElementAttributes(parentElement, driver);
		return cachingParentElement;
	}

	private List<CachedElementAttributes> getSiblingElement(WebElement element, WebDriver driver){
		List<WebElement> precedingElementList = element.findElements(By.xpath(PRECEDING_SIBLING));
		List<WebElement> followingElementList = element.findElements(By.xpath(FOLLOWING_SIBLING));

		List<CachedElementAttributes> cachingSiblinglementList = new ArrayList<>();
		for(WebElement precedingElement: precedingElementList) {
			cachingSiblinglementList.add(getCachedElementAttributes(precedingElement, driver));
		}

		for(WebElement followingElement: followingElementList) {
			cachingSiblinglementList.add(getCachedElementAttributes(followingElement, driver));
		}

		return cachingSiblinglementList;
	}

	private List<CachedElementAttributes> getChildElement(WebElement element, WebDriver driver){
		List<WebElement> childElementList = element.findElements(By.xpath(CHILD));
		List<CachedElementAttributes> cachingChildElementList = new ArrayList<>();
		for(WebElement childElement: childElementList) {
			cachingChildElementList.add(getCachedElementAttributes(childElement, driver));
		}
		return cachingChildElementList;
	}

	private List<WebElement> getAncestorElements(WebElement element){
		return element.findElements(By.xpath(ANCESTOR));
	}
}
