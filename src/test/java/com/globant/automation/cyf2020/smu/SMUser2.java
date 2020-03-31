package com.globant.automation.cyf2020.smu;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SMUser2 extends BasePage {
    public SMUser2(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div[@class=\"profile-board__btn-wrapper\"]//button")
    private WebElement sendStar;
    @FindBy (xpath = "(//div[@class=\"ui-navbar__logo-container\"]//a)")
    private WebElement goHome;
    @FindBy (xpath = "//div[@class=\"curtain--navbar suite-discovery__curtain\"]")
    private WebElement popUp1;
    @FindBy (xpath = "//div[@class=\"suite-discovery__curtain\"]")
    private  WebElement popUp2;



    public SendStar sendStar(){
        click(popUp1);
        click(popUp2);
        click(sendStar);
        return getNextPage(SendStar.class);

    }
    public SMUHome goHome(){
        click(goHome);
        return getNextPage(SMUHome.class);
    }







}
