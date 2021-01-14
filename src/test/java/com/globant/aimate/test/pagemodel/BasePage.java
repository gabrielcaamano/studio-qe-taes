package com.globant.aimate.test.pagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.aimate.annotation.AIElementLocatorFactory;

public abstract class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(new AIElementLocatorFactory(pDriver, pDriver), this);
		wait = new WebDriverWait(pDriver, 0);
		driver = pDriver;
	
	}
	
//	public BasePage(WebDriver pDriver) {
		
//		PageFactory.initElements(pDriver, this);
//		wait = new WebDriverWait(pDriver, 10);
//		driver = pDriver;
		
//	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}
	
}
