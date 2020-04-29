package com.globant.automation.cyf2020.tests;

import com.globant.automation.cyf2020.infrastructure.BaseTest;
import com.globant.automation.cyf2020.infrastructure.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.json.JSONObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EjercicioTest extends BaseTest {

	@Test
	public void test() {
		HomePage home = new HomePage(driver);
		home.clickContentButton();
	}

	
}
