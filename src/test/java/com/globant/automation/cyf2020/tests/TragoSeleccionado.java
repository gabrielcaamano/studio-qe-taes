package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TragoSeleccionado extends BasePage{

	public TragoSeleccionado(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 @FindBy (xpath= "//div[@class='col s6']//h5" )
	 private WebElement ingredientes;
	
	 
	 public String guardarIngredientes() {
		 return getText(ingredientes);
	 }
	 
}
