package com.globant.aimate.test.joacoPageModel;

import com.globant.aimate.annotation.AIElementLocatorFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(new AIElementLocatorFactory(pDriver, pDriver), this);
        wait = new WebDriverWait(pDriver, 60);
        driver = pDriver;
        actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public Actions getActions() { return actions; }

}
