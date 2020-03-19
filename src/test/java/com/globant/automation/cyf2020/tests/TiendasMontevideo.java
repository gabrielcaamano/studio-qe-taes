package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TiendasMontevideo extends BasePage{

	public TiendasMontevideo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "(//h1[@class='breadcrumb__title'])")
	private WebElement nombreTM;
	
	@FindBy(xpath="//div[@class='andes-card andes-card--animated'][4]")
	private WebElement clickTienda;
	
	public String Tienda() {
		return nombreTM.getText();
	}
	
	public TiendasMontevideo navigateToTiendasMontevideo() {
	       click(clickTienda);
	   	   return getNextPage(TiendasMontevideo.class);
		
    }
}
