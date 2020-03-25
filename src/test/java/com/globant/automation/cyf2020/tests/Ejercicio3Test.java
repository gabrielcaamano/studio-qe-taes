package com.globant.automation.cyf2020.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Ejercicio3Test {
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
	public void ejercicio() {  //ejecuta el ejercicio 2
		PagPincipalEJER1 PrincipalPagina = new PagPincipalEJER1(driver);
		Trago tragoseleccionado = PrincipalPagina.navigateToTercerTrago();
		String elTitulo = tragoseleccionado.tituloTrago(); 
		
		
		buscarCategoria(buscarCategoriaDTrago(elTitulo), elTitulo);
		
	}
	
	public String buscarCategoriaDTrago(String titulo) { //toma el nombre del trago y me devuelve la categoria.
		
		
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
		String categoriaDelTrago = contenidoTragoJson.get("strCategory").toString();
		
		
		
		return categoriaDelTrago;
		
	}
	
	//busco la categoria, despues que el nombre segun la categoria y la comparo segun lo que saque de la pagina
public void buscarCategoria(String categoria, String nombreDeBebida) {
		
		
		//Guardamos en una variable la url del método get
		String categoriaDeTrago = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=" + categoria;
		
		//Obtenemos la respuesta de la petición segun la categoria
		Response response = RestAssured.given().get(categoriaDeTrago); 
		
		//Pasamos a tipo String el body de la respuesta
		String tragoaAsString = response.getBody().asString();
		
		//Convertimos la respuesta a JSON
		JSONObject responseToJson = new JSONObject(tragoaAsString);
	
		
		
		//Convertimos la respuesta a JsonArray 
		JSONArray array = responseToJson.getJSONArray("drinks");
		
		
		
				
		
			//tomo el nombre segun la categoria
				int i=1;
				
				String nombre = array.get(i).toString();
				
				JSONObject contenidoTragoJson = new JSONObject(nombre);
				
				String nombreTrago = contenidoTragoJson.get("strDrink").toString();
				
				
				//recorro el array buscando el nombre de la categoria
			while(i < array.length()) {

				    
		           nombre = array.get(i -1).toString();
		           contenidoTragoJson = new JSONObject(nombre);
				   nombreTrago = contenidoTragoJson.get("strDrink").toString();
				  
				   
		          
		           
		           if (nombreTrago.equals(nombreDeBebida)) {
		           
		        	   System.out.println("Encontro el trago"); 
		        	   
		        	   Assert.assertEquals(nombreTrago , nombreDeBebida );
		        	   
		           } else if (i > array.length()) {
		        	   
		        	   System.out.println("No se a encontrado la bebida"); 
		        	   break;
		           } 
					
		           
		           i++;
		           
					} 
					
					
			
				
				
}
	
	
	
	
	
}
