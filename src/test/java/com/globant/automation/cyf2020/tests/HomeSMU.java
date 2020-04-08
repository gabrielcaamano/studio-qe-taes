package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.globant.automation.cyf2020.infrastructure.BasePage;

public class HomeSMU extends BasePage{

	public HomeSMU(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath=("//h3[@class='user-info__name'] "))
	private WebElement nameAndSurname;
	
	@FindBy(xpath= ("(//p[@class='user-info__job'])"))
	private WebElement work;
	
	@FindBy (xpath= ("//div[@class='ui-components suite-search-box']//input"))
	private WebElement searchBar;
	
	@FindBy (xpath= ("//div[@class='avatar-media__body']//h4 "))
	private WebElement userSearched;
	    
	@FindBy (xpath= ("//div[@class='suite-user_menu']//button"))
	private WebElement userIcon;
	
	@FindBy (xpath= ("//div[@class='suite-user_menu__popup-buttons']//button[2]"))
	private WebElement logOut;
	
	@FindBy (xpath= ("//div[@class='search-result-item__content']//div"))
	private WebElement selectUser;
	

	public String nombreApellido() {
		return getText(nameAndSurname);
	}
	public String infoTrabajo() {
		return getText(work);
	}
	public LoginPageSMU saliendo() {
		click(userIcon);
		click(logOut);
		return getNextPage(LoginPageSMU.class);
	}
	
	public String OtroUsuario (String user) {
		type(searchBar,user);
		click(searchBar);
	    return user;
	}
	
	public OtroUsuario navigateToOtroUsuario() {
		click(selectUser);
		return getNextPage(OtroUsuario.class);
	}
	
	
	
	
	
	
	
	
}
