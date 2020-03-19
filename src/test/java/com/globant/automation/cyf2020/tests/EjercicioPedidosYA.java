package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pedidosYa.ConfirmacionUbicacion;
import pedidosYa.HomePage;
import pedidosYa.Pedido;
import pedidosYa.PedidosYaUru;
import pedidosYa.PrimeraSugerencia;
import pedidosYa.Sugerencias;

public class EjercicioPedidosYA {
	HomePage paginaInicio;
	private WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pedidosya.com");
		
		paginaInicio = new HomePage(driver);
	}
	
	/*@AfterMethod
	public void closeDriver() {
		driver.close();
	}*/
	
	@Test
	public void ejercicio() {
		PedidosYaUru homePageUruguay = paginaInicio.irPaginaUruguay();
		String direccionAEscribir = "Andes 1234";
		homePageUruguay.escribirDireccion(direccionAEscribir);
		homePageUruguay.escribirComida("Pasta");
		ConfirmacionUbicacion confUbicacion = homePageUruguay.clickBuscar();
		Sugerencias priSugerencia = confUbicacion.clickConfirmoUbicacion();
		PrimeraSugerencia agragarAlPedido = priSugerencia.clickPrimeraSugerencia();
		String precio = agragarAlPedido.precioSugerencia();
		 agragarAlPedido.clickAgregarAPedido();
		Pedido elPedido = agragarAlPedido.clickAgregarAPedido();
		
		System.out.println(elPedido.direccionPedido());
		Assert.assertEquals(direccionAEscribir, elPedido.direccionPedido(), "Las direcciones no coinciden");
		Assert.assertEquals(precio, elPedido.precioPedido(), "Los precios no coinciden");
		
		elPedido.clickContinuar();
		
	}
	
}
