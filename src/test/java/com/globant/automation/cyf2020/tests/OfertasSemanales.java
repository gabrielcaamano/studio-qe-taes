package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OfertasSemanales {
    
	@FindBy(xpath="//li[@class = \"results-item highlighted article grid item-info-height-195\"][1]//div[@class = \"rowItem item highlighted item--grid new to-item\"]//div[@class = \"item__info \"]")
	private WebElement primerItem;
	
	@FindBy(xpath = "//li[@class = \"results-item highlighted article grid item-info-height-195\"][1]//div[@class = \"rowItem item highlighted item--grid new to-item\"]//div[@class = \"item__info \"]//span[@class = \"price__fraction\"]")
	private WebElement precioPP;
	
	@FindBy(xpath="//li[@class = \"results-item highlighted article grid item-info-height-195\"][1]//div[@class = \"rowItem item highlighted item--grid new to-item\"]//div[@class = \"item__info \"]//span[@class = \"main-title\"]")
	private WebElement nameOfProductPP;
	
	@FindBy(xpath="//li[@class = \"results-item highlighted article grid item-info-height-195\"][1]//div[@class = \"rowItem item highlighted item--grid new to-item\"]//div[@class = \"item__info \"]//div[@class = \"item__discount \"]")
	private WebElement porcetagePP;
	
	
	
	public OfertasSemanales() {
		this.precioPP = precioPP;
		this.nameOfProductPP = nameOfProductPP;
		this.porcetagePP = porcetagePP;
		this.primerItem = primerItem;
	}
	
	public WebElement getPrecioPP() {
		return precioPP;
	}

	public WebElement setPrimerItem(WebElement primerItem) {
		return this.primerItem = primerItem;
	}
	
	public WebElement getPrimerItem() {
		return primerItem;
	}

	public WebElement setPrecioPP(WebElement precioPP) {
		return this.precioPP = precioPP;
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
	
	public void clickPrimerProduct() {
		
		click(primerItem, 10);
		
	}

	private void click(WebElement primerItem2, int i) {
		// TODO Auto-generated method stub
		
	}
	
	
}
