package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.pages.ActivityFeedPage;
import com.globant.automation.cyf2020.pages.BarPage;
import com.globant.automation.cyf2020.pages.LoginPage;
import com.globant.automation.cyf2020.pages.SendStar;
import com.globant.automation.cyf2020.pages.User;
import com.globant.automation.cyf2020.pages.UserProfilePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GLBSNDBX151 {

	private WebDriver driver;
	private int recivedStar;
	private int sentStar;
	User userB = new User("user93@bootcampsqe.com", "user93@bootcampsqe.com", "username93", "feed93", "job_mfnsf");
	User userA = new User("user91@bootcampsqe.com", "user91@bootcampsqe.com", "username91", "feed91", "job_mcbkn");
	private String selectedValue;
	
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
		BarPage bar = login.login(userB.getUser(), userB.getPassword());
		
//		UserProfilePage profile = bar.clickMyProfile();
//		profile.clickPopUp();
//		profile.clickPopUp();
//		profile.clickPopUp();
//		profile.clickRecognition();
//		profile.sentStar();
		
		ActivityFeedPage home = bar.clickActivityFeed();
		
		Assert.assertEquals(userB.getName(), home.getName(), "The names are not the same");
		Assert.assertEquals(userB.getLastName(), home.getLastName(), "Last names are not the same");
		Assert.assertEquals(userB.getJob(), home.getJob(), "Jobs are not the same");
		
	}
	
	@Test (priority=2)
	public void amountOfStar() {
		BarPage bar = new BarPage(driver);
		ActivityFeedPage home = bar.clickActivityFeed();

		recivedStar =  Integer.parseInt(home.amountRecivedStar());

	}
	
	@Test (priority=3)
	public void logout() {
		BarPage home = new BarPage(driver);
		home.clickButtonMenuProfile();
		home.clickLogout();
	}
	
	@Test(priority=4)
	public void loginUserA() {
		LoginPage login = new LoginPage(driver);
		BarPage bar = login.login(userA.getUser(), userA.getPassword());
		ActivityFeedPage home = bar.clickActivityFeed();
		
		Assert.assertEquals(userA.getName(), home.getName(), "The names are not the same");
		Assert.assertEquals(userA.getLastName(), home.getLastName(), "Last names are not the same");
		Assert.assertEquals(userA.getJob(), home.getJob(), "Jobs are not the same");

		sentStar = Integer.parseInt(home.amountSentStar());
	}

	@Test (priority=5)
	public void sendStar() {
		ActivityFeedPage home = new ActivityFeedPage(driver);
		home.clickPopUp();
		home.clickPopUp();
		home.clickPopUp();
		home.clickPopUp();
		driver.navigate().refresh();
		SendStar star = home.clickAValueToSendStar();
		star.starTo(userB.getName());
		star.clickFirstInList();
		selectedValue = star.starValueSelected();
		star.whyStarMessage(" Test");
		star.clickSendButton();
		Assert.assertFalse(home.starWasSentBefore(), "The star was sent before");
		star.clickCloseButton();
		
		
//		Assert.assertEquals(Integer.parseInt(home.amountSentStar()), (sentStar + 1), "The number of stars sent does't increase 1");
		Assert.assertEquals(home.starSentBy(), "me", "The user who sent the star does't match in the feed");
		Assert.assertEquals(home.kindOfStar(), selectedValue, "The kind of star does't match in the feed");
		Assert.assertEquals(home.starSentTo(), userB.getName() + " "+  userB.getLastName(), "The user who received the star does't match in the feed");
		
		BarPage bar = new BarPage(driver);

		UserProfilePage myProfile = bar.clickMyProfile();
		myProfile.clickPopUp();
		myProfile.clickPopUp();
		myProfile.clickPopUp();
		myProfile.clickRecognition();
		myProfile.sentStar();
		Assert.assertEquals(myProfile.starSentTo(), userB.getName() + " "+ userB.getLastName(), "The user who received the star does't match in the profile");
		Assert.assertEquals(myProfile.kindOfStar(), selectedValue, "The kind of star does't match in the profile");
		
	}
	
	@Test (priority=6)
	public void logOutAAndLoginB() {
		logout();
		loginUserB();
	}
	
	@Test (priority =7)
	public void recivedStar() {
		BarPage bar = new BarPage(driver);
		Assert.assertTrue(bar.thereIsNotification(), "There isn't a notification");		
		bar.clickNotifications();
		bar.clickNotifications();
		bar.clickNotifications();
		Assert.assertFalse(bar.notificationUnread(), "The notification is unread");
		bar.clickNotifications();
		ActivityFeedPage home = bar.clickActivityFeed();
		
//		Assert.assertEquals(Integer.parseInt(home.amountRecivedStar()), (recivedStar + 1), "The number of stars received does't increase 1");
		Assert.assertEquals(home.starSentBy(), userA.getName() + " " + userA.getLastName(), "The user who sent the star does't match in the feed");
		Assert.assertEquals(home.kindOfStar(), selectedValue, "The kind of star does't match in the feed");
		Assert.assertEquals(home.starSentTo(), userB.getName() + " " + userB.getLastName(), "The user who received the star does't match in the feed");

		UserProfilePage myProfile = bar.clickMyProfile();
		myProfile.clickPopUp();
		
		Assert.assertEquals(myProfile.starSentBy(), userA.getName() + " " + userA.getLastName(), "The user who sent the star does't match in the profile");
		Assert.assertEquals(myProfile.kindOfStar(), selectedValue, "The kind of star does't match in the profile");

	}

}
