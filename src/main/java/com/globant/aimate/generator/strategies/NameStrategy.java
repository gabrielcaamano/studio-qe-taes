package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;

public class NameStrategy extends LocatorStrategy {

	public NameStrategy(WebDriver driver) {
		super(driver);
	}

	@Override
	public By generate(CachedElementAttributes cachingElement) {
        if (cachingElement.getName() != null && !cachingElement.getName().isEmpty()) {
            return By.name(cachingElement.getName());
        } else {
            return null;
        }
	}

}
