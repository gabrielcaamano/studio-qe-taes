package com.globant.automation.cyf2020.PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class CarritoPage extends BasePage {

	public CarritoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy( css= "div[class=price total-price]")
	private WebElement precioFinal;
	
	String precioFinalProd = "";
	
	public void datosCarrito() {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement cart = wait.until((ExpectedConditions.visibilityOfElementLocated(By.id("scrollContainer"))));
		WebElement precioFinal = getElement(By.cssSelector("div[class=price total-price]"), EXTENDED_TIMEOUT);
		precioFinalProd = getText(precioFinal, MOREEXTENDED_TIMEOUT);
		System.out.println("El precio final es: " + precioFinalProd);
	}
	
	public String getPrecioFinalProd() {
		return this.precioFinalProd;
	}
}
