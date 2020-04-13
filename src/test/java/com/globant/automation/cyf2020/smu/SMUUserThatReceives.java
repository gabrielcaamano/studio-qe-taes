package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SMUUserThatReceives extends BasePage {
    public SMUUserThatReceives(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div[@class=\"profile-board__btn-wrapper\"]//button")
    private WebElement sendStar;
    @FindBy (xpath = "(//div[@class=\"ui-navbar__logo-container\"]//a)")
    private WebElement goHome;
    @FindBy (xpath = "//div[@class=\"curtain--navbar suite-discovery__curtain\"]")
    private WebElement popUp1;
    @FindBy (xpath = "//span[contains(@class,'suite-discovery')]")
    private  WebElement popUp2;
    @FindBy (xpath = "//span[contains(@class, 'ui-components-icon_comment')]")
    private  WebElement clickToComment;
    @FindBy (xpath = "//div[contains(@class,'public-DraftEditor-content')]")
    private  WebElement theComment;
    @FindBy (xpath = "//span[contains(@class,'ui-components-icon_send-message')]")
   private WebElement sendCommentBtn;
    @FindBy (xpath = "//span[contains(@class, 'counter__value')]")
    private  WebElement amountOfComments;





    public SendStar sendStar(){
        if(popUp1!= null){
            click(popUp1);}
        if (popUp2!= null){
            click(popUp2);
        } if (sendStar!=null){
        click(sendStar);}
        return getNextPage(SendStar.class);

    }

    public String commentOnSentStar(String txt){
       if (popUp1!=null) {
           click(popUp1);}
        if (popUp2!= null){
            click(popUp2);}
        if (clickToComment!=null){
            click(clickToComment);
            type(theComment,txt);
            click(sendCommentBtn);}
        return txt;
    }

    public String howManyCommentsOnTheLastStarReceived(){
        wait(DEFAULT_TIMEOUT);
        return getText(amountOfComments);
    }



    public SMUHome goHome(){
        click(goHome);
        return getNextPage(SMUHome.class);
    }







}
