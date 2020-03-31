package com.globant.automation.cyf2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "//h3 [@class = 'user-info__name']")
	private WebElement name;
	
	@FindBy (xpath = "//p [@class = 'user-info__job']")
	private WebElement job;
	
	public String getName() {
		return getText(name);
	}
	
	public String getJob() {
		return getText(job);
	}
	
}
