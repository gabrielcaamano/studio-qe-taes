package com.globant.automation.cyf2020.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.aimate.annotation.AIFindBy;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Author: santiago.blanco
 * Date: 4/28/20
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[@content-desc='Content']")));
    }

    @AIFindBy(accessibility = "Content")
    private WebElement contentButton;
    
    @AndroidFindBy(accessibility = "Content")
    private WebElement cosito;

    public void clickContentButton(){
    	System.out.println(cosito.isDisplayed());
        System.out.println(contentButton.isDisplayed());
    }
}
