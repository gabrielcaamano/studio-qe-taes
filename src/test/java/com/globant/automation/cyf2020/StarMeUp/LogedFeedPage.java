package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.automation.cyf2020.tests.LoginStarMeUpTest.GLOBANTVALUES;

public class LogedFeedPage extends StarMeUp {

	public LogedFeedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h3[@class='user-info__name']")
	private WebElement infoNameLastname;

	@FindBy(className = "user-info__job")
	private WebElement infoJob;

	@FindBy(xpath = "//div[@class='profile-stats']//div[1]//div[1]//div[1]//div[2]")
	private WebElement recibedStars;

	@FindBy(xpath = "//div[@class='profile-stats']//div[2]//div[1]//div[1]//div[2]")
	private WebElement sentStars;

	@FindBy(xpath = "//div[contains(@class,\"send-star__colleague-wrapper\")]//input")
	private WebElement searchColleagueInputWHO;

	@FindBy(xpath = "//div[@class='send-star__message-textarea']//div[@class='DraftEditor-root']")
	WebElement messageBox;

	@FindBy(xpath = "//div[@class='send-star__message-textarea']//div[@class='notranslate public-DraftEditor-content']")
	private WebElement messageInput;

	@FindBy(xpath = "//button[@class='button button--nomargin-right button--transparent button--color-']")
	private WebElement sendStarBtn;

	@FindBy(xpath = "//div[contains(@class,'suite-segment__children')]//div[1]//div[2]//span[2]//div[1]//span[2]")
	private WebElement commentAmount;

	@FindBy(xpath = "//div[@class='suite-segment__children']//div[1]//div[2]//span[2]//div[2]//span[2]")
	private WebElement likeAmount;

	@FindBy(xpath = "//div[contains(@class,'suite-segment__children')]//div[1]//div[2]//span[2]//div[1]")
	private WebElement commentBtn;

	@FindBy(xpath = "//div[@class='suite-accordion__body suite-accordion__body--expanded']//div[@class='DraftEditor-root']")
	private WebElement addACommentBox;
	String addACommentBoxXpath = "//div[@class='suite-accordion__body suite-accordion__body--expanded']//div[@class='messages__input']";

	@FindBy(xpath = "//div[@class='suite-accordion__body suite-accordion__body--expanded']//div[@class='notranslate public-DraftEditor-content']")
	private WebElement addACommentInput;

	@FindBy(xpath = "//span[@class=\"ui-components-icon ui-component-icon ui-components-icon_send-message ui-component-icon_small messages__input-icon ui-component-icon_white messages__input-icon \"]")
	private WebElement sendCommentIcon;

	private String namePage = "";
	private String lastnamePage = "";
	private String deliveryConfirmationText;
	private int recibedStarsBefore;
	private int sentStarsBefore;
	private int recibedStarsAfter;
	private int sentStarsAfter;
	private boolean popUpRecognition = true;

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
		recibedStarsBefore = Integer.parseInt(getText(recibedStars, EXTENDED_TIMEOUT));
	}

	public void setRecibedStarsAfter() {
		recibedStarsAfter = Integer.parseInt(getText(recibedStars, EXTENDED_TIMEOUT));
	}

	public void setSentStarsBefore() {
		sentStarsBefore = Integer.parseInt(getText(sentStars, EXTENDED_TIMEOUT));
	}

	public void setSentStarsAfter() {

		sentStarsAfter = Integer.parseInt(getText(sentStars, EXTENDED_TIMEOUT));
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

	public void setPopUpRecognition(boolean popUpRecognitionDisplayed) {
		popUpRecognition = popUpRecognitionDisplayed;
	}

	public WebElement switchValueBtn(GLOBANTVALUES value) {

		switch (value) {
		case INTEGRITY:
			return globantIntegrityValue;
		case EXCELLENCE:
			return globantExcellenceValue;
		case TEAMWORK:
			return globantTeamworkValue;
		case INNOVATION:
			return globantInnovationValue;
		case LEARNING:
			return globantLearningValue;
		case THINK_BIG:
			return globantThinkBigValue;
		default:
			return globantExcellenceValue;

		}

	}

	public void selectValueAndSendAStar(String who, GLOBANTVALUES value, boolean popUpRecognitionDisplayed) {

		setPopUpRecognition(popUpRecognitionDisplayed);
		avoidPopUps();
		WebElement valueBtn = switchValueBtn(value);
		click(valueBtn, EXTENDED_TIMEOUT);
		type(searchColleagueInputWHO, who, EXTENDED_TIMEOUT);
		WebElement userToStar = getElement(By.xpath("//div[@class='search-result-item__content']"), EXTENDED_TIMEOUT);
		click(userToStar);
		click(messageBox);
		messageInput.sendKeys("This is an automation star");
		sendStarBtn.click();

	}

	public void searchUserAndSendAStar(String who, String value, boolean popUpRecognitionDisplayed) {

		setPopUpRecognition(popUpRecognitionDisplayed);
		searchUser(who);

	}

	public RecognitionPage searchUser(String who) {

		avoidPopUps();
		clickPresentElement(searchColleagueInput);
		type(searchColleagueInput, who, EXTENDED_TIMEOUT);
		getElementAndClick(By.cssSelector(
				"nav.ui-navbar:nth-child(1) div.ui-navbar__container div.ui-navbar__search-container div.search-wrapper div.search-results.search-results-starmeup ul.search-result-list.search-result-list--restricted-height.search-result-list--restricted-height-starmeup div.search-result-list__wrapper.search-result-list__wrapper--starmeup li.search-result-item.search-result-item--visitable div.search-result-item__content div.avatar-media.search-result-item__avatar.avatar-media__medium div.avatar-media__body > h4.heading"),
				EXTENDED_TIMEOUT);
		getElementAndClick(By.xpath(
				"//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]"),
				EXTENDED_TIMEOUT);
		return new RecognitionPage(driver, popUpRecognition);

	}

	public static void scrollToBottom(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,300)");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void avoidPopUps() {

		if (isElementPresent(By.xpath(
				"//span[@class='suite-discovery suite-discovery__smu suite-discovery__smu--right suite-discovery__smu--open']"),
				EXTENDED_TIMEOUT)) {
			getElement(By.xpath(
					"//span[@class='suite-discovery suite-discovery__smu suite-discovery__smu--right suite-discovery__smu--open']"))
							.click();
			getElementAndClick(By.xpath(
					"//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--right suite-discovery__smu--open\"]"),
					EXTENDED_TIMEOUT);
			getElementAndClick(By.xpath(
					"//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]"),
					EXTENDED_TIMEOUT);
			getElementAndClick(By.xpath("//span[contains(@class, \"suite-discovery__smu--open\")]"), EXTENDED_TIMEOUT);
			click(activityFeedBtn);
		}
	}

	public String starDeliveryChecking() {

		WebElement deliveryConfirmation = getElement(By.xpath("//p[@class=\"confirmation__header-message\"]//span"));
		deliveryConfirmationText = getText(deliveryConfirmation);
		getElementAndClick(By.xpath("//i[@class='close large icon confirmation__close']"), EXTENDED_TIMEOUT);
		System.out.println(deliveryConfirmationText);
		return deliveryConfirmationText;
	}

	public boolean searchStarOnActivityFeed(String whoRecibesName, GLOBANTVALUES value, String whoSendsName) {

		boolean starFound = true;
		activityFeedBtn.click();
		WebElement userWhoRecibesFeed = getElement(By.xpath("//span[@class=\"feed-item__avatar-name--cursor\"]"));
		WebElement userWhoSendsFeed = getElement(By.xpath("//strong[@class=\"feed-footer__full-name\"]"));
		WebElement valueFeed = getElement(By.xpath("//div[@class=\"feed-item__badge-description\"]"));
		String userWhoRecibesFeedText = getText(userWhoRecibesFeed);
		String userWhoSendsFeedText = getText(userWhoSendsFeed);
		String valueFeedText = getText(valueFeed);
		String valueStr;
		valueStr = value.getValue().toUpperCase();

		userWhoRecibesFeedText = getText(userWhoRecibesFeed);
		userWhoSendsFeedText = getText(userWhoSendsFeed);
		valueFeedText = getText(valueFeed);
		starFound = ((userWhoSendsFeedText.contains(whoSendsName)) && (valueStr.contentEquals(valueFeedText)));
		return starFound;

	}

	public RecognitionPage goRecognition() {

		myProfileBtn.click();
		return new RecognitionPage(driver, popUpRecognition);
	}

	public boolean thereIsANotification() {
		getElement(By.xpath("//div[@class=\"notifications-button__label\"]"));
		return true;
	}

	public boolean checkStarNotification(String whoSent, GLOBANTVALUES value) {

		WebElement firstNotName;
		WebElement valueNot;
		String firstNotNameText;
		String valueNotText;

		getElementAndClick(By.xpath("//div[@class='notifications-button__label']"), EXTENDED_TIMEOUT);
		firstNotName = getElement(By.xpath("//span[@class='notifications-item__content-header']"));
		firstNotNameText = getText(firstNotName);
		valueNot = getElement(By.cssSelector(
				"nav.ui-navbar:nth-child(1) div.ui-navbar__container div.ui-navbar__icon-container div.notifications div.ui-components.suite-segment.notifications-list div.suite-segment__children div.notifications-list__content ul.notifications-list__list li.notifications-item.notifications-item--active div.notifications-item__content div.notifications-item__content-description div:nth-child(1) > span:nth-child(1)"));
		valueNotText = getText(valueNot);
		getElementAndClick(By.xpath(
				"//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button notifications-button--active button--color-')]"),
				EXTENDED_TIMEOUT);

		return (firstNotNameText.contains(whoSent) && (valueNotText.contains(value.getValue())));

	}

	public boolean checkCommentNotification(String whoSent, GLOBANTVALUES value) {

		getElementAndClick(By.xpath("//div[@class='notifications-button__label']"), EXTENDED_TIMEOUT);
		WebElement firstNotName = getElement(By.xpath("//span[@class='notifications-item__content-header']"));
		WebElement valueNot = getElement(By.cssSelector("span:nth-child(3)"));
		String firstNotNameText = getText(firstNotName);
		String valueNotText = getText(valueNot);
		getElementAndClick(By.xpath(
				"//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button notifications-button--active button--color-')]"),
				EXTENDED_TIMEOUT);

		return firstNotNameText.contains(whoSent) &&valueNotText.contains(value.getValue());
	}

	public boolean checkLikeNotification(String whoSent) {

		getElementAndClick(By.xpath("//div[@class='notifications-button__label']"), EXTENDED_TIMEOUT);
		WebElement firstNotName = getElement(By.xpath("//span[@class='notifications-item__content-header']"));
		String firstNotNameText = getText(firstNotName);
		getElementAndClick(By.xpath(
				"//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button notifications-button--active button--color-')]"),
				EXTENDED_TIMEOUT);

		return firstNotNameText.contains(whoSent);
	}

	public boolean notificationWasRead() {

		getElementAndClick(By.xpath(
				"//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button button--color-')]"),
				EXTENDED_TIMEOUT);
		WebElement notRead = getElement(By.xpath("//span[contains(text(),\"You don't have notifications\")]"));
		getElementAndClick(By.xpath(
				"//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button notifications-button--active button--color-')]"),
				EXTENDED_TIMEOUT);
		return true;

	}

	public int getAmount(String amountOf) {
		
		switch (amountOf) {
		case "commentAmount":
			return Integer.parseInt(getText(commentAmount));
		case "likeAmount":
			return Integer.parseInt(getText(likeAmount));
		}
		return 0;

	}

	public void likear() {

		clickPresentElement(getElement(By.xpath("//div[contains(@class,'feed-footer feed-footer--dark')]//div[2]")));
	}

	public void comment() {

		clickPresentElement(commentBtn);
		clickPresentElement(addACommentBox);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
		}
		type(addACommentInput, "This is an automation comment");
		sendCommentIcon.click();
		wait(DEFAULT_TIMEOUT);

	}

	public boolean checkComment(String whoSent) {

		WebElement nameComment = getElement(By.xpath("//span[@class=\"message-item__author-name\"]"));
		String nameCommentText = getText(nameComment);
		return nameCommentText.contains(whoSent);

	}
}
