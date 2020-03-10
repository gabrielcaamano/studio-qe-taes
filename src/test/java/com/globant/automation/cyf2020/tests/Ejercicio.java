package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio {
	
	public static String busquedaGoogle;
	public static String busquedaBing;

	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);
	}
	
	public static void main(String[] args) {
		
//		openDriver();
		ejercicio1("hola");
		ejercicio2();
		
		if(busquedaGoogle == busquedaBing) {
			System.out.println("Los resultados son iguales.");
		}else {
			System.out.println("Los resultados son diferentes.");
		}
		
	}
	
	public static void ejercicio1(String terms) {
		
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement inputBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		inputBuscar.sendKeys(terms);
				
		WebElement btnBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.className("gNO89b")));
		btnBuscar.click();
		
		String xPathVar = "(//div[@class = 'g']//cite)[1]";
		busquedaGoogle = driver.findElement(By.xpath(xPathVar)).getText();
				
		driver.close();
		
	}

	public static void ejercicio2() {
		
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		driver.get("http://bing.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement buscar = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		buscar.sendKeys("hola");
		buscar.sendKeys(Keys.ENTER);
		
		String xPathVar = "(//div[@class='sb_add sb_adTA']//cite)[1]";
		busquedaBing =  driver.findElement(By.xpath(xPathVar)).getText();
			
		driver.close();
		
	}

}
