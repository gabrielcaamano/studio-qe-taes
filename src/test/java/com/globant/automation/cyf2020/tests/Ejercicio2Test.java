package com.globant.automation.cyf2020.tests;

import org.json.JSONArray;
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

public class Ejercicio2Test {
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
	
	//@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	@Test
	public void ejercicio1() {
		PagPincipalEJER1 PrincipalPagina = new PagPincipalEJER1(driver);
		Ingredientes ingredientes = PrincipalPagina.navigateToIngredientes();
		Trago trago2 = ingredientes.navigateToTragodeIngredients("Mint");
		
		System.out.println(trago2.obtenerIngredientesLista());
		buscarSegundoElemento("Mint");
	}
	
	
public void buscarSegundoElemento(String ingrediente) {
		
		
		//Guardamos en una variable la url del método get
		String endpointIngrediente = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + ingrediente;
		
		//Obtenemos la respuesta de la petición
		Response response = RestAssured.given().get(endpointIngrediente); 
		
		//Pasamos a tipo String el body de la respuesta
		String tragoaAsString = response.getBody().asString();
		
		//Convertimos la respuesta a JSON
		JSONObject responseToJson = new JSONObject(tragoaAsString);
	
		String segundoAtriculoJson = responseToJson.get("drinks").toString().replace("[", "").replace("]", "");
		
		JSONArray array = responseToJson.getJSONArray("drinks");
		
		
		
		// Manipulamos el Json a nuestra manera para obtener lo que queremos
		
		String nombre = array.get(1).toString();
		
		JSONObject contenidoTragoJson = new JSONObject(nombre);
		
		String nombreTrago = contenidoTragoJson.get("strDrink").toString();
		
		//Imprimo en pantalla el nombre de trago
		System.out.println("El nombre del trago es: " + nombreTrago);
		
		
		
		
		
	}
	
	
	
}
