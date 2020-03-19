package com.globant.automation.cyf2020.MercadoLibre;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MLOfertaSemanal1 extends MLHome {

	@FindBy(xpath = "//span[@class=\"main-title\"]")
	WebElement nombreHome;

	@FindBy(xpath = "//ol[@id=\"searchResults\"][1]//a[@class=\"item__info-link item__js-link \"]//div[@class=\"item__info \"]//div[@class=\"item__price item__price-discount\"]//span[@class=\"price__symbol\"]")
	WebElement monedaHome;

	@FindBy(xpath = "//ol[@id=\"searchResults\"][1]//a[@class=\"item__info-link item__js-link \"]//div[@class=\"item__info \"]//div[@class=\"item__price item__price-discount\"]//span[@class=\"price__fraction\"]")
	WebElement precioHome;

	@FindBy(xpath = "//ol[@id=\"searchResults\"][1]//li[@class=\"results-item highlighted article grid product item-info-height-195\"][1]//div[@class=\"rowItem item highlighted item--grid new \"][1]//a[@class=\"item__info-link item__js-link \"][1]//div[@class=\"item__info \"]//div[@class=\"item__discount \"]")
	WebElement descuentoHome;
	
	//@FindBy(xpath = "//ol[@id=\"searchResults\"][1]//li[@class=\"results-item highlighted article grid product item-info-height-195\"][1]//div[@class=\"rowItem item highlighted item--grid new \"][1]//a[@class=\"item__info-link item__js-link \"][1]//div[@class=\"item__info \"]//div[@class=\"item__discount \"]")
	//WebElement linkProducto;
	
	String nombreHomeString = "";
	String monedaHomeString = "";
	String precioHomeString = "";
	String descuentoHomeString = "";

	public MLOfertaSemanal1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public String datosGetTextOfertaSemanal() {

		nombreHomeString = nombreHome.getText();
		monedaHomeString = monedaHome.getText();
		precioHomeString = precioHome.getText();
		descuentoHomeString = descuentoHome.getText();

		String resultadoOfertaSemanalPage = nombreHomeString + " vale: " + monedaHomeString + " "
				+ precioHomeString + " con un descuento de " + descuentoHomeString;
		
		System.out.println(resultadoOfertaSemanalPage);
		
		return resultadoOfertaSemanalPage;
		
	}
	
	public MLProducto GoProducto() {
		
		click(nombreHome, DEFAULT_TIMEOUT);
		return new MLProducto(driver);
	}

}
