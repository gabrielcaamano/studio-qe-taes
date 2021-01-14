package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;

public class IdStrategy extends LocatorStrategy {

	public IdStrategy(WebDriver driver) {
		super(driver);
	}

	@Override
	public By generate(CachedElementAttributes cachingElement) {
        if (cachingElement.getId() != null && !cachingElement.getId().isEmpty()) {
            return By.id(cachingElement.getId());
        } else {
            return null;
        }
	}

}
