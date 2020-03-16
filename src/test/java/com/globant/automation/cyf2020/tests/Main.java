package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
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
		
		Producto products = OfertasSemanales.navigateProducto();
		
		//Producto  Producto = new Producto(driver);
		
		
        
		
	}
	
	

	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}

}
