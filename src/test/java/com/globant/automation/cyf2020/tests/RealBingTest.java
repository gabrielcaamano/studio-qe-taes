package com.globant.automation.cyf2020.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.bingYgoogle.BingHomePage;
import pageObjects.bingYgoogle.BingSearchPage;

public class RealBingTest {

        private WebDriver driver;


        @BeforeSuite
        public void openBing() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("http://www.bing.com/");
            driver.manage().window().maximize();
        }



        @Test
        public void testBingSearch() {
            BingHomePage homePage= new BingHomePage(driver);
            BingSearchPage resultPage=  homePage.bingSearch("globant");
            String actualText= resultPage.bingSearchResult();
            driver.quit();
            Assert.assertTrue(actualText.toLowerCase().contains("globant"));

        }

    }





