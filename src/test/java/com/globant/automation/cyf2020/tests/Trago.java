package com.globant.automation.cyf2020.tests;

import java.util.StringTokenizer;

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
	
	public void obtenerIngredientesLista() {
		String ingredientes = getText(ingredientesList);
		
		System.out.println(ingredientes); 
		
		String sTexto = "Light rum 2 oz".replace(" ", "");
		
		int posicion = sTexto.indexOf("2");
		
		System.out.println(posicion);
		StringTokenizer stPalabras = new StringTokenizer(sTexto);
		
		while (stPalabras.hasMoreTokens()) {
			  String sPalabra = stPalabras.nextToken();
			  System.out.println(sPalabra.substring(0,posicion));
			}
 		
		 
	}



	
}
