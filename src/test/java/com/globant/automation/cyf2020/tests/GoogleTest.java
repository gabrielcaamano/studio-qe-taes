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
import pageObjects.GoogleHomePage;
import pageObjects.GoogleSearchPage;

public class GoogleTest {

    private WebDriver driverG;


    @BeforeSuite
    public void openGoogle() {
        WebDriverManager.chromedriver().setup();
        driverG = new ChromeDriver();
        driverG.get("http://www.Google.com/");
    }



    @Test
    public void testGoogleSearch() {
        GoogleHomePage homePage= PageFactory.initElements(driverG, GoogleHomePage.class);
     GoogleSearchPage resultPage=  homePage.googleSearch("Corona");
        String actualText= resultPage.googleSearchResult();
        driverG.quit();
        Assert.assertEquals(actualText,"Cookie Notice. Utilizamos cookies para personalizar contenido y" +
                " anuncios, proporcionar funciones de redes sociales y analizar nuestro tráfico. También ...","search result text failed");

    }
}
