package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.json.JSONObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EjercicioTest {
	
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClasss() {
		System.out.println("ANTES DE TODOS");
	}
	
	@BeforeClass
	public void segundoBeforeClass() {
		System.out.println("OTRO BEFORECLASS");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mercadolibre.com.uy");
	}
	
	@AfterMethod
	public void closeDriver() {
//		driver.close();
	}
	
	@Test
	public void ejercicio1() {
		System.out.println("ESTOY EN test1");
		
		Assert.assertEquals("pedro", "pedro", "los nombres no fueron iguales");
		boolean variableFalse = false;
		Assert.assertTrue(variableFalse, "la variable no fue true");
		
		System.out.println("CODIGO EXTRA");
	}
	
	@Test
	public void ejercicioRestAssured() {
		
		//Guardamos en una variable la url del método get
		String endpointTrago = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita";
		
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
		
		Assert.assertEquals(nombreTrago, "Margarita");
		
		//               ¡¡FIN!!!
	}
	
	@Test
	public void ejercicio2() {
		System.out.println("estoy en test2");
	}
	
}
