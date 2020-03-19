package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;


  public class MercadoLibre extends BasePage {

   	 public MercadoLibre (WebDriver driver) {
		super(driver);
	  }
  
   	 @FindBy(xpath="(//li[@class='nav-menu-item'])[5]")
	private WebElement botonOfertas;
   	
   	 
   	 
   	 public OfertasSemanales navigateToOfertasSemanales() {
       click(botonOfertas);
   	   return getNextPage(OfertasSemanales.class);
   	 }
   	 
   	 
   	 
   	 
 	@FindBy (xpath= "(//li[@class='nav-menu-item']//a[@class='nav-menu-item-link'])[2]")
 	private WebElement botonTiendasOficiales;
 	
 	
   	public TiendasOficiales navigateToTiendasOficiales() {
	       click(botonTiendasOficiales);
	   	   return getNextPage(TiendasOficiales.class);
	   	 }
   	 

   }
