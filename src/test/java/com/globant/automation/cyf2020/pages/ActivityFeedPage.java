package com.globant.automation.cyf2020.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class ActivityFeedPage extends BasePage {

	public ActivityFeedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "//h3 [@class = 'user-info__name']")
	private WebElement name;
	
	@FindBy (xpath = "//p [@class = 'user-info__job']")
	private WebElement job;
	
	@FindBy (xpath = "//div [@class = 'stat__content']")
	private WebElement recivedStar;
	
	@FindBy (xpath = "(//div [@class = 'stat__content'])[2]")
	private WebElement sentStar;
	
	@FindBy (xpath= "//strong[@class = 'feed-footer__full-name']")
	private WebElement firstStarSentBy;
	
	@FindBy (xpath = "//div[@class = 'feed-item__badge-description']")
	private WebElement kindOfStar;
	
	@FindBy (xpath = "//span [@class = 'feed-item__avatar-name--cursor']")
	private WebElement starSentTo;
	
	@FindBy (xpath = "//span [contains (@class , 'suite-discovery__smu--open')]")
	private WebElement popUp;
	
	public void clickPopUp() {
		click(popUp);
	}
	
	public String getName() {
		String[] completeName = getText(name).split(" ");
		return completeName[0];	
	}
	
	public String getLastName() {
		String[] completeName = getText(name).split(" ");
		return completeName[1];
	}
	
	public String getJob() {
		return getText(job);
	}
	
	public String amountRecivedStar() {
		return getText(recivedStar);
	}
	
	public String amountSentStar() {
		return getText(sentStar);
	}
	
	public String starSentBy() {
		return getText(firstStarSentBy);
	}
	
	public String kindOfStar() {
		return getText(kindOfStar);
	}
	
	public String starSentTo() {
		return getText(starSentTo);
	}
}
