package ejerciciosRestAssured;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TragoPage extends BasePage{

	public TragoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "i[class='mdi-content-send white-text']")
	private WebElement nombre;
	
	@FindBy (xpath = "(//h5[@class = 'white-text'])[1]")
	private WebElement ingrdientes;
	
	public String nombre() {
		return getText(nombre);
	}
	
	public String getIngrdientes() {
		return getText(ingrdientes);
	}
}
