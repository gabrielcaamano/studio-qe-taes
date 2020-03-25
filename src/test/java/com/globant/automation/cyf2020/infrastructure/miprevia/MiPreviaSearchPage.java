package com.globant.automation.cyf2020.infrastructure.miprevia;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiPreviaSearchPage extends BasePage {
    public MiPreviaSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//input[@class=\"mdc-text-field__input white-text\"]")
    private WebElement searchIngredient;
    @FindBy (xpath = "//div[@class=\"row\"]//button")
    private  WebElement searchBtn;
    @FindBy (xpath = "(//div[@class=\"card\"]//i)[2]")
    private WebElement drink2;
    @FindBy (id = "textoIngredientes")
    private WebElement theIngredient;


    public String insertIngredientAndSearch(String validIngredient){
        type(searchIngredient,validIngredient);
        click(searchBtn);
        return validIngredient;
    }
   /* public String getTheIngredientISearched(){
        return getText(theIngredient);
    }*/

    public SecondDrinkListed goToDrinkTwo(){
        click(drink2);
        return getNextPage(SecondDrinkListed.class);
    }
}
