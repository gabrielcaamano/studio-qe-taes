package com.globant.automation.cyf2020.PageObjects;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.automation.cyf2020.infrastructure.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleFather extends BasePage {
	
	public GoogleFather(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchBar;
	
	@FindBy(how = How.NAME, using = "btnK")
	private WebElement searchBtn;
	
	
	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);

	}
	public static GoogleSearch busquedaPorTecladoChrome(WebDriver driver) {

		System.out.println("Type any Search Term to Google: ");
		Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
		String searchTerm = entradaEscaner.nextLine(); // Invocamos un método sobre un objeto Scanner
		System.out.println("Search Term to Google: \"" + searchTerm + "\"");
		GoIndexSearchTerm(searchTerm, driver);
		System.out.println("Quiero saber si la barra buscadora de Google es un Page Object Pattern");
		return new GoogleSearch(driver);

	}

	public static void GoIndexSearchTerm(String term, WebDriver driver) {

		driver.get("http://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement searchBar = wait.until((ExpectedConditions.elementToBeClickable(By.name("q"))));
		searchBar.sendKeys(term);
		WebElement searchBtn = wait.until((ExpectedConditions.elementToBeClickable(By.name("btnK"))));
		searchBtn.click();
		
	}

}
