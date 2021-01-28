package com.globant.aimate.test.joacoPageModel.bing;

import com.globant.aimate.annotation.AIFindBy;
import com.globant.aimate.test.joacoPageModel.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BingSearchPage extends BasePage {

    public BingSearchPage(WebDriver pDriver) {
        super(pDriver);
    }

    @AIFindBy(xpath = "(//div//h2//aasd)[2]")
    private WebElement search;


    public String searchSuccess() {
        return getWait().until(ExpectedConditions.visibilityOf(this.search)).getText();
    }
}
