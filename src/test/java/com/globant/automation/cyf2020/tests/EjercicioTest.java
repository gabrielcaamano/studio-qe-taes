package com.globant.automation.cyf2020.tests;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EjercicioTest {
	
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClasss() {
		System.out.println("ANTES DE TODOS");
	}
	
	@BeforeClass
	public void segundoBeforeClass() {
		System.out.println("OTRO BEFORECLASS");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mercadolibre.com.uy");
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	@Test
	public void ejercicio1() {
		System.out.println("ESTOY EN test1");
		
		Assert.assertEquals("pedro", "pedro", "los nombres no fueron iguales");
		boolean variableFalse = false;
		Assert.assertTrue(variableFalse, "la variable no fue true");
		
		System.out.println("CODIGO EXTRA");
	}
	
	@Test
	public void ejercicio2() {
		System.out.println("estoy en test2");
		
		
	}
	
}
