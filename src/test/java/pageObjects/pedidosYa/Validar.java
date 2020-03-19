package pageObjects.pedidosYa;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Validar extends BasePage {

    public Validar(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "(//div[@class=\"data\"]//span)[1]")
    private WebElement addressCheck;
    @FindBy (xpath = "(//ul[@class=\"cart_items\"]//div[@class=\"price\"]")
    private WebElement priceCheck;
   @FindBy (xpath = "//a[@class=\"button full-width\"]")
    private WebElement cont;


   public String addressRight() {
     return getText (addressCheck);
    }
     public  String priceRight() {
    return getText(priceCheck);
    }

 public PopUpReg continues(){
    click(cont);
    return getNextPage(PopUpReg.class);
 }
}