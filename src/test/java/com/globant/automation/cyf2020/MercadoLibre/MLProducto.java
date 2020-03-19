package com.globant.automation.cyf2020.MercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MLProducto extends MLHome {

	public MLProducto(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h1[@class=\"item-title__primary \"]")
	WebElement nombreProductoPage;
	

	@FindBy(xpath = "//fieldset[@class=\"item-price \"]//span[@class=\"price-tag\"]//span[@class=\"price-tag-symbol\"]")
	WebElement monedaProductoPage;

	@FindBy(xpath = "//fieldset[@class=\"item-price \"]//span[@class=\"price-tag\"]//span[@class=\"price-tag-fraction\"]")
	WebElement precioProductoPage;
	
	@FindBy(xpath = "//fieldset[@class=\"item-price \"]//div[@class=\"price-tag discount-arrow arrow-left \"]//p")
	WebElement descuentoProductoPage;
	
	String nombreProductoPageString = "";
	String monedaProductoPageString = "";
	String precioProductoPageString = "";
	String descuentoProductoPageString = "";
	
	public String getDatosTextProductoPage() {
		
		nombreProductoPageString = nombreProductoPage.getText();
		monedaProductoPageString = monedaProductoPage.getText();
		precioProductoPageString = precioProductoPage.getText();
		descuentoProductoPageString = descuentoProductoPage.getText();
		
		String resultadoProductoPage = nombreProductoPageString + " vale: " + monedaProductoPageString + " "
				+ precioProductoPageString + " con un descuento de " + descuentoProductoPageString;
		
		System.out.println(resultadoProductoPage);
		
		return resultadoProductoPage;
	}
	

}
