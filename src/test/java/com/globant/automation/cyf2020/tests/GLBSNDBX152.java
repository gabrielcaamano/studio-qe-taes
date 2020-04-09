package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.pages.ActivityFeedPage;
import com.globant.automation.cyf2020.pages.BarPage;
import com.globant.automation.cyf2020.pages.LoginPage;
import com.globant.automation.cyf2020.pages.User;
import com.globant.automation.cyf2020.pages.UserProfilePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GLBSNDBX152 {

	private WebDriver driver;
	private int amountOfComment;
	User userA = new User("user93@bootcampsqe.com", "user93@bootcampsqe.com", "username93", "feed93", "job_mfnsf");
	User userB = new User("user91@bootcampsqe.com", "user91@bootcampsqe.com", "username91", "feed91", "job_mcbkn");
	String commentMessage;
	
	@BeforeClass
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.starmeup.com/login.html");
	}
	
//	@AfterClass
//	public void closeDriver() {
//		driver.close();
//	}
	
	@Test(priority=1)
	public void loginUserB() {
		LoginPage login = new LoginPage(driver);
		login.login(userB.getUser(), userB.getPassword());
		
	}
	
	@Test (priority=2)
	public void amountOfComment() {
		BarPage bar = new BarPage(driver);
		UserProfilePage myProfile = bar.clickMyProfile();
		myProfile.clickPopUp();
		myProfile.clickPopUp();
		myProfile.clickPopUp();
//		myProfile.clickRecognition();
		
		Assert.assertEquals(myProfile.starSentBy(), userA.getName() + " " + userA.getLastName() , "The user who received the star does't match in the profile");
		amountOfComment =  Integer.parseInt(myProfile.getAmountCommentsOfLastStarRecived());
	}
	
	@Test (priority=3)
	public void logout() {
		BarPage bar = new BarPage(driver);
		bar.clickButtonMenuProfile();
		bar.clickLogout();
	}
	
	@Test(priority=4)
	public void loginUserA() {
		LoginPage login = new LoginPage(driver);
		BarPage bar = login.login(userA.getUser(), userA.getPassword());
		UserProfilePage myProfile = bar.clickMyProfile();
		myProfile.clickPopUp();
		myProfile.clickPopUp();
		myProfile.clickPopUp();

//		myProfile.clickRecognition();
		myProfile.sentStar();
		
//		Assert.assertEquals(userA.getName(), home.getName(), "The names are not the same");
//		Assert.assertEquals(userA.getLastName(), home.getLastName(), "Last names are not the same");
//		Assert.assertEquals(userA.getJob(), home.getJob(), "Jobs are not the same");

		Assert.assertEquals(myProfile.starSentTo(), userB.getName() + " "+ userB.getLastName(), "The user who received the star does't match in the profile");
		commentMessage = "Test comment";
		myProfile.comment(commentMessage);

		Assert.assertEquals(myProfile.lastCommentInSentStar(), commentMessage, "The comment is not displayed");
		Assert.assertEquals(Integer.parseInt(myProfile.getAmountCommentsOfLastStarSent()), amountOfComment + 1, "The amount of comments does't increase 1");

	}

	@Test (priority=5)
	public void logOutAAndLoginB() {
		logout();
		loginUserB();
	}
	
	@Test (priority =6)
	public void reciveComment() {
		BarPage bar = new BarPage(driver);
		Assert.assertTrue(bar.thereIsNotification(), "There isn't a notification");		
		bar.clickNotifications();
		bar.clickNotifications();
		bar.clickNotifications();
		Assert.assertFalse(bar.notificationUnread(), "The notification is unread");
		bar.clickNotifications();
		
		UserProfilePage myProfile = bar.clickMyProfile();
//		myProfile.clickRecognition();
		Assert.assertEquals(myProfile.starSentBy(), userA.getName() + " "+ userA.getLastName(), "The user who sent the star does't match in the profile");

		Assert.assertEquals(myProfile.lastCommentInRecivedStar(), commentMessage, "The comment is not displayed");
		Assert.assertEquals(Integer.parseInt(myProfile.getAmountCommentsOfLastStarRecived()), amountOfComment + 1, "The amount of comments does't increase 1");

	}
	
}
