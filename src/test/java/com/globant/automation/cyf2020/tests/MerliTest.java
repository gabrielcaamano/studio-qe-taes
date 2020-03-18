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
        driverMerli.manage().window().maximize();
    }

    @Test
    public void MerlisTest(){
        MerLiHome home= new MerLiHome(driverMerli);
        MerLiOfertas ofertasPage=  home.merliSales();
        String[] prodsInfo = ofertasPage.getProdpInfo;
        MerLiProd prodPage= ofertasPage.goToProduct();
        String[] getProdInfo = prodPage.getProdInfo;
        driverMerli.quit();

        Assert.assertTrue(prodsInfo.toString().contains(getProdInfo.toString()));

    }




}
