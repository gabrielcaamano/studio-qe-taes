package com.globant.automation.cyf2020.tests;

import com.globant.automation.cyf2020.smu.*;
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

    @Test (priority = 1)
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


        SMUser user2= new SMUser();
        user2.setName("username68");
        SMUser2 sendStar= loggedIn.searchBar(user2.getName());
        SendStar sendingTheStar= sendStar.sendStar();
        String messageForUser2= sendingTheStar.sendingStar("gr8 work");
        SMUser2 backToUser2= sendingTheStar.closeConfirmation();
        SMUHome backToHome= backToUser2.goHome();

    }



   /* @Test (priority = 2)
    public void testingGiveStar(){
        SMUser user2 = new SMUser();
        user2.setName("username68");
        SMUHome smuHome= new SMUHome(driver);
        SendStar sendStar= smuHome.clickOnAStar();
        String thisStarIsFor= sendStar.giveStarTo(user2.getName());
        String messageForUser2= sendStar.sendStar("gr8 bro");
        SMUHome backToStart= sendStar.closeConfirmation();



    }
*/






   //@AfterSuite
   // public  void close(){
     //   driver.quit();
  //  }



    }













