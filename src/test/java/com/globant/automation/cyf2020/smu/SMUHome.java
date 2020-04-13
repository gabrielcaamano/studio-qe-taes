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
    private  WebElement theStar;
    @FindBy (xpath = "//input[@class=\"suite-search-box__input\"]")
    private WebElement searchUsersName;
    @FindBy (xpath = "//div[@class=\"search-result-item__content\"]")
    private  WebElement receivingUser;
    @FindBy (xpath = "(//div[@class=\"stat__content\"])[1]")
    private  WebElement starsUserHas;
    @FindBy (xpath = "//button[contains(@class, 'suite-user_menu__profile-image-icon')]")
    private  WebElement profileBtn;
    @FindBy (xpath = "(//button[@class=\"button button--color- button--size-small\"])[1]")
    private  WebElement logOutBtn;
    @FindBy (xpath = "//button[contains(@class,'notifications-button')]")
    private  WebElement notifBtn;
    @FindBy (xpath = "//button[@class=\"button button--transparent button--color- button--size-small\"]")
    private WebElement viewAll;
    @FindBy (xpath = "//p[@class=\"notifications-list__info\"]")
    private WebElement noNotifsTxt;
    @FindBy (xpath = "//span[contains(@class, 'suite-discovery suite-discovery__smu ')]")
     private WebElement popUp1;
    @FindBy (xpath = "//span[contains(@class, 'suite-discovery suite-discovery__smu ')]")
    private WebElement popUp2;
    @FindBy (xpath = "//span[contains(@class, 'suite-discovery suite-discovery__smu ')]")
    private WebElement popUp3;
    @FindBy (xpath = "//div[@class=\"notifications\"]")
    private WebElement clickNotif;
    @FindBy (xpath = "(//div[@class=\"feed-item__content-wrapper\"]//span)[1]")
    private WebElement activityFeedStarSentBy;
    @FindBy (xpath = "//div[@class=\"feed-item__badge-wrapper\"]")
    private WebElement activityFeedStar;
    @FindBy (xpath = "(//li[@class=\"ui-navbar__menu-item\"])[3]")
    private WebElement goToProfile;




    public String nameInfo(){
        return getText(usersName);
    }
    public  String jobInfo(){
        return getText(job);
    }

    public SendStar clickOnAStar(){
        click(theStar);
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
    public Notifications aNotification(){
        click(notifBtn);
        click(viewAll);
        return  getNextPage(Notifications.class);
    }
    public String notification(){
        click(notifBtn);
        return getText(noNotifsTxt);
    }
    public void clickOnNotificationAgain(){
        click(clickNotif);
    }


    public String activityFeedStar(){
        return getText(activityFeedStarSentBy);
    }

    public StarInfo goToStarInfo(){
        click(activityFeedStar);
        return getNextPage(StarInfo.class);
    }


    public StarMeUpLogin logOut(){
        click(profileBtn);
        click(logOutBtn);
        return getNextPage(StarMeUpLogin.class);
    }


    public SMUUserThatReceives searchBar(String user2){
        type(searchUsersName,user2);
        click(receivingUser);
        return getNextPage(SMUUserThatReceives.class);
    }

    public MyProfile goToProfile(){
        click(goToProfile);
        return getNextPage(MyProfile.class);
    }

}
