package com.globant.automation.cyf2020.tests.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {

		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.pedidosya.com/"); //navega a la pagina principal

		PedidosYaPais pedidosYapag = new PedidosYaPais(driver);
		DeliveryOnline pedidos = pedidosYapag.navigateToSearchBurger(); // navega a ofertas semanales
		
		//DeliveryOnline devileryPag = new DeliveryOnline(driver); borrar codigo, y re usar
		AgrandarPedido agendarPag = pedidos.navigateToSearchpedido("Av. 18 de Julio 885", "Facal");
		String getDireccion1 = "Delivery para " + pedidos.getTheDireccionText();
	    AceptarSugerencia sugerenciaAccep = agendarPag.aceptarSgerencia();
	    String getPrecio1 = sugerenciaAccep.capturaPrecio();
		
		
	    MiPedido obtenerValoresYaceptar = sugerenciaAccep. goToElPedido();
		String getDireccion2 = obtenerValoresYaceptar.capturaDireccion();
		String getPrecio2 = obtenerValoresYaceptar.capturaPrecio2();
		
		tienenElMismoPrecio(getPrecio1, getPrecio2); //verificar si tienen el mismo precio
		tienenLaMismaDireccion(getDireccion1, getDireccion2);
		System.out.println("la ventana modal ha salido?: " + obtenerValoresYaceptar.darClickYVerificarModal());
		
		driver.close();
		
	}
	
	
	
	public static void tienenElMismoPrecio(String precio1, String precio2) {
      	
	   	   
	   	   System.out.println("los dos productos tienen el mismo precio?: " + precio1.equals(precio2));
	   	   }
	
	public static void tienenLaMismaDireccion(String direccion1, String direccio2) {
      	
	   	   
	   	   System.out.println("El producto tiene la direccion correcta?: " + direccion1.equals(direccio2));
	   	   }
	
	
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}


}
