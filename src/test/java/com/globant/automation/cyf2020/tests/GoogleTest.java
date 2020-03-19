package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest{
	private WebDriver driver;
	
	
	
	@BeforeSuite
	public void openGoogle() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("http://google.com");
	}
	
	@Test
	public void testGoogle(){
		GoogleHome homePage =  PageFactory.initElements(driver, GoogleHome.class);
		GoogleSearchPage resultPage = homePage.googleSearch("movie");
		String actualText= resultPage.traePalabra();
		Assert.assertEquals("movie","el resultado de la busqueda ha fallado");
	}
	
}
