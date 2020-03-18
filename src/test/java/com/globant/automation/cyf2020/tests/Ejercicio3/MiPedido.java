package com.globant.automation.cyf2020.tests.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class MiPedido extends BasePage{
	
	@FindBy(xpath = "//div[@id = \"footerOpen\"]//a[@class =\"button\"]")
	private WebElement precio2;
	@FindBy(xpath = "//div[@class = \"price \"]")
	private WebElement precioSugerencia;
	
	@FindBy(xpath = "//section[@class = \"optionItem radios inputs third \"][1]//ul//li[1]//input")
	private WebElement primerCampoYOpcionClick;
	
	public MiPedido(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
}
