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
	
	@FindBy(xpath = "//section[@class = \"optionItem radios inputs third \"][1]//ul//li[1]//input")
	private WebElement primerCampoYOpcionClick;
	
	@FindBy(xpath = "//section[@class = \"optionItem radios inputs third \"][2]//ul//li[1]//input")
	private WebElement segundoCampoYOpcionClick;
	
	public AceptarSugerencia(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String capturaPrecio() {
		String precio = getText(precioSugerencia);
		
				return precio;
	}
	
     public void clickSugerenciaYAceptar() {
    	
    	 click(primerCampoYOpcionClick);
 		click(segundoCampoYOpcionClick);
 		click(acceptSugerClick);
	}

	

	

	public MiPedido elPedido() {
		
		clickSugerenciaYAceptar();
	 	
	 		
			
		return getNextPage(MiPedido.class);
	}
	
	
	
}
