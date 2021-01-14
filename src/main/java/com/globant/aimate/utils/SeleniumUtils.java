package com.globant.aimate.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	
	private SeleniumUtils() {
		// Utility class
	}
	
	public static WebElement getWebElement(WebDriver driver, final By byLocator, int seconds) {
		WebElement webElement = null;

		try {
			webElement = (new WebDriverWait(driver, seconds)).until(dr -> dr.findElement(byLocator));
		} catch (Exception e) {
			return null;
		}

		return webElement;
	}
	
	public static int getNumberOfElements(WebDriver driver, By locator) {
		return driver.findElements(locator).size();
	}

	public static Point getRelativePositionFromAbsolute(Point point, Dimension windowSize){
		int relativeX = point.getX()*100/windowSize.getWidth();
		int relativeY = point.getY()*100/windowSize.getHeight();
		return new Point(relativeX,relativeY);
	}

}
