package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.StarMeUp.LoginUserPage;
import com.globant.automation.cyf2020.infrastructure.BasePage;

public class StarMeUpHomePage extends BasePage {
	
	public StarMeUpHomePage(WebDriver driver) {
		super(driver);
		driver.get("http://uat.starmeup.com/");
	}

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement menuLoginBtn;
	
	@FindBy(xpath = "//p[contains(text(),'StarMeUp')]")
	WebElement starMeUpMenu;


	public LoginUserPage goStarMeUp() {
		click(menuLoginBtn);
		click(starMeUpMenu);
		return new LoginUserPage(driver);
	}

}
