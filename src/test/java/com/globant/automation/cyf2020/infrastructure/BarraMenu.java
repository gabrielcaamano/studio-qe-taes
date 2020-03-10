package com.globant.automation.cyf2020.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BarraMenu extends BasePage {

	@FindBy(xpath="//div[@class = \"nav-menu\"]//ul[@class = \"nav-menu-list\"]//li[05]//a")
	private WebElement oferSemanalBtn;
	
	
	
	public BarraMenu(WebDriver driver) {
		super(driver);
		driver.get("");
	}
	
	

}
