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
	
	@FindBy (xpath = "//div [@class = 'stat__content']")
	private WebElement recivedStar;
	
	@FindBy (xpath = "(//div [@class = 'stat__content'])[2]")
	private WebElement sentStar;
	
	@FindBy (xpath = "//input [@class = 'suite-search-box__input']")
	private WebElement search;
	
	@FindBy (xpath = "//div [@class = 'search-result-item__content']")
	private WebElement searchButton;
	
	@FindBy (xpath = "//button[@class = 'button button--basic button--icon button--nomargin button--nopadding button--transparent suite-user_menu__profile-image-icon button--color-']")
	private WebElement button;

	@FindBy (xpath = "//button[@class = 'button button--color- button--size-small']")
	private WebElement logoutButton;
	
	public String getName() {
		String[] completeName = getText(name).split(" ");
		return completeName[0];	
	}
	
	public String getLastName() {
		String[] completeName = getText(name).split(" ");
		return completeName[1];
	}
	
	public String getJob() {
		return getText(job);
	}
	
	public String amountRecivedStar() {
		return getText(recivedStar);
	}
	
	public String amountSentStar() {
		return getText(sentStar);
	}
	
	public void searchColleague(String colleague) {
		search.sendKeys(colleague);
	}
	
	public void clickSearch() {
		click(searchButton);
	}	
	
	public void clickButton() {
		click(button);
	}
	
	public void clickLogout() {
		click(logoutButton);
	}
}
