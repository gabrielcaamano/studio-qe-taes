package com.globant.automation.cyf2020.tests;

import com.globant.automation.cyf2020.smu.SMUHome;
import com.globant.automation.cyf2020.smu.SMUser;
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
        SMUser user = new SMUser();
        user.setUsersEmail(("user62@bootcampsqe.com"));
        user.setPassword("user62@bootcampsqe.com");
        user.setUsersJob("job_rhxmf");
        user.setName("username62");
        user.setLastName("feed62");
        StarMeUpLogin loginPage= new StarMeUpLogin(driver);
        String username= loginPage.usernameLogin(user.getUsersEmail());
        SMUHome loggedIn= loginPage.passwordLoginComplete(user.getPassword());
        String usersNamesAre= loggedIn.nameInfo();
        String usersJobIs= loggedIn.jobInfo();
       //String[] usernames= usersNamesAre.split(" ",2);
        //String userNumber= username.substring(5,6);



        Assert.assertTrue(usersNamesAre.contains(user.getName()));
        Assert.assertTrue(usersNamesAre.contains(user.getLastName()));
        Assert.assertTrue(usersJobIs.contains(user.getUsersJob()));
        Assert.assertTrue(username.contains(user.getUsersEmail()));

         //
    }
    @AfterSuite
    public  void close(){
        driver.quit();
    }



    }













