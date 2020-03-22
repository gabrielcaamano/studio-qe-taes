package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.globant.automation.cyf2020.infrastructure.BasePage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Trago extends BasePage{
	
	
	@FindBy(id="nombre")
	private WebElement tituloTrago;
	
	@FindBy(id="h5ing")
	private WebElement ingredientesList;
	
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
