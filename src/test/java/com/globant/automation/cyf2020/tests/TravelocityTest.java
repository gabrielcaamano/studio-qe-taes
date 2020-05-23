package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.Travelocity.TravelocityHome;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TravelocityTest {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void startDriver() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.travelocity.com/");
			driver.manage().window().maximize();

	}

	@Test
	public void Ejercicio1() {
		
		TravelocityHome travelocityHome = new TravelocityHome(driver);
		travelocityHome.searchFlight();
	}
}
