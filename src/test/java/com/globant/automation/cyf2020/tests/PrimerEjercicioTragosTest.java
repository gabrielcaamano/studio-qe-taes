
package com.globant.automation.cyf2020.tests;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.globant.automation.cyf2020.PrimerEjercicioTragosHome;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PrimerEjercicioTragosTest {
	
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

		PrimerEjercicioTragosHome tragosHome = new PrimerEjercicioTragosHome(driver);
		String nombreTragoHome = tragosHome.obtenerNombreTrago("1"); //Obtain recommended drink by index 1-3
		System.out.println("El nombre del trago en la Pagina Web es: " + nombreTragoHome);
		Response response = RestAssured.given().get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + nombreTragoHome);
		String infoApi = response.getBody().asString();
		infoApi = infoApi.replace("[", "");
		infoApi = infoApi.replace("]", "");
		JSONObject objetoDrinks = new JSONObject(infoApi);
		JSONObject infoTrago = objetoDrinks.getJSONObject("drinks");
		String nombreTragoApi = infoTrago.getString("strDrink");
		System.out.println("El nombre del trago en la API es: " + nombreTragoApi);
		Assert.assertEquals(nombreTragoHome, nombreTragoApi, "Los nombres del trago en la página y en la API no coiniciden");
		
		}

	@AfterMethod
	public void cerrarNavegador() {
		driver.close();	
	}
}
