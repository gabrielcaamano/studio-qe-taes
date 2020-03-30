package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PaginaPrincipalStarOS extends BasePage {

	
	@FindBy(xpath = "//h3[@class = \"user-info__name\"]")
	private WebElement nombreYApellidoDUsuarix;
	
	
	@FindBy(xpath = "//p[@class=\"user-info__job\"]")
	private WebElement jobOfTheUser;
	
	
	public PaginaPrincipalStarOS(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public String[] nombreYApellidoArray () {
		
		String nameAndLastName = nombreYApellidoDUsuarix.toString();
		String arrayDeIngredientes[] = nameAndLastName.split("\n");
		
		return arrayDeIngredientes;
	}
 
	public String getTheJob() {
		String trabajo = jobOfTheUser.toString();
		return trabajo;
	}
	
	
	
}
