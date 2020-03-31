package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class LogedFeedPage extends BasePage {

	public LogedFeedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h3[@class='user-info__name']")
	private WebElement infoNameLastname;
	
	@FindBy(className = "user-info__job")
	private WebElement infoJob;
	
	@FindBy(xpath = "//button[@class='button button--basic button--icon button--nomargin button--nopadding button--transparent suite-user_menu__profile-image-icon button--color-']//img[@class='user-avatar']")
	private WebElement userBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/nav[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/button[2]")
	private WebElement logOutBtn;
	
	String namePage = "";
	String lastnamePage = "";
	
	public void splitNameLastname() {
		String nameLastname = getText(infoNameLastname, DEFAULT_TIMEOUT);
		namePage = nameLastname.substring(0, 10);
		lastnamePage = nameLastname.substring(11, 17);
	}
	
	public UserInfo userInfoFeed() {
		splitNameLastname();
		UserInfo pageUserInfo = new UserInfo(namePage, lastnamePage, getText(infoJob, DEFAULT_TIMEOUT));
		return pageUserInfo;
	}
	
	public void logOut() {
		click(userBtn, EXTENDED_TIMEOUT);
		click(logOutBtn, EXTENDED_TIMEOUT);
	}

}
