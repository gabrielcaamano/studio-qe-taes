package pageObjects.pedidosYa;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgregarAcarrito extends BasePage {
    public AgregarAcarrito(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@class=\"button\"]//i")
    private WebElement price;

    @FindBy (xpath = "(//section[@class=\"optionsContainer\"]//li)[1]")
    private WebElement pick;

    @FindBy (xpath = "//small[@class=\"totalQuantity\"]")
    private  WebElement pickOne

    @FindBy (xpath ="//div[@class=\"tinner\"]//a")
    private WebElement add;

    public String priceInfo(){
        return price.getText();}


        public  Validar goToVal(){
        click(add);
        return getNextPage(Validar.class);
    }





}
