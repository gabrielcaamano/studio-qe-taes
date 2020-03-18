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
	
	@FindBy(xpath = "//section[1]//li[1]//input[@type = \"radio\"]")
	private WebElement primerCampoYOpcionClick;
	
	@FindBy(xpath = "//section[2]//li[1]//input[@type = \"radio\"]" )
	private WebElement segundoCampoYOpcionClick;
	
	
	@FindBy(xpath = "//section[@data-order=\"0\"]//h5//small")
	private WebElement estadoDeSabor1;
	
	@FindBy(xpath = "//section[@data-order=\"1\"]//h5//small")
	private WebElement estadoDeSabor2;
	
	
	
	public AceptarSugerencia(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String capturaPrecio() {
		String precio = getText(precioSugerencia);
		
				return precio;
	}
	
     public void clickCondimento1() {
    	
    	 click(primerCampoYOpcionClick);
    	
    	 click(segundoCampoYOpcionClick);
 		
	}

     public void clickSabores2() {
     	
    	
    	
    	 click(segundoCampoYOpcionClick);
 		
	}

public void condicion() {
	String estado = "Completaste la selección";
	String sabor1 = getText(estadoDeSabor1);;
	String sabor2 = getText(estadoDeSabor2);;
	if (sabor1.equals(estado) && sabor2.equals(estado)) {
		click(acceptSugerClick);
	} else { System.out.println("Esta porqueria no funciona");}
	 
	 
}


	public MiPedido elPedido() {
		
		clickCondimento1() ;
		 
		clickSabores2();
		
		 //click(acceptSugerClick);
		condicion();
		return getNextPage(MiPedido.class);
	}
	
	
	
}
