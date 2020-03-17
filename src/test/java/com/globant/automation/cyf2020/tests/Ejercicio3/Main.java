package com.globant.automation.cyf2020.tests.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.globant.automation.cyf2020.tests.DeliveryOnline;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {

		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.pedidosya.com/"); //navega a la pagina principal

		PedidosYaPais pedidosYapag = new PedidosYaPais(driver);
		DeliveryOnline pedidos = pedidosYapag.navigateToSearchBurger(); // navega a ofertas semanales
		
	}
	
	
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}


}
