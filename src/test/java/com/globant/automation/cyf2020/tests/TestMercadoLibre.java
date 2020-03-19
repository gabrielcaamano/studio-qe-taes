package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMercadoLibre {
		private WebDriver driver;
			
		@BeforeSuite
		public void openMercadoLibre() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.get("http://www.mercadolibre.com.uy/");
			
		}
		@Test
		public void testMercado() {
				MercadoLibre homePage =  new MercadoLibre(driver);
				OfertasSemanales ofertasPage = homePage.navigateToOfertasSemanales();
			    String nombreP = ofertasPage.nombreP();
			    String precioP = ofertasPage.precioP();
			    String porcentajeP = ofertasPage.porcentajeDescuento1();
			    Producto product = ofertasPage.navigateToProducto();
			    
			    
			    Assert.assertEquals(nombreP, product.nombreP()," los nombres no son iguales");
			    Assert.assertEquals(precioP, product.precioP(), " precios diferentes");
			    Assert.assertEquals(porcentajeP, product.porcentajeDescuento1(), "descuentos diferentes");	    
		 }
		
		@BeforeSuite
		public void openMercadoLibre1() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.get("http://www.mercadolibre.com.uy/");
		}
		
		@Test
		public void testMercadoLibre() {
		MercadoLibre home= new MercadoLibre(driver);
		driver.navigate().back();
		TiendasOficiales storesPage= home.navigateToTiendasOficiales();
		TiendasMontevideo tienda = storesPage.navigateToTiendasMontevideo();
		String tiendasM = tienda.Tienda();
		Assert.assertTrue(tiendasM.toLowerCase().contains(tiendasM));
		
		
		
		
		
			
		}
		
		
}

