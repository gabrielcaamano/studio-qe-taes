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
		
		DeliveryOnline devileryPag = new DeliveryOnline(driver);
		AgrandarPedido agendarPag = devileryPag.navigateToSearchpedido();
		
		AgrandarPedido agrandarPedido = new AgrandarPedido(driver);
		AceptarSugerencia sugerenciaAccep = agrandarPedido.aceptarSgerencia();
		
		AceptarSugerencia establecerPedido = new AceptarSugerencia(driver);
		MiPedido obtenerValoresYaceptar = establecerPedido.elPedido();
		
	}
	
	
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}


}
