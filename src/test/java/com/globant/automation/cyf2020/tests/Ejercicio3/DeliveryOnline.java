package com.globant.automation.cyf2020.tests.Ejercicio3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class DeliveryOnline extends BasePage {
	
	@FindBy(xpath = "//input[@id = \"optional\"]")
	private WebElement RestaurantInput;
	@FindBy(xpath = "//input[@id = \"address\"]")
	private WebElement direccionInput;
	@FindBy(xpath = "//button[@id = \"search\"]")
	private WebElement searchButn;
	
	@FindBy(xpath = "//div[@id = \"mapContainer\"]")
	private WebElement ventanaMdl;
	
	@FindBy(xpath = "//a[@id = \"confirm\"]")
	private WebElement btnconfirmUbication;
	
	
	public DeliveryOnline(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void ingresarValores() {
		direccionInput.sendKeys("Av. 18 de Julio 885");
		RestaurantInput.sendKeys("Pizza centro");
		click(searchButn);
		
		if (ventanaMdl.isDisplayed()) {
			
			click(btnconfirmUbication);
			
		}
	}
	
}
