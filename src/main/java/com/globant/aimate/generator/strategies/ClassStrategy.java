package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;
import com.globant.aimate.model.Locator;

public class ClassStrategy extends LocatorStrategy {

	public ClassStrategy(WebDriver driver) {
		super(driver);
	}

	@Override
	public By generate(CachedElementAttributes cachingElement) {
        String tag = cachingElement.getTag() == null ? "*" : cachingElement.getTag();
        Point position = cachingElement.getRelativePosition();

        if (cachingElement.getClazz() != null && !cachingElement.getClazz().isEmpty()) {
            Locator l = testNewLocator(new Locator("//" + tag + "[@class='" + cachingElement.getClazz() + "']"), position);
            return l.getBy();
        } else {
            return null;
        }
	}

}
