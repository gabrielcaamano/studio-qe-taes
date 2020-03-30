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


    public String nameInfo(){
        return getText(usersName);
    }
    public  String jobInfo(){
        return getText(job);
    }

}
