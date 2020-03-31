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
    public SMUser2 searchBar(String user2){
        type(searchUsersName,user2);
        click(receivingUser);
        return getNextPage(SMUser2.class);
    }

}
