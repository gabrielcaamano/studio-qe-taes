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
	
	@FindBy(className = "btn btn-login")
	WebElement loginBtn;
	
	public LogedFeedPage typeUsuario(String password) {
		type(inputPassword, password);
		click(loginBtn);
		return new LogedFeedPage(driver);
	}

}
