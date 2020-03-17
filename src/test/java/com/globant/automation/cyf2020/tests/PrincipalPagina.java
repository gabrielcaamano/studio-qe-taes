package com.globant.automation.cyf2020.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PrincipalPagina extends BasePage{

	@FindBy(xpath = "//div[@class = \"nav-menu\"]//ul[@class = \"nav-menu-list\"]//li[05]//a")
	private WebElement ofertaSemanalButn;

	@FindBy(xpath = "//a[@class = \"nav-logo\"]")
	private WebElement logoMercado;

	public OfertasSemanales navigateToWeeklyOffers() {
		click(ofertaSemanalButn);
		return getNextPage(OfertasSemanales.class);
	}
	
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
		
	
		
		
		
		
	}
	

	
} 

