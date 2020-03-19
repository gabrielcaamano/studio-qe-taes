package pageObjects.mercadoLibre;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MvdTienda extends BasePage {
    public MvdTienda(WebDriver driver) {
        super(driver);
    }

     @FindBy (className = "breadcrumb__title")
    private WebElement nmbrTnd;


    public String tiendaBuscada() {
        return nmbrTnd.getText();
    }


}
