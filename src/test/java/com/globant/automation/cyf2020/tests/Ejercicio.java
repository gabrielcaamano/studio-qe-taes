package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio {
	
	
	
	private static void WebDriverWait(WebDriver driver, int i) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		
	
		
//ejercicio que ejecuta el ejercicio 1 y 2 y compara si el primer resultado es igual en ambos
		sonIguales( ejercicio1(), ejercicio1());
	}
	
	public static String ejercicio1() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	  
	  	 
		 String URL = "https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjZy6rx1Y3oAhVKH7kGHXUTCt4QPAgH";
		    driver.navigate().to(URL);
		    WebDriverWait(driver, 20);
		    WebElement inputBrowser = driver.findElement(By.name("q"));
		    WebElement buttonBrowser = driver.findElement(By.name("btnK"));
		    inputBrowser.sendKeys("Hola Mundo");
		   
		    inputBrowser.sendKeys(Keys.ENTER);
		    
		   
		    
		    String elemento2 = "//div[@class = \"g\"][2]//a";
		     WebElement TxtBoxContent = driver.findElement(By.xpath(elemento2));  
		     String contenido = TxtBoxContent.getAttribute("href");
		    
		     return contenido;

		   
		    
	} 

	public static String ejercicio2() { 
		
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	  
	  	 
		String URL = "https://www.bing.com/";
		    driver.navigate().to(URL);
		    WebDriverWait(driver, 20);
		    WebElement inputBrowser = driver.findElement(By.name("q"));
		    inputBrowser.sendKeys("Hola Mundo");
		   
		    
		    WebElement buttonBrowser = driver.findElement(By.name("q"));
		    
		    buttonBrowser.sendKeys(Keys.ENTER);
		  
		     String elemento2 = "//li[@class = \"b_algo\"]//h2[1]//a[1]";
		     WebElement TxtBoxContent = driver.findElement(By.xpath(elemento2));  
		     String contenido = TxtBoxContent.getAttribute("href");
		    
		     return contenido;
		     
		     
		    
		    
		  
		
		
	}
	
	public static void sonIguales(String ejercicio1, String ejercicio2) { 
		
		System.out.println("el resultado de los dos navegadores es igual?: " + ejercicio1.equals(ejercicio2));
		
		
		
		
	}
	
	 
}


