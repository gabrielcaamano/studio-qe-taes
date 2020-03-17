package com.globant.automation.cyf2020.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.BingHomePage;
import pageObjects.BingSearchPage;
import pageObjects.mercadoLibre.MerLiHome;
import pageObjects.mercadoLibre.MerLiOfertas;
import pageObjects.mercadoLibre.MerLiProd;

public class MerliTest {

    private WebDriver driverMerli;


    @BeforeSuite
    public void openMerli() {
        WebDriverManager.chromedriver().setup();
        driverMerli = new ChromeDriver();
        driverMerli.get("http://www.mercadolibre.com.uy/");
    }

    @Test
    public void MerlisTest(){
        MerLiHome home= PageFactory.initElements(driverMerli, MerLiHome.class);
        MerLiOfertas ofertasPage=  home.merliSales();
        String price = ofertasPage.getPprice;
        String name= ofertasPage.getPname;
        String sale= ofertasPage.getPsale;
        MerLiProd prodPage= ofertasPage.goToProduct();
        String price1 = prodPage.getsPrice;
        String name1= prodPage.getsName;
        String sale1= prodPage.getsSale;
        driverMerli.quit();

        Assert.assertEquals(name,name1, "Not the same");
        Assert.assertEquals(price,price1, "Not the same");
        Assert.assertEquals(sale,sale1, "Not the same");
    }




}
