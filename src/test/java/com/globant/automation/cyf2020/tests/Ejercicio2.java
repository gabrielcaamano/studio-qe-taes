package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Ejercicio2 extends BasePage {

	public Ejercicio2(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath=("//ul[@class='right hide-on-med-and-down']//a" ))
	private WebElement botonQueTragos;
	

	 public QueTragos navigateToQueTragos() {
	       click(botonQueTragos);
	   	   return getNextPage(QueTragos.class);
	 }
	 
	 
	 
}
