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
	protected WebElement userBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/nav[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/button[2]")
	protected WebElement logOutBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Integrity')]")
	protected WebElement globantIntegrityValue;

	@FindBy(xpath = "//span[contains(text(),'Excellence')]")
	protected WebElement globantExcellenceValue;

	@FindBy(xpath = "//span[contains(text(),'Teamwork')]")
	protected WebElement globantTeamworkValue;

	@FindBy(xpath = "//span[contains(text(),'Innovation')]")
	protected WebElement globantInnovationValue;

	@FindBy(xpath = "//span[contains(text(),'Learning')]")
	protected WebElement globantLearningValue;

	@FindBy(xpath = "//span[contains(text(),'Think big')]")
	protected WebElement globantThinkBigValue;
	
	@FindBy(linkText = "MY PROFILE")
	protected WebElement myProfileBtn;
	
	@FindBy(linkText = "LEADERBOARD")
	protected WebElement leaderboardBtn;

	@FindBy(linkText = "ACTIVITY FEED")
	protected WebElement activityFeedBtn;
	
	@FindBy(css = "nav.ui-navbar:nth-child(1) div.ui-navbar__container div.ui-navbar__search-container div.search-wrapper div:nth-child(1) div.search-results.search-results-starmeup div.ui-components.suite-search-box > input.suite-search-box__input")
	protected WebElement searchColleagueInput;

}
