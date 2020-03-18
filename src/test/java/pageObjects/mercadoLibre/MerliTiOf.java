package pageObjects.mercadoLibre;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class MerliTiOf extends BasePage {


    public MerliTiOf(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath= ("//div[@class=\"container-card-logo\"])[2]"))
            private WebElement montevideo;



}
