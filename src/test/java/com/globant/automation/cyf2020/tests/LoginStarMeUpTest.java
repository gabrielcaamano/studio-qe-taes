package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.StarMeUp.LogedFeedPage;
import com.globant.automation.cyf2020.StarMeUp.LoginPassPage;
import com.globant.automation.cyf2020.StarMeUp.LoginUserPage;
import com.globant.automation.cyf2020.StarMeUp.UserInfo;

public class LoginStarMeUpTest {

	LoginUserPage loginUserPage;
	WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void iniciarlizarNavegador(String browser) {

		MyDriver myDriver = new MyDriver(browser);
		driver = myDriver.getDriver();
		StarMeUpHomePage homePage = new StarMeUpHomePage(driver);
		loginUserPage = homePage.goStarMeUp();

	}
	
	@DataProvider(name = "infoProfile")
	public Object[][] infoKeys() {
		Object[][] key = new Object[10][4];

		key[0][0]= "user51@bootcampsqe.com";
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

	@Test(dataProvider = "loginKey")
	public void login(String userKey, String name, String lastname, String job) {

		LoginPassPage loginPassPage = loginUserPage.typeUser(userKey);
		LogedFeedPage logedFeedPage = loginPassPage.typePassword(userKey);
		//comparar userInfo con dataProvider
		UserInfo pageUserInfo = logedFeedPage.userInfoFeed();
		loginUserPage = logedFeedPage.logOut();
		Assert.assertEquals(pageUserInfo.getName(), name, "Names doesnt match");
		Assert.assertEquals(pageUserInfo.getLastname(), lastname, "Lastnames doesnt match");
		Assert.assertEquals(pageUserInfo.getJob(), job, "Jobs doesnt match");

	}

}
