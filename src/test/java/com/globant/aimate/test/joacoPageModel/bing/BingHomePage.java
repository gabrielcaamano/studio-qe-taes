package com.globant.aimate.test.joacoPageModel.bing;

import com.globant.aimate.annotation.AIFindBy;
import com.globant.aimate.test.joacoPageModel.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BingHomePage extends BasePage {

    public BingHomePage(WebDriver pDriver) {
        super(pDriver);
    }

    @AIFindBy(id = "bLoo")
    private WebElement bingLogo;

    @AIFindBy(id = "sb_form")
    private WebElement inputText;

    @AIFindBy(xpath = "//labelasdasda")
    private WebElement btnSearch;

    public void imBing() {
        getWait().until(ExpectedConditions.visibilityOf(this.bingLogo));
        Assert.assertNotNull(this.bingLogo, "Im not Bing");
    }

    public BingSearchPage search(String text) {
        getWait().until(ExpectedConditions.visibilityOf(this.inputText)).sendKeys(text);
        getActions().sendKeys(Keys.ENTER).perform();
        //this.btnSearch.click();
        return new BingSearchPage(getDriver());
    }




}
