package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class NavBar extends BasePage {

	@FindBy(xpath = "//input[@class=\"suite-search-box__input\"]")
	private WebElement inputSearchNavbar;

	@FindBy(xpath = "//div[@class=\"ui-navbar__logo-container\"]//a")
	private WebElement volverAlaPaginaDeInicio;
	
	@FindBy(xpath = "//li[@class=\"ui-navbar__menu-item\"][2]//a")
	private WebElement leaderBoardBtn;
	
	@FindBy(xpath = "//button[contains(@class, 'button--transparent suite-user_menu__profile-image-icon')]")
	private WebElement buttonSettingsOrLogOUT;

	@FindBy(xpath = "//button[@class=\"button button--color- button--size-small\"]")
	private WebElement LogOutBttn;

	@FindBy(xpath = "//button[contains(@class, 'button--icon button--nopadding')]")
	private WebElement campanaNotificationBtn;

	@FindBy(xpath = "//button[contains(@class, 'notifications-button notifications-button--active button--color-')]")
	private WebElement campanaNotificationActivaBtn;

	@FindBy(xpath = "//div[@class=\"ui-navbar__menu-item menu-item--featureDiscovery\"]//a")
	private WebElement myProfile;

	@FindBy(xpath = "//li[@class=\"notifications-item notifications-item--active\"]")
	private WebElement primeraNotificacion;

	@FindBy(xpath = "//li[@tabindex=\"0\"]")
	private WebElement usuarioBuscado;
	
	@FindBy(xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")
	private WebElement popUpMyProfile;

	public NavBar(WebDriver driver) {

		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickElPerfil() {
		click(myProfile);
	}

	public void buscarUsuario(String usuarix) {
		type(inputSearchNavbar, usuarix);
	}

	public void clickInBell() {
		wait(Duration.ofSeconds(6));
		click(campanaNotificationBtn);
	}

	public void clickInActiveBell() {
		wait(Duration.ofSeconds(3));
		click(campanaNotificationActivaBtn);
	}

	public void clickOnTheNotification() {
		click(primeraNotificacion);

	}

	public ProfileOfCoworker navigateToProfileOfCoworker(String usuarix) {

		buscarUsuario(usuarix);
		click(usuarioBuscado);

		return getNextPage(ProfileOfCoworker.class);
	}

	public ProfileOfUser navigateToProfileOfUser() {
		clickElPerfil();

		return getNextPage(ProfileOfUser.class);
	}

	public ActivityFeedStarOS navigateToPrincipalPage() {
		click(volverAlaPaginaDeInicio);

		return getNextPage(ActivityFeedStarOS.class);
	}

	public Login navigateTologOut() {
		
		click(buttonSettingsOrLogOUT);
		click(LogOutBttn);

		return getNextPage(Login.class);
	}
	
	public Leaderboard navigateToLeaderBoard() {
		click(leaderBoardBtn);
		

		return getNextPage(Leaderboard.class);
	}

}
