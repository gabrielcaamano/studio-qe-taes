package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {

		
		WebDriver driver = openDriver();
		driver.manage().window().maximize();
		
		PrincipalPagina PrincipalPagina = new PrincipalPagina(driver);
		
		//driver.close();
        
	}
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}

}
