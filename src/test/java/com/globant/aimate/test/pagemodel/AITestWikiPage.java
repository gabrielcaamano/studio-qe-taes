package com.globant.aimate.test.pagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.globant.aimate.annotation.AIFindBy;

public class AITestWikiPage extends BasePage{


	@AIFindBy(id="searchInput")
	private WebElement searchInput;
	
	@AIFindBy(css = "i[data-jsl10n='search-input-button']")
	//@AIFindBy(xpath = "//button[contains(@class,'pure-button')]")
	private WebElement searchBtn;
	
	public AITestWikiPage(WebDriver driver) {
		super(driver);
		
	}
	
	public AITestWikiArticlePage searchWiki(String textWiki) {
		//getWait().until(ExpectedConditions.visibilityOf(searchBtn));//.elementToBeClickable(searchBtn));
			
			getWait().until(ExpectedConditions.elementToBeClickable(searchBtn));
		
		//SeleniumUtils.getWebElement(,searchBtn,10);
		
		
	

		searchInput.sendKeys(textWiki);	
		searchBtn.click();
		return new AITestWikiArticlePage(getDriver()); 
				
	}
	
	
	public WebElement getSearchInput() {
		return searchInput;
	}
	public void setSearchInput(WebElement searchInput) {
		this.searchInput = searchInput;
	}


	
}
