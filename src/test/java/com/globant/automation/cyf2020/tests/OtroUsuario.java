package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.automation.cyf2020.infrastructure.BasePage;

public class OtroUsuario extends BasePage{

	public OtroUsuario(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath=("//button[@class= 'button profile-board__btn-wrapper-button button--color-black']"))
	 private WebElement sendStar;

	 public sendStar clickStar() {
		 click(sendStar);
		 return getNextPage(sendStar.class);
	}
	 
	

}
