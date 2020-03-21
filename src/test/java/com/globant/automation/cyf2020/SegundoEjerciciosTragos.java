package com.globant.automation.cyf2020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class SegundoEjerciciosTragos extends BasePage {

	public SegundoEjerciciosTragos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "a[class=white-text]")
	WebElement queTrago;
	
	public QueTragoBusqueda ingresarIngrediente(String ingrediente) {
		type(queTrago, ingrediente);
		return new QueTragoBusqueda(driver);
	}

}
