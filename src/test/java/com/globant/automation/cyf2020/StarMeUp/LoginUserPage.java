package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class LoginUserPage extends BasePage {

	public LoginUserPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "username")
	WebElement inputUserName;
	
	@FindBy(className = "btn btn-login")
	WebElement nextBtn;
	
	public LoginPassPage typeUsuario(String userName) {
		type(inputUserName, userName);
		click(nextBtn);
		return new LoginPassPage(driver);
	}
}
