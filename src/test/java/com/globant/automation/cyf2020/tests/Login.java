package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Login extends BasePage {

	


	@FindBy(id="username")
	private WebElement imputUsuario;
	
	@FindBy(id="password")
	private WebElement imputPassword;
	
	
	@FindBy(xpath = "//button[@class=\"btn btn-login\"]")
	private WebElement nextBTN;
	
	@FindBy(xpath = "//li[@id=\"loginInputBtn\"]//button[@class=\"btn btn-login\"]")
	private WebElement loginBTN;
	 
	
	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	 private void ingresarUser(String nombre) { 
			type(imputUsuario, nombre); //uso de type de base page
			
			
			}
	 
	 private void ingresarPassword (String password) {
		 type(imputPassword, password);
		 
	 }
	
	 public void clickEnNext(WebElement whereToClick) {
		 
		 click(whereToClick);
	 }
	 
	 
	 public ActivityFeedStarOS navigateToActivityFeed(String nombre, String password) {
		    ingresarUser(nombre);
		    clickEnNext(nextBTN);
		    
		    ingresarPassword(password);
		    clickEnNext(loginBTN);
		    
				
			return getNextPage(ActivityFeedStarOS.class);
		}
	 
	 
	
	
}
