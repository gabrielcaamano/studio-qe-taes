package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ImageStrategy extends LocatorStrategy {

	public ImageStrategy(WebDriver driver) {
		super(driver);
	}

	@Override
	public By generate(CachedElementAttributes cachingElement) {
		if (cachingElement.getElement() instanceof MobileElement) {
			return MobileBy.image(cachingElement.getScreenshot());
		}
		return null;
	}

}
