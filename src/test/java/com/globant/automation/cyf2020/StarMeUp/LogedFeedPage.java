package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.Document;

import com.globant.automation.cyf2020.infrastructure.BasePage;

import groovyjarjarantlr.RecognitionException;

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

	@FindBy(xpath = "//div[@class='profile-stats']//div[1]//div[1]//div[1]//div[2]")
	private WebElement recibedStars;

	@FindBy(xpath = "//div[@class='profile-stats']//div[2]//div[1]//div[1]//div[2]")
	private WebElement sentStars;

	@FindBy(xpath = "//span[contains(text(),'Integrity')]")
	private WebElement globantIntegrityValue;
	
	@FindBy(xpath = "//span[contains(text(),'Excellence')]")
	private WebElement globantExcellenceValue;
	
	@FindBy(xpath = "//span[contains(text(),'Teamwork')]")
	private WebElement globantTeamworkValue;
	
	@FindBy(xpath = "//span[contains(text(),'Innovation')]")
	private WebElement globantInnovationValue;
	
	@FindBy(xpath = "//span[contains(text(),'Learning')]")
	private WebElement globantLearningValue;
	
	@FindBy(xpath = "//span[contains(text(),'Think big')]")
	private WebElement globantThinkBigValue;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement searchColleagueInput;

	@FindBy(xpath = "//button[@class='button button--icon button--nomargin suite-search-box__input-button suite-search-box__input-button--green button--color-']")
	private WebElement searchColleagueBtn;

	@FindBy(xpath = "//div[@class='send-star__message-textarea']//div[@class='DraftEditor-root']")
	WebElement messageBox;

	@FindBy(xpath = "//div[@class='send-star__message-textarea']//div[@class='notranslate public-DraftEditor-content']")
	private WebElement messageInput;

	@FindBy(xpath = "//button[@class='button button--nomargin-right button--transparent button--color-']")
	private WebElement sendStarBtn;
	
	@FindBy(linkText = "MY PROFILE")
	private WebElement myProfileBtn;
	
	@FindBy(linkText = "ACTIVITY FEED")
	private WebElement activityFeedBtn;

	private String namePage = "";
	private String lastnamePage = "";
	private String deliveryConfirmationText;
	private int recibedStarsBefore;
	private int sentStarsBefore;
	private int recibedStarsAfter;
	private int sentStarsAfter;

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

	public void setRecibedStarsBefore() {
		recibedStarsBefore = Integer.parseInt(getText(recibedStars, MOSTEXTENDED_TIMEOUT));
	}

	public void setRecibedStarsAfter() {
		recibedStarsAfter = Integer.parseInt(getText(recibedStars, MOSTEXTENDED_TIMEOUT));
	}

	public void setSentStarsBefore() {
		sentStarsBefore = Integer.parseInt(getText(sentStars, MOSTEXTENDED_TIMEOUT));
	}

	public void setSentStarsAfter() {

		sentStarsAfter = Integer.parseInt(getText(sentStars, MOSTEXTENDED_TIMEOUT));
	}

	public int getRecibedStarsBefore() {

		return recibedStarsBefore;
	}

	public int getRecibedStarsAfter() {

		return recibedStarsAfter;
	}

	public int getSentStarsBefore() {

		return sentStarsBefore;
	}

	public int getSentStarsAfter() {

		return sentStarsAfter;
	}
	
	public WebElement switchValueBtn (String value) {
		
		switch(value) {
		  case "Integrity":
		    return globantIntegrityValue;
		  case "Excelence":
		    return globantExcellenceValue;
		  case "Teamwork":
			    return globantTeamworkValue;
		  case "Innovation":
			  return globantInnovationValue;
		  case "Learning":
			    return globantLearningValue;
		  case "Think big":
			    return globantThinkBigValue;
		  default: return globantExcellenceValue;    
		
		}
		
	}

	public void sendAStar(String who, String value) {

		avoidPopUps();
		WebElement valueBtn = switchValueBtn(value);
		click(valueBtn, EXTENDED_TIMEOUT);
		type(searchColleagueInput, who, EXTENDED_TIMEOUT);
		WebElement userToStar = getElement(By.xpath("//div[@class='search-result-item__content']"),
				EXTENDED_TIMEOUT);
		click(userToStar);
		click(messageBox);
		messageInput.sendKeys("This is an automation star");
		sendStarBtn.click();
	}

	public void avoidPopUps() {

		getElementAndClick(By.xpath(
				"//span[@class='suite-discovery suite-discovery__smu suite-discovery__smu--right suite-discovery__smu--open']"));
		getElementAndClick(By.xpath(
				"//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]"));
		getElementAndClick(By.xpath("/html[1]/body[1]/div[22]/div[1]/span[1]"));

	}

	public String starDeliveryChecking() {

		WebElement deliveryConfirmation = getElement(By.xpath("//p[@class=\"confirmation__header-message\"]//span"));
		deliveryConfirmationText = getText(deliveryConfirmation);
		getElementAndClick(By.xpath("//i[@class='close large icon confirmation__close']"));
		System.out.println(deliveryConfirmationText);
		return deliveryConfirmationText;
	}

	public boolean searchStarOnActivityFeed( String whoRecibesName, String value, String whoSendsName ) {
		
		int index = 1;
		boolean starFound = true;
		activityFeedBtn.click();
		WebElement userWhoRecibesFeed = getElement(By.cssSelector("div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(" + index + ") div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__avatar-title:nth-child(1) div.feed-item__avatar-name > span.feed-item__avatar-name--cursor"));;
		WebElement userWhoSendsFeed = getElement(By.cssSelector("div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(" + index + ") div.feed-footer.feed-footer--dark span.feed-footer__user-info p.feed-footer__prefix-text.feed-footer__prefix-text--smu > strong.feed-footer__full-name"));;
		WebElement valueFeed = getElement(By.cssSelector("div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(" + index + ") div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__badge-wrapper:nth-child(2) > div.feed-item__badge-description"));
		String userWhoRecibesFeedText = getText(userWhoRecibesFeed);
		String userWhoSendsFeedText = getText(userWhoSendsFeed);
		String valueFeedText = getText(valueFeed);
		String valueToUpperCase;
		valueToUpperCase = value.toUpperCase();

		while ( (userWhoRecibesFeedText.contentEquals("null"))  && (! userWhoRecibesFeedText.contains(whoRecibesName))) {

			userWhoRecibesFeed = getElement(By.cssSelector("div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(\" + index + \") div.feed-footer.feed-footer--dark span.feed-footer__user-info p.feed-footer__prefix-text.feed-footer__prefix-text--smu > strong.feed-footer__full-name"));
			userWhoSendsFeed = getElement(By.cssSelector("div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(\" + index + \") div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__avatar-title:nth-child(1) div.feed-item__avatar-name > span.feed-item__avatar-name--cursor"));
			valueFeed = getElement(By.cssSelector("div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(" + index + ") div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__badge-wrapper:nth-child(2) > div.feed-item__badge-description"));
			
			userWhoRecibesFeedText = getText(userWhoRecibesFeed);
			userWhoSendsFeedText = getText(userWhoSendsFeed);
			valueFeedText = getText(valueFeed);
			
			index++;
		}
		
		if ( userWhoRecibesFeedText.contentEquals("null") ) {
			starFound = false;
			return starFound;
		} else {
			starFound = (( userWhoSendsFeedText.contains(whoSendsName) ) && ( valueToUpperCase.contentEquals(valueFeedText)));
			return starFound;
		}
	}
	
	public RecognitionPage goRecognition() {
		
		myProfileBtn.click();
		return new RecognitionPage(driver);
	}
	
	public boolean thereIsANotification() {
		getElement(By.xpath("\"//div[@class='notifications-button__label']\""));
		return true;
	}
	
	public boolean checkNotification(String whoSent, String value) {
		
		WebElement firstNotName ;
		WebElement valueNot;
		String firstNotNameText;
		String valueNotText;
		
		getElementAndClick(By.xpath("//div[@class='notifications-button__label']"));
		firstNotName = getElement(By.xpath("//span[@class='notifications-item__content-header']"));
		firstNotNameText = getText(firstNotName);
		valueNot = getElement(By.cssSelector("nav.ui-navbar:nth-child(1) div.ui-navbar__container div.ui-navbar__icon-container div.notifications div.ui-components.suite-segment.notifications-list div.suite-segment__children div.notifications-list__content ul.notifications-list__list li.notifications-item.notifications-item--active div.notifications-item__content div.notifications-item__content-description div:nth-child(1) > span:nth-child(1)"));
		valueNotText = getText(valueNot);
		getElementAndClick(By.xpath("//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button notifications-button--active button--color-')]"));
		
		return ( firstNotNameText.contains(whoSent) && ( valueNotText.contains(value)));
		
	}
	
	public boolean notificationWasRead() {
		
		getElementAndClick(By.xpath("//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button button--color-')]"));
		WebElement notRead = getElement(By.xpath("//span[contains(text(),\"You don't have notifications\")]"));
		getElementAndClick(By.xpath("//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button notifications-button--active button--color-')]"));
		return true;
		
	}
}
