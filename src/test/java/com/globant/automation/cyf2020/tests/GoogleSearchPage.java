package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class GoogleSearchPage extends BasePage {

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
  @FindBy  (how= How.CLASS_NAME, using="st") 
  private WebElement palabraBuscada;
  public String traePalabra() {
  return palabraBuscada.getText();
  }
}
