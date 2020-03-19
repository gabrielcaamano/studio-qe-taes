package pedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PedidosYaUru extends BasePage{

	public PedidosYaUru(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "//input[@class = 'primary']")
	private WebElement direccion;
	
	@FindBy (xpath = "//input[@class = 'secondary']")
	private WebElement comida;
		
	@FindBy (xpath = "(//button[@class= 'button'])[2]")
	private WebElement buscar;
	
	public void escribirDireccion(String miDireccion) {
		type(direccion, miDireccion);
	}
	
	public void escribirComida(String comidaQuiero) {
		type(comida, comidaQuiero);
	}
	
	public ConfirmacionUbicacion clickBuscar() {
		click(buscar);
		return getNextPage(ConfirmacionUbicacion.class);
	}
	
}
