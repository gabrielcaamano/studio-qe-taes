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
        driverG.manage().window().maximize();
    }



    @Test
    public void testGoogleSearch() {
        GoogleHomePage homePage= new GoogleHomePage(driverG);
     GoogleSearchPage resultPage=  homePage.googleSearch("corona");
        String actualText= resultPage.googleSearchResult();
        driverG.quit();
        Assert.assertTrue(actualText.toLowerCase().contains("corona"),"search result text failed");

    }
}
