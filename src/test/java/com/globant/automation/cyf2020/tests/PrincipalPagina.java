package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PrincipalPagina extends BasePage{

	@FindBy(xpath = "//div[@class = \"nav-menu\"]//ul[@class = \"nav-menu-list\"]//li[05]//a")
	private WebElement ofertaSemanalButn;

	@FindBy(xpath = "//a[@class = \"nav-logo\"]")
	private WebElement logoMercado;

	
	public WebElement getOfertaSemanalButn() {
		return ofertaSemanalButn;
	}

	public WebElement setOfertaSemanalButn(WebElement ofertaSemanalButn) {
		return this.ofertaSemanalButn = ofertaSemanalButn;
	}

	public WebElement getLogoMercado() {
		return logoMercado;
	}

	public WebElement setLogoMercado(WebElement logoMercado) {
		return this.logoMercado = logoMercado;
	}
	
	
	public PrincipalPagina(WebDriver driver) {
		super(driver);
		
		click(getOfertaSemanalButn());
		
		
		
		
	}
	
	/*public  void DarClickOffer() {
		click(this.ofertaSemanalButn, 10);
	}
	public  void DarClicLogo() {
		click(this.logoMercado, 10);
	}


	private void click(WebElement ofertaSemanalButn2, int i) {
		// TODO Auto-generated method stub
		
	}
	*/
	
} 

