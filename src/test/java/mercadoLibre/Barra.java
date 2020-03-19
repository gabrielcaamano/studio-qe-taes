package mercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class Barra extends BasePage{
	
	public Barra(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//li[@class ='nav-menu-item']//a)[5]")
	private WebElement ofertas;
	
	@FindBy(xpath = "//a[@class='nav-logo']")
	private WebElement logo;
	
	@FindBy(xpath = "(//a[@class='nav-menu-item-link'])[2]")
	private WebElement tiendasOficiales;
	
	public void setOfertas(WebElement ofertas) {
		this.ofertas = ofertas;
	}
	public WebElement getOfertas() {
		return this.ofertas;
	}
	
	public void setLogo(WebElement logo) {
		this.logo = logo;
	}
	public WebElement getLogo() {
		return this.logo;
	}
	
	public void setTiendasOficiales(WebElement tiendasOficiales) {
		this.tiendasOficiales = tiendasOficiales;
	}
	public WebElement getTiendasOficiales() {
		return this.tiendasOficiales;
	}
	
	
	public Ofertas irOfertasSemana() {
		click (getOfertas());
		return getNextPage(Ofertas.class); 
	}
	
	public void irInicio() {
		click(getLogo());
	}
	
	public TiendasOficiales irTiendasOficiales() {
		click(getTiendasOficiales());
		return getNextPage(TiendasOficiales.class);

	}
	
}
