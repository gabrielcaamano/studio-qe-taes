package com.globant.automation.cyf2020.tests;
import org.testng.Assert;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestTragos {
	private WebDriver driver;

	@BeforeMethod
	public void openTragos() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://cyf-2020.firebaseapp.com/");	
	}
	
	@Test 
	public void testTragos(){
		Tragos homepage = new Tragos(driver);
		homepage.clickBotonRecomendarTragos();
		String nombrePrimerTrago = homepage.nombrePrimerTrago();
	    String tragosSinEspacios= nombrePrimerTrago.replace(" ", "%20");	
		
	    //Guardamos en una variable la url del método get
		String infoTrago = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";
		
		//Obtenemos la respuesta de la petición
		Response response = RestAssured.given().urlEncodingEnabled(false).get(infoTrago + tragosSinEspacios);
		
		//Pasamos a tipo String el body de la respuesta
		String tragoaAsString = response.getBody().asString();
		
		//Convertimos la respuesta a JSON
		JSONObject responseToJson = new JSONObject(tragoaAsString);
		
		// Manipulamos el Json a nuestra manera para obtener lo que queremos
		String contenidoTrago = responseToJson.get("drinks").toString().replace("[", "").replace("]", "");
		JSONObject contenidoTragoJson = new JSONObject(contenidoTrago);
		String nombreTrago2 = contenidoTragoJson.get("strDrink").toString();
		
		//Imprimo en pantalla el nombre de trago
		System.out.println("El nombre del trago es: " + nombreTrago2);
		
		Assert.assertEquals(nombreTrago2, nombrePrimerTrago, "estos no son iguales");
		
	
    }
}


