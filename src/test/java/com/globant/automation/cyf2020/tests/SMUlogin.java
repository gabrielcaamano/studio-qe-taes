package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.pages.HomePage;
import com.globant.automation.cyf2020.pages.LoginPage;
import com.globant.automation.cyf2020.pages.UserClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SMUlogin {

	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.starmeup.com/login.html");
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	@Test
	public void ejercicio() {
		UserClass user = new UserClass();
		LoginPage login = new LoginPage(driver);
		login.writeUser(user.getUser());
		login.clickNext();
		login.writePassword(user.getPassword());
		HomePage home = login.clickLogin();
		
		String[] completeName = home.getName().split(" ");
		String name = completeName[0];
		String lastName = completeName[1];
		
		Assert.assertEquals(user.getName(), name, "Los nombres no son iguales");
		Assert.assertEquals(user.getLastName(), lastName, "Los apellidos no son iguales");
		Assert.assertEquals(user.getJob(), home.getJob(), "Los trabajos no son iguales");
	}
}
