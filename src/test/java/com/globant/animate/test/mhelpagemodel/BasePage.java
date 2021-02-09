package com.globant.animate.test.mhelpagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage (WebDriver aDriver) {
		PageFactory.initElements(aDriver, this);
		wait = new WebDriverWait(aDriver, 10);
		driver = aDriver;
	}
	public WebDriverWait getWait() {
		return wait;
	}
	protected WebDriver getDriver() {
		return driver;
	}
	
	public void dispose() {
		if (driver !=null) {
			driver.quit();
		}
	}

}
