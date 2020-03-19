package pageObjects.mercadoLibre;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BingSearchPage;

import javax.xml.xpath.XPath;

public class MerliTiOf extends BasePage {


    public MerliTiOf(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@class=\"andes-form-control andes-form-control--textfield\"]//input")
    private WebElement searchTienda;

    @FindBy(xpath = "//div[@class=\"andes-card andes-card--animated\"]//img")
    private WebElement clickTmvd;


    public MvdTienda tiendaSearch(String tienda) {
        type(searchTienda, tienda);
        click(clickTmvd);
        return getNextPage(MvdTienda.class);


    }
}
