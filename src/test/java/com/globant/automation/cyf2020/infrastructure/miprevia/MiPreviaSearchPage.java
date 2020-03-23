package com.globant.automation.cyf2020.infrastructure.miprevia;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiPreviaSearchPage extends BasePage {
    public MiPreviaSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div[@class=\"col s4 offset-s3\"]//input")
    private WebElement searchIngredient;
    @FindBy (xpath = "//div[@class=\"row\"]//button")
    private  WebElement searchBtn;
    @FindBy (xpath = "(//div[@class=\"card\"]//i)[2]")
    private WebElement drink2;


    public String insertIngredientAndSearch(String validIngredient){
        type(searchIngredient,validIngredient);
        click(searchBtn);
        return getText(searchIngredient);
    }

    public SecondDrinkListed goToDrinkTwo(){
        click(drink2);
        return getNextPage(SecondDrinkListed.class);
    }
}
