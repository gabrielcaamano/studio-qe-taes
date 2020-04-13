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
    @FindBy (xpath = "//span[contains(@class,'suite-discovery')]")
    private WebElement popUp1;
    @FindBy (xpath = "//span[contains(@class,'suite-discovery')]")
    private  WebElement popUp2;
    @FindBy (xpath = "//span[contains(@class, 'ui-components-icon_comment')]")
    private  WebElement commentBtn;
    @FindBy (xpath = "//div[contains(@class,'public-DraftEditor-content')]")
    private  WebElement commentTxt;
    @FindBy (xpath = "//span[contains(@class,'ui-components-icon_send-message')]")
   private WebElement sendCommentBtn;
    @FindBy (xpath = "//span[contains(@class, 'counter__value')]")
    private  WebElement amountOfComments;
    @FindBy (xpath = "//span[contains(@class, 'ui-components-icon_like')]")
    private  WebElement likeBtn;
    @FindBy (xpath = "(//span[contains(@class, 'counter__value')])[3]")
    private WebElement amountOfLikes;





    public SendStar sendStar(){
        if(popUp1!= null){
            click(popUp1);}
        if (popUp2!= null){
            click(popUp2);
        } if (sendStar!=null){
        click(sendStar);}
        return getNextPage(SendStar.class);

    }
// I have to comment out the pop ups because when i run the whole test it doesn't work with them, but when i do the comment test i have to have them uncommented
    // the same happens with the likes, but i don't understand why considering that i tell it to click on them only if they're present
      public String commentOnSentStar(String txt){
      // if (popUp1!=null) {
          // click(popUp1);}
        //if (popUp2!= null){
          //  click(popUp2);}
        if (commentBtn !=null){
            click(commentBtn);
            type(commentTxt,txt);
            click(sendCommentBtn);}
        return txt;
    }

    public String howManyCommentsOnTheLastStarReceived(){
        wait(DEFAULT_TIMEOUT);
        return getText(amountOfComments);
    }

    public String likeTheLastStarSent(){
        //if (popUp1!=null) {
          //  click(popUp1);}
        //if (popUp2!= null){
           // click(popUp2);}
        if (commentBtn !=null) {
            click(likeBtn);
        }
        wait(DEFAULT_TIMEOUT);
        return getText(amountOfLikes);
    }



    public SMUHome goHome(){
        click(goHome);
        return getNextPage(SMUHome.class);
    }







}
