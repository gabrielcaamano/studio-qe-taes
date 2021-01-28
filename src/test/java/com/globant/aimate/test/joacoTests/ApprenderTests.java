package com.globant.aimate.test.joacoTests;

import com.globant.aimate.test.joacoPageModel.apprender.AITestApprenderLoginPage;
import com.globant.aimate.test.joacoPageModel.apprender.AITestHomePageApprender;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApprenderTests {

    private WebDriver driver;

    @BeforeTest
    public void setupTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.apprender.uy");
        driver.manage().window().maximize();

    }
    @AfterTest
    public void teardown() {
        if(driver!=null) {
            driver.quit();
        }
    }

    @Test
    public void goToLoginPageTest() {
        AITestHomePageApprender apprenderHomePage = new AITestHomePageApprender(driver);
        AITestApprenderLoginPage apprenderLoginPage = apprenderHomePage.goToLoginPage();
        String loginButtonText = apprenderLoginPage.getTextLoginButton();
        Assert.assertEquals(loginButtonText, "Login");
    }

}
