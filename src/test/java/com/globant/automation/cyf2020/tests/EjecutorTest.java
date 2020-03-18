    package com.globant.automation.cyf2020.tests;
    import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

	

		
	public class EjecutorTest {
			
		
		private WebDriver driver;
		
		@Test
		public void navegarAPaginaPrincipal() { 
			WebDriver driver = openDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://www.mercadolibre.com.uy/"); //navega a la pagina principal
		
			PrincipalPaginaTest PrincipalPagina = new PrincipalPaginaTest(driver);
			OfertasSemanalesTest offers = PrincipalPagina.navigateToWeeklyOffers(); // navega a ofertas semanales
		
			
			String getDatoOferta = offers.obtenerDatos();
			ProductoTest products = offers.navigateProducto(); //navega a productos
			
			
			String getDatoProducto = products.obtenerDatos2();
			sonElMismPorducto(getDatoOferta, getDatoProducto); //comparo si son iguales los datos obtenidos
			TiendasOficialesTest tiendasOficial = products.navigateTiendasOff(); //navego a tiendas oficiales
			
	       
			ArticuloTiendasMtvdeoTest articuloTiendasMtvdeo  = tiendasOficial.navigateToTienda("Tiendas Montevideo");//navego hacia el articulo
			
			
			
			String linktiendOFF = articuloTiendasMtvdeo.getHrefTiendOfi();
			verificacionDeLink (linktiendOFF);
			driver.close();     
			
		}
		
		  public void cerrarNavegador() {
		      	
			  driver.close();
;	   	   
	   	   }
		 
		
		public static WebDriver openDriver() {
			DesiredCapabilities caps = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			return driver;
		}

		
		
		  
		  public static void sonElMismPorducto(String liOferta, String producto) {
	      	
			  assertEquals(liOferta ,producto);
;	   	   
	   	   }
          
		  public static void verificacionDeLink (String link) {
				String hrefDeTiendasOff = "https://mercadolibre.com.uy/tiendas-oficiales";
				assertEquals(link, hrefDeTiendasOff);
				 
			 }


	}

