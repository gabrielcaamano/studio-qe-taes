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
        driverMerli.manage().window().maximize();
        driverMerli.get("http://www.mercadolibre.com.uy/");

    }

    @Test
    public void MerlisTest() {
        MerLiHome home = new MerLiHome(driverMerli);
        MerLiOfertas ofertasPage = home.merliSales();
        String pDiscount = ofertasPage.getDiscount();
        String pName = ofertasPage.getName();
        String pPrice = ofertasPage.getPrice();
        MerLiProd prodPage = ofertasPage.goToProduct();
        String precioP = prodPage.getPriceP();
        String nameP= prodPage.getNameP();
        String descuentoP=prodPage.getSaleP();
        driverMerli.quit();

        Assert.assertEquals(pName,nameP, "Not the same product name");
        Assert.assertEquals(pPrice,precioP, "Not the same product price");
        Assert.assertEquals(pDiscount,descuentoP, "Discount is not the same");

    }




}
