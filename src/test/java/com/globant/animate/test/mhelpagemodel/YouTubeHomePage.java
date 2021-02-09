package com.globant.animate.test.mhelpagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.aimate.annotation.AIFindBy;

public class YouTubeHomePage extends BasePage{

	public YouTubeHomePage(WebDriver driver) {
		super(driver);
		driver.get("http://youtube.com");
	}
	
	@AIFindBy (id="search-input")
	private WebElement searchInput;
	
	@AIFindBy (id="search-icon-legacy")
	private WebElement searchButton;
	
	public SearchResultPage search (String searchFor) {
		searchInput.sendKeys(searchFor);
		getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		return new SearchResultPage(getDriver());
	}

}
