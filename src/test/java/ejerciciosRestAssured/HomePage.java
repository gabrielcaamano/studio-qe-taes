package ejerciciosRestAssured;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (css = "a[class='btn-large waves-effect waves-light teal lighten-1']")
	private WebElement recomendar;
	
	@FindBy(css = "a[class = 'btn-floating halfway-fab waves-effect waves-light teal']")
	private WebElement primerTrago;

	@FindBy(xpath = "(//span[@class = 'card-title'])[3]")
	private WebElement tercerTragoName;
	
	@FindBy(css = "a[class='white-text']")
	private WebElement queTrago;
	
	
	public void clickRecomendar() {
		click(recomendar);
	}
	
	public TragoPage clickPrimerTrago() {
		click(primerTrago);
		return getNextPage(TragoPage.class);
	}

	public QueTragoPage clickQueTrago() {
		click(queTrago);
		return getNextPage(QueTragoPage.class);
	}
	
	public String tercerTragoName() {
		return getText(tercerTragoName);
	}
	
}
