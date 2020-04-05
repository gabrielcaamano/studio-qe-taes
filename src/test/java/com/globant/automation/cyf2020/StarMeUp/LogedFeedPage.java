package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.By;
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
	private WebElement searchColleagueInputWHO;

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

	@FindBy(css = "nav.ui-navbar:nth-child(1) div.ui-navbar__container div.ui-navbar__search-container div.search-wrapper div:nth-child(1) div.search-results.search-results-starmeup div.ui-components.suite-search-box > input.suite-search-box__input")
	private WebElement searchColleagueInput;

	@FindBy(css = "nav.ui-navbar:nth-child(1) div.ui-navbar__container div.ui-navbar__search-container div.search-wrapper div:nth-child(1) div.search-results.search-results-starmeup div.ui-components.suite-search-box > button.button.button--icon.button--nomargin.suite-search-box__input-button.suite-search-box__input-button--secondary-gray.button--color-")
	private WebElement searchColleagueBtn;

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

	public WebElement switchValueBtn(String value) {

		switch (value) {
		case "Integrity":
			return globantIntegrityValue;
		case "Excellence":
			return globantExcellenceValue;
		case "Teamwork":
			return globantTeamworkValue;
		case "Innovation":
			return globantInnovationValue;
		case "Learning":
			return globantLearningValue;
		case "Think big":
			return globantThinkBigValue;
		default:
			return globantExcellenceValue;

		}

	}

	public void selectValueAndSendAStar(String who, String value, boolean popUpRecognitionDisplayed) {
		
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

	public String switchValueIcon(String value) {

		switch (value) {
		case "Integrity":
			return "div.profile div.fullscreen-modal div.fullscreen-modal__content div.send-star__header-wrapper div.send-star__wrapper div.second-wrapper div.star-container div.what-value.what-value--horizontal div.value-icon:nth-child(1) > img.value-icon__core-value";
		case "Excellence":
			return "div.profile div.fullscreen-modal div.fullscreen-modal__content div.send-star__header-wrapper div.send-star__wrapper div.second-wrapper div.star-container div.what-value.what-value--horizontal div.value-icon:nth-child(2) > img.value-icon__core-value";
		case "Teamwork":
			return "div.profile div.fullscreen-modal div.fullscreen-modal__content div.send-star__header-wrapper div.send-star__wrapper div.second-wrapper div.star-container div.what-value.what-value--horizontal div.value-icon:nth-child(3) > img.value-icon__core-value";
		case "Innovation":
			return "div.profile div.fullscreen-modal div.fullscreen-modal__content div.send-star__header-wrapper div.send-star__wrapper div.second-wrapper div.star-container div.what-value.what-value--horizontal div.value-icon:nth-child(4) > img.value-icon__core-value";
		case "Learning":
			return "div.profile div.fullscreen-modal div.fullscreen-modal__content div.send-star__header-wrapper div.send-star__wrapper div.second-wrapper div.star-container div.what-value.what-value--horizontal div.value-icon:nth-child(5) > img.value-icon__core-value";
		case "Think big":
			return "div.profile div.fullscreen-modal div.fullscreen-modal__content div.send-star__header-wrapper div.send-star__wrapper div.second-wrapper div.star-container div.what-value.what-value--horizontal div.value-icon:nth-child(6) > img.value-icon__core-value";
		default:
			return "";

		}

	}

	public void searchUserAndSendAStar(String who, String value , boolean popUpRecognitionDisplayed) {
		setPopUpRecognition(popUpRecognitionDisplayed);
		avoidPopUps();
		searchColleagueInput.click();
		type(searchColleagueInput, who);
		getElementAndClick(By.cssSelector("nav.ui-navbar:nth-child(1) div.ui-navbar__container div.ui-navbar__search-container div.search-wrapper div.search-results.search-results-starmeup ul.search-result-list.search-result-list--restricted-height.search-result-list--restricted-height-starmeup div.search-result-list__wrapper.search-result-list__wrapper--starmeup li.search-result-item.search-result-item--visitable div.search-result-item__content div.avatar-media.search-result-item__avatar.avatar-media__medium div.avatar-media__body > h4.heading"));
		getElementAndClick(By.xpath("//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]"));
		getElementAndClick(By.cssSelector("div.profile div.profile__container.ui-components.ui-components.ui-container.ui-container--centered div.ui-components.suite-grid div.profile__column--left.ui-components.suite-column.suite-column-desktop-size-3.suite-column-desktop-sm-size-3.hide-from-tablet div.ui-components.suite-panel.profile-board.profile-board--with-stats:nth-child(1) div.ui-components.suite-segment div.suite-segment__children div.profile-board--fade-in div.profile-board__btn-wrapper > button.button.profile-board__btn-wrapper-button.button--color-black"));
		getElementAndClick(By.cssSelector(switchValueIcon(value)));
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

	public boolean searchStarOnActivityFeed(String whoRecibesName, String value, String whoSendsName) {

		int index = 1;
		boolean starFound = true;
		activityFeedBtn.click();
		WebElement userWhoRecibesFeed = getElement(By.cssSelector(
				"div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child("
						+ index
						+ ") div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__avatar-title:nth-child(1) div.feed-item__avatar-name > span.feed-item__avatar-name--cursor"));
		;
		WebElement userWhoSendsFeed = getElement(By.cssSelector(
				"div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child("
						+ index
						+ ") div.feed-footer.feed-footer--dark span.feed-footer__user-info p.feed-footer__prefix-text.feed-footer__prefix-text--smu > strong.feed-footer__full-name"));
		;
		WebElement valueFeed = getElement(By.cssSelector(
				"div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child("
						+ index
						+ ") div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__badge-wrapper:nth-child(2) > div.feed-item__badge-description"));
		String userWhoRecibesFeedText = getText(userWhoRecibesFeed);
		String userWhoSendsFeedText = getText(userWhoSendsFeed);
		String valueFeedText = getText(valueFeed);
		String valueToUpperCase;
		valueToUpperCase = value.toUpperCase();

		while ((userWhoRecibesFeedText.contentEquals("null")) && (!userWhoRecibesFeedText.contains(whoRecibesName))) {

			userWhoRecibesFeed = getElement(By.cssSelector(
					"div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(\" + index + \") div.feed-footer.feed-footer--dark span.feed-footer__user-info p.feed-footer__prefix-text.feed-footer__prefix-text--smu > strong.feed-footer__full-name"));
			userWhoSendsFeed = getElement(By.cssSelector(
					"div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(\" + index + \") div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__avatar-title:nth-child(1) div.feed-item__avatar-name > span.feed-item__avatar-name--cursor"));
			valueFeed = getElement(By.cssSelector(
					"div.home-layout.ui-components.ui-container.ui-container--centered:nth-child(3) div.ui-components.suite-grid div.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-8.suite-column-tablet-size-12:nth-child(2) div.main-panel div.feed div.ui-components.suite-segment:nth-child(2) div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child("
							+ index
							+ ") div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__badge-wrapper:nth-child(2) > div.feed-item__badge-description"));

			userWhoRecibesFeedText = getText(userWhoRecibesFeed);
			userWhoSendsFeedText = getText(userWhoSendsFeed);
			valueFeedText = getText(valueFeed);

			index++;
		}

		if (userWhoRecibesFeedText.contentEquals("null")) {
			starFound = false;
			return starFound;
		} else {
			starFound = ((userWhoSendsFeedText.contains(whoSendsName))
					&& (valueToUpperCase.contentEquals(valueFeedText)));
			return starFound;
		}
	}

	public RecognitionPage goRecognition() {

		myProfileBtn.click();
		return new RecognitionPage(driver, popUpRecognition);
	}

	public boolean thereIsANotification() {
		getElement(By.xpath("\"//div[@class='notifications-button__label']\""));
		return true;
	}

	public boolean checkNotification(String whoSent, String value) {

		WebElement firstNotName;
		WebElement valueNot;
		String firstNotNameText;
		String valueNotText;

		getElementAndClick(By.xpath("//div[@class='notifications-button__label']"));
		firstNotName = getElement(By.xpath("//span[@class='notifications-item__content-header']"));
		firstNotNameText = getText(firstNotName);
		valueNot = getElement(By.cssSelector(
				"nav.ui-navbar:nth-child(1) div.ui-navbar__container div.ui-navbar__icon-container div.notifications div.ui-components.suite-segment.notifications-list div.suite-segment__children div.notifications-list__content ul.notifications-list__list li.notifications-item.notifications-item--active div.notifications-item__content div.notifications-item__content-description div:nth-child(1) > span:nth-child(1)"));
		valueNotText = getText(valueNot);
		getElementAndClick(By.xpath(
				"//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button notifications-button--active button--color-')]"));

		return (firstNotNameText.contains(whoSent) && (valueNotText.contains(value)));

	}

	public boolean notificationWasRead() {

		getElementAndClick(By.xpath(
				"//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button button--color-')]"));
		WebElement notRead = getElement(By.xpath("//span[contains(text(),\"You don't have notifications\")]"));
		getElementAndClick(By.xpath(
				"//button[contains(@class,'button button--icon button--nopadding button--transparent notifications-button notifications-button--active button--color-')]"));
		return true;

	}
}
