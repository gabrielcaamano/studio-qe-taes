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

public class RealBingTest {

        private WebDriver driver;


        @BeforeSuite
        public void openBing() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("http://www.bing.com/");
        }



        @Test
        public void testBingSearch() {
            BingHomePage homePage= PageFactory.initElements(driver, BingHomePage.class);
            BingSearchPage resultPage=  homePage.bingSearch("globant");
            String actualText= resultPage.bingSearchResult();
            driver.quit();
            Assert.assertTrue(actualText.toLowerCase().contains("globant"));

        }

    }





