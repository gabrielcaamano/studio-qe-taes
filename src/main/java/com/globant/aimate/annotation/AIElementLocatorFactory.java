package com.globant.aimate.annotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;

import io.appium.java_client.pagefactory.locator.CacheableElementLocatorFactory;
import io.appium.java_client.pagefactory.locator.CacheableLocator;
import org.openqa.selenium.WebDriver;

public class AIElementLocatorFactory implements CacheableElementLocatorFactory {
	
	private WebDriver driver;
	private SearchContext searchContext;

	public AIElementLocatorFactory(SearchContext searchContext) {
		this.searchContext = searchContext;
	}

	public AIElementLocatorFactory(WebDriver pDriver, SearchContext searchContext) {
		this.driver = pDriver;
		this.searchContext = searchContext;
	}

	@Override
    public CacheableLocator createLocator(Field field) {
        return new AIElementLocator(driver, searchContext, field);
    }

	@Override
	public CacheableLocator createLocator(AnnotatedElement annotatedElement) {
        return this.createLocator((Field) annotatedElement);

	}
}