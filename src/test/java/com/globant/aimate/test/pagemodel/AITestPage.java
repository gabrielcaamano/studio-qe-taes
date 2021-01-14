package com.globant.aimate.test.pagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.globant.aimate.annotation.AIElementLocatorFactory;
import com.globant.aimate.annotation.AIFindBy;

public class AITestPage {
	
	@AIFindBy(id = "nonChangingElementId")
	private WebElement nonChangingElement;

	@AIFindBy(id = "firstExampleId")
	private WebElement firstExample;
	
	@AIFindBy(xpath = "//p[text()='Second test: from Text to ID (random new text: 10/28/2019)']")
	private WebElement secondExample;
	
	public AITestPage(WebDriver driver) {
		PageFactory.initElements(new AIElementLocatorFactory(driver), this);
	}
	
	public String getNonChangingElementText() {
		return nonChangingElement.getText();
	}
	
	public String getFirstExampleText() {
		return firstExample.getText();
	}

	public String getSecondExampleText() {
		return secondExample.getText();
	}

}
