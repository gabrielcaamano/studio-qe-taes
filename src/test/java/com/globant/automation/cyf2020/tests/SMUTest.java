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

import javax.management.Notification;
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
        userB.setUsersEmail(("user69@bootcampsqe.com"));
        userB.setPassword("user69@bootcampsqe.com");
        userB.setUsersJob("job_zxbpb");
        userB.setName("username69");
        userB.setLastName("feed69");
        userB.setStars(6);
        StarMeUpLogin loginPage= new StarMeUpLogin(driver);
        String username= loginPage.usernameLogin(userB.getUsersEmail());
        SMUHome loggedIn= loginPage.passwordLoginComplete(userB.getPassword());
        String usersNamesAre= loggedIn.nameInfo();
        String usersJobIs= loggedIn.jobInfo();
       //String[] usernames= usersNamesAre.split(" ",2);
        //String userNumber= username.substring(5,6);

        Assert.assertTrue(usersNamesAre.contains(userB.getName()), "Name's different");
        Assert.assertTrue(usersNamesAre.contains(userB.getLastName()), "Different last name");
        Assert.assertTrue(usersJobIs.contains(userB.getUsersJob()), "That's not what they work as");
        Assert.assertTrue(username.contains(userB.getUsersEmail()), "It's not their email");
        String starsBHas= loggedIn.howManyStars();
        loggedIn.logOut();
        String stars = Integer.toString(userB.getStars());
        Assert.assertTrue(starsBHas.contains(stars), "It's giving another value of stars");

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
        userB.setName("username69");
        SMUser2 sendStar= smuHomeB.searchBar(userB.getName());
        SendStar sendingTheStar= sendStar.sendStar();
        sendingTheStar.sendingStar("test");
        SMUser2 backToUser= sendingTheStar.closeConfirmation();
        SMUHome backToHome= backToUser.goHome();
        backToHome.logOut();


    }
   @Test (priority = 3)
    public void checkStars(){
       SMUser userB = new SMUser();
       userB.setUsersEmail(("user69@bootcampsqe.com"));
       userB.setPassword("user69@bootcampsqe.com");
       userB.setName("username69");
       userB.setLastName("feed69");
       userB.setStars(4);
       SMUser userA = new SMUser();
       userA.setUsersEmail(("user64@bootcampsqe.com"));
       userA.setPassword("user64@bootcampsqe.com");
       userA.setLastName("feed64");
       StarMeUpLogin loginPage= new StarMeUpLogin(driver);
       String username= loginPage.usernameLogin(userB.getUsersEmail());
       SMUHome loggedIn= loginPage.passwordLoginComplete(userB.getPassword());
      // loggedIn.popUps();
       Notifications starNotification= loggedIn.starNotification();
      NotificationInfo theStarNotification= starNotification.goToNotificationInfo();
      SMUHome goHome= theStarNotification.goBackHome();
       String notification= goHome.notification();
      goHome.imTryingMyHardest();


       int starsAdd= userB.getStars()+1;
       String stars = Integer.toString(starsAdd);

      // loggedIn.popUps();

      String actStar= loggedIn.activityFeedStar(); //userB should be the first star to appear
      Assert.assertTrue(actStar.contains(userB.getName()),"Not the same names");

      MyProfile myProfile= loggedIn.goToProfile();
      SMUHome actFeed1= myProfile.goBackHome();
      MyProfile myProfile1= actFeed1.goToProfile();
      String starsBHas= myProfile1.howManyStars();
    Assert.assertTrue(starsBHas.contains(stars), "not the same amount of stars");
      String theStarWasSentBy= myProfile1.starSentBy(); //verifies if the star is in received bc the star shows with who sent it
    Assert.assertTrue(theStarWasSentBy.contains(userA.getLastName()), "Different last names");
  String noNotification = myProfile1.notification();
       Assert.assertTrue(noNotification.toLowerCase().contains("don't"), "no");
   }






   //@AfterSuite
   // public  void close(){
     //   driver.quit();
  //  }



    }













