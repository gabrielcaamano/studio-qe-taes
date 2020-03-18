package com.globant.automation.cyf2020.tests.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class AceptarSugerencia extends BasePage{

	@FindBy(xpath = "//div[@id = \"footerOpen\"]//a[@class =\"button\"]")
	private WebElement acceptSugerClick;
	@FindBy(xpath = "//div[@class = \"price \"]")
	private WebElement precioSugerencia;
	

	
	public AceptarSugerencia(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String capturaPrecio() { //Captura el precio de de la sugerencia
		String precio = getText(precioSugerencia);
		
				return precio;
	}
	



	public MiPedido goToElPedido() {
		
	
		click(acceptSugerClick);
		 
		
		return getNextPage(MiPedido.class);
	}
	
	
	
}
