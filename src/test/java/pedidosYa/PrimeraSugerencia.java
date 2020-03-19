package pedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PrimeraSugerencia extends BasePage {

	public PrimeraSugerencia(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "//div[@class = 'tcontent']//span")
	private WebElement precio;
	
	@FindBy (xpath = "//div[@class = 'tcontent']//a")
	private WebElement agregar;
	
	public String precioSugerencia() {
		return getText(precio);
	}
	
	public Pedido clickAgregarAPedido() {
		click(agregar);
		return getNextPage(Pedido.class);
	}
}
