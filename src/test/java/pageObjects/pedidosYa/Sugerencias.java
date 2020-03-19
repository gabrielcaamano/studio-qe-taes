package pageObjects.pedidosYa;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sugerencias extends BasePage {
    public Sugerencias(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//a[@class=\"peyaCard js-fp-card\"])[1]")
    private WebElement firstRec;


 public AgregarAcarrito suggestion(){
    click(firstRec);
    return getNextPage(AgregarAcarrito.class);
 }
}