package com.globant.automation.cyf2020.infrastructure.miprevia;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviaHomePage extends BasePage {
    public PreviaHomePage(WebDriver driver) {
        super(driver);
    }


    //change xpath
    @FindBy(xpath = "(//div[@class=\"row center\"]//a)[1]")
    private WebElement btnRecDrink;
    @FindBy(xpath = "//div[@class=\"col m4\"]//span[@class=\"card-title\"]")
    private WebElement drinkName1;
    @FindBy (xpath = "//ul[@class=\"right hide-on-med-and-down\"]//a")
    private  WebElement whatDrink;

    public String getRandomDrink() {
        click(btnRecDrink);
        return getText(drinkName1);
    }

    public MiPreviaSearchPage goToWhatDrink(){
        click(whatDrink);
        return getNextPage(MiPreviaSearchPage.class);
    }
}






