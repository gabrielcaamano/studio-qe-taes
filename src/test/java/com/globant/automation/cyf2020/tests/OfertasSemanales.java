package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class OfertasSemanales extends BasePage {
    
	@FindBy(xpath="//li[@class = \"results-item highlighted article grid item-info-height-195\"][1]//div[@class =\"item__image item__image--grid\"]//div[@class =\"images-viewer\"]")
	private WebElement primerItem;
	
	@FindBy(xpath = "//li[@class = \"results-item highlighted article grid item-info-height-195\"][1]//div[@class = \"item__info \"]//span[@class = \"price__fraction\"]")
	private WebElement precioPP;
	
	@FindBy(xpath="//li[@class = \"results-item highlighted article grid item-info-height-195\"][1]//a[@class = \"item__info-link item__js-link \"]//h2[@class = \"item__title list-view-item-title \"]//span[@class = \"main-title\"]")
	private WebElement nameOfProductPP;
	
	@FindBy(xpath="//li[@class = \"results-item highlighted article grid item-info-height-195\"][1]//div[@class = \"item__info \"]//div[@class = \"item__discount \"]")
	private WebElement porcetagePP;
	
	@FindBy(xpath="//h1[\"breadcrumb__title\"]")
	private WebElement TiendasOficialTITLE;
	

	 public Producto navigateProducto() {
		 obtenerDatos();
		 
		 click(primerItem);
   		return getNextPage(Producto.class);
   	}
	 
	public OfertasSemanales(WebDriver driver) {
		super(driver);
	}
	
	
	public WebElement getPrecioPP() {
		return precioPP;
	}

	public WebElement setPrecioPP(WebElement precioPP) {
		return this.precioPP = precioPP;
	}
	
	public WebElement setPrimerItem(WebElement primerItem) {
		return this.primerItem = primerItem;
	}
	
	public WebElement getPrimerItem() {
		return primerItem;
	}

	public WebElement getNameOfProductPP() {
		return nameOfProductPP;
	}

	public WebElement setNameOfProductPP(WebElement nameOfProductPP) {
		return this.nameOfProductPP = nameOfProductPP;
	}
	
	public WebElement getPorcetagePP() {
		return porcetagePP;
	}

	public WebElement setPorcetagePP(WebElement porcetagePP) {
		return this.porcetagePP = porcetagePP;
	}
	public String obtenerDatos() {
		
		String precio1 = getText(precioPP); 
		String nombre1 = getText(nameOfProductPP); 
		String porcentage1 = getText(porcetagePP); 
		String CadenaDeDatos1 = nombre1 + " " + precio1 +" "+ porcentage1;
		
		return CadenaDeDatos1;
	}
	
	
	
	
	
}
