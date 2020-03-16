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

public class EjercicioSel {
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);
	}
	
	public static void main(String[] args) {
		
		openDriver();
		////openDriver();
		google("bands");
		bing("globant");
		googleAndBing("corona");
		
		
		
	}

	public static void google(String what){
		 WebDriver driver = openDriver();
		 driver.get("http://www.google.com/");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		 
		 
		 WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		 //what i want to search + searching it
		searchBox.sendKeys(what + Keys.ENTER);
		WebElement verify = wait.until(ExpectedConditions.elementToBeClickable(By.className("st")));
		
		String ver= verify.getText();
	
		System.out.println("Was this what you were looking for? : " + ver.contains(what));
	
	}
	
				
		
		// enter and search	
	// other ways to do it but not really, the other way is easier
		//driver.findElement(By.name("btnK")).click();
		//.name("btnK")).sendKeys(Keys.ENTER);
		/*driver.findElement(By.name("btnK")).click();
		driver.manage().window().maximize(); driver.findElement(By.className("gNO89b")).sendKeys(Keys.ENTER);*/
		
		
		

	public static void bing(String aWord) {
		 WebDriver driver = openDriver();
		 driver.get("https://www.bing.com/");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		 
		 
		 WebElement bingBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		 //what i want to search + searching it
		bingBox.sendKeys(aWord + Keys.ENTER);
		
WebElement isThisRight = wait.until(ExpectedConditions.elementToBeClickable(By.className("b_attribution")));
		
		String ver= isThisRight.getText();
	
		System.out.println("Was this what you were looking for? : " + ver.contains(aWord));
	
	}
	
	public static void googleAndBing(String insertTerm){
		WebDriver driver = openDriver();
		 	driver.get("https://www.bing.com/");
		
			WebDriverWait wait=new WebDriverWait(driver, 10);
			 
			  WebElement theSearchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
			 //what i want to search + searching it
			theSearchBox.sendKeys(insertTerm + Keys.ENTER);
			
	WebElement searchBing = wait.until(ExpectedConditions.elementToBeClickable(By.className("b_attribution")));
	
	
	WebDriver driverG = openDriver();
	driverG.get("http://www.google.com/");
	
	WebDriverWait waitG=new WebDriverWait(driverG, 10);
	 
	  WebElement theSearchBoxG = waitG.until(ExpectedConditions.elementToBeClickable(By.name("q")));
	 //what i want to search + searching it
	theSearchBoxG.sendKeys(insertTerm + Keys.ENTER);
	WebElement searchGoogle = waitG.until(ExpectedConditions.elementToBeClickable(By.className("st")));
	
	  if (searchBing.equals(searchGoogle)) {
		  System.out.println("Similar results were found!");
		  }
	  else System.out.println("The results found were not similar!");
	  	  
	  }
	
	}
	  
	