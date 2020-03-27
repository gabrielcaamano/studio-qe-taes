package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Tragos extends BasePage {

	public Tragos(WebDriver driver) {
		super(driver);
		driver.get("https:cyf-2020.firebaseapp.com/");
	}
	
	@FindBy(xpath=( "//div[@class='row center']//a" ))
	private WebElement botonRecomendarTragos;
	
	@FindBy (xpath= ("(//div[@class='col m4']//span)[1]"))
	 private WebElement primerTrago;

	 @FindBy (xpath=(" //div[@class='card-image']//span") )
	 private WebElement nombrePrimerTrago;

	
	 public void clickBotonRecomendarTragos(){
		 botonRecomendarTragos.click();
	 }
	 
	 public String nombrePrimerTrago() {
		 return getText(primerTrago);
	 }

	

	
	
	 
	 
	 

}
