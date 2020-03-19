package com.globant.automation.cyf2020.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class ElegirSugerencia extends BasePage {

	public ElegirSugerencia(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@data-id=\"27865\"]")
	private WebElement sugerenciaComida;
	
	public SugerenciaPage GoSugerenciaComida() {
		click(sugerenciaComida);
		return new SugerenciaPage(driver);
	}
	
}
