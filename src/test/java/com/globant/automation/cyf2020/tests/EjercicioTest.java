package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mercadoLibre.Barra;
import mercadoLibre.Ofertas;
import mercadoLibre.Producto;
import mercadoLibre.TiendasMontevideo;
import mercadoLibre.TiendasOficiales;

public class EjercicioTest {
	
	Barra barra;
	private WebDriver driver; 
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mercadolibre.com.uy");
		
		barra = new Barra(driver);
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	@Test
	private void ejercicio1() {
		Ofertas ofertas = barra.irOfertasSemana();
		
		String descuento = ofertas.descuento1;
		String precio = ofertas.precio1;
		String nombre = ofertas.nombre1;
		
		
		Producto prod = ofertas.irProducto();
		// 
		
		Assert.assertEquals(nombre, prod.nombre2, "Los nombres no son iguales");
		Assert.assertEquals(precio, prod.precio2, "Los precios no son iguales");
		Assert.assertEquals(descuento, prod.descuento2, "Los descuentos no son iguales");
		
	}
	
	@Test
	private void ejercicio2() {
				
		TiendasOficiales aBuscar = barra.irTiendasOficiales();
		
		aBuscar.buscar("Tiendas Montevideo");
		String tituloEnTiendas = (aBuscar.getTitulo()).getText();
		
		TiendasMontevideo paginaTiendasMontevideo = aBuscar.irTiendaMontevideo();
		
		Assert.assertEquals(paginaTiendasMontevideo.tituloPagina, tituloEnTiendas, "No es el mismo producto");
	}
	
	
	/*@BeforeClass
	public void beforeClasss() {
		System.out.println("ANTES DE TODOS");
	}
	
	@BeforeClass
	public void segundoBeforeClass() {
		System.out.println("OTRO BEFORECLASS");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mercadolibre.com.uy");
		
		barra = new Barra(driver);
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	@Test
	public void ejercicio1() {
		System.out.println("ESTOY EN test1");
		
		Assert.assertEquals("pedro", "pedro", "los nombres no fueron iguales");
		boolean variableFalse = false;
		Assert.assertTrue(variableFalse, "la variable no fue true");
		
		System.out.println("CODIGO EXTRA");
	}
	
	@Test
	public void ejercicio2() {
		System.out.println("estoy en test2");
	}
	*/
}
