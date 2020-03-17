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

    @FindBy (xpath = "/html/body/header/div/div[2]/ul/li[5]/a")
    private WebElement ofertasSem;
    @FindBy(xpath = "/html/body/header/div/div[2]/ul/li[4]/a")
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
