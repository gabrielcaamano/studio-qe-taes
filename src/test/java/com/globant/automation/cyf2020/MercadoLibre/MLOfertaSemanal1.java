package com.globant.automation.cyf2020.MercadoLibre;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MLOfertaSemanal1 extends MLHome {

	@FindBy(xpath = "//span[@class=\"main-title\"]")
	WebElement nombreHome;

	@FindBy(xpath = "//ol[@id=\"searchResults\"][1]//li[@class=\"results-item highlighted article grid item-info-height-195\"][1]//div[@class=\"rowItem item highlighted item--grid new to-item\"]//a[@class=\"item__info-link item__js-link \"]//div[@class=\"item__info \"]//div[@class=\"item__price item__price-discount\"]//span[@class=\"price__symbol\"]")
	WebElement monedaHome;

	@FindBy(xpath = "//ol[@id=\"searchResults\"][1]//li[@class=\"results-item highlighted article grid item-info-height-195\"][1]//div[@class=\"rowItem item highlighted item--grid new to-item\"]//a[@class=\"item__info-link item__js-link \"]//div[@class=\"item__info \"]//div[@class=\"item__price item__price-discount\"]//span[@class=\"price__fraction\"]")
	WebElement precioHome;

	@FindBy(xpath = "//span[@class=\"price__symbol\"]")
	WebElement descuentoHome;
	
	@FindBy(xpath = "//ol[@id=\"searchResults\"][1]//li[@class=\"results-item highlighted article grid item-info-height-195\"][1]//div[@class=\"rowItem item highlighted item--grid new to-item\"]//a[@class=\"item__info-link item__js-link \"]")
	WebElement linkProducto;
	
	String nombreHomeString = "";
	String monedaHomeString = "";
	String precioHomeString = "";
	String descuentoHomeString = "";
	
	@FindBy(xpath = "//ul[@class=\"nav-menu-list\"]//li[@class=\"nav-menu-item\"][6]//a[@class=\"nav-menu-item-link \"]")
	WebElement vender;

	public MLOfertaSemanal1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public MLProducto GoProducto() {

		vender.click();
		return new MLProducto(driver);

	}
	

	public MLProducto GoHome() {
		
		linkProducto.click();
		return new MLProducto(driver);
		
	}

	public void datosToString() {

		nombreHomeString = nombreHome.toString();
		monedaHomeString = monedaHome.toString();
		precioHomeString = precioHome.toString();
		descuentoHomeString = descuentoHome.toString();

		System.out.println("En Ofertas Semanales, el producto " + nombreHomeString + " vale: " + monedaHomeString + " "
				+ precioHomeString + " con un descuento de " + descuentoHomeString);

	}

}
