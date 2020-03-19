package com.globant.automation.cyf2020.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class UruguayPedidosYa extends BasePage {

	public UruguayPedidosYa(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "address")
	private WebElement inputDireccion;

	
	@FindBy(id = "optional")
	private WebElement inputComida;
	
	@FindBy(id = "search")
	private WebElement botonBuscar;
	
	@FindBy(id = "confirm")
	private	WebElement botonConfirmarDir;

	public ElegirSugerencia entrega(String direccion, String comida) {
		type(inputDireccion, direccion);
		type(inputComida, comida);
		click(botonBuscar);
		click(botonConfirmarDir, EXTENDED_TIMEOUT);;
		return new ElegirSugerencia(driver);
	}
	
}
