
package com.globant.automation.cyf2020.tests;

import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.globant.automation.cyf2020.EjercicioTragosHome;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EjercicioTragosTest {
	
	WebDriver driver;

	@BeforeMethod
	public void abrirNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cyf-2020.firebaseapp.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void TestTragos() {

		EjercicioTragosHome tragosHome = new EjercicioTragosHome(driver);
		String nombreTragoHome = tragosHome.obtenerNombre();
		System.out.println("El nombre del trago en la Pagina Web es: " + nombreTragoHome);
		Response response = RestAssured.given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + nombreTragoHome);
		String infoApi = response.getBody().asString();
		infoApi = infoApi.replace("[", "");
		infoApi = infoApi.replace("]", "");
		JSONObject objetoDrinks = new JSONObject(infoApi);
		JSONObject infoTrago = objetoDrinks.getJSONObject("drinks");
		String nombreTragoApi = infoTrago.getString("strDrink");		
		}

}
