package pageObjects.mercadoLibre;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MerLiProd extends BasePage{


    public MerLiProd(WebDriver driver) {
        super(driver);
    }


//(//div[@class=\"layout-description-wrapper\"]//span[@class=\"price-tag-fraction\"])[2]
    @FindBy (xpath = "(//div[@class=\"layout-col layout-col--right\"]//h1)")
    private WebElement nameP;
    @FindBy (xpath = "(//div[@class =\"layout-col layout-col--right\"]//span[@class=\"price-tag-fraction\"])[2]")
    private WebElement priceP;
    @FindBy (xpath="//div[@class=\"price-tag discount-arrow arrow-left\"]//p")
    private WebElement saleP;


    // i think if i only use getter itll be alright  <--- she really thought huh

    public String getNameP(){
        return getText(nameP);
    }

    public String getPriceP(){
        return getText(priceP);
    }
    public String getSaleP(){
        return getText(saleP);
    }

    public  String[] infoProd ={ getSaleP(),getNameP(),getPriceP()};
    }


