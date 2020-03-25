package com.globant.automation.cyf2020.tests;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;



public class Ejercicio1Test {
	private WebDriver driver;
	
	
	@BeforeClass
	public void beforeClasss() {
		System.out.println("Inicia el test");
	}
	
	
	
    @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cyf-2020.firebaseapp.com/");
	} 
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	

	@Test
	public void ejercicio1() {
		PagPincipalEJER1 PrincipalPagina = new PagPincipalEJER1(driver);
		Trago tragoseleccionado = PrincipalPagina.navigateToTercerTrago();
		String elTitulo = tragoseleccionado.tituloTrago(); //el titulo toma el nombre del trago
		
		buscarNombreDTrago(elTitulo); 
	}
	
	
	



	
	public void buscarNombreDTrago(String titulo) { //toma el nombre del trago y se asegura de que coincida con la variable elTitulo.
		
		
		//Guardamos en una variable la url del método get
		String endpointTrago = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + titulo;
		
		//Obtenemos la respuesta de la petición
		Response response = RestAssured.given().get(endpointTrago); 
		
		//Pasamos a tipo String el body de la respuesta
		String tragoaAsString = response.getBody().asString();
		
		//Convertimos la respuesta a JSON
		JSONObject responseToJson = new JSONObject(tragoaAsString);
		
		// Manipulamos el Json a nuestra manera para obtener lo que queremos
		String contenidoTrago = responseToJson.get("drinks").toString().replace("[", "").replace("]", "");
		JSONObject contenidoTragoJson = new JSONObject(contenidoTrago);
		String nombreTrago = contenidoTragoJson.get("strDrink").toString();
		
		//Imprimo en pantalla el nombre de trago
		System.out.println("El nombre del trago es: " + nombreTrago);
		
		Assert.assertEquals(nombreTrago, titulo);
		System.out.println("los titulos coinciden, ejercicio 1 finalizado");
		
	}
	
	
	

	 

}
