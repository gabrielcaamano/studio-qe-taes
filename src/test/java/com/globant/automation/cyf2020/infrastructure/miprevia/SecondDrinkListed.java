package com.globant.automation.cyf2020.infrastructure.miprevia;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondDrinkListed extends BasePage {
    public SecondDrinkListed(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "((//div[@class=\"col s6\"]//h5[@class=\"white-text\"])[1])//p")
    private WebElement ingredients;


    public String getAllIngredients(){
        return getText(ingredients);
    }



}
