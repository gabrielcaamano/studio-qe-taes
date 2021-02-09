package com.globant.aimate.test.pagemodel;

import com.globant.aimate.annotation.AIFindBy;
import com.globant.aimate.test.infrastructure.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiHome extends BaseWebPage {

    @AIFindBy(id = "searchInput")
    private WebElement searchInput;

    @AIFindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement searchBtn;

    public WikiHome(WebDriver pDriver) {
        super(pDriver);
    }

    public WikiSearchResult search(String text) {
        sendKeys(searchInput, text);
        click(searchBtn);
        return new WikiSearchResult(getDriver());
    }

}
