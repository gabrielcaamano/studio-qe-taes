package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Leaderboard extends BasePage {

	@FindBy(xpath = "//button[contains(@class, 'button--transparent feed-tabs-filter__button hide-from-mobile')]")
	private WebElement filtrerBtn;

	@FindBy(xpath = "//p[@class=\"notifications-list__info\"]//span")
	private WebElement youDontHaveNotifications;

	public Leaderboard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void filtrersBtn() {
		click(filtrerBtn);
	}

}
