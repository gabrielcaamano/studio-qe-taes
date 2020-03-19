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
	
	@FindBy (xpath="//h1[@class='item-title__primary ']")
	private WebElement nombreProducto;

	@FindBy (xpath="(//div[@class='layout-col layout-col--right']//span[@class='price-tag-fraction'])[2]")
	private WebElement precioProducto;
	
	@FindBy (xpath="//fieldset[@class='item-price ']//p")
	private WebElement porcentajeDescuento;
	
	@FindBy(xpath="(//li[@class='results-item highlighted article grid product item-info-height-195'])[1]")
	private WebElement clickProducto;
	
	
	public String nombreP() {
	return getText(nombreProducto);
	}
	public String precioP() {
	return getText(precioProducto);
	}
	public String porcentajeDescuento1() {
	return getText(porcentajeDescuento);
	}
	public Producto navigateToProducto() {
	   click(clickProducto);
		   return getNextPage(Producto.class);
		 }
	

}
