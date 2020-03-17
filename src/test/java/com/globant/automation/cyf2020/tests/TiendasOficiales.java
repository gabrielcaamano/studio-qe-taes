package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TiendasOficiales extends BasePage {

	public TiendasOficiales(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath="//div[@class = \"searchbox\"]//input")
	private WebElement inputTiendasOficial;
	
	@FindBy(xpath="//a[@class = \"logo-search\"]")
	private WebElement tiendaMonClick;
	
	
	
 	public void ingresarDatos() {
 		String InputTiendasMon = "tiendas montevideo";
 		
 		inputTiendasOficial.sendKeys(InputTiendasMon);
		
	}
	
	   public ArticuloTiendasMtvdeo navigateArticulo() {
		 ingresarDatos();
		 
   		click(tiendaMonClick);
   		return getNextPage(ArticuloTiendasMtvdeo.class);
   	}

	
	
	 
	
	
}