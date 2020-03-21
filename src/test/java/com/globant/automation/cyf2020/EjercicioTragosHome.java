package com.globant.automation.cyf2020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class EjercicioTragosHome extends BasePage{
	
	public EjercicioTragosHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "download-button")
	WebElement recomendarBtn;
	
	@FindBy(id = "tit1")
	WebElement nombrePrimerTrago;
	
	public String obtenerNombre() {
		click(recomendarBtn, EXTENDED_TIMEOUT);
		return getText(nombrePrimerTrago);
	}

}
