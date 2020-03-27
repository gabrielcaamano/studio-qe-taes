package com.globant.automation.cyf2020.tests;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testEjercicio2 {
	private WebDriver driver;

	@BeforeMethod
	public void openTragos() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://cyf-2020.firebaseapp.com/");	
	}
	
	@Test
	public void testEjercicio2() {
		Ejercicio2 homepage= new Ejercicio2(driver);
		QueTragos tragosPage = homepage.navigateToQueTragos();
		String resultPage= tragosPage.buscaIngredientes("lemon");
		TragoSeleccionado resultPage2= tragosPage.navigateToTragoSeleccionado();
	    String ingredientes = resultPage2.guardarIngredientes();
	    String listaIngredientes[]= ingredientes.split("\n");
		System.out.print("Estos son los ingredientes" + listaIngredientes);
		
		
		 //Guardamos en una variable la url del método get
		String infoIngredientes = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=";
		
		//Obtenemos la respuesta de la petición
		Response response = RestAssured.given().urlEncodingEnabled(false).get(infoIngredientes + resultPage);
		
		//Pasamos a tipo String el body de la respuesta
		String ingredientesAsString = response.getBody().asString();
		
		//Convertimos la respuesta a JSON
		JSONObject responseToJson = new JSONObject(ingredientesAsString);
		
		// Manipulamos el Json a nuestra manera para obtener lo que queremos
		JSONArray buscarIngredientes = responseToJson.getJSONArray("drinks");
		JSONObject trago2 = buscarIngredientes.getJSONObject(1);
		String nombreTrago = trago2.getString("strDrink");
		String infoTrago= "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + nombreTrago.replace(" ", "%20");
		Response response1 = RestAssured.given().urlEncodingEnabled(false).get(infoTrago);
		String tragosAsString = response1.getBody().asString();
		JSONObject responseToJson2 = new JSONObject (tragosAsString);
		JSONObject traerIngredientes= responseToJson2.getJSONArray("drinks").getJSONObject(0);  
		
		int i=1;
		while (i<listaIngredientes.length) {
			String nombreTrago1=  traerIngredientes.getString("strIngredient" + i).toString();
			Assert.assertTrue(listaIngredientes [i-1].contains(nombreTrago1));
			i=i+1;
		}
	
		
		
		
	
    }
	}



	

