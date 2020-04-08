package com.globant.automation.cyf2020.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecutorTest {

	private WebDriver driver;

	@BeforeClass
	public void beforeClasss() {
		System.out.println("Inicia el test");
	}

	@BeforeMethod
	public void starWebPage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://uat.starmeup.com/login.html?continue=aHR0cHM6Ly91YXQuc3Rhcm1ldXAuY29tLw%3D%3D&origin=SMU&logout=true");
	}

	// @AfterMethod
	public void closeDriver() {
		driver.close();
	}

	// @Test
	public void LoginEjercicio1() {

		UserStarMeUp usuario = new UserStarMeUp();
		usuario.setEmail("user81@bootcampsqe.com");
		usuario.setPassword("user81@bootcampsqe.com");
		usuario.setJob("job_jurzv");
		usuario.setNombre("username81");
		usuario.setApellido("feed81");

		Login login = new Login(driver);
		ActivityFeedStarOS paginaPrincipal = login.navigateToActivityFeed(usuario.getEmail(), usuario.getPassword());

		// Take the data and compare to see if they match
		compararNombreApellidoYJob(usuario.getNombre(), usuario.getApellido(), paginaPrincipal.nombreYApellido(),
				usuario.getJob(), paginaPrincipal.getTheJob());

	}

	// @Test
	public void SendStar1Y2() {

		UserStarMeUp userB = new UserStarMeUp();
		userB.setEmail("user85@bootcampsqe.com");
		userB.setPassword("user85@bootcampsqe.com");

		Login login = new Login(driver);
		ActivityFeedStarOS principalPage = login.navigateToActivityFeed(userB.getEmail(), userB.getPassword());
		int captureNumberOfStarsReceivedUserB = 0;
		captureNumberOfStarsReceivedUserB = +principalPage.getStarRecibed();
		NavBar navigationNavBar = principalPage.navigateToNavBar();
		login = navigationNavBar.navigateTologOut();

		// userA is created
		UserStarMeUp userA = new UserStarMeUp();
		userA.setEmail("user82@bootcampsqe.com");
		userA.setPassword("user82@bootcampsqe.com");

		// for the userA
		principalPage = login.navigateToActivityFeed(userA.getEmail(), userA.getPassword());

		int captureNumberOfStarsReceivedUserA = principalPage.getStarSent();

		navigationNavBar = principalPage.navigateToNavBar();

		// driver at user profile
		ProfileOfCoworker coworkerProfile = navigationNavBar.navigateToProfileOfCoworker(userB.getEmail());

		/*
		 * something about navigateToPrincipalPageFormPDCoworker, the number is the type of
		 * acknowledgment that you want to send, is ordered like this: 
		 * 1 = Integrity 
		 * 2 = Excellence 
		 * 3 = Team Work 
		 * 4 = Innovation 
		 * 5 = Learning 
		 * 6 = Think Big
		 * 
		 * The next field is for comments to the coworker.
		 * 
		 */

		principalPage = coworkerProfile.navigateToPrincipalPageFromPDCoworker(3, ":O");
		// I return to the Activity feed

		// captured the data in the variable

		principalPage.reLoadTheActivity();
		String nameAndSenderActivityFeed = principalPage.captureNameAndSenderActivityFeed();

		// check if the stars sent increased by one
		assertEquals(principalPage.getStarSent(), captureNumberOfStarsReceivedUserA);

		//I go to the user's personal profile
		ProfileOfUser personalProfile = navigationNavBar.navigateToProfileOfUser();

		personalProfile.clickSentTab();

		String nameAndSenderActivityFeed2 = personalProfile.captureNameAndSenderProfile();
		
		//compare if the data collected is the same
		
		assertEquals(nameAndSenderActivityFeed2, nameAndSenderActivityFeed);

		// go to the userB

		navigationNavBar.navigateTologOut();
		principalPage = login.navigateToActivityFeed(userB.getEmail(), userB.getPassword());

		navigationNavBar.clickInBell();
		navigationNavBar.clickOnTheNotification();

		navigationNavBar.clickInBell();

		assertEquals(true, principalPage.VerifyNotificationThisReadTrueOrFalse());

		navigationNavBar.clickInActiveBell();

		navigationNavBar.navigateToPrincipalPage();

		//I check if the number of stars increased
		assertEquals(captureNumberOfStarsReceivedUserB, principalPage.getStarRecibed());

		String senderActivityFeedUserB = principalPage.senderNameActivityFeed();

		//I go to the user's personal profile
		personalProfile = navigationNavBar.navigateToProfileOfUser();

		
		//I compare if the data collected is the same
		assertEquals(personalProfile.senderName(), senderActivityFeedUserB);

	}

	// @Test
	public void SendStar3() {

		UserStarMeUp userB = new UserStarMeUp();
		userB.setEmail("user85@bootcampsqe.com");
		userB.setPassword("user85@bootcampsqe.com");

		Login login = new Login(driver);
		ActivityFeedStarOS principalPage = login.navigateToActivityFeed(userB.getEmail(), userB.getPassword());
		NavBar navigationBar = principalPage.navigateToNavBar();

		ProfileOfUser personalProfileUser = navigationBar.navigateToProfileOfUser();
		int numberOfComments1 = 0;
		numberOfComments1 = +personalProfileUser.amountOfComments();
		System.out.println(numberOfComments1);

		personalProfileUser.clicktoOpenComments();
		System.out.println(personalProfileUser.firstCommentExists());

		navigationBar.navigateTologOut();

		UserStarMeUp userA = new UserStarMeUp();
		userA.setEmail("user82@bootcampsqe.com");
		userA.setPassword("user82@bootcampsqe.com");

		principalPage = login.navigateToActivityFeed(userA.getEmail(), userA.getPassword());

		personalProfileUser.clickSentTab();

		String sendCommentAndSave = personalProfileUser.writeAComment(" Holas");
		personalProfileUser.clickPopUpRight();
		personalProfileUser.clickForSentTheComent();
		personalProfileUser.clickPopUpInMyProfile();

		
		String getCommentType = personalProfileUser.firstCommentExists();
		System.out.println(getCommentType);
		navigationBar.navigateTologOut();

		// start session the userB again
		principalPage = login.navigateToActivityFeed(userB.getEmail(), userB.getPassword());
		personalProfileUser.clickPopUpInMyProfile(); // close a pop up that blocks an action
		navigationBar.clickInBell();
		navigationBar.clickOnTheNotification();

		String getCommentTypeInNotifications = personalProfileUser.firstCommentExists();

		System.out.println(getCommentTypeInNotifications);

		int numberOfComments2 = 0;
		numberOfComments2 = +personalProfileUser.amountOfComments();
		

		assertEquals(getCommentType, getCommentTypeInNotifications);

		assertEquals(numberOfComments2, numberOfComments1 + 1);
	}

	// @Test
	public void sanityLikeAStar() {

		UserStarMeUp userB = new UserStarMeUp();
		userB.setEmail("user82@bootcampsqe.com");
		userB.setPassword("user82@bootcampsqe.com");

		Login login = new Login(driver);
		ActivityFeedStarOS principalPage = login.navigateToActivityFeed(userB.getEmail(), userB.getPassword());
		NavBar navigationBar = principalPage.navigateToNavBar();

		ProfileOfUser usersPersonalProfile = navigationBar.navigateToProfileOfUser();

		// amount of reactions in the first star
		int amountOfReactions = 0;
		amountOfReactions = +usersPersonalProfile.getAmountOfReactions();
		System.out.println(amountOfReactions);

		// log out of the user B
		navigationBar.navigateTologOut();

		UserStarMeUp userA = new UserStarMeUp();
		userA.setEmail("user81@bootcampsqe.com");
		userA.setPassword("user81@bootcampsqe.com");

		principalPage = login.navigateToActivityFeed(userA.getEmail(), userA.getPassword());

		usersPersonalProfile.clickSentTab();

		// send a like in a star of the user B
		usersPersonalProfile.clickToSendLike();
		usersPersonalProfile.clickPopUpRight();
		usersPersonalProfile.clickPopUpInMyProfile();

		// close the session of user A
		navigationBar.navigateTologOut();

		// start session the userB again
		principalPage = login.navigateToActivityFeed(userB.getEmail(), userB.getPassword());
		usersPersonalProfile.clickPopUpInMyProfile(); // close a pop up that blocks an action
		navigationBar.clickInBell();
		navigationBar.clickOnTheNotification();

		int amountOfReactions2 = 0;
		amountOfReactions2 = +usersPersonalProfile.getAmountOfReactionsInNotifications();
		System.out.println(amountOfReactions2);

		assertEquals(amountOfReactions2, amountOfReactions + 1);

		assertEquals(usersPersonalProfile.firstLikeIsPresentOrNot(), true);

	}

	@Test
	public void editStar() {

		UserStarMeUp userA = new UserStarMeUp();
		userA.setEmail("user81@bootcampsqe.com");
		userA.setPassword("user81@bootcampsqe.com");

		Login login = new Login(driver);
		ActivityFeedStarOS principalPage = login.navigateToActivityFeed(userA.getEmail(), userA.getPassword());
		NavBar barraDeNavegacion = principalPage.navigateToNavBar();

		principalPage.clickInStartSendForUserA();
		principalPage.clickInEditStar();
		
		String contentBeforeBeingModified = principalPage.contentOfThStarMessage();
		principalPage.modifyTheContentFromWhy("-Edited-");
		principalPage.clickEnPopUp();
		principalPage.editStarBtnConfirmAndCloseConfirm();
		
		String contentAfterBeingModified = principalPage.contentOfThStarMessage();
		
		assertNotEquals(contentAfterBeingModified, contentBeforeBeingModified, "los cambios en el mensaje no fueron aplicados");
		
		}

	public void compararNombreApellidoYJob(String nombreSetteado, String appellidoSetteado,
			String nombreYapellidoEnLaPagina, String trabajoSetteado, String trabajoEnLaPagina) {

		assertEquals(nombreYapellidoEnLaPagina, nombreSetteado + " " + appellidoSetteado);

		assertEquals(trabajoSetteado, trabajoEnLaPagina);

	}

}
