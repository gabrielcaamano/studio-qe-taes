package com.globant.automation.cyf2020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Trago extends BasePage {

	public Trago(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="h5ing")
	WebElement ingredientes;
	
	public String mostrarIngredientes() {
		return getText(ingredientes);
	}
}
