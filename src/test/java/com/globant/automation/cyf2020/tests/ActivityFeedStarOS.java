package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class ActivityFeedStarOS extends BasePage {

	@FindBy(xpath = "//h3[@class = \"user-info__name\"]")
	private WebElement nombreYApellidoDUsuarix;

	@FindBy(xpath = "//p[@class=\"user-info__job\"]")
	private WebElement jobOfTheUser;

	@FindBy(xpath = "//div[@class=\"stat__content\"]")
	private WebElement starRecibed;

	@FindBy(xpath = "//div[contains(@class, 'profile-stats')][2]//div[@class=\"stat__content\"]")
	private WebElement starSent;

	@FindBy(xpath = "//div[contains(@class, 'profile-stats')][3]//div[@class=\"stat__content\"]")
	private WebElement starParaEnviar;

	@FindBy(xpath = "//div[@class=\"feed-item__content-wrapper\"]")
	private WebElement starSentByUserA;

	@FindBy(xpath = "//button[contains(@class, 'button--icon button--nopadding button--c')]")
	private WebElement editStarSentByUserA;

	@FindBy(xpath = "//div[contains(@class, 'public-DraftStyleDefault-ltr')]//span[@data-text=\"true\"]")
	private WebElement conctentOfTheWhy;
	
	@FindBy(xpath = "//div[@class=\"feed-item__description-notes\"]")
	private WebElement textMessageOfStartSent;

	
	@FindBy(xpath = "//div[@class=\"notranslate public-DraftEditor-content\"]")
	private WebElement whyMessageInput;

	@FindBy(xpath = "//button[@class=\"button button--nomargin-right button--transparent button--color-\"]")
	private WebElement editStarBtnConfirm;

	@FindBy(xpath = "//i[@class=\"close large icon confirmation__close\"]")
	private WebElement cerrarConfirmacionDeEnvioDeEstrella;	
	
	@FindBy(xpath = "//div[contains(@class, 'tab-panel__item')]")
	private WebElement recentTab;

	@FindBy(xpath = "//span[@class=\"feed-item__avatar-name--cursor\"]")
	private WebElement nombreDelCoworkerAlQueLeEnvieLaEstrella;

	@FindBy(xpath = "//strong[@class=\"feed-footer__full-name\"]")
	private WebElement porQuienEsEnviadaLaEstrella;

	@FindBy(xpath = "//p[@class=\"notifications-list__info\"]//span")
	private WebElement youDontHaveNotifications;

	@FindBy(xpath = "//span[contains(@class, 'suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open')]")
	private WebElement popUpUpInTheNav;  
	
	

	public ActivityFeedStarOS(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// toma el nombre y el apellido de la pagina, con una espera previa ya que la
	// pagina tarda en cargar
	public String nombreYApellido() {

		wait(Duration.ofSeconds(10));

		String nameAndLastName = getText(nombreYApellidoDUsuarix);

		return nameAndLastName;
	}

	// toma el trabajo de la pagina
	public String getTheJob() {
		String trabajo = getText(jobOfTheUser);
		return trabajo;
	}

	public int getStarRecibed() {
		String estrellasRecibidas = getText(starRecibed);
		int numStarGive = Integer.parseInt(estrellasRecibidas);
		return numStarGive;
	}

	public int getStarSent() {
		String estrellasEnviadas = getText(starSent);
		int numStarSent = Integer.parseInt(estrellasEnviadas);
		return numStarSent;
	}

	public void clickInStartSendForUserA() {

		click(starSentByUserA);

	}

	public void clickInEditStar() {

		click(editStarSentByUserA);

	}

	public void clickEnPopUp() {

		click(popUpUpInTheNav);

	}
	
	public void clickInRecentTab() {

		click(recentTab);

	}

	

	public String modifyTheContentFromWhy(String textToAdd) {

		

		type(whyMessageInput, " " + textToAdd);
		
		return textToAdd;

	}
	
	public String contentOfThStarMessage() {

		String messageModified = getText(textMessageOfStartSent);

		return messageModified;

	}
	

	public void editStarBtnConfirmAndCloseConfirm() {

		click(editStarBtnConfirm);
		
		click(cerrarConfirmacionDeEnvioDeEstrella);

	}
	

	public String captureNameAndSenderActivityFeed() {

		String nombreYApellidoObtenido = getText(nombreDelCoworkerAlQueLeEnvieLaEstrella);
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento + " envia a " + nombreYApellidoObtenido;

	}

	public String senderNameActivityFeed() {
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento;

	}

	public boolean VerifyNotificationThisReadTrueOrFalse() {

		String youNotienesNotificaciones = getText(youDontHaveNotifications);

		if (youNotienesNotificaciones.equals("You don't have notifications")) {
			System.out.println(youNotienesNotificaciones);
			return true;
		}

		return false;

	}

	public NavBar navigateToNavBar() {

		return getNextPage(NavBar.class);
	}

}
