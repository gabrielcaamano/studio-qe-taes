package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;

public class SrcStrategy extends LocatorStrategy {

	public SrcStrategy(WebDriver driver) {
		super(driver);
	}

	@Override
	public By generate(CachedElementAttributes cachingElement) {
        String tag = cachingElement.getTag() == null ? "*" : cachingElement.getTag();
        if (cachingElement.getSrc() != null && !cachingElement.getSrc().isEmpty()) {
            return By.xpath("//" + tag + "[@src='" + cachingElement.getSrc() + "']");
        } else {
            return null;
        }
	}

}
