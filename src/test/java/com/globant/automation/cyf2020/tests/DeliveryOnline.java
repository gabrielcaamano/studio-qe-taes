package com.globant.automation.cyf2020.tests;

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
	
	public DeliveryOnline(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
}
