package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;


public class Producto extends BasePage{
           @FindBy(xpath = "//header[@class = \"item-title\"]//h1[@class = \"item-title__primary __web-inspector-hide-shortcut__\"]")
           private WebElement nombre;
           
           @FindBy(xpath = "//fieldset[@class = \"item-price \"]//span[@class = \"price-tag\"]//span[@class = \"price-tag-fraction\"]")
           private WebElement precio;
           
           @FindBy(xpath = "//fieldset[@class = \"item-price \"]//div[@class = \"price-tag discount-arrow arrow-left \"]//p")
           private WebElement porcentage;
           
           @FindBy(xpath = "//ul[@class = \"nav-menu-list\"]//li[@class = \"nav-menu-item\"][04]")
           private WebElement btnTiendasOficiales;
         


           public Producto(WebDriver driver) {
       		super(driver);
       	}
           
       	public void obtenerDatos() {
    		
    		String precio2 = getText(precio); 
    		String nombre2 = getText(nombre); 
    		String porcentage2 = getText(porcentage); 
    		System.out.println(precio2);
    	}

           
           public Producto navigateProducto() {
      		obtenerDatos(); 
         	click(btnTiendasOficiales);
         	return getNextPage(Producto.class);
         	}
           
           
	


          
           
           


}
