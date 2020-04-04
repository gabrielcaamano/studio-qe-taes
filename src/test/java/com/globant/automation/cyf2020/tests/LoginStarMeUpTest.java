package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.StarMeUp.LogedFeedPage;
import com.globant.automation.cyf2020.StarMeUp.LoginPassPage;
import com.globant.automation.cyf2020.StarMeUp.LoginUserPage;
import com.globant.automation.cyf2020.StarMeUp.MyDriver;
import com.globant.automation.cyf2020.StarMeUp.RecognitionPage;
import com.globant.automation.cyf2020.StarMeUp.StarInfo;
import com.globant.automation.cyf2020.StarMeUp.UserInfo;

public class LoginStarMeUpTest {

	WebDriver driver;
	WebDriver driverA;
	WebDriver driverB;

	@BeforeTest
	@Parameters({ "browser", "browserB" })
	public void startDriver(String browser, String browserB) {

		MyDriver myDriver = new MyDriver(browser);
		driver = myDriver.getDriver();

	}

	@DataProvider(name = "infoProfile")
	public Object[][] infoKeys() {
		Object[][] key = new Object[10][4];

		key[0][0] = "user51@bootcampsqe.com";
		key[0][1] = "username51";
		key[0][2] = "feed51";
		key[0][3] = "job_mjybp";

		key[1][0] = "user52@bootcampsqe.com";
		key[1][1] = "username52";
		key[1][2] = "feed52";
		key[1][3] = "job_sgewz";

		key[2][0] = "user53@bootcampsqe.com";
		key[2][1] = "username53";
		key[2][2] = "feed53";
		key[2][3] = "job_dikcp";

		key[3][0] = "user54@bootcampsqe.com";
		key[3][1] = "username54";
		key[3][2] = "feed54";
		key[3][3] = "job_zofjj";

		key[4][0] = "user55@bootcampsqe.com";
		key[4][1] = "username55";
		key[4][2] = "feed55";
		key[4][3] = "job_udbps";

		key[5][0] = "user56@bootcampsqe.com";
		key[5][1] = "username56";
		key[5][2] = "feed56";
		key[5][3] = "job_oyywn";

		key[6][0] = "user57@bootcampsqe.com";
		key[6][1] = "username57";
		key[6][2] = "feed57";
		key[6][3] = "job_zyqwy";

		key[7][0] = "user58@bootcampsqe.com";
		key[7][1] = "username58";
		key[7][2] = "feed58";
		key[7][3] = "job_ylzxr";

		key[8][0] = "user59@bootcampsqe.com";
		key[8][1] = "username59";
		key[8][2] = "feed59";
		key[8][3] = "job_odihn";

		key[9][0] = "user60@bootcampsqe.com";
		key[9][1] = "username60";
		key[9][2] = "feed60";
		key[9][3] = "job_ccujm";

		return key;
	}

	public LogedFeedPage login(String userKey, LoginUserPage loginUserPage, LoginPassPage loginPassPage) {

		loginUserPage = new LoginUserPage(driver);
		loginPassPage = loginUserPage.typeUser(userKey);
		return loginPassPage.typePassword(userKey);
	}

	// @Test(dataProvider = "infoProfile")
	public void loginAndCheckInfo(String userKey, String nameKey, String lastnameKey, String jobKey) {

		LoginUserPage loginUserPage = null;
		LoginPassPage loginPassPage = null;
		LogedFeedPage logedFeedPage = null;
		UserInfo pageUserInfo = null;

		logedFeedPage = login(userKey, loginUserPage, loginPassPage);
		pageUserInfo = logedFeedPage.userInfoFeed();
		logedFeedPage.logOut();

		Assert.assertEquals(pageUserInfo.getName(), nameKey, "Names doesnt match");
		Assert.assertEquals(pageUserInfo.getLastname(), lastnameKey, "Lastnames doesnt match");
		Assert.assertEquals(pageUserInfo.getJob(), jobKey, "Jobs doesnt match");

	}

	@Test
	public void loginAndSendAStar() {
		
		StarInfo starInfoBefore = new StarInfo();
		
		String userKeyB = "user58@bootcampsqe.com";
		LoginUserPage loginUserB = null;
		LoginPassPage loginPassB = null;
		LogedFeedPage logedFeedB = null;
		
		logedFeedB = login(userKeyB, loginUserB, loginPassB);
		logedFeedB.setRecibedStarsBefore();
		logedFeedB.logOut();
		
		String userKeyA = "user59@bootcampsqe.com";
		LoginUserPage loginUserA = null;
		LoginPassPage loginPassA = null;
		LogedFeedPage logedFeedA = null;
		
		String whoSent = "username59";
		String whoRecibed = "username58";
		String value = "Innovation";
		
		logedFeedA = login(userKeyA, loginUserA, loginPassA);
		logedFeedA.setSentStarsBefore();
		starInfoBefore.setNameWhoRecibes(whoRecibed);
		starInfoBefore.setNameWhoSends(whoSent);
		starInfoBefore.setValue(value);
		logedFeedA.sendAStar(whoRecibed);
		Assert.assertEquals(logedFeedA.starDeliveryChecking(), "Your star to " + whoRecibed + " was sent successfully", "Unsuccessful star delivery");
		logedFeedA.setSentStarsAfter();
		//Assert.assertEquals(logedFeedA.getSentStarsAfter(), logedFeedA.getSentStarsBefore() + 1, "Wrong sent stars counting" );
		Assert.assertTrue(logedFeedA.searchStarOnActivityFeed(starInfoBefore.getNameWhoRecibes(), starInfoBefore.getValue(), "me"), "Star not founded in whos sends feed");
		RecognitionPage recognitionA = logedFeedA.goRecognition();
		Assert.assertTrue(recognitionA.checkRecognitionSent(whoRecibed, value), "Star is not founded in sent recognition");
		logedFeedA.logOut();
		
		logedFeedB = login(userKeyB, loginUserB, loginPassB);
		Assert.assertTrue(logedFeedB.thereIsANotification(), "There is not a notifcation");
		Assert.assertTrue(logedFeedB.checkNotification(whoSent, value), "The notification doesnt match the star");
		Assert.assertTrue(logedFeedB.notificationWasRead(), "Notification was not read");
		logedFeedB.setRecibedStarsAfter();
		//Assert.assertEquals(logedFeedB.getSentStarsAfter(), logedFeedB.getRecibedStarsBefore() + 1, "Wrong received stars counting");
		RecognitionPage recognitionB = logedFeedB.goRecognition();
		Assert.assertTrue(recognitionB.checkRecognitionRecived(whoSent, value), "Star is not founded in recived recognition");
		Assert.assertTrue(logedFeedB.searchStarOnActivityFeed(whoRecibed, value, whoSent), "Star is not found in whos recives feed");
		
	}

	// @AfterTest
	public void closeDriver() {
		driver.close();
	}

}
