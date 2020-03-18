package com.globant.automation.cyf2020.tests.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class AgrandarPedido extends BasePage {
	@FindBy(xpath = "//li//a[@class = \"peyaCard js-fp-card\"]")
	private WebElement sugerenciaClick;
	
	public AgrandarPedido(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickSugerencia() {
		
		click(sugerenciaClick);
		
	}
	

	public AceptarSugerencia aceptarSgerencia() {
		clickSugerencia();
			
		return getNextPage(AceptarSugerencia.class);
	}
	}
	
