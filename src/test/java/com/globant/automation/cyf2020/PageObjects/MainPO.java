package com.globant.automation.cyf2020.PageObjects;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainPO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = openDriver();
		GoogleHome homeGoogle = new GoogleHome(driver);
		SearchBar homeSearchBar = new SearchBar();
		homeSearchBar.barClass = "gLFyf gsfi";
		homeSearchBar.barLength = "2048";
		homeSearchBar.barTitle = "Buscar";

		homeGoogle.busquedaPorTecladoChrome(driver);
		SearchBar searchSearchBar = new SearchBar();
		searchSearchBar.barClass = "gLFyf gsfi";
		searchSearchBar.barLength = "2048";
		searchSearchBar.barTitle = "Buscar";
		
		Comparacion(homeSearchBar, searchSearchBar);

	}

	public static WebDriver openDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);

	}

	public static boolean Comparacion(SearchBar barra1, SearchBar barra2) {
		if ((barra1.barClass == barra2.barClass) && (barra1.barLength == barra2.barLength)
				&& (barra2.barTitle == barra2.barTitle)) {

			System.out.println(("La barra buscadora es un Page Object"));
			return true;

		} else {

			System.out.println(("La barra buscadora no es un Page Object"));
			return false;

		}
	}

}
