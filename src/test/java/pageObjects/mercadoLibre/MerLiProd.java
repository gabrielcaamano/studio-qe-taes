package pageObjects.mercadoLibre;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MerLiProd extends BasePage{


    public MerLiProd(WebDriver driver) {
        super(driver);
    }



    @FindBy (xpath = "//*[@id=\"short-desc\"]/div/header/h1")
    private WebElement nameP;
    @FindBy (xpath = "//*[@id=\"productInfo\"]/fieldset[1]/span[2]/span[2]")
    private WebElement priceP;
    @FindBy (xpath="//*[@id=\"productInfo\"]/fieldset[1]/div")
    private WebElement saleP;


    // i think if i only use getter itll be alright  <--- she really thought huh
    public void setNameP(WebElement nameP){
        this.nameP = nameP;
    }
    public WebElement getNameP(){
        return this.nameP;
    }
public String getsName= getText(getNameP());

    public void setPriceP(WebElement priceP){
           this.priceP= priceP;}

    public WebElement getPriceP(){
        return this.priceP;
}

 public String getsPrice= getText(getPriceP());

public WebElement getSaleP(){
        return this.saleP;
}

 public  String getsSale= getText(getSaleP());

    public void setSaleP(WebElement saleP) {
        this.saleP = saleP;
    }

    public String[] getProdInfo={getsName, getsPrice, getsSale};


    }


