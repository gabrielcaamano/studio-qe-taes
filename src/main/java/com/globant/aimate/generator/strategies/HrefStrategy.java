package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;

public class HrefStrategy extends LocatorStrategy {

	public HrefStrategy(WebDriver driver) {
		super(driver);
	}

	@Override
	public By generate(CachedElementAttributes cachingElement) {
        if (cachingElement.getHref() != null && !cachingElement.getHref().isEmpty()) {
            return By.partialLinkText(cachingElement.getHref());
        } else {
            return null;
        }
	}

}
