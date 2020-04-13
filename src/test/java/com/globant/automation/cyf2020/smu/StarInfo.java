package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StarInfo extends BasePage {
    public StarInfo(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//button[contains(@class, 'button--nopadding')])[3]")
    private WebElement editStarBtn;
    @FindBy (xpath = "//div[contains(@class, 'feed-item__description-notes')]")
    private  WebElement editedText;


    public SendStar goToEditStar() {
        click(editStarBtn);
        return getNextPage(SendStar.class);
    }
    public String updatedText(){
        wait(DEFAULT_TIMEOUT);
        return getText(editedText);
    }
}
