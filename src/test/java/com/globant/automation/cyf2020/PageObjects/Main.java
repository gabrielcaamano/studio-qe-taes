package com.globant.automation.cyf2020.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = openDriver();
		driver.manage().window().maximize();

		Ejercicio ejercicio1 = new Ejercicio(driver);
		String resultGoogle = ejercicio1.busquedaPorTecladoChrome();
		
		driver.close();
		
		WebDriver driver2 = openDriver();
		driver2.manage().window().maximize();

		Ejercicio2 ejercicio2 = new Ejercicio2(driver2);
		String resultBing = ejercicio2.BusquedaPorTecladoBing();

		driver2.close();

		if (resultGoogle.equals(resultBing)) {
			System.out.println("Los resultados de Bing y Google coinciden");
		} else {
			System.out.println("Los resultados de Bing y Google son diferentes");
		}
	}
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);

	}

}