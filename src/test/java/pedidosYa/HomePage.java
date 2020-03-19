package pedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//li[@class = 'flag'])[8]")
	private WebElement elegirPais;
	
	public PedidosYaUru irPaginaUruguay() {
		click (elegirPais);
		return getNextPage(PedidosYaUru.class); 
	}
	
}
