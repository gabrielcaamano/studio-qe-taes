package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;
import com.globant.aimate.model.Locator;

public class AltStrategy extends LocatorStrategy {

	public AltStrategy(WebDriver driver) {
		super(driver);
	}

	@Override
	public By generate(CachedElementAttributes cachingElement) {
        String tag = cachingElement.getTag() == null ? "*" : cachingElement.getTag();
        Point position = cachingElement.getRelativePosition();

        if (cachingElement.getAlt() != null && !cachingElement.getAlt().isEmpty()) {
            Locator l = testNewLocator(new Locator("//" + tag + "[@alt='" + cachingElement.getAlt() + "']"), position);
            return l.getBy();
        } else {
            return null;
        }
	}

}
