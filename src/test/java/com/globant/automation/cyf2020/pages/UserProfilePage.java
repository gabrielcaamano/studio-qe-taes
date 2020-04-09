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
	
	@FindBy (xpath= "(//strong[@class = 'feed-footer__full-name'])[1]")
	private WebElement starSentBy;
	
	@FindBy (xpath = "//div[@class = 'feed-item__badge-description']")
	private WebElement kindOfStar;
	
	@FindBy (xpath = "//span [@class = 'feed-item__avatar-name--cursor']")
	private WebElement starSentTo;
	
	@FindBy (xpath = "//span [@class= 'ui-components-suite__toast__text']")
	private WebElement starWasSent;
	
	@FindBy (xpath = "(//div [contains (@class, 'action-link--active')] //span)[2]")
	private WebElement recognition;
	
	@FindBy (xpath = "( //span [@class = 'counter__value'])[2]")
	private WebElement amountCommentsOfLastStarRecived;
	
	@FindBy (xpath = "( //span [@class = 'counter__value'])[1]")
	private WebElement amountCommentsOfLastStarSent;
	
	@FindBy (xpath = "(//div [@class = 'counter feed-footer__counter'])[1]")
	private WebElement firstClickToComment;
	
	@FindBy (xpath = "(//div [@class = 'notranslate public-DraftEditor-content'])[1]")
	private WebElement whereComment;
	
	@FindBy (xpath = "//span [contains (@class, 'ui-components-icon_send-message')]")
	private WebElement sendComment;
	
	@FindBy (xpath = "//div[contains (@class, 'message-item__text')]")
	private WebElement textOfComment;
	
	@FindBy (xpath = "//span [contains (@class, 'ui-components-icon_comment')] ")
	private WebElement commentInRecivedStar;
	
	public void clickPopUp() {
		if (isElementDisplayed(popUp, ANIMATION_DURATION)) {
			click(popUp);
		}
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
	
	public void clickRecognition() {
		click(recognition);
	}
	
	public String getAmountCommentsOfLastStarRecived() {
		wait(DEFAULT_TIMEOUT);
		return getText(amountCommentsOfLastStarRecived);
	}
	
	public String getAmountCommentsOfLastStarSent() {
		wait(DEFAULT_TIMEOUT);
		return getText(amountCommentsOfLastStarSent);
	}
	
	public void comment (String text) {
		click(firstClickToComment);	
		whereComment.sendKeys(text);
		click(sendComment);
	}
	
	public String lastCommentInSentStar() {
//		click(firstClickToComment);
		return getText(textOfComment);
	}
	
	public String lastCommentInRecivedStar() {
		click(commentInRecivedStar);
		return getText(textOfComment);
	}
	
	
}
