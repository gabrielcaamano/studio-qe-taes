package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class MiPedido extends BasePage{
	
	@FindBy(xpath = "//ul[@class=\"cart_items\"]//div[@class=\"price\"]")
	private WebElement precio2;
	
    @FindBy(xpath = "//span[@title=\"Avenida 18 de Julio 885\"]")
	private WebElement direccion2;
	
    @FindBy(id="order")
	private WebElement continuarBtn;
    
    @FindBy(xpath = "//div[@class=\"tbox\"]")
	private WebElement modal;
	
    public MiPedido(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    public String capturaPrecio2() { //Captura el precio de de la sugerencia
		String precioTwo = getText(precio2);
		
				return precioTwo;
	}
    
    public String capturaDireccion() { //Captura el precio de de la sugerencia
		String direccionTwo = getText(direccion2);
		
				return direccionTwo;
	}
    
   public boolean darClickYVerificarModal() {
		click(continuarBtn);
		return isElementDisplayed(modal);
		
   }
	
    
	
}