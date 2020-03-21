package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.QueTragoBusqueda;
import com.globant.automation.cyf2020.SegundoEjerciciosTragos;
import com.globant.automation.cyf2020.Trago;
import io.github.bonigarcia.wdm.WebDriverManager;

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
	SegundoEjerciciosTragos tragosHome = new SegundoEjerciciosTragos(driver);
	QueTragoBusqueda busquedaIngrediente = tragosHome.ingresarIngrediente("frutilla");
	Trago tragoBuscado = busquedaIngrediente.buscar();
	tragoBuscado.mostrarIngredientes();
	}
}
