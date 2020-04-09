package com.globant.automation.cyf2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class SendStar extends BasePage {

	public SendStar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "//div [@class ='send-star__colleague'] //input") //[@class = 'suite-search-box__input']
	private WebElement starTo;
	
	@FindBy (xpath = "//li [@class='search-result-item search-result-item--visitable']")
	private WebElement firtInList;
	
	@FindBy (xpath = "(//div [@class ='value-icon'])[2]")
	private WebElement starValue;
	
	@FindBy (xpath = "//div[contains (@class , 'public-DraftEditor-content')]")
	private WebElement message;
	
	@FindBy(xpath = "//button [contains (@class , 'button--nomargin-right')]")
	private WebElement sendButton;
	
	@FindBy (xpath = "//i [contains (@class , 'confirmation__close')]")
	private WebElement closeButton;
	
	@FindBy (xpath = "//strong [@class= 'selected-value__name']")
	private WebElement starValueSelected;

	public void starTo (String name) {
		wait(ANIMATION_DURATION);
		type(starTo, name);
	}
	
	public void clickFirstInList() {
		click(firtInList);
	}
	
	public void clickStarValue() {
		click(starValue);
	}
	
	public void whyStarMessage(String whyStar) {
		type(message, whyStar);
	}
	
	public void clickSendButton() {
		click(sendButton);
	}
	
	public void clickCloseButton() {
		click(closeButton);
	}
	
	public String starValueSelected() {
		return getText(starValueSelected);
	}
}
