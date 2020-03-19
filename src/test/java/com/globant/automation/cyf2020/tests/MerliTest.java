package com.globant.automation.cyf2020.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.mercadoLibre.*;

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
    public void merlisTest() {
        MerLiHome home = new MerLiHome(driverMerli);
        MerLiOfertas ofertasPage = home.merliSales(); //clicks on ofertas semanales
        String pDiscount = ofertasPage.getDiscount(); //gets the first products discount %
        String pName = ofertasPage.getName(); //gets the first products name
        String pPrice = ofertasPage.getPrice(); //gets the first products price
        MerLiProd prodPage = ofertasPage.goToProduct(); //clicks on the first product
        String precioP = prodPage.getPriceP(); //from here down i get the product info from the products page
        String nameP= prodPage.getNameP();
        String descuentoP=prodPage.getSaleP();


        Assert.assertEquals(pName,nameP, "Not the same product name");
        Assert.assertEquals(pPrice,precioP, "Not the same product price");
        Assert.assertEquals(pDiscount,descuentoP, "Discount is not the same");

    }

     @Test
     public void merliTest2() {
        MerLiHome home= new MerLiHome(driverMerli);
         MerliTiOf storesPage=  home.merliOfs(); //clicks on the stores tab
         MvdTienda tienda= storesPage.tiendaSearch("tiendas montevideo");// searches a store in the search bar of that area
         String laTienda= tienda.tiendaBuscada();
         Assert.assertTrue(laTienda.toLowerCase().contains("tiendas montevideo"));
         }

         @AfterSuite
      public  void close(){
             driverMerli.quit();
         }















}