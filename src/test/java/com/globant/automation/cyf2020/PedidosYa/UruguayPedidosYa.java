package com.globant.automation.cyf2020.PedidosYa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UruguayPedidosYa {

	@FindBy(xpath = "//input[@id=\"address\"]")
	public WebElement inputDireccion;

	
	@FindBy(xpath = "//input[@id=\"optional\"]")
	public WebElement inputComida;
	
	@FindBy(xpath = "//button[@id=\"search\"]")
	public WebElement botonBuscar;

}
