package ejerciciosRestAssured;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class QueTragoPage extends BasePage {

	public QueTragoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "input[class='mdc-text-field__input white-text']")
	private WebElement ingresarIngrediente;
	
	@FindBy(css = "button[class = 'btn waves-effect waves-light']")
	private WebElement buscar;
	
	@FindBy (xpath = "(//a[@class = 'btn-floating halfway-fab waves-effect waves-light teal'])[2]")
	private WebElement trago;
	
	public void ingresarIngrediente (String ingrediente) {
		ingresarIngrediente.sendKeys(ingrediente);
	}

	public void clickBuscar() {
		click(buscar);
	}
	
	public TragoPage irTrago() {
		click(trago);
		return getNextPage(TragoPage.class);
	}
	
}
