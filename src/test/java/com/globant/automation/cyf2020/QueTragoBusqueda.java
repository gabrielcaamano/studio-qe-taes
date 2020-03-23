package com.globant.automation.cyf2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.objenesis.instantiator.annotations.Typology;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class QueTragoBusqueda extends BasePage {

	public QueTragoBusqueda(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="textoIngredientes")
	WebElement buscarBar;
	
	@FindBy(id="botonBuscar")
	WebElement buscarBtn;

	public Trago buscarIngrediente(String ingrediente) {
		type(buscarBar, ingrediente, DEFAULT_TIMEOUT);
		click(buscarBtn, DEFAULT_TIMEOUT);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement tragoIcono = getElement(By.xpath("//div[@id=\"card2\"]//i"), DEFAULT_TIMEOUT);
		click(tragoIcono, DEFAULT_TIMEOUT);
		return new Trago(driver);
	}
	
}
