package pageObjects.mercadoLibre;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BingSearchPage;

public class MerLiOfertas extends BasePage {
    public MerLiOfertas(WebDriver driver) {
        super(driver);
    }

    //elements i need are product name, price and discount
    @FindBy (xpath = "//*[@id=\"MLU456717578\"]/a/div/h2/span")
    private WebElement productName;
    @FindBy(xpath = "//*[@id=\"MLU456717578\"]/a/div/div[1]/span[2]")
    private  WebElement productPrice;
    @FindBy (xpath = "//*[@id=\"MLU456717578\"]/a/div/div[2]")
    private WebElement productDiscount;
    @FindBy (xpath = "//*[@id=\"MLU456717578\"]/a/div")
    private WebElement clickProduct;


//if the any of the elements change, i can use setters

public void setProductName(WebElement productName){
     this.productName = productName;
}
// rmr getter no tienen parametros bc they are getting what you want, setters do set a value
public WebElement getProductName(){
    return this.productName;
}
    public String getPname= getText(getProductName());

public void setProductPrice(WebElement productPrice){
    this.productPrice= productPrice;
}
public WebElement getProductPrice(){
    return this.productPrice;
}
    public String getPprice= getText(getProductPrice());

    public void setProductDiscount(WebElement productDiscount) {
        this.productDiscount = productDiscount;
    }

    public WebElement getProductDiscount() {
        return productDiscount;
    }

    public String getPsale= getText(getProductDiscount());

    public MerLiProd goToProduct () {
        click(clickProduct);
        return getNextPage(MerLiProd.class);
    }
}






