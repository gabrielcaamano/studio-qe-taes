package com.globant.aimate.test.pagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.globant.aimate.annotation.AIFindBy;

public class AITestWikiArticlePage extends BasePage {

	
	public AITestWikiArticlePage(WebDriver driver) {
		super(driver);
		
	}
	
	@AIFindBy(id="firstHeading")
	//@FindBy(css="h1[id=\"firstHeading\"]")
	private WebElement titleWiki;
	
	public String getTitleWiki() {
		return titleWiki.getText();
	}
	
}
