package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class StarMeUp extends BasePage {

	public StarMeUp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//button[@class='button button--basic button--icon button--nomargin button--nopadding button--transparent suite-user_menu__profile-image-icon button--color-']//img[@class='user-avatar']")
	private WebElement userBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/nav[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/button[2]")
	private WebElement logOutBtn;

}
