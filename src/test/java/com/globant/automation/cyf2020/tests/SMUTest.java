package com.globant.automation.cyf2020.tests;

import com.globant.automation.cyf2020.smu.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        SMUser userB = new SMUser();
        userB.setUsersEmail(("user66@bootcampsqe.com"));
        userB.setPassword("user66@bootcampsqe.com");
        userB.setUsersJob("job_egdyn");
        userB.setName("username66");
        userB.setLastName("feed66");
        userB.setStars(1);
        StarMeUpLogin loginPage= new StarMeUpLogin(driver);
        String username= loginPage.usernameLogin(userB.getUsersEmail());
        SMUHome loggedIn= loginPage.passwordLoginComplete(userB.getPassword());
        String usersNamesAre= loggedIn.nameInfo();
        String usersJobIs= loggedIn.jobInfo();
       //String[] usernames= usersNamesAre.split(" ",2);
        //String userNumber= username.substring(5,6);

        Assert.assertTrue(usersNamesAre.contains(userB.getName()), "Name's different");
        Assert.assertTrue(usersNamesAre.contains(userB.getLastName()), "lAST NAME'S ARE DIFFERENT");
        Assert.assertTrue(usersJobIs.contains(userB.getUsersJob()), "NOT THE SAME JOB");
        Assert.assertTrue(username.contains(userB.getUsersEmail()), "BIG NO NO");
        String starsBHas= loggedIn.howManyStars();
        loggedIn.logOut();
        String stars = Integer.toString(userB.getStars());
        Assert.assertTrue(starsBHas.contains(stars), "U GUESSED IT,N O P E FIND OUT WHAT THAT MEANS TO ME, A LIL NO");

       /* SMUser user2= new SMUser();
        user2.setName("username68");
        SMUser2 sendStar= loggedIn.searchBar(user2.getName());
        SendStar sendingTheStar= sendStar.sendStar();
        String messageForUser2= sendingTheStar.sendingStar("gr8 work");
        SMUser2 backToUser2= sendingTheStar.closeConfirmation();
        SMUHome backToHome= backToUser2.goHome();
*/
    }

//li[@class="notifications-item notifications-item--active"]

    @Test (priority = 2)
    public void testingGiveStar(){
        SMUser userA = new SMUser();
        userA.setUsersEmail(("user64@bootcampsqe.com"));
        userA.setPassword("user64@bootcampsqe.com");
        StarMeUpLogin loginPage= new StarMeUpLogin(driver);
        String usernameB= loginPage.usernameLogin(userA.getUsersEmail());
        SMUHome smuHomeB= loginPage.passwordLoginComplete(userA.getPassword());
        SMUser userB= new SMUser();
        userB.setName("username66");
        SMUser2 sendStar= smuHomeB.searchBar(userB.getName());
        SendStar sendingTheStar= sendStar.sendStar();
        sendingTheStar.sendingStar();
        SMUser2 backToUser= sendingTheStar.closeConfirmation();
        SMUHome backToHome= backToUser.goHome();
        backToHome.logOut();


    }
   @Test (priority = 3)
    public void checkStars(){
       SMUser userB = new SMUser();
       userB.setUsersEmail(("user66@bootcampsqe.com"));
       userB.setPassword("user66@bootcampsqe.com");
       userB.setName("username66");
       userB.setLastName("feed66");
       userB.setStars(1);
       SMUser userA = new SMUser();
       userA.setUsersEmail(("user64@bootcampsqe.com"));
       userA.setPassword("user64@bootcampsqe.com");
       userA.setLastName("feed64");
       StarMeUpLogin loginPage= new StarMeUpLogin(driver);
       String username= loginPage.usernameLogin(userB.getUsersEmail());
       SMUHome loggedIn= loginPage.passwordLoginComplete(userB.getPassword());
       //loggedIn.popUps();
       String notification= loggedIn.notification();
       //loggedIn.clickOnce();
       Assert.assertTrue(notification.toLowerCase().contains("don't"));
       String starsBHas= loggedIn.howManyStars();
       int starsAdd= userB.getStars()+1 ;
       String stars = Integer.toString(starsAdd);

       Assert.assertTrue(starsBHas.contains(stars));
      String actStar= loggedIn.activityFeedStar(); //userB should be the first star to appear
      Assert.assertTrue(actStar.contains(userB.getName()),"u r a star, i am human, we r not the same");
      MyProfile myProfile= loggedIn.goToProfile();
      String theStarWasSentBy= myProfile.starSentBy(); //verifies if the star is in received bc the star shows with who sent it
      Assert.assertTrue(theStarWasSentBy.contains(userA.getLastName()), "dont forget to delete these messages");

   }






   //@AfterSuite
   // public  void close(){
     //   driver.quit();
  //  }



    }













