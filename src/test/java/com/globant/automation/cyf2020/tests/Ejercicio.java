package com.globant.automation.cyf2020.tests;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio {
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//openDriver();
	//	System.out.println(ejercicio1("movie"));
		//ejercicio2("movie");
		ejercicio3("movie");
	}
	public static boolean ejercicio1(String buscar) throws InterruptedException {
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement inputBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		//WebElement element = driver.findElement(By.name("q"));
		inputBuscar.sendKeys(buscar);
		
	    WebElement buttonBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.className("gNO89b")));
	    
	    buttonBuscar.click();
	    
	    //Thread.sleep(4000);
	    
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("st")));
	    
	    String resultado = element.getText();
	    
	    System.out.println(resultado);
	    
	    driver.close();
	    
	    if(resultado.contains("MOVIE")) {
	    	return true;
	    } else {
	    	return false;
	    }
	    
	}
	
	public static void ejercicio2(String search) {
		WebDriver driver = openDriver();
		driver.manage().window().maximize();	
		driver.get("http://bing.com");
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement inputBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		inputBuscar.sendKeys(search);
		inputBuscar.sendKeys(Keys.ENTER);
		
	}
	//cambio
	public static void ejercicio3(String buscar) {
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		WebElement inputBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		inputBuscar.sendKeys(buscar);
		inputBuscar.sendKeys(Keys.ENTER);
		
		
		WebDriver driver2 = openDriver();
		driver2.manage().window().maximize();
		driver2.get("http://bing.com");
		WebDriverWait wait1 = new WebDriverWait(driver2, 10);	
		WebElement inputBuscar1 = wait1.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		inputBuscar1.sendKeys(buscar);
		inputBuscar1.sendKeys(Keys.ENTER); 
		
		if (inputBuscar.equals(inputBuscar1)) {
			System.out.println("son iguales");
		} else {
			System.out.println("error");
		}
	}
	
	////
	
	
	
	
}
	

