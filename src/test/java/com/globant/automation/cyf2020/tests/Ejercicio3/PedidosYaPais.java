package com.globant.automation.cyf2020.tests.Ejercicio3;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import com.globant.automation.cyf2020.tests.DeliveryOnline;


public class PedidosYaPais extends BasePage{ 
	
	public PedidosYaPais(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@id = \"link-uy\"]")
	private WebElement urgayButn;

	public WebElement getUrgayButn() {
		return urgayButn;
	}
	
	public DeliveryOnline navigateToSearchBurger() {
		click(urgayButn);
		return getNextPage(DeliveryOnline.class);
	}
	
}
