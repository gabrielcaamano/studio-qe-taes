package com.globant.automation.cyf2020.tests;

import com.globant.automation.cyf2020.smu.SMUHome;
import com.globant.automation.cyf2020.smu.StarMeUpLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.Struct;

public class SMUTest {
    private WebDriver driver;

    @BeforeSuite
    public void openSMU() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uat.starmeup.com/login.html");
    }

    @Test
     public void  testingLogin(){
        StarMeUpLogin loginPage= new StarMeUpLogin(driver);
        String username= loginPage.usernameLogin("user60@bootcampsqe.com");
        SMUHome loggedIn= loginPage.passwordLoginComplete("user60@bootcampsqe.com");
        String usersNamesAre= loggedIn.nameInfo();
        String usersJobIs= loggedIn.jobInfo();
        String[] usernames= usersNamesAre.split(",",2);



        Assert.assertTrue(username.contains(usernames[0]));


    }
    @AfterSuite
    public  void close(){
        driver.quit();
    }













}
