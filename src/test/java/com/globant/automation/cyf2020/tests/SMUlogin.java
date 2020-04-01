package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.pages.HomePage;
import com.globant.automation.cyf2020.pages.LoginPage;
import com.globant.automation.cyf2020.pages.UserClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SMUlogin {

	private WebDriver driver;
	public String recivedStar;
	public String sentStar;
	
	@BeforeClass
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.starmeup.com/login.html");
	}
	
	@AfterClass
	public void closeDriver() {
		driver.close();
	}
	
	@Test(priority=1)
	public void loginUserB() {
		UserClass userB = new UserClass();
		LoginPage login = new LoginPage(driver);
		HomePage home = login.login(userB.getUserB(), userB.getPasswordB());
		
		Assert.assertEquals(userB.getNameB(), home.getName(), "Los nombres no son iguales");
		Assert.assertEquals(userB.getLastNameB(), home.getLastName(), "Los apellidos no son iguales");
		Assert.assertEquals(userB.getJobB(), home.getJob(), "Los trabajos no son iguales");
		
		recivedStar = home.amountRecivedStar();
	}
	
	@Test (priority=2)
	public void logout() {
		HomePage home = new HomePage(driver);
		home.clickButton();
		home.clickLogout();
	}
	
	@Test(priority=3)
	public void loginUserA() {
		UserClass userA = new UserClass();
		LoginPage login = new LoginPage(driver);
		HomePage home = login.login(userA.getUser(), userA.getPassword());
		
		Assert.assertEquals(userA.getName(), home.getName(), "Los nombres no son iguales");
		Assert.assertEquals(userA.getLastName(), home.getLastName(), "Los apellidos no son iguales");
		Assert.assertEquals(userA.getJob(), home.getJob(), "Los trabajos no son iguales");
		
		sentStar = home.amountSentStar();
	}

	@Test (priority=4)
	public void buscar() {
		UserClass userB = new UserClass();
		HomePage search = new HomePage(driver);
		search.searchColleague(userB.getNameB());
		search.clickSearch();
	}
	
}
