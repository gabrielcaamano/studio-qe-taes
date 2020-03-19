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

    @FindBy (xpath ="(//a[@class=\"button\"])[4]")
    private WebElement add;

    public String info(){
        return price.getText();}

        public  Validar goToVal(){
        click(add);
        return getNextPage(Validar.class);
    }





}
