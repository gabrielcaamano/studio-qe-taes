package com.globant.automation.cyf2020.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.PedidosYa.ElegirSugerencia;
import com.globant.automation.cyf2020.PedidosYa.HomePagePedidosYa;
import com.globant.automation.cyf2020.PedidosYa.SugerenciaPage;
import com.globant.automation.cyf2020.PedidosYa.UruguayPedidosYa;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PedidosYaTest {

	private WebDriver driver;

	@BeforeClass
	public void abrirNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.pedidosya.com");
		driver.manage().window().maximize();
	}

	@Test
	public void ingresarLocalidad() {
		
		HomePagePedidosYa HomePedidosYa = new HomePagePedidosYa(driver);
		UruguayPedidosYa HomeUruguay = HomePedidosYa.goUruguay();
		ElegirSugerencia elegirSugerenciaPage = HomeUruguay.entrega("Paraguay 2141", "Hamburguesa");
		SugerenciaPage sugerenciaPage = elegirSugerenciaPage.GoSugerenciaComida();
		sugerenciaPage.AgregarPedido();
		String precioSuguerencia = elegirSugerenciaPage.getPrecioInicial();
		String precioFinal = sugerenciaPage.getPrecioFinalProd();
		assertEquals(precioSuguerencia, precioFinal);
	}

}