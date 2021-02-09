package com.globant.aimate.test.infrastructure;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseWebTests {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
