package com.globant.aimate.test.mobilepagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.aimate.annotation.AIElementLocatorFactory;

public abstract class AIMobileTestPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public AIMobileTestPage(WebDriver pDriver) {
		PageFactory.initElements(new AIElementLocatorFactory(pDriver), this);
		wait = new WebDriverWait(pDriver, 60);
		driver = pDriver;
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}
	
}

