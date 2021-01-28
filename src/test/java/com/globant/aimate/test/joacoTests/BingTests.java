package com.globant.aimate.test.joacoTests;

import com.globant.aimate.test.joacoPageModel.bing.BingHomePage;
import com.globant.aimate.test.joacoPageModel.bing.BingSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BingTests {

    private WebDriver driver;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com");
    }

    @AfterTest
    public void teardown() {
        if(driver!=null) {
            driver.quit();
        }
    }

    @Test
    public void googleSearchs() {
        BingHomePage bingHomePage = new BingHomePage(driver);
        bingHomePage.imBing();
        String searchText = "Nacional";
        BingSearchPage bingSearchPage = bingHomePage.search(searchText);
        Assert.assertTrue(bingSearchPage.searchSuccess().toLowerCase().contains(searchText.toLowerCase()), "Ta Mal");
    }

}
