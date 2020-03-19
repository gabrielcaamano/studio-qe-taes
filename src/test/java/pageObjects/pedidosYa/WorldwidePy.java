package pageObjects.pedidosYa;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorldwidePy extends BasePage {


    public WorldwidePy(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath ="//a[@id=\"link-uy\"]")
    private WebElement uyFlag;

    public PedidosYaUy clickUy(){
        click(uyFlag);
        return getNextPage(PedidosYaUy.class);
    }

}
