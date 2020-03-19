package pedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class ConfirmacionUbicacion extends BasePage {

	public ConfirmacionUbicacion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "//a[@class = 'button']")
	private WebElement confirmarUbicacion;
	
	public Sugerencias clickConfirmoUbicacion() {
		click (confirmarUbicacion);
		return getNextPage(Sugerencias.class);
	}
	
}
