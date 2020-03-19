package pedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Pedido extends BasePage {

	public Pedido(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//div[@class ='data']//span")
	private WebElement direccion;
	
	@FindBy (xpath = "//li[@class = 'modified  seen']//div[@class = 'price']")
	private WebElement precio;
	
	@FindBy (xpath = "//div[@class= 'peyaCard']//a[@class = 'button full-width']")
	private WebElement continuar;
	
	public String direccionPedido() {
		return getText(direccion).replace("Delivery para ", "");
	}

	public String precioPedido() {
		return getText(precio);
	}
	
	public void clickContinuar() {
		click(continuar);
	}
}
