package com.globant.aimate.test.joacoPageModel.apprender;

import com.globant.aimate.annotation.AIFindBy;
import com.globant.aimate.test.joacoPageModel.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AITestApprenderLoginPage extends BasePage {

    public AITestApprenderLoginPage(WebDriver pDriver) {
        super(pDriver);
    }


    @AIFindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton2;


    public String getTextLoginButton() {
        return getWait().until(ExpectedConditions.visibilityOf(this.loginButton2)).getText();
    }


}
