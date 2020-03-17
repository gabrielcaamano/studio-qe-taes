package com.globant.automation.cyf2020.PageObjects;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejercicio {

	private WebDriver driver;

	public Ejercicio(WebDriver driver) {
		this.driver = driver;
	}

	public String busquedaPorTecladoChrome() {

		System.out.println("Type a Search Term to Google: ");
		Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
		String searchTerm = entradaEscaner.nextLine(); // Invocamos un método sobre un objeto Scanner
		System.out.println("Search Term to Google: \"" + searchTerm + "\"");
		return GoIndexSearchTerm(searchTerm);

	}

	public String GoIndexSearchTerm(String term) {

		driver.get("http://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement searchBar = wait.until((ExpectedConditions.elementToBeClickable(By.name("q"))));
		searchBar.sendKeys(term);
		WebElement searchBtn = wait.until((ExpectedConditions.elementToBeClickable(By.name("btnK"))));
		searchBtn.click();
		String resultGoogle = SaveFirstResult(wait, term);
		return resultGoogle;
		
	}

	public String SaveFirstResult(WebDriverWait wait, String term) {

		WebElement firstResult = wait
				.until((ExpectedConditions.elementToBeClickable(By.cssSelector("h3.LC20lb.DKV0Md"))));
		String firstResultString = firstResult.getText().toLowerCase();

		System.out.println("This is the first search's result: " + firstResultString);
		if (firstResultString.contains(term.toLowerCase())) {
			System.out.println("Successfull search");
			return firstResultString;
		} else {
			System.out.println("Unsuccesfull search");
			return null;
		}

	}
}
