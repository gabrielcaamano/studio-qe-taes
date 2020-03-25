package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PagPincipalEJER1 extends BasePage{


	@FindBy(id="download-button")
	private WebElement recomendarButn;

	@FindBy(xpath = "//div[@class=\"col m4\"][1]//a[@class=\"btn-floating halfway-fab waves-effect waves-light teal\"]")
	private WebElement primerTragoClick;
	
	@FindBy(xpath = "//div[@class=\"col m4\"][3]//a[@class=\"btn-floating halfway-fab waves-effect waves-light teal\"]")
	private WebElement tercerTragoClick;
	
	
	@FindBy(xpath = "//A[@class=\"white-text\"]")
	private WebElement queTragoButn;
	 
	public PagPincipalEJER1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public Trago navigateToPrimerTrago() {
		click(recomendarButn, 10);
		
		click(primerTragoClick);
		return getNextPage(Trago.class);
	}
	
	public Trago navigateToTercerTrago() {
		click(recomendarButn, 10);
		
		click(tercerTragoClick);
		return getNextPage(Trago.class);
	}
	
	
	
	public Ingredientes navigateToIngredientes() {
		
		
		click(queTragoButn);
		return getNextPage(Ingredientes.class);
	}
	
	

	

	private void click(WebElement recomendarButn2, int i) {
		// TODO Auto-generated method stub
		
	}
	
	
}
