package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TiendasOficiales {

	@FindBy(xpath="//div[@class = \"searchbox\"]//input")
	private WebElement inputTiendasOficial;
	
	@FindBy(xpath="//logo-search[@class = \"logo-search\"]")
	private WebElement tiendaMonClick;
	
	
	
 	public void ingresarDatos() {
 		String InputTiendasMon = "tiendas montevideo";
 		
 		inputTiendasOficial.sendKeys(InputTiendasMon);
		
	}
	
	 /*public ArticuloTiendasMtvdeo navigateProducto() {
		 ingresarDatos();
   		click(tiendaMonClick);
   		return getNextPage(ArticuloTiendasMtvideo.class);
   	} */
	
	
	 
	
	
}
