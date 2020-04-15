package com.globant.automation.cyf2020.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.tests.ProfileOfCoworker.ChooseARecognition;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecutorTest {

	private WebDriver driver;
	private ExcelReader readExcel;

	ChooseARecognition valueOfRecognition = ChooseARecognition.INNOVATION;

	@BeforeClass
	public void beforeClasss() {
		System.out.println("Inicia el test");
	}

	@BeforeMethod
	public void startWebPage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		readExcel = new ExcelReader();
		driver.manage().window().maximize();
		driver.get(
				"https://uat.starmeup.com/login.html?continue=aHR0cHM6Ly91YXQuc3Rhcm1ldXAuY29tLw%3D%3D&origin=SMU&logout=true");
	}

	// @AfterMethod
	public void closeDriver() {
		driver.close();
	}

	public String user(int usuario) throws IOException {

		String filepath = "C:\\Users\\paula.brites\\Desktop\\users.xlsx";
		String correoYPassword = readExcel.getCellValue(filepath, "Worksheet", usuario, 18);

		return correoYPassword;

	}

	@Parameters({ "userA", "userB" })
	@Test(priority = 0)

	public void starAndThenSearchUser(int userA, int userB) throws IOException {

		String correoYpasswordUserB = user(userB);

		Login login = new Login(driver);
		ActivityFeedStarOS principalPage = login.navigateToActivityFeed(correoYpasswordUserB, correoYpasswordUserB);
		int captureNumberOfStarsReceivedUserB = 0;

		captureNumberOfStarsReceivedUserB = +principalPage.getStarRecibed();
		NavBar navigationNavBar = principalPage.navigateToNavBar();
		login = navigationNavBar.navigateTologOut();

		// userA is created
		String correoYpasswordUserA = user(userA);

		// for the userA
		principalPage = login.navigateToActivityFeed(correoYpasswordUserA, correoYpasswordUserA);

		int captureNumberOfStarsReceivedUserA = principalPage.getStarSent();

		navigationNavBar = principalPage.navigateToNavBar();

		// driver at user profile
		ProfileOfCoworker coworkerProfile = navigationNavBar.navigateToProfileOfCoworker(correoYpasswordUserB);

		principalPage = coworkerProfile.navigateToPrincipalPageFromPDCoworker(valueOfRecognition, "TestAE");
		// I return to the Activity feed

		// captured the data in the variable

		String nameAndSenderActivityFeed = principalPage.captureNameAndSenderActivityFeed();

		// check if the stars sent increased by one
		assertEquals(principalPage.getStarSent(), captureNumberOfStarsReceivedUserA);

		// I go to the user's personal profile
		ProfileOfUser personalProfile = navigationNavBar.navigateToProfileOfUser();

		personalProfile.clickSentTab();

		String nameAndSenderActivityFeed2 = personalProfile.captureNameAndSenderProfile();

		// compare if the data collected is the same

		assertEquals(nameAndSenderActivityFeed2, nameAndSenderActivityFeed);

		// go to the userB

		navigationNavBar.navigateTologOut();
		principalPage = login.navigateToActivityFeed(correoYpasswordUserB, correoYpasswordUserB);

		navigationNavBar.clickInBell();
		navigationNavBar.clickOnTheNotification();

		navigationNavBar.clickInBell();

		assertEquals(true, principalPage.VerifyNotificationThisReadTrueOrFalse());

		navigationNavBar.clickInActiveBell();

		navigationNavBar.navigateToPrincipalPage();

		// I check if the number of stars increased
		assertEquals(captureNumberOfStarsReceivedUserB, principalPage.getStarRecibed());

		String senderActivityFeedUserB = principalPage.senderNameActivityFeed();

		// I go to the user's personal profile
		personalProfile = navigationNavBar.navigateToProfileOfUser();

		principalPage.clickInRecentTab();
		// I compare if the data collected is the same
		assertEquals(personalProfile.senderName(), senderActivityFeedUserB);

	}

	@Parameters({ "userA", "userB" })
	@Test(priority = 1)
	public void commentOnStarWithText(int userA, int userB) throws IOException {

		String correoYpasswordUserB = user(userB);

		Login login = new Login(driver);
		ActivityFeedStarOS principalPage = login.navigateToActivityFeed(correoYpasswordUserB, correoYpasswordUserB);
		NavBar navigationBar = principalPage.navigateToNavBar();

		ProfileOfUser personalProfileUser = navigationBar.navigateToProfileOfUser();
		int numberOfComments1 = 0;
		numberOfComments1 = +personalProfileUser.amountOfComments();
		System.out.println(numberOfComments1);
		personalProfileUser.clickInPopUpAll();
		personalProfileUser.clicktoOpenComments();
		System.out.println(personalProfileUser.firstCommentExists());
		personalProfileUser.clickInPopUpAll();
		navigationBar.navigateTologOut();

		String correoYpasswordUserA = user(userA);

		principalPage = login.navigateToActivityFeed(correoYpasswordUserA, correoYpasswordUserA);

		personalProfileUser.clickSentTab();

		personalProfileUser.clickInPopUpAll();
		personalProfileUser.clicktoOpenComments();
		String sendCommentAndSave = personalProfileUser.writeAComment(" Jelou");

		personalProfileUser.clickForSentTheComent();

		String getCommentType = personalProfileUser.firstCommentExists();
		System.out.println(getCommentType);
		navigationBar.navigateTologOut();

		// start session the userB again
		principalPage = login.navigateToActivityFeed(correoYpasswordUserB, correoYpasswordUserB);

		navigationBar.clickInBell();
		navigationBar.clickOnTheNotification();

		String getCommentTypeInNotifications = personalProfileUser.firstCommentExists();

		System.out.println(getCommentTypeInNotifications);

		int numberOfComments2 = 0;
		numberOfComments2 = +personalProfileUser.amountOfComments();

		assertEquals(getCommentType, getCommentTypeInNotifications);

		assertEquals(numberOfComments2, numberOfComments1 + 1);
	}

	@Parameters({ "userA", "userB" })
	@Test(priority = 2)

	public void sanityLikeAStar(int userA, int userB) throws IOException {
		System.out.println("test3");
		String correoYpasswordUserB = user(userB);

		Login login = new Login(driver);
		ActivityFeedStarOS principalPage = login.navigateToActivityFeed(correoYpasswordUserB, correoYpasswordUserB);
		NavBar navigationBar = principalPage.navigateToNavBar();

		ProfileOfUser usersPersonalProfile = navigationBar.navigateToProfileOfUser();

		// amount of reactions in the first star
		int amountOfReactions = 0;
		amountOfReactions = +usersPersonalProfile.getAmountOfReactions();
		System.out.println(amountOfReactions);

		// log out of the user B
		navigationBar.navigateTologOut();

		String correoYpasswordUserA = user(userA);

		principalPage = login.navigateToActivityFeed(correoYpasswordUserA, correoYpasswordUserA);

		usersPersonalProfile.clickSentTab();

		// send a like in a star of the user B
		usersPersonalProfile.clickInPopUpAll();
		usersPersonalProfile.clickToSendLike();

		usersPersonalProfile.clickInPopUpAll();

		// close the session of user A
		navigationBar.navigateTologOut();

		// start session the userB again
		principalPage = login.navigateToActivityFeed(correoYpasswordUserB, correoYpasswordUserB);
		usersPersonalProfile.clickInPopUpAll(); // close a pop up that blocks an action
		navigationBar.clickInBell();
		navigationBar.clickOnTheNotification();

		int amountOfReactions2 = 0;
		amountOfReactions2 = +usersPersonalProfile.getAmountOfReactionsInNotifications();
		System.out.println(amountOfReactions2);

		assertEquals(amountOfReactions2, amountOfReactions + 1);

		assertEquals(usersPersonalProfile.firstLikeIsPresentOrNot(), true);

	}

	@Parameters({ "userA" })
	@Test(priority = 3)
	public void editStar(int userA) throws IOException {

		String correoYpasswordUserA = user(userA);

		Login login = new Login(driver);
		ActivityFeedStarOS principalPage = login.navigateToActivityFeed(correoYpasswordUserA, correoYpasswordUserA);
		NavBar barraDeNavegacion = principalPage.navigateToNavBar();

		principalPage.clickInStartSendForUserA();
		principalPage.clickInEditStar();

		String contentBeforeBeingModified = principalPage.contentOfThStarMessage();
		principalPage.modifyTheContentFromWhy("-Edited -");
		principalPage.clickEnPopUp();
		principalPage.editStarBtnConfirmAndCloseConfirm();

		String contentAfterBeingModified = principalPage.contentOfThStarMessage();

		assertNotEquals(contentAfterBeingModified, contentBeforeBeingModified,
				"the changes in the message were not applied");

	}

	public void compararNombreApellidoYJob(String nombreSetteado, String appellidoSetteado,
			String nombreYapellidoEnLaPagina, String trabajoSetteado, String trabajoEnLaPagina) {

		assertEquals(nombreYapellidoEnLaPagina, nombreSetteado + " " + appellidoSetteado);

		assertEquals(trabajoSetteado, trabajoEnLaPagina);

	}

}
