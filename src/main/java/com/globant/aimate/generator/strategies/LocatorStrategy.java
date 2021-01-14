package com.globant.aimate.generator.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.globant.aimate.model.CachedElementAttributes;
import com.globant.aimate.model.Locator;
import com.globant.aimate.utils.SeleniumUtils;

public abstract class LocatorStrategy {

    private WebDriver driver;
	
	public LocatorStrategy(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract By generate(CachedElementAttributes cachingElement);
	
	protected WebDriver getDriver() {
		return driver;
	}

    protected Locator testNewLocator(Locator locator, Point originalPosition) {
        int i = 1;
        boolean isWorking = false;
        boolean isUnique = false;
        Locator result = new Locator(locator.getBy(), locator.getReference());

        int count = 0;
        do {
            count = SeleniumUtils.getNumberOfElements(driver, result.getBy());
            isWorking = count >= 1;
            isUnique = count == 1;

            if (isWorking && !isUnique) {
                result.setReference("("+ result.getReference() +")["+ i +"]");
                Point newPosition = SeleniumUtils.getRelativePositionFromAbsolute(SeleniumUtils.getWebElement(driver, result.getBy(), 5).getRect().getPoint(), driver.manage().window().getSize());
                if (originalPosition.equals(newPosition)) {
                    result.setUnique(true);
                    result.setBy(By.xpath(result.getReference()));
                }
            }
            i = i + 1;
        } while (!isWorking && !isUnique && i < count);

        return result;
    }
	
}
