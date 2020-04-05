package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PerfilDeUser extends BasePage {

	
//
	@FindBy(xpath = "//div[@class=\"tab-panel__item\"]")
	private WebElement sentTab;
	//
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//span[@class=\"feed-item__avatar-name--cursor\"]")
	private WebElement nombreDelCoworkerAlQueLeEnvieLaEstrella;
	
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//strong[@class=\"feed-footer__full-name\"]")
	private WebElement porQuienEsEnviadaLaEstrella;

	//comentario
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//div[@class=\"counter feed-footer__counter\"][1]//span[@class=\"counter__value\"]")
	private WebElement cantidadDecomentarios;
		
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//div[@class=\"counter feed-footer__counter\"]")
	private WebElement comentario1Bttn;
		
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//div[@class=\"message-item__text\"]")
	private WebElement primerComentarioTxt;
		     			
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//div[@class=\"notranslate public-DraftEditor-content\"]")
	private WebElement input1Comentario;
	
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//span[@class=\"ui-components-icon ui-component-icon ui-components-icon_send-message ui-component-icon_small messages__input-icon ui-component-icon_white messages__input-icon \"]")
	private WebElement sendComentarioBttn;
	
	@FindBy(xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--right suite-discovery__smu--open\"]")
	private WebElement popUpUserRight;  
	
	@FindBy(xpath = "//div[@class=\"curtain--navbar suite-discovery__curtain\"]")
	private WebElement popUpUserGeneral;
	
	@FindBy(xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")
	private WebElement popUpMyProfile;

	
	
	
	
		
	
	public PerfilDeUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickSentTab() {
		click(sentTab);
		
	}
	
	public String capturarNombreYreemitentePerfil() {
		String nombreYApellidoObtenido = getText(nombreDelCoworkerAlQueLeEnvieLaEstrella);
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento + " envia a " + nombreYApellidoObtenido;
		
	}
	
	public String nombreDelReemitente() {
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento;
		
	}
	
	//obtengo la cantidad de comentarios
	public int cantidadDeComentarios() {
			String numeroDeComents = getText(cantidadDecomentarios);
			int numeroDeComentsPasadoANumeros = Integer.parseInt(numeroDeComents);
			return numeroDeComentsPasadoANumeros;
		}
		
		//si hay comentarios me retorna el primero, si no hay me da un mensaje de que aun no hay coments
	public String primercomentarioExisteOno() {
			
			if(isElementPresent(primerComentarioTxt)) {
			String comentario1 = getText(primerComentarioTxt);
			return comentario1; } else {return "Aun no hay comentarios";}
		}
	
	public String escribirUnComentario(String comentario) {
		clicktoOpenComments();
		type(input1Comentario, comentario);

		return comentario;
		
	}
	
	public void clickPopUpRight() {
		click(popUpUserRight);
	}
	
	public void clickForSentTheComent() {
		click(sendComentarioBttn);
	}
	
	public void clickPopUpGeneral() {
		click(popUpUserGeneral, Duration.ofSeconds(5));
	}
	
	
	public void clicktoOpenComments() {
		click(comentario1Bttn);
	}
	
	
	public void clickPopUpInMyProfile() {
		click(popUpMyProfile);
	}
	
	
    
	
	
	

}