package com.globant.automation.cyf2020.tests;

import java.time.Duration;

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


	//toma el nombre y el apellido de la pagina, con una espera previa ya que la pagina tarda en cargar
	public String nombreYApellido () {
		
		     wait(Duration.ofSeconds(10));
		     
		     String nameAndLastName = getText(nombreYApellidoDUsuarix);
		     
			 return nameAndLastName;
	
		
		
	}
 
	//toma el trabajo de la pagina
	public String getTheJob() {
		String trabajo = getText(jobOfTheUser);
		return trabajo;
	}
	
	
	
}
