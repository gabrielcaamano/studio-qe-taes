package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
<<<<<<< Updated upstream
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.Travelocity.TravelocityHome;
=======
>>>>>>> Stashed changes

import io.github.bonigarcia.wdm.WebDriverManager;

public class TravelocityTest {
	
<<<<<<< Updated upstream
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
=======
	@BeforeTest
	public void abrirNavegador() {
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.travelocity.com/");
		driver.manage().window().maximize();
>>>>>>> Stashed changes
	}
}
