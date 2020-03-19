package com.globant.automation.cyf2020.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio1 {
private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("ANTES DE LAS CLASES");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com.uy");
		System.out.println("Antes del metodo");
	}
	
	
	@Test
	public void ejercicio1() {
		System.out.println("test");
		Assert.assertNotEquals(1.5, 1.6, "Los floats son iguales");
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
		System.out.println("Despues del metodo");
		
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("DESPUES DE LAS CLASES");
	}
	
}
