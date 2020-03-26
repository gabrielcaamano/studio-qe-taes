package com.globant.automation.cyf2020.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.globant.automation.cyf2020.QueTragoBusqueda;
import com.globant.automation.cyf2020.SegundoEjercicioTragos;
import com.globant.automation.cyf2020.Trago;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SegundoEjerciciosTragosTest {

	private WebDriver driver;

	@BeforeMethod
	public void abrirNavegador() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cyf-2020.firebaseapp.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testTragosSegundo() {

		// Busca en la app web tragos con "ingrediente" y trae los ingredientes del
		// segundo de la lista
		String ingrediente = "Vodka";
		SegundoEjercicioTragos miPreviaHome = new SegundoEjercicioTragos(driver);
		QueTragoBusqueda busquedaIngrediente = miPreviaHome.queTrago();
		Trago tragoBuscado = busquedaIngrediente.buscarIngrediente(ingrediente);
		String ingredientesWeb = tragoBuscado.mostrarIngredientes();
		System.out.println(ingredientesWeb);

		// Busca en la api los tragos con "ingrediente" y devuelve el nombre del segundo
		// de la lista, (esta direccion no tiene los ingredientes)
		Response response = RestAssured.given()
				.get("https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + ingrediente);
		String infoApi = response.getBody().asString();
		JSONObject objetoDrinks = new JSONObject(infoApi);
		JSONArray infoTragosIngrediente = objetoDrinks.getJSONArray("drinks");
		JSONObject segundoTrago = infoTragosIngrediente.getJSONObject(1);
		String nombreTragoIngrediente = segundoTrago.getString("strDrink");

		// Busca en la api que tiene los ingredientes, el trago con el nombre
		// "nombreTragoIngrediente" y devuelve los ingredientes
		Response responseIngredientes = RestAssured.given()
				.get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + nombreTragoIngrediente);
		String infoApiIngredientes = responseIngredientes.getBody().asString();
		infoApiIngredientes = infoApiIngredientes.replace("[", "");
		infoApi = infoApiIngredientes.replace("]", "");
		JSONObject objetoDrinksIngredientes = new JSONObject(infoApi);
		JSONObject infoTragoIngredientes = objetoDrinksIngredientes.getJSONObject("drinks");
		String ingrTragoApi = "";
		String ingredientesTragoApi = "";
		boolean comparacionExitosa = false;
		int i = 1;
		boolean ingredientesCoinciden = true;

		while ( !(ingrTragoApi.equals("null")) && ingredientesCoinciden && (i <= 15) ) {
			ingrTragoApi = infoTragoIngredientes.get("strIngredient" + i).toString();
			if ( !ingrTragoApi.equals("null") ) {
				ingredientesCoinciden = ingredientesWeb.contains(ingrTragoApi.toString());
				System.out.println(ingrTragoApi.toString() + "prueba");
				if ( ingredientesCoinciden ) {
					ingredientesTragoApi = ingredientesTragoApi + ingrTragoApi.toString() + " ";
				}
			} else {
				comparacionExitosa = true;
			}
			i++;
		}

		System.out.println(ingredientesTragoApi);

		// Compara las dos busquedas
		System.out.println("Los ingredientes de la Web y de la API coinciden: " + comparacionExitosa);
		Assert.assertTrue(comparacionExitosa,
				"Los ingredientes del segundo trago en la lista de tragos con el ingrediente " + ingrediente
						+ ", no coinciden en la API con la Web");

	}

	@AfterMethod
	public void cerrarNavegador() {
		driver.close();
	}
}
