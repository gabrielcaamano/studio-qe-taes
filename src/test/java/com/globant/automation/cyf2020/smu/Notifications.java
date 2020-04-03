package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Notifications extends BasePage {
    public Notifications(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//div[@class=\"notificationsHistory__item\"])[1]")
    private WebElement firstNotif;


    public NotificationInfo goToNotificationInfo(){
        click(firstNotif);
        return  getNextPage(NotificationInfo.class);
    }









}