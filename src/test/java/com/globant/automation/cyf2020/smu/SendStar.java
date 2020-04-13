package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendStar extends BasePage {
    public SendStar(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//div[@class=\"value-icon\"])[3]")
    private WebElement star;
    @FindBy (xpath = "//div[@class=\"notranslate public-DraftEditor-content\"]")
    private WebElement whyStar;
    @FindBy (xpath = "//button[@class=\"button button--nomargin-right button--transparent button--color-\"]")
    private  WebElement sendStarBtn;
    @FindBy (xpath = "//h2[@class=\"confirmation__header-title\"]")
    private WebElement confirmationTxt;
    @FindBy (xpath = "//i[@class=\"close large icon confirmation__close\"]")
    private WebElement closeConf;




    public String sendingStar(String txt) {
        click(star);
        type(whyStar,txt);
        click(sendStarBtn);
        return txt;
    }

    public String successfullySentStar(){
        return getText(confirmationTxt); }

        public SMUUserThatReceives closeConfirmation(){
        click(closeConf);
        return getNextPage(SMUUserThatReceives.class);
        }












}






