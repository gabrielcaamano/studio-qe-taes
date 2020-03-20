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
	
	@FindBy(xpath = "//ul[@class=\"content content-products fp_abtestv1\"][1]//li[1]//a[@class=\"peyaCard js-fp-card\"][1]//div[@class=\"content_info\"][1]//footer[@class=\"fp_control without_before\"][1]//span[@class=\"after_price\"]")
	private WebElement precioSugerencia;
	
	String precioInicial = "";
	
	public SugerenciaPage GoSugerenciaComida() {
		precioInicial = getText(precioSugerencia);
		System.out.println("El precio inicial es: " + precioInicial);
		click(sugerenciaComida);
		return new SugerenciaPage(driver);
	}
	
	public String getPrecioInicial() {
		return this.precioInicial;
	}
	
}
