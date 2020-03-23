package com.globant.automation.cyf2020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class SegundoEjercicioTragos extends BasePage {

	public SegundoEjercicioTragos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "a[class=white-text]")
	WebElement queTrago;
	
	public QueTragoBusqueda queTrago () {
		click(queTrago);
		return new QueTragoBusqueda(driver);
	}

}
