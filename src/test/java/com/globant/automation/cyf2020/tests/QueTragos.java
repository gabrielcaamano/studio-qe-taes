package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.automation.cyf2020.infrastructure.BasePage;
public class QueTragos extends BasePage {

	public QueTragos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath= "//div[@class='col s4 offset-s3']//input")
	private WebElement buscador;
	
	@FindBy (xpath= "//div[@class='col s2']//button")
	private WebElement botonBuscar;
	
	@FindBy (xpath= ("(//div[@class='card-image']) [2]//i"))
	private WebElement drink2;
	
	
	
	public String buscaIngredientes (String ingrediente) {
		type(buscador, ingrediente);
		click(botonBuscar);
		return ingrediente;
	}

	  public TragoSeleccionado navigateToTragoSeleccionado() {
		click (drink2);
		return getNextPage(TragoSeleccionado.class);
	}
	  
	
}
	
	
	
	 

