package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class LoginPassPage extends BasePage {

	public LoginPassPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "password")
	WebElement inputPassword;
	
	@FindBy(xpath = "//li[@id='loginInputBtn']//button[@class='btn btn-login'][contains(text(),'Login')]")
	WebElement loginBtn;
	
	public LogedFeedPage typePassword(String password) {
		type(inputPassword, password, DEFAULT_TIMEOUT);
		click(loginBtn, DEFAULT_TIMEOUT);
		return new LogedFeedPage(driver);
	}

}
