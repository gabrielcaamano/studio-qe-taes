package com.globant.automation.cyf2020.TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Ejercicio3 {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Antes del metodo");
	}
	
	
	@Test
	public void testFalse() {
		System.out.println("testTrue");
		Assert.assertEquals(1.5, 1.6, "Los floats no son iguales");
	}
	
	@Test
	public void testTrue() {
		System.out.println("testTrue");
		Assert.assertEquals(1.0, 1.0, "Los floats son iguales");
	}
	
	@AfterMethod
	public void closeDriver() {
		System.out.println("Despues del metodo");
	}
	
}
