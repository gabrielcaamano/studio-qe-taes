package com.globant.automation.cyf2020.tests;

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
	
	
	
    
	
	
	

}