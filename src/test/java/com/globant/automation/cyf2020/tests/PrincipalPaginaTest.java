	package com.globant.automation.cyf2020.tests;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.globant.automation.cyf2020.infrastructure.BasePage;

	
	public class PrincipalPaginaTest extends BasePage{

	@FindBy(xpath = "//div[@class = \"nav-menu\"]//ul[@class = \"nav-menu-list\"]//li[05]//a")
	private WebElement ofertaSemanalButn;

	@FindBy(xpath = "//a[@class = \"nav-logo\"]")
	private WebElement logoMercado;
	
	
	public PrincipalPaginaTest(WebDriver driver) {
		super(driver);
		}
	
	
	
	@Test
	public OfertasSemanalesTest navigateToWeeklyOffers() {
		click(ofertaSemanalButn);
		return getNextPage(OfertasSemanalesTest.class);
	}

	
	
	

	
} 

