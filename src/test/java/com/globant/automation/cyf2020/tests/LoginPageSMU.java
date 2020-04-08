package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class LoginPageSMU extends BasePage{

	public LoginPageSMU(WebDriver driver) {
		super(driver);
        driver.get("https://uat.starmeup.com/login.html");
	}
	
	@FindBy (id= "username")
	private WebElement user_name;
	
	@FindBy(id="password")
	private WebElement user_password;
	
	@FindBy (xpath= "//div[@class='container col-xs-12 col-md-8']//li[4]//button")
	private WebElement btnNext;
	
	@FindBy (xpath="(//button[@class='btn btn-login'])[2]")
	private WebElement btnLogin;
	
	
	@FindBy (id= "username")
	private WebElement user_name2;
	
	@FindBy(id="password")
	private WebElement user_password2;
	
	@FindBy (xpath= "//div[@class='container col-xs-12 col-md-8']//li[4]//button")
	private WebElement btnNext2;
	
	@FindBy (xpath="(//button[@class='btn btn-login'])[2]")
	private WebElement btnLogin2;


	public String ingresaUser (String user) {
		type(user_name, user);
		click(btnNext);
		return user;
	}
	public HomeSMU ingresaPasswordYnavega (String password) {
		type(user_password, password);
		click(btnLogin);
		return getNextPage(HomeSMU.class);
	}

	public String ingresarUser2 (String user2) {
		type(user_name2,user2);
		click(btnNext2);
		return user2;
		
		
		
	}
	
}


