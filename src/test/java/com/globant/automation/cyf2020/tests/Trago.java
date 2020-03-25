package com.globant.automation.cyf2020.tests;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.globant.automation.cyf2020.infrastructure.BasePage;



public class Trago extends BasePage{
	
	
	@FindBy(id="nombre")
	private WebElement tituloTrago;
	
	@FindBy(id="h5ing")
	private WebElement ingredientesList;
	
	@FindBy(xpath = "//h5[@id = \"h5ing\" ]//p")
	private WebElement cantidaddeP;
	
	
	
	public Trago(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	public String tituloTrago() {
		String titulo = getText(tituloTrago);
		return titulo;
	}
	
	public String obtenerIngredientesLista() {
		String ingredientes = getText(ingredientesList);
		 
	    return ingredientes;
 		
		 
	}



	
}
