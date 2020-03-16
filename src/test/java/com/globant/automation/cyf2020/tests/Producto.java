package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Producto extends BasePage{

	public Producto(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//div[@class ='layout-col layout-col--right']//span[@class='price-tag-fraction'])[2]") 
	private WebElement precio;
	
	@FindBy(xpath = "(//div[@class ='layout-col layout-col--right']//h1[@class='item-title__primary '])")
	private WebElement nombre;

	@FindBy(xpath = "(//div[@class ='layout-col layout-col--right']//div[@class='price-tag discount-arrow arrow-left '])")
	private WebElement descuento;
	
	
	public void setPrecio(WebElement precio) {
		this.precio = precio; 
	}
	public WebElement getPrecio() {
		return this.precio;
	}
	
	public void setNombre(WebElement nombre) {
		this.nombre = nombre;
	}
	public WebElement getNombre() {
		return this.nombre;
	}
	
	public void setDescuento(WebElement descuento) {
		this.descuento = descuento; 
	}
	public WebElement getDescuento() {
		return this.descuento;
	}
	
	public String precio2 = getText(getPrecio());
	public String nombre2 = getText(getNombre());
	public String descuento2 = getText(getDescuento());
	
}
