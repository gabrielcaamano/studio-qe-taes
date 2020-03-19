package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TiendasOficiales extends BasePage {

	public TiendasOficiales(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy (xpath= "(//div[@class='logo-name-search']//span)[3]")
	private WebElement nombreTiendasMontevideo;
	
	@FindBy(xpath="//div[@class='andes-card andes-card--animated'][4]")
	private WebElement clickTienda;
	
	
	public String nombreTiendasMontevideo() {
		return getText(nombreTiendasMontevideo);
	}
	public TiendasMontevideo navigateToTiendasMontevideo() {
	       click(clickTienda);
	   	   return getNextPage(TiendasMontevideo.class);
		
 }
}
