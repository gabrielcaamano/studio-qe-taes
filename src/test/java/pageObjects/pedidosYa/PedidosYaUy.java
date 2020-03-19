package pageObjects.pedidosYa;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PedidosYaUy extends BasePage {
    public PedidosYaUy(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div[@class=\"searchLabelContainer address clearfix\"]//input")
    private WebElement address;
    @FindBy (xpath = "//div[@class=\"content-input-search\"]//input")
    private WebElement food;
    @FindBy (xpath = "//button[@id=\"search\"]")
    private WebElement search;
    @FindBy (xpath = "//a[@class=\"button\"]")
    private WebElement yes;




    public Sugerencias addInfo(String typeAdress, String typeFood){ //types the info and searches
        type(address,typeAdress);
        type(food,typeAdress);
        click(search);
        click(yes);
        return getNextPage(Sugerencias.class);
    }
    public String getAddress(){
        return address.getText();

}
}