package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;
import com.globant.automation.cyf2020.infrastructure.Trago;

public class PagPincipalEJER1 extends BasePage{


	@FindBy(id="download-button")
	private WebElement recomendarButn;

	@FindBy(xpath = "//div[@class=\"col m4\"][1]//a[@class=\"btn-floating halfway-fab waves-effect waves-light teal\"]")
	private WebElement primerTragoClick;
	 
	public PagPincipalEJER1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public Trago navigateToTrago() {
		click(recomendarButn, 10);
		
		click(primerTragoClick);
		return getNextPage(Trago.class);
	}

	private void click(WebElement recomendarButn2, int i) {
		// TODO Auto-generated method stub
		
	}
	
	
}
