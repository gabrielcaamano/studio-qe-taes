package pageObjects.pedidosYa;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class PopUpReg extends BasePage {
    public PopUpReg(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div[@class=\"columns text-center\"]//h1]")
    private WebElement registro;


 public String register(){
    return registro.getText();
 }



}
