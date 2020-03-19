package com.globant.automation.cyf2020.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class HomePagePedidosYa extends BasePage {
	
	public HomePagePedidosYa(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		driver.get("https://www.pedidosya.com");
	}

	@FindBy(xpath = "//a[@title=\"PedidosYa Uruguay\"]")
	private WebElement menuPais;
	
	public UruguayPedidosYa goUruguay() {
		click(menuPais);
		return getNextPage(UruguayPedidosYa.class);
	}
}
