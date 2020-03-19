package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import mercadoLibre.Barra;
import mercadoLibre.Ofertas;
import mercadoLibre.Producto;
import mercadoLibre.TiendasOficiales;

public class Main{
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);
	}

	public static void main(String[] args) {
		
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		driver.get("http://mercadolibre.com.uy");
		
		Barra barra = new Barra(driver);
		Ofertas ofertas = barra.irOfertasSemana();
		
		String descuento = ofertas.descuento1;
		String precio = ofertas.precio1;
		String nombre = ofertas.nombre1;
		
		
		Producto prod = ofertas.irProducto();
		// 
		
		System.out.println(precio);
		System.out.println(prod.precio2);
		
		System.out.println(descuento);
		System.out.println(prod.descuento2);
		
		if ((precio.equals(prod.precio2)) && (nombre.equals(prod.nombre2)) && (descuento.equals(prod.descuento2))) {
			System.out.println ("Coinciden");
		}else {
			System.out.println ("No coinciden");

		}
		
		Barra inicio= new Barra(driver);
		inicio.irInicio();
		
		Barra tiendasOficiales = new Barra(driver);
		tiendasOficiales.irTiendasOficiales();
		
		TiendasOficiales aBuscar = new TiendasOficiales(driver);
		aBuscar.buscar("Tiendas Montevideo");
		aBuscar.irTiendaMontevideo();
		
		//driver.close();
	}

}
