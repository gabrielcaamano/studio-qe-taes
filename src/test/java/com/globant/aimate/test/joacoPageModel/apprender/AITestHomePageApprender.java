package com.globant.aimate.test.joacoPageModel.apprender;

import com.globant.aimate.annotation.AIFindBy;
import com.globant.aimate.test.joacoPageModel.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AITestHomePageApprender extends BasePage {

    public AITestHomePageApprender(WebDriver pDriver) {
        super(pDriver);
    }

    @AIFindBy(xpath = "//a[@class='nav-link']")
    private WebElement goToLoginButton2;

    public AITestApprenderLoginPage goToLoginPage() {
        getWait().until(ExpectedConditions.elementToBeClickable(this.goToLoginButton2)).click();
        return new AITestApprenderLoginPage(getDriver());
    }
}
