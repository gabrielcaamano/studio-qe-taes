package pageObjects.mercadoLibre;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BingSearchPage;

public class MerLiHome extends BasePage {
    public MerLiHome(WebDriver driver) {
        super(driver);
    }
//change xpath
   @FindBy(xpath = "(//li[@class=\"nav-menu-item\"]//a[@class=\"nav-menu-item-link\"])[3]")
    private WebElement ofertasSem;
    @FindBy(xpath = "(//li[@class=\"nav-menu-item\"]//a[@class=\"nav-menu-item-link\"])[2]")
    private WebElement tiendasOf;


    public MerLiOfertas merliSales () {
        click(ofertasSem);
        return getNextPage(MerLiOfertas.class);
    }
    public MerliTiOf merliOfs(){
        click(tiendasOf);
        return  getNextPage(MerliTiOf.class);
    }
}
