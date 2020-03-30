package com.globant.automation.cyf2020.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class LoginStarMeUpTest {
	
	@BeforeTest
	@Parameter({"browser"})
	public void iniciarlizarNavegador() {
	WebDriver driver = new MyDriver(String browser) {
		
	}
	
	@Test
	public void prueba() {
		System.out.println("hola");
	}

}
