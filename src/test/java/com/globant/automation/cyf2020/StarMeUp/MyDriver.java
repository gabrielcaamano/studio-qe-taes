package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.globant.automation.cyf2020.StarMeUp.LoginUserPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyDriver {

	private WebDriver driver;
	
	public MyDriver(String browser) {
		
		switch (browser) {
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox": 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
	}
	
	public WebDriver getDriver() {
		driver.manage().window().maximize();
		return driver;
	}
}
