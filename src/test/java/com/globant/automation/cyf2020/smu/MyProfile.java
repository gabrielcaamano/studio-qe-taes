package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfile extends BasePage {
    public MyProfile(WebDriver driver) {
        super(driver);
    }
     @FindBy (xpath = "(//strong[@class=\"feed-footer__full-name\"])[1]")
    private WebElement userWhoSentStar;

    public String starSentBy(){
        return getText(userWhoSentStar);
    }






}
