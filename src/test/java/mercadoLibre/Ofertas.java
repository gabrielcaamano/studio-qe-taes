package mercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Ofertas extends BasePage {

	public Ofertas(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "(//li[@class ='results-item highlighted article grid item-info-height-195'])[1]")
	private WebElement producto;
	
	@FindBy(xpath = "(//li[@class ='results-item highlighted article grid item-info-height-195']//span[@class='price__fraction'])[1]") 
	private WebElement precio;
	
	@FindBy(xpath = "(//li[@class ='results-item highlighted article grid item-info-height-195']//span[@class='main-title'])[1]")
	private WebElement nombre;

	@FindBy(xpath = "(//li[@class ='results-item highlighted article grid item-info-height-195']//div[@class='item__discount '])[1]")
	private WebElement descuento;


	public void setProducto(WebElement producto) {
		this.producto = producto; 
	}
	public WebElement getProducto() {
		return this.producto;
	}
		
	public void setPrecio(WebElement precio) {
		this.precio = precio; 
	}
	public WebElement getPrecio() {
		return this.precio;
	}
	
	public void setNombre(WebElement nombre) {
		this.nombre = nombre;
	}
	public WebElement getNombre() {
		return this.nombre;
	}
	
	public void setDescuento(WebElement descuento) {
		this.descuento = descuento;
	}
	public WebElement getDescuento() {
		return this.descuento;
	}
	
	public String precio1 = getText(getPrecio());
	public String nombre1 = getText(getNombre());
	public String descuento1 = getText(getDescuento());
	
	public Producto irProducto() {
		click(getProducto());
		return getNextPage(Producto.class);
	}
}

