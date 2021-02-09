package com.globant.animate.test.mhelpagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.globant.aimate.annotation.AIFindBy;

public class SearchResultPage extends BasePage {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AIFindBy (xpath="//paper-button[contains(@class, 'ytd-toggle-button-renderer')]")
	private WebElement filterButton;
	
	@AIFindBy (xpath="(//yt-formatted-string[@class='style-scope ytd-search-filter-renderer'])[7]")
	private WebElement filterByChannel;
	
	@AIFindBy (xpath="(//div/h3/a[@id='video-title'])[1]")
	private WebElement firstVid;
	
	//need to make a webelement list for channels, 
	//that way i can verify that it clicks on the correct channel (?) maybe, idk...
	

}
