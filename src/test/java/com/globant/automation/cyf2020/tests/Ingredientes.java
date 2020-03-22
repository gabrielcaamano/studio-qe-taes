package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Ingredientes extends BasePage {
	@FindBy(id="textoIngredientes")
	private WebElement imputIngrediente;
	
	@FindBy(id="botonBuscar")
	private WebElement buscarIngredienteButn;
	
	@FindBy(xpath = "//div[@id=\"card2\"]//a")
	private WebElement segundoTrago;
	
	
	public Ingredientes(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void buscarIngredienteYBuscar(String ingrediente) {
		type(imputIngrediente, ingrediente);
		
		click(buscarIngredienteButn);
		
	
	
	}
	

	public Trago navigateToTragodeIngredients(String ingrediente) {
		
		buscarIngredienteYBuscar(ingrediente);
		
		click(segundoTrago);
		return getNextPage(Trago.class);
	}

	
	
	
	
}
