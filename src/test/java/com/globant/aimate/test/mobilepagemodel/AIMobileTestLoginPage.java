package com.globant.aimate.test.mobilepagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.globant.aimate.annotation.AIFindBy;

public class AIMobileTestLoginPage extends AIMobileTestPage{

	@AIFindBy(id="appLogo")
	private WebElement validateAppLogo;
	
	@AIFindBy(id = "fragment_landing_text_view_title_line_2")
	private WebElement validateStartMeAppLogo;
	
	@AIFindBy(id = "fragment_landing_button_sign_in")
	private WebElement btnEnterStartMe;
	
	

	public AIMobileTestLoginPage (WebDriver driver) {
		super(driver);
		
	}
	

	
	public AIMobileTestLoginPage enterLogin(WebDriver driver) {
		//getWait().until(ExpectedConditions.visibilityOf(getValidateAppLogo()));
		getWait().until(ExpectedConditions.visibilityOf(getValidateStartMeAppLogo()));
		getWait().until(ExpectedConditions.elementToBeClickable(getBtnEnterStartMe()));
		btnEnterStartMe.click();
		
		return new AIMobileTestLoginPage(getDriver());
	}	
	

	public WebElement getValidateAppLogo() {
		return validateAppLogo;
	}

	public WebElement getValidateStartMeAppLogo() {
		return validateStartMeAppLogo;
	}

	public WebElement getBtnEnterStartMe() {
		return btnEnterStartMe;
	}
	
	
	
}
