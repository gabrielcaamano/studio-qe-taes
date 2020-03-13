package com.globant.automation.cyf2020.tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejercicio2 {

	private WebDriver driver;

	public Ejercicio2(WebDriver driver) {
		this.driver = driver;
	}

	public String BusquedaPorTecladoBing() {

		System.out.println("Type a Search Term to Bing: ");
		Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
		String searchTerm = entradaEscaner.nextLine(); // Invocamos un método sobre un objeto Scanner
		System.out.println("Search Term to Bing: \"" + searchTerm + "\"");
		return GoIndexSearchTerm(searchTerm);

	}

	public String GoIndexSearchTerm(String term) {

		driver.get("http://www.bing.com");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement searchBar = wait.until((ExpectedConditions.elementToBeClickable(By.id("sb_form_q"))));
		searchBar.sendKeys(term);
		searchBar.sendKeys(Keys.ENTER);
		// WebElement searchBtn =
		// wait.until((ExpectedConditions.elementToBeClickable(By.id("sb_form_go"))));
		// searchBtn.click();
		return SaveFirstResult(wait, term);
		

	}

	private static By ById(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String SaveFirstResult(WebDriverWait wait, String term) {

		WebElement firstResult = wait
				.until((ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"b_algo\"]//a[1]"))));
		String firstResultString = firstResult.getText();
		System.out.println("This is the first search's result: " + firstResultString);
		if (firstResultString.contains(term)) {
			System.out.println("Successfull search");
			String resultBing = firstResultString;
			return resultBing;
		} else {
			System.out.println("Unsuccesfull search");
			return null;
		}

	}

}
