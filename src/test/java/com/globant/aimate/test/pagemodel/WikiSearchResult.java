package com.globant.aimate.test.pagemodel;

import com.globant.aimate.annotation.AIFindBy;
import com.globant.aimate.test.infrastructure.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiSearchResult extends BaseWebPage {

    @AIFindBy(id = "firstHeading")
    private WebElement title;

    public WikiSearchResult(WebDriver pDriver) {
        super(pDriver);
    }

    public String getTitle() {
        return getText(title);
    }

}
