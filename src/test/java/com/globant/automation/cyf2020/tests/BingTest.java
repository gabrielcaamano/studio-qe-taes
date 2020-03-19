package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BingTest {
	private WebDriver driver;
	
	@BeforeSuite
	public void openBing() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("http://bing.com");
	}
	@Test
	public void testBing(){
		BingHome homePage =  PageFactory.initElements(driver, BingHome.class);
		BingSearchPage resultPage = homePage.googleSearch("movie");
		String actualText= resultPage.traePalabraB();
		Assert.assertEquals("movie","el resultado de la busqueda ha fallado");
	}
	
}
