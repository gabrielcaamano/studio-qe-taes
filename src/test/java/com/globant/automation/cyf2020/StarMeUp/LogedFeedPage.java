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
	
	@FindBy(className = "info__name")
	private WebElement infoNameLastname;
	
	@FindBy(className = "user-info__job")
	private WebElement infoJob;
	
	@FindBy(className = "button button--basic button--icon button--nomargin button--nopadding button--transparent suite-user_menu__profile-image-icon button--color-")
	private WebElement userBtn;
	
	@FindBy(className = "button button--color- button--size-small")
	private WebElement logOutBtn;
	
	String namePage = "";
	String lastnamePage = "";
	
	public String splitNameLastname() {
		String nameLastname = getText(infoNameLastname, DEFAULT_TIMEOUT);
		//split
		//return namePage, lastnamePage separados
		return namePage;
	}
	
	public UserInfo userInfoFeed() {
		splitNameLastname();
		UserInfo pageUserInfo = new UserInfo(namePage, lastnamePage, getText(infoJob, DEFAULT_TIMEOUT));
		return pageUserInfo;
	}
	
	public LoginUserPage logOut() {
		click(userBtn, DEFAULT_TIMEOUT);
		click(logOutBtn, DEFAULT_TIMEOUT);
		return new LoginUserPage(driver);
		
	}

}
