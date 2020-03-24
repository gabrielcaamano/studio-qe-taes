package com.globant.automation.cyf2020.tests;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ejerciciosRestAssured.HomePage;
import ejerciciosRestAssured.QueTragoPage;
import ejerciciosRestAssured.TragoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EjercicioHTTP {

	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cyf-2020.firebaseapp.com/");
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	@Test
	public void ejercicio1() {
		HomePage home = new HomePage(driver);
		home.clickRecomendar();
		TragoPage primerTrago = home.clickPrimerTrago();

		String link = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s="+ (primerTrago.nombre()).replace(" ", "%20");

		Response response = RestAssured.given().urlEncodingEnabled(false).get(link);
		
		String trago = response.getBody().asString();
		
		JSONObject responseToJson = new JSONObject(trago);
		
		String contenidoTrago = responseToJson.get("drinks").toString().replace("[", "").replace("]", "");
		JSONObject contenidoTragoJson = new JSONObject(contenidoTrago);
		String nombreTrago = contenidoTragoJson.get("strDrink").toString();
				
		Assert.assertEquals(nombreTrago, primerTrago.nombre());
		
	}
	
	@Test
	public void ejercicio2() {
		HomePage home = new HomePage(driver);
		QueTragoPage queTrago = home.clickQueTrago();
		queTrago.ingresarIngrediente("vodka");
		queTrago.clickBuscar();
		TragoPage trago = queTrago.irTrago();
		
		String ingred = trago.getIngrdientes();
		String listIngred[] = ingred.split("\n");				

		String link = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s="+ (trago.nombre()).replace(" ", "%20");

		Response response = RestAssured.given().urlEncodingEnabled(false).get(link);
		
		String tragoResponse = response.getBody().asString();
		
		JSONObject responseToJson = new JSONObject(tragoResponse);
		
		String contenidoTrago = responseToJson.get("drinks").toString().replace("[", "").replace("]", "");
		JSONObject contenidoTragoJson = new JSONObject(contenidoTrago);
		int i=1;
		String ingredienteTrago = contenidoTragoJson.get("strIngredient" + i).toString();
		String medidaIngrediente = contenidoTragoJson.get("strMeasure" + i).toString();
		
		while(i < listIngred.length) {
			Assert.assertEquals(listIngred[i-1] +" ", ingredienteTrago + " " + medidaIngrediente, "Los ingredientes no son iguales");
			i++;
			ingredienteTrago = contenidoTragoJson.get("strIngredient" + i).toString();	
			medidaIngrediente = contenidoTragoJson.get("strMeasure" + i).toString();

		}
	}
	
}
