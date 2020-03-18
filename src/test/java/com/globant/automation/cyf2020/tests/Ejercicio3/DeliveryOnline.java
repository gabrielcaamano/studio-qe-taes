package com.globant.automation.cyf2020.tests.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class DeliveryOnline extends BasePage {
	
	@FindBy(xpath = "//input[@id = \"optional\"]")
	private WebElement RestaurantInput;
	@FindBy(xpath = "//input[@id = \"address\"]")
	private WebElement direccionInput;
	@FindBy(xpath = "//button[@id = \"search\"]")
	private WebElement searchButn;
	
	@FindBy(xpath = "//div[@id = \"mapContainer\"]")
	private WebElement ventanaMdl;
	
	@FindBy(xpath = "//a[@id = \"confirm\"]")
	private WebElement btnconfirmUbication;
	
	
	public DeliveryOnline(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
    private void ingresarValores(String lugar, String restaurant) { 
		type(direccionInput, lugar); //uso de type de base page
		type(RestaurantInput, restaurant);
		click(searchButn);
		
		
	}
    
   public String getTheDireccionText() {
	   
	   String direccionInputText = direccionInput.getAttribute("value");
	   
	   return direccionInputText;
   }
	
	public AgrandarPedido navigateToSearchpedido(String lugar, String restaurant) {
		ingresarValores(lugar, restaurant);
		getTheDireccionText();
		click(btnconfirmUbication);
			
		return getNextPage(AgrandarPedido.class);
	}
	
}
