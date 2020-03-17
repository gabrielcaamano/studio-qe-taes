package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.PedidosYa.HomePagePedidosYa;
import com.globant.automation.cyf2020.PedidosYa.UruguayPedidosYa;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PedidosYaTest {

	private WebDriver driver;

	@BeforeMethod
	public void abrirNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.pedidosya.com");
		driver.manage().window().maximize();
	}

	@Test
	public void ingresarLocalidad() {
		
		HomePagePedidosYa HomePedidosYa = new HomePagePedidosYa(driver);
		HomePedidosYa.menuPais.click();
		UruguayPedidosYa HomeUruguay = new UruguayPedidosYa();
		entrega(HomeUruguay.inputDireccion, HomeUruguay.inputComida, HomeUruguay.botonBuscar);
	}
	
	public void entrega(WebElement inputDireccion, WebElement inputComida, WebElement botonBuscar) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		sendKeys(inputDireccion, "Paraguay 2141", wait);
		sendKeys(inputComida, "Hamburguesa", wait);
		click(botonBuscar, wait);
	}
	
	protected void sendKeys(WebElement element, String keys, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(keys);
	}
	
	protected void click(WebElement element, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

}