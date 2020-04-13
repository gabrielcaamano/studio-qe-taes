package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfile extends BasePage {
     @FindBy (xpath = "(//strong[@class=\"feed-footer__full-name\"])[1]")
    private WebElement userWhoSentStar;
    @FindBy (xpath = "(//div[@class=\"stat__content\"])[1]")
    private  WebElement starsUserHas;
    @FindBy (xpath = "//span[contains(@class,'suite-discovery__smu--open')]")
    private WebElement popUp1;
    @FindBy (xpath = "//button[contains(@class,'notifications-button')]")
    private  WebElement notifBtn;
    @FindBy (xpath = "//p[@class=\"notifications-list__info\"]")
    private WebElement noNotifsTxt;
    @FindBy (xpath = "(//li[@class=\"ui-navbar__menu-item\"])[1]")
    private WebElement home;
    @FindBy (xpath = "//div[@class=\"tab-panel__item tab-panel__item--active\"]")
    private  WebElement received;
    @FindBy (xpath = "(//span[contains(@class, 'counter__value')])[2]")
    private  WebElement amountOfComments;
    @FindBy (xpath = "//button[contains(@class, 'suite-user_menu__profile-image-icon')]")
    private  WebElement clickToLogOut;
    @FindBy (xpath = "(//button[@class=\"button button--color- button--size-small\"])[1]")
    private  WebElement logOutBtn;
    @FindBy (xpath = "//div[@class=\"notifications\"]")
    private WebElement clickNotif;
    @FindBy (xpath = "(//span[contains(@class, 'counter__value')])[3]")
    private WebElement amountOfLikes;






    public MyProfile(WebDriver driver) {
        super(driver);
    }

    public SMUHome goBackHome(){
        click(home);
        return  getNextPage(SMUHome.class);
    }


    public void clickReceived(){
        click(received);
    }



    public String howManyStars() {
        click(popUp1);
       // click(popUp1);
        return getText(starsUserHas);}

        public String howManyCommentsOnTheLastStarReceived(){
        return getText(amountOfComments);
        }

    public String howManyLikesOnTheLastStarReceived(){
        return getText(amountOfLikes);
    }

        public String starSentBy() {
            return getText(userWhoSentStar);
        }
    public String notification(){
        click(notifBtn);
        return getText(noNotifsTxt);
    }
    public void clickOnNotificationAgain(){
        click(clickNotif);
    }

    public StarMeUpLogin logOut(){
        click(clickToLogOut);
        click(logOutBtn);
        return getNextPage(StarMeUpLogin.class);
    }

    public void clickOnPopUps(){
        if (popUp1!=null){
            click(popUp1);
        }
    }

    }
