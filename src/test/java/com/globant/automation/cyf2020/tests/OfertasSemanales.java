package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class OfertasSemanales extends BasePage{

	public OfertasSemanales(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy (xpath="(//li[@class ='results-item highlighted article grid product item-info-height-195']//span[@class='main-title'])[1]" )
			private WebElement nombreProducto;
	
	@FindBy (xpath="(//div[@class ='item__price item__price-discount']//span[@class='price__fraction'])[1]")
	private WebElement precioProducto;
	
	@FindBy (xpath="(//li[@class ='results-item highlighted article grid product item-info-height-195']//div[@class='item__discount '])[1]")
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
