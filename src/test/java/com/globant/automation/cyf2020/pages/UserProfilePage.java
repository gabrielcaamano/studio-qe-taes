package com.globant.automation.cyf2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class UserProfilePage extends BasePage {

	public UserProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//button[contains (@class, 'profile-board__btn-wrapper')]")
	private WebElement amountSendStar;
	
	@FindBy (xpath = "//span [contains (@class , 'suite-discovery__smu--open')]")
	private WebElement popUp;
	
	@FindBy (xpath = "//div [@class = 'tab-panel__item']")
	private WebElement sentStar;
	
	@FindBy (xpath= "//strong[@class = 'feed-footer__full-name']")
	private WebElement starSentBy;
	
	@FindBy (xpath = "//div[@class = 'feed-item__badge-description']")
	private WebElement kindOfStar;
	
	@FindBy (xpath = "//span [@class = 'feed-item__avatar-name--cursor']")
	private WebElement starSentTo;
	
	@FindBy (xpath = "//span [@class= 'ui-components-suite__toast__text']")
	private WebElement starWasSent;
	
	public void clickPopUp1() {
		click(popUp);
	}
	public void clickPopUp2() {
		click(popUp);
	}
	
	public SendStar clickSendStar() {
		click(amountSendStar);
		return getNextPage(SendStar.class);
	}
	
	public void sentStar() {
		click(sentStar);
	}
	
	public String starSentBy() {
		return getText(starSentBy);
	}
	
	public String kindOfStar() {
		return getText(kindOfStar);
	}
	
	public String starSentTo() {
		return getText(starSentTo);
	}

	public boolean starWasSentBefore() {
		return isElementDisplayed(starWasSent);
	}
}
