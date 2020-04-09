package com.globant.automation.cyf2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input [@class = 'form control']")
	private WebElement user;
	
	@FindBy(xpath = "//button[@class = 'btn btn-login']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//input [@class = 'js-login']")
	private WebElement password;
	
	@FindBy(xpath = "(//button[@class = 'btn btn-login'])[2]")
	private WebElement loginButton;
	
	
	public BarPage login(String name, String pass) {
		type(user, name);
		click(nextButton);
		type(password, pass);
		click(loginButton);
		return getNextPage(BarPage.class);
	}

}
