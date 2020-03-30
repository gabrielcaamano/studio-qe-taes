package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StarMeUpLogin extends BasePage {
    public StarMeUpLogin(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//input[@class=\"form control\"]")
   private  WebElement username;
    @FindBy (xpath = "//button[@class=\"btn btn-login\"]")
    private  WebElement nextBtn;
    @FindBy (xpath = "//input[@class=\"js-login\"]")
    private  WebElement password;
    @FindBy (xpath = "(//button[@class=\"btn btn-login\"])[2]")
    private  WebElement loginBtn;


    public String usernameLogin(String email){
        type(username,email);
        click(nextBtn);
        return email;
    }

    public SMUHome passwordLoginComplete(String secretWord){
        type(password,secretWord);
        click(loginBtn);
        return  getNextPage(SMUHome.class);
    }













}
