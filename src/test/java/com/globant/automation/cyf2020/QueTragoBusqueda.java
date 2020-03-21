package com.globant.automation.cyf2020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class QueTragoBusqueda extends BasePage {

	public QueTragoBusqueda(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="botonBuscar")
	WebElement buscarBtn;
	
	@FindBy(xpath = "//div[@id=\"card2\"]//i")
	WebElement tragoIcono;
	
	public Trago buscar() {
		click(buscarBtn);
		click(tragoIcono);
		return new Trago(driver);
	}
	
}
