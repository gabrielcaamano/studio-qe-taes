package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class sendStar extends BasePage{

	public sendStar(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath=("//div[@class='what-value what-value--horizontal']//div[3]"))
	 private WebElement star;
	
	@FindBy (xpath=("//span[contains(@class,'suite-discovery__smu--bottom')]"))
	 private WebElement pop1;
	
	@FindBy (xpath=("//span[contains(@class,'suite-discovery suite-discovery__smu ')]"))
	 private WebElement pop2;
	
	@FindBy (xpath=("//div[@class='notranslate public-DraftEditor-content']"))
	 private WebElement writeReason;
	
	@FindBy (xpath=("//button[@class='button button--nomargin-right button--transparent button--color-']//span"))
	 private WebElement clickSendStar;
	
	public void teamWorkStar() {
		if(pop1 != null) {
			click(pop1);
		} else {
			System.out.println("There is no pop1");
		}
		if (pop2 != null) {
			click(pop2);
		} else {
			System.out.println("There is no pop2");
		} 
		click(star);
	    }
	
	public String write(String message) {
		type(writeReason, message);
		click(writeReason);
		return message;
	}
	
	public void clickSendStar() {
		click(clickSendStar);
	}

	 
	
}
