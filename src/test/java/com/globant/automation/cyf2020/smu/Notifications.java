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
    @FindBy (xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")
    private WebElement popUp;
    @FindBy (xpath = "(//div[@class=\"notificationsHistory__item--text\"])[1]")
    private WebElement firstNotifsTxt;


    public String getsTheText(){
        return getText(firstNotifsTxt);
    }


    public NotificationInfo goToNotificationInfo(){
       // click(popUp);
        click(firstNotif);
        return  getNextPage(NotificationInfo.class);
    }









}