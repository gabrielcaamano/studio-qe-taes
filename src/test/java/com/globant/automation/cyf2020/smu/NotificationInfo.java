package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationInfo extends BasePage {
    public NotificationInfo(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//a[@class=\"ui-navbar__menu-link\"])[1]")
    private WebElement home;

    public SMUHome goBackHome(){
        click(home);
        return  getNextPage(SMUHome.class);
    }





}
