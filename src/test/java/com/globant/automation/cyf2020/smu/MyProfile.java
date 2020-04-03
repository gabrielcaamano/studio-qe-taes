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
    @FindBy (xpath = "(//div[@class=\"stat__content\"])[1]")
    private  WebElement starsUserHas;
    @FindBy (xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--right suite-discovery__smu--open\"]")
    private WebElement popUp2;
  //  @FindBy (xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")
   // private  WebElement popUp1;
    @FindBy (xpath = "//button[@class=\"button button--icon button--nopadding button--transparent notifications-button button--color-\"]")
    private  WebElement notifBtn;
    @FindBy (xpath = "//p[@class=\"notifications-list__info\"]")
    private WebElement noNotifsTxt;
    @FindBy (xpath = "(//li[@class=\"ui-navbar__menu-item\"])[1]")
    private WebElement home;

    public SMUHome goBackHome(){
        click(home);
        return  getNextPage(SMUHome.class);
    }





    public String howManyStars() {
        click(popUp2);
       // click(popUp1);
        return getText(starsUserHas);}

        public String starSentBy() {
            return getText(userWhoSentStar);
        }
    public String notification(){
        click(notifBtn);
        return getText(noNotifsTxt);
    }

    }
