package com.globant.automation.cyf2020.tests;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {

		
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mercadolibre.com.uy/"); //navega a la pagina principal

		PrincipalPagina PrincipalPagina = new PrincipalPagina(driver);
		OfertasSemanales offers = PrincipalPagina.navigateToWeeklyOffers(); // navega a ofertas semanales
		
		OfertasSemanales OfertasSemanales = new OfertasSemanales(driver); //creo un objeto de ofertas semanales
		String getDatoOferta = OfertasSemanales.obtenerDatos();
		Producto products = OfertasSemanales.navigateProducto(); //navega a productos
		
		
		Producto  producto = new Producto(driver);
		String getDatoProducto = producto.obtenerDatos2();
		sonElMismPorducto(getDatoOferta, getDatoProducto); //comparo si son iguales los datos obtenidos
		TiendasOficiales tiendasOficial = producto.navigateTiendasOff(); //navego a tiendas oficiales
		
        TiendasOficiales tiendasOficiales = new TiendasOficiales(driver);
		ArticuloTiendasMtvdeo articuloTiendasMtvdeo  = tiendasOficiales.navigateArticulo();//navego hacia el articulo
		
		
		ArticuloTiendasMtvdeo atriculotienda = new ArticuloTiendasMtvdeo(driver);
		String linktiendOFF = atriculotienda.getHrefTiendOfi();
		verificacionDeLink (linktiendOFF);
		driver.close();
	}
	
	

	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	
	
	
	  public static void sonElMismPorducto(String liOferta, String producto) {
      	
   	   
   	   System.out.println("los dos productos son iguales?: " + liOferta.equals(producto));
   	   }

	  public static void verificacionDeLink (String liOferta) {
			String hrefDeTiendasOff = "https://mercadolibre.com.uy/tiendas-oficiales";
			 System.out.println("Estamos en la página de productos oficiales?: " + hrefDeTiendasOff.equals(liOferta));
			 
		 }


}
