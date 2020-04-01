package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SMUHome extends BasePage {
    public SMUHome(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "user-info__name")
    private WebElement usersName;
    @FindBy (className = "user-info__job")
    private  WebElement job;
    @FindBy (xpath = "(//div[@class=\"core-value__button-wrapper\"]//span)[3]")
    private  WebElement teamworkStar;
    @FindBy (xpath = "//input[@class=\"suite-search-box__input\"]")
    private WebElement searchUsersName;
    @FindBy (xpath = "(//div[@class=\"avatar-media search-result-item__avatar avatar-media__medium\"])[1]")
    private  WebElement receivingUser;
    @FindBy (xpath = "(//div[@class=\"stat__content\"])[1]")
    private  WebElement starsUserHas;
    @FindBy (xpath = "(//button[@class=\"button button--basic button--icon button--nomargin button--nopadding button--transparent suite-user_menu__profile-image-icon button--color-\"])[1]")
    private  WebElement clickToLogOut;
    @FindBy (xpath = "(//button[@class=\"button button--color- button--size-small\"])[1]")
    private  WebElement logOutBtn;
    @FindBy (xpath = "//button[@class=\"button button--icon button--nopadding button--transparent notifications-button button--color-\"]")
    private  WebElement notifBtn;
    @FindBy (xpath = "//span[@class=\"ui-components-icon ui-component-icon ui-components-icon_notification ui-component-icon_medium  ui-component-icon_grey\"]")
    private WebElement notifBtnWhenClicked;
    @FindBy (xpath = "//p[@class=\"notifications-list__info\"]")
    private WebElement noNotifsTxt;
    @FindBy (xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--right suite-discovery__smu--open\"]")
     private WebElement popUp1;
    @FindBy (xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")
    private WebElement popUp2;
    @FindBy (xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--top suite-discovery__smu--open\"]")
    private WebElement popUp3;
    @FindBy (xpath = "//div[@class=\"curtain\"]")
    private WebElement clickAny;
    @FindBy (xpath = "(//div[@class=\"feed-item__content-wrapper\"]//span)[1]")
    private WebElement activityFeedStar;
    @FindBy (xpath = "(//a[@class=\"ui-navbar__menu-link\"])[2]")
    private WebElement goToProfile;




    public String nameInfo(){
        return getText(usersName);
    }
    public  String jobInfo(){
        return getText(job);
    }

    public SendStar clickOnAStar(){
        click(teamworkStar);
        return getNextPage(SendStar.class);
    }
    public String howManyStars(){
        return getText(starsUserHas);
    }
    public void popUps(){

        click(popUp1);
        click(popUp2);
        click(popUp3);
    }

    public String notification(){
        click(notifBtn);
        click(clickAny);
        click(notifBtn);
        return getText(noNotifsTxt);
    }


    public void clickOnce(){
        click(clickAny);
    }


    public String activityFeedStar(){
        return getText(activityFeedStar);
    }


    public StarMeUpLogin logOut(){
        click(clickToLogOut);
        click(logOutBtn);
        return getNextPage(StarMeUpLogin.class);
    }


    public SMUser2 searchBar(String user2){
        type(searchUsersName,user2);
        click(receivingUser);
        return getNextPage(SMUser2.class);
    }

    public MyProfile goToProfile(){
        click(goToProfile);
        return getNextPage(MyProfile.class);
    }

}
