package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendStar extends BasePage {
    public SendStar(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//div[@class=\"value-icon\"])[2]")
    private WebElement star;
    @FindBy (xpath = "//button[@class=\"button button--icon button--nomargin button--nopadding button--transparent send-star__message-textarea-button-emoji send-star__message-textarea-button-element button--color-\"]")
    private WebElement whyStarEmogi;
    @FindBy (xpath = "(//span[@class=\"emoji-mart-emoji\"])[9]")
    private  WebElement emogi;
    @FindBy (xpath = "//button[@class=\"button button--nomargin-right button--transparent button--color-\"]")
    private  WebElement sendStarBtn;
    @FindBy (xpath = "//h2[@class=\"confirmation__header-title\"]")
    private WebElement confirmationTxt;
    @FindBy (xpath = "//i[@class=\"close large icon confirmation__close\"]")
    private WebElement closeConf;




    public void sendingStar() {
        click(star);
        click(whyStarEmogi);
        click(emogi);
        click(sendStarBtn);

    }

    public String successfullySentStar(){
        return getText(confirmationTxt); }

        public SMUser2 closeConfirmation(){
        click(closeConf);
        return getNextPage(SMUser2.class);
        }









    }

