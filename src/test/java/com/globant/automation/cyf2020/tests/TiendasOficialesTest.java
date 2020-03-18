package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TiendasOficialesTest extends BasePage {

	public TiendasOficialesTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath="//div[@class = \"searchbox\"]//input")
	private WebElement inputTiendasOficial;
	
	@FindBy(xpath="//a[@class = \"logo-search\"]")
	private WebElement tiendaMonClick;
	
	
	
 	private void ingresarDatos(String tiendaABuscar) {
 		String InputTiendasMon = tiendaABuscar;
 		
 		inputTiendasOficial.sendKeys(InputTiendasMon);
		
	}
	
	   public ArticuloTiendasMtvdeoTest navigateToTienda(String tiendaABuscar) {
		   ingresarDatos(tiendaABuscar);
		   click(tiendaMonClick);
   		return getNextPage(ArticuloTiendasMtvdeoTest.class);
   	}

	
	
	 
	
	
}