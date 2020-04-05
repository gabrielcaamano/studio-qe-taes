package com.globant.automation.cyf2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class BarPage extends BasePage {

	public BarPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//input [@class = 'suite-search-box__input']")
	private WebElement search;
	
	@FindBy (xpath = "//div [@class = 'search-result-item__content']")
	private WebElement colleageFound;
	
	@FindBy (xpath = "//button[contains(@class,'suite-user_menu__profile-image-icon')]")
	private WebElement buttonMenuProfile;

	@FindBy (xpath = "//button[@class = 'button button--color- button--size-small']")
	private WebElement logoutButton;
	
	@FindBy (xpath = "(//li [@class = 'ui-navbar__menu-item'])")
	private WebElement activityFeed;
	
	@FindBy (xpath = "(//li [@class = 'ui-navbar__menu-item'])[3]")
	private WebElement myProfile;
	
	@FindBy(xpath = "//button [contains (@class , 'button--nopadding')]")
	private WebElement notifications;
	
	@FindBy(xpath = "//li [contains (@class , 'notifications-item--active')]")
	private WebElement notificationUnread;
	
	public void searchColleague(String colleague) {
		search.sendKeys(colleague);
	}
	
	public void clickColleageFound() {
		click(colleageFound);
	}	
	
	public void clickButtonMenuProfile() {
		click(buttonMenuProfile);
	}
	
	public void clickLogout() {
		click(logoutButton);
	}
	
	public ActivityFeedPage clickActivityFeed() {
		click(activityFeed);
		return getNextPage(ActivityFeedPage.class);
	}
	
	public UserProfilePage clickMyProfile() {
		click(myProfile);
		return getNextPage(UserProfilePage.class);
	}
	
	public void clickNotifications() {
		click(notifications);
	}
	
	public boolean notificationUnread() {
		return isElementDisplayed(notificationUnread);
	}
}
