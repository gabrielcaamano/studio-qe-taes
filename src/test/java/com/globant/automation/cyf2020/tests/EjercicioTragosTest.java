
package com.globant.automation.cyf2020.tests;

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
		String contenidoTrago = response.getBody().asString();
		String sinParentesis = contenidoTrago.replace("[", "");
		sinParentesis = contenidoTrago.replace("]", "");
		System.out.println(sinParentesis);


	}

}
