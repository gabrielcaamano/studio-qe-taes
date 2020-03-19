package pageObjects.mercadoLibre;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MerLiOfertas extends BasePage {
    public MerLiOfertas(WebDriver driver) {
        super(driver);
    }

    //elements i need are product name, price and discount
    @FindBy(xpath = "(//li[@class=\"results-item highlighted article grid product item-info-height-195\"]//h2)[1]")
    private WebElement productName;
    @FindBy(xpath = "(//li[@class=\"results-item highlighted article grid product item-info-height-195\"]//span[@class=\"price__fraction\"])[1]")
    private WebElement productPrice;
    @FindBy(xpath ="(//li[@class=\"results-item highlighted article grid product item-info-height-195\"]//div[@class=\"item__discount\"])[1])")
    private WebElement productDiscount;
    @FindBy(xpath = "(//li[@class=\"results-item highlighted article grid product item-info-height-195\"]//div)[1]")
    private WebElement clickProduct;
  /*  @FindBy (xpath ="//a[@id=\"backToCateg\"]" )
    private WebElement goBack; */


    public String getName(){
       return getText(productName);

    }

    public String getPrice(){
        return getText(productPrice);
    }

    public String getDiscount() {
    return getText(productDiscount);
    }  //gets it when i need it

    public String[]  allInfo ={ getDiscount(), getPrice(), getName()};


    public MerLiProd goToProduct() {
        click(clickProduct);
        return getNextPage(MerLiProd.class);
    }

  /*  public MerLiHome goingBack(){
        click(goBack);
        return getNextPage(MerLiHome.class);
    } */
}






