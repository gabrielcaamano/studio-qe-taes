package mercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class TiendasOficiales extends BasePage{
	
	public TiendasOficiales(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@class='andes-form-control__field']")
	private WebElement buscador;
	
	@FindBy(xpath = "//a[@class='logo-search']")
	private WebElement tiendasMontevideo;
	
	@FindBy (xpath = "//div[@class = 'logo-name-search']//span")
	private WebElement titulo;
	
	public void setBuscador(WebElement buscador) {
		this.buscador = buscador; 
	}
	public WebElement getBuscador() {
		return this.buscador;
	}
	
	public void setTiendasMontevideo(WebElement tiendasMontevideo) {
		this.tiendasMontevideo = tiendasMontevideo;
	}
	public WebElement getTiendasMontevideo(){
		return this.tiendasMontevideo;
	}
	
	public void setTitulo(WebElement titulo) {
		this.titulo = titulo;
	}
	public WebElement getTitulo() {
		return this.titulo;
	}
	
	
	public void buscar(String toSearch) {
		buscador.sendKeys(toSearch);
	}
	
	public TiendasMontevideo irTiendaMontevideo(){
		click(getTiendasMontevideo());
		return getNextPage(TiendasMontevideo.class);
	}
	
	public String tituloPagina = getText(getTitulo());	

}
