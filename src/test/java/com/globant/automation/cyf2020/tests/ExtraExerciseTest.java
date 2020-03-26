package com.globant.automation.cyf2020.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.PrimerEjercicioTragosHome;
import com.globant.automation.cyf2020.infrastructure.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ExtraExerciseTest {

	private WebDriver driver;

	@BeforeMethod
	public void abrirNavegador() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cyf-2020.firebaseapp.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testExtra() {
		
		// Reused code of first API exercise
		// strCategory obtained from API?name
		PrimerEjercicioTragosHome drinksHomeExtra = new PrimerEjercicioTragosHome(driver);
		String nameThirdDrinkHome = drinksHomeExtra.obtenerNombreTrago("3"); //Obtain recommended drink by index 1-3
		Response responseName = RestAssured.given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + nameThirdDrinkHome);
		String infoApiThirdDrink = responseName.getBody().asString();
		infoApiThirdDrink = infoApiThirdDrink.replace("[", "");
		infoApiThirdDrink = infoApiThirdDrink.replace("]", "");
		JSONObject objetoDrinks = new JSONObject(infoApiThirdDrink);
		JSONObject infoTragoName = objetoDrinks.getJSONObject("drinks");
		String categoryTragoApiName = infoTragoName.getString("strCategory");
		String nameTragoApiName = infoTragoName.getString("strDrink");
	
		//Busqueda del trago por sen la API
		Response responseCat = RestAssured.given().get("https://thecocktaildb.com/api/json/v1/1/filter.php?c=" + categoryTragoApiName);
		String infoApiCat = responseCat.getBody().asString();
		JSONObject objetoDrinksCat = new JSONObject(infoApiCat);
		JSONArray arrayTragosCat = objetoDrinksCat.getJSONArray("drinks");
		boolean iguales = false;
		String nombreApiCat = "";
		
		int i = 1;
		while ( i <= arrayTragosCat.length() && !iguales ) {
			nombreApiCat = arrayTragosCat.getJSONObject(i - 1).get("strDrink").toString();
			iguales = nombreApiCat.equals(nameTragoApiName);
			i++;
		}
		Assert.assertEquals(nombreApiCat, nameTragoApiName);
	}

	@AfterMethod
	public void cerrarNavegador() {
		driver.close();
	}

}
