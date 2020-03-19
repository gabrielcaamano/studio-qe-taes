package pedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Sugerencias extends BasePage {

	public Sugerencias(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "(//a[@class = 'peyaCard js-fp-card'])[1]")
	private WebElement sugerencia;
	
	public PrimeraSugerencia clickPrimeraSugerencia() {
		click(sugerencia);
		return getNextPage(PrimeraSugerencia.class);
	}
}
