package com.globant.automation.cyf2020.StarMeUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import com.globant.automation.cyf2020.tests.LoginStarMeUpTest.GLOBANTVALUES;

public class RecognitionPage extends BasePage {

	public RecognitionPage(WebDriver driver, boolean popUpRecognition) {
		super(driver);
		popUpRecognitionDisplayed = popUpRecognition;
	}

	@FindBy(xpath = "//div[@class='tab-panel__item tab-panel__item--active']")
	private WebElement recivedBtn;

	@FindBy(xpath = "//div[@class='tab-panel__item']")
	private WebElement sentBtn;

	@FindBy(xpath = "//div[contains(@class,'suite-segment__children')]//div[1]//div[2]//span[2]//div[1]//span[2]")
	private WebElement commentAmount;

	@FindBy(xpath = "//div[contains(@class,'suite-segment__children')]//div[1]//div[2]//span[2]//div[1]")
	private WebElement commentBtn;

	@FindBy(xpath = "//div[@class='suite-accordion__body suite-accordion__body--expanded']//div[@class='DraftEditor-root']")
	private WebElement addACommentBox;
	String addACommentBoxXpath = "//div[@class='suite-accordion__body suite-accordion__body--expanded']//div[@class='messages__input']";

	@FindBy(xpath = "//div[@class='suite-accordion__body suite-accordion__body--expanded']//div[@class='notranslate public-DraftEditor-content']")
	private WebElement addACommentInput;

	@FindBy(xpath = "//span[@class=\"ui-components-icon ui-component-icon ui-components-icon_send-message ui-component-icon_small messages__input-icon ui-component-icon_white messages__input-icon \"]")
	private WebElement sendCommentIcon;

	@FindBy(xpath = "//div[@class='send-star__message-textarea']//div[@class='notranslate public-DraftEditor-content']")
	private WebElement messageInput;

	@FindBy(xpath = "//button[@class='button button--nomargin-right button--transparent button--color-']")
	private WebElement sendStarBtn;
	
	@FindBy(xpath = "//div[@class='suite-segment__children']//div[1]//div[2]//span[2]//div[2]//span[2]")
	private WebElement likeAmount;

	private boolean popUpRecognitionDisplayed;

	public boolean checkRecognitionSent(String whoRecibed, GLOBANTVALUES value) {

		boolean founded;
		String whoRecibedElementText;
		String valueElementText;
		WebElement whoRecibedElement;
		WebElement valueElement;
		String valueStr;
		valueStr = value.getValue();

		if (popUpRecognitionDisplayed) {
			WebElement popUpRecognitionElement = getElement(By.xpath(
					"//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]"));
			popUpRecognitionElement.click();
		}
		sentBtn.click();
		whoRecibedElement = getElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]"));
		valueElement = getElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]"));

		whoRecibedElementText = getText(whoRecibedElement);
		valueElementText = getText(valueElement);
		valueElementText = valueElementText.toUpperCase();
		founded = ((whoRecibedElementText.contains(whoRecibed)) && (valueStr.contentEquals(valueElementText)));
		return founded;
	}

	public boolean checkRecognitionRecived(String whoSent, GLOBANTVALUES value) {

		boolean founded;
		WebElement whoSentElement;
		WebElement valueElement;
		String whoSentElementText;
		String valueElementText;

		recivedBtn.click();
		whoSentElement = getElement(By.cssSelector(
				"div.profile div.profile__container.ui-components.ui-components.ui-container.ui-container--centered div.ui-components.suite-grid div.profile__main-content.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-6.suite-column-tablet-size-12 div.main-panel div.recognition div.ui-components.suite-segment div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(1) div.feed-footer.feed-footer--dark span.feed-footer__user-info p.feed-footer__prefix-text.feed-footer__prefix-text--smu > strong.feed-footer__full-name"));
		valueElement = getElement(By.cssSelector(
				"div.profile div.profile__container.ui-components.ui-components.ui-container.ui-container--centered div.ui-components.suite-grid div.profile__main-content.ui-components.suite-column.suite-column-desktop-size-6.suite-column-desktop-sm-size-6.suite-column-tablet-size-12 div.main-panel div.recognition div.ui-components.suite-segment div.suite-segment__children div.ui-components.suite-panel.feed-item.suite-panel--nopadding:nth-child(1) div.feed-item__content-wrapper div.feed-item__description-wrapper div.feed-item__badge-wrapper:nth-child(1) > div.feed-item__badge-description"));
		whoSentElementText = getText(whoSentElement);
		valueElementText = getText(valueElement);
		String valueStr;
		valueStr = value.getValue();

		founded = (whoSentElementText.contains(whoSent) && valueElementText.contentEquals(valueStr));

		return founded;
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

	public void sendAStar(String value) {

		getElementAndClick(By.cssSelector(
				"div.profile div.profile__container.ui-components.ui-components.ui-container.ui-container--centered div.ui-components.suite-grid div.profile__column--left.ui-components.suite-column.suite-column-desktop-size-3.suite-column-desktop-sm-size-3.hide-from-tablet div.ui-components.suite-panel.profile-board.profile-board--with-stats:nth-child(1) div.ui-components.suite-segment div.suite-segment__children div.profile-board--fade-in div.profile-board__btn-wrapper > button.button.profile-board__btn-wrapper-button.button--color-black"),
				EXTENDED_TIMEOUT);
		getElementAndClick(By.cssSelector(switchValueIcon(value)), EXTENDED_TIMEOUT);
		messageInput.sendKeys("This is an automation star");
		sendStarBtn.click();

	}


	public int getAmount(boolean popUpPresent, String amountOf) {

		if (popUpPresent) {
			getElementAndClick(By.xpath(
					"//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]"),
					EXTENDED_TIMEOUT);
		}

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
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException ie) { }
		 */
		clickPresentElement(addACommentBox);
		try { Thread.sleep(5000); } catch (InterruptedException ie) { }
		type(addACommentInput, "This is an automation comment");
		sendCommentIcon.click();

	}

	public boolean checkComment(String whoSent) {

		WebElement nameComment = getElement(By.xpath("//span[@class=\"message-item__author-name\"]"));
		String nameCommentText = getText(nameComment);
		return nameCommentText.contains(whoSent);

	}
	
}
