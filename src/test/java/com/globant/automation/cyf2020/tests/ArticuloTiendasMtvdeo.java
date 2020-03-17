package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class ArticuloTiendasMtvdeo extends BasePage {
	
	@FindBy(xpath="//li[@class =\"breadcrumb__path\"][1]//a")
	private WebElement StringVerifiDTiendOfi;
	
    
	public ArticuloTiendasMtvdeo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	
	public String getHrefTiendOfi() {
		String href = StringVerifiDTiendOfi.getAttribute("href");
		
		return href;
	}

	
	
	
}
