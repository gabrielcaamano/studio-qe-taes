package com.globant.automation.cyf2020.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Ejercicio2Test {  //en este ejercicio voy a hacer el el ejercicio2 de HTTP. 
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
		
		Ingredientes ingredientes = PrincipalPagina.navigateToIngredientes();
		
		Trago trago2 = ingredientes.navigateToTragodeIngredients("Mint");
		
		String ingredientesDeLaPagina = trago2.obtenerIngredientesLista();
		
		compararIngredientes(buscarSegundoElemento("Mint"), ingredientesDeLaPagina);
	}
	
	
public String buscarSegundoElemento(String ingrediente) {
		
		
		//Guardamos en una variable la url del método get
		String endpointIngrediente = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + ingrediente;
		
		//Obtenemos la respuesta de la petición segun el ingrediente pasado por parametro
		Response response = RestAssured.given().get(endpointIngrediente); 
		
		//Pasamos a tipo String el body de la respuesta
		String tragoaAsString = response.getBody().asString();
		
		//Convertimos la respuesta a JSON
		JSONObject responseToJson = new JSONObject(tragoaAsString);
	
		
		
		//Convertimos la respuesta a JsonArray para poder tomar la segunda posicion
		JSONArray array = responseToJson.getJSONArray("drinks");
		
		
		
		// Manipulamos el Json a nuestra manera para obtener el segundo elemento
		
		String nombre = array.get(1).toString();
		
		JSONObject contenidoTragoJson = new JSONObject(nombre);
		
		String nombreTrago = contenidoTragoJson.get("strDrink").toString();
		
		//Imprimo en pantalla el nombre de trago obtenido
		System.out.println("El nombre del trago es: " + nombreTrago); 
		
		return nombreTrago;   //retorno el nombre del trago para tomarlo como parametro en la funcion de comparar ingredientes
		
}


		
		public void compararIngredientes(String nombreDeTrago, String ingredientList) {
		//de aqui en mas comparo los ingredientes que tengo que verificar;
		
		//coloco los ingredientes en un array para si acceder por posisciones
		String arrayDeIngredientes[] = ingredientList.split("\n");		
		
		
		//Guardamos en una variable la url del método get
		String endpointTrago = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + nombreDeTrago;
				
				//Obtenemos la respuesta de la petición
		Response respuesta = RestAssured.given().get(endpointTrago); 
				
				//Pasamos a tipo String el body de la respuesta
		String tragoComoString = respuesta.getBody().asString();
				
				//Convertimos la respuesta a JSON
		JSONObject respuestaAJson = new JSONObject(tragoComoString);
				
		// Manipulamos el Json a nuestra manera para obtener las bebidas
		
		String contenidoTrago = respuestaAJson.get("drinks").toString().replace("[", "").replace("]", "");
				
		JSONObject ingredientesJson = new JSONObject(contenidoTrago);
		
		
		//tomo los ingredientes y las medidas
		int i=1;
		String ingredienteDLTrago = ingredientesJson.get("strIngredient" + i).toString();
		String medidaDlIngrediente = ingredientesJson.get("strMeasure" + i).toString();
		
		
	
					
		
		for(i = 1 ;i < arrayDeIngredientes.length;) {

           Assert.assertEquals(arrayDeIngredientes[i-1] +" ", ingredienteDLTrago + " " + medidaDlIngrediente, "Los ingredientes no coinciden");
           i++;
           ingredienteDLTrago = ingredientesJson.get("strIngredient" + i).toString();	
		    medidaDlIngrediente = ingredientesJson.get("strMeasure" + i).toString();
			
			} 
			
			
			
		} 
		
		}
		
				
			