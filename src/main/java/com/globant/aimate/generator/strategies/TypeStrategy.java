package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;
import com.globant.aimate.model.Locator;

public class TypeStrategy extends LocatorStrategy {

	public TypeStrategy(WebDriver driver) {
		super(driver);
	}

	@Override
	public By generate(CachedElementAttributes cachingElement) {
        String tag = cachingElement.getTag() == null ? "*" : cachingElement.getTag();
        Point position = cachingElement.getRelativePosition();

        if (cachingElement.getType() != null && !cachingElement.getType().isEmpty()) {
            Locator l = testNewLocator(new Locator("//" + tag + "[@type='" + cachingElement.getType() + "']"), position);
            return l.getBy();
        } else {
            return null;
        }
	}

}
