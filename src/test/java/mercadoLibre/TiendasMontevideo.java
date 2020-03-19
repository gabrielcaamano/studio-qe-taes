package mercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TiendasMontevideo extends BasePage {

	public TiendasMontevideo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//li[@class = 'breadcrumb__path']//span)[2]")
	private WebElement titulo;
	
	public void setTitulo(WebElement titulo) {
		this.titulo = titulo; 
	}
	public WebElement getTitulo() {
		return this.titulo;
	}
	
	public String tituloPagina = getText(getTitulo());
}
