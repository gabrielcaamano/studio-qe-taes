package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;


public class ProductoTest extends BasePage{
           @FindBy(xpath = "//header[@class = \"item-title\"]//h1[@class = \"item-title__primary \"]")
           private WebElement nombre;
           
           @FindBy(xpath = "//fieldset[@class = \"item-price \"]//span[@class = \"price-tag\"]//span[@class = \"price-tag-fraction\"]")
           private WebElement precio;
           
           @FindBy(xpath = "//fieldset[@class = \"item-price \"]//div[@class = \"price-tag discount-arrow arrow-left \"]//p")
           private WebElement porcentage;
           
           @FindBy(xpath = "//ul[@class = \"nav-menu-list\"]//li[@class = \"nav-menu-item\"][04]")
           private WebElement btnTiendasOficiales;
         


           public ProductoTest(WebDriver driver) {
        	   
       		super(driver);
       	}
           
       	public String obtenerDatos2() {
    		
    		String precio2 = getText(precio); 
    		String nombre2 = getText(nombre); 
    		String porcentage2 = getText(porcentage);
    		String CadenaDeDatos2 = nombre2 + " " + precio2 +" "+ porcentage2;
    		
    		return CadenaDeDatos2;
    	}

           
           public TiendasOficialesTest navigateTiendasOff() {
      		obtenerDatos2(); 
         	click(btnTiendasOficiales);
         	return getNextPage(TiendasOficialesTest.class);
         	
           }
           
           
         
		


          
           
           


}