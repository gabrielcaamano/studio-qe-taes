package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

	private WebDriver driver;
	
	public void MyDriver(String browser) {
		
		switch (browser) {
		case "chrome": 
			driver = new ChromeDriver();
			break;
		case "firefox": 
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
	}
	
	public WebDriver getDriver() {

		return driver;
	}
}
