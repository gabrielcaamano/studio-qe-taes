package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class LoginUserPage extends BasePage {

	public LoginUserPage(WebDriver driver) {
		super(driver);
		driver.get("https://uat.starmeup.com/login.html");
	}
	
	@FindBy(id = "username")
	WebElement inputUserName;
	
	@FindBy(xpath = "//button[@class='btn btn-login']")
	WebElement nextBtn;
	
	@FindBy(linkText = "Use another account")
	WebElement switchAccountLink;
	
	public LoginPassPage typeUser(String userName) {
		if ( switchAccountLink.isDisplayed() ) {
			click(switchAccountLink, DEFAULT_TIMEOUT);
		}
		type(inputUserName, userName, DEFAULT_TIMEOUT);
		click(nextBtn, DEFAULT_TIMEOUT);
		return new LoginPassPage(driver);
	}
	
}
