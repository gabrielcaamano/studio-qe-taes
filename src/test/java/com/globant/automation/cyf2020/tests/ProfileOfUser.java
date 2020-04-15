package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class ProfileOfUser extends BasePage {

//
	@FindBy(xpath = "//div[@class=\"tab-panel__item\"]")
	private WebElement sentTab;
	//
	@FindBy(xpath = "//span[@class=\"feed-item__avatar-name--cursor\"]")
	private WebElement nombreDelCoworkerAlQueLeEnvieLaEstrella;

	@FindBy(xpath = "//strong[@class=\"feed-footer__full-name\"]")
	private WebElement porQuienEsEnviadaLaEstrella;

	// comentario
	@FindBy(xpath = "//span[contains(@class, 'feed-footer__counters--smu')]//div[2]//span[@class=\"counter__value\"]")
	private WebElement cantidadDecomentarios;

	@FindBy(xpath = "//div[@class=\"counter feed-footer__counter\"][2]//span[@class=\"counter__value\"]")
	private WebElement amountOfLikes;

	@FindBy(xpath = "//div[@class=\"counter feed-footer__counter\"][3]//span[@class=\"counter__value\"]")
	private WebElement amountOfLikesInNotifications;

	@FindBy(xpath = "//span[contains(@class, 'ui-components-icon_comment')]")
	private WebElement comentario1Bttn;

	@FindBy(xpath = "//div[@class=\"counter feed-footer__counter\"][2]//span")
	private WebElement like1Bttn;

	@FindBy(xpath = "//div[@class=\"message-item\"]//span[@class=\"message-item__author-name\"]")
	private WebElement autorOfComments;

	@FindBy(xpath = "//small//span[contains(@class, 'ui-components-icon_like-full')]")
	private WebElement mentionsOfTheLike;

	@FindBy(xpath = "//div[contains(@class, 'feed-item suite-panel--nopadding')][1]//div[@class=\"message-item__text\"]")
	private WebElement primerComentarioTxt;

	@FindBy(xpath = "//div[@class=\"notranslate public-DraftEditor-content\"]")
	private WebElement input1Comentario;

	@FindBy(xpath = "//span[contains(@class, 'messages__input-icon' )]")
	private WebElement sendComentarioBttn;


	@FindBy(xpath = "//span[contains(@class, 'suite-discovery')]")
	private WebElement popAll;
	
	

	public ProfileOfUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickSentTab() {
		click(sentTab);

	}

	public String captureNameAndSenderProfile() {
		String nombreYApellidoObtenido = getText(nombreDelCoworkerAlQueLeEnvieLaEstrella);
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento + " envia a " + nombreYApellidoObtenido;

	}

	public String senderName() {
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento;

	}

	// obtengo la cantidad de comentarios
	public int amountOfComments() {
		String numeroDeComents = getText(cantidadDecomentarios);
		int numeroDeComentsPasadoANumeros = Integer.parseInt(numeroDeComents);
		return numeroDeComentsPasadoANumeros;
	}

	// si hay comentarios me retorna el primero, si no hay me da un mensaje de que
	// aun no hay coments
	public String firstCommentExists() {

		if (isElementPresent(primerComentarioTxt)) {
			String comentario1 = getText(primerComentarioTxt);
			return comentario1;
		} else {
			return "Aun no hay comentarios";
		}
	}

	public boolean firstLikeIsPresentOrNot() {

		if (isElementPresent(mentionsOfTheLike)) {

			return true;
		} else {
			return false;
		}
	}

	public String writeAComment(String comentario) {
		
		type(input1Comentario, comentario);

		return comentario;

	}

	

	public void clickForSentTheComent() {
		click(sendComentarioBttn);
	}

	public void clickInPopUpAll() {
		if(isElementPresent(popAll)) {
			click(popAll);
			
		}
	}
	
	public void clicktoOpenComments(){
		
			click(comentario1Bttn);
		
		
	}

	public void clickToSendLike() {
		click(like1Bttn);
	}

	

	// get the amount of reactions
	public int getAmountOfReactions() {
		String numbersOfReactions = getText(amountOfLikes);
		int numbersOfReactionsConvertToInt = Integer.parseInt(numbersOfReactions);
		return numbersOfReactionsConvertToInt;
	}

	public int getAmountOfReactionsInNotifications() {
		String numbersOfReactionsNotifications = getText(amountOfLikesInNotifications);
		int numbersOfReactionsConvertToInt = Integer.parseInt(numbersOfReactionsNotifications);
		return numbersOfReactionsConvertToInt;
	}

}