package com.globant.aimate.test.joacoPageModel;

import com.globant.aimate.annotation.AIElementLocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(new AIElementLocatorFactory(pDriver, pDriver), this);
        wait = new WebDriverWait(pDriver, 60);
        driver = pDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

}
