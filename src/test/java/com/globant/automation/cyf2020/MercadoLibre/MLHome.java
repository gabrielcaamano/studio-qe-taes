package com.globant.automation.cyf2020.MercadoLibre;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class MLHome extends BasePage {

	public MLHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//ul[@class=\"nav-menu-list\"]//li[@class=\"nav-menu-item\"][5]//a[@class=\"nav-menu-item-link\"]")
	WebElement ofertaSemanal;

	public void GoOfertaSemanal(WebElement element, Duration timeout) {

		if (isElementDisplayed(element, timeout)) {
			ofertaSemanal.click();
		} else return;
		
	}


	public MLOfertaSemanal1 GoHome(String linkML) {
		// TODO Auto-generated method stub
		driver.get("https://www.mercadolibre.com.uy/");
		ofertaSemanal.click();
		return new MLOfertaSemanal1(driver);
	}

}
