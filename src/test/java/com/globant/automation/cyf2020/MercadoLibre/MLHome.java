package com.globant.automation.cyf2020.MercadoLibre;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class MLHome extends BasePage {

	public MLHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//ul[@class=\"nav-menu-list\"]//li[@class=\"nav-menu-item\"][5]//a[@class=\"nav-menu-item-link\"]")
	WebElement ofertaSemanalLink;

	public MLOfertaSemanal1 GoOfertasSemanales() {
		// TODO Auto-generated method stub
		driver.get("https://www.mercadolibre.com.uy/");
		ofertaSemanalLink.click();
		return  new MLOfertaSemanal1(driver);
	}

}
