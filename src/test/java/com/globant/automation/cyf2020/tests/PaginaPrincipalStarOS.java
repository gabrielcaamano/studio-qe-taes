package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PaginaPrincipalStarOS extends BasePage {

	
	@FindBy(xpath = "//h3[@class = \"user-info__name\"]")
	private WebElement nombreYApellidoDUsuarix;
	
	@FindBy(xpath = "//p[@class=\"user-info__job\"]")
	private WebElement jobOfTheUser;
	
	@FindBy(xpath = "//div[@class=\"profile-stats\"]//div[@class=\"ui-components suite-segment profile-stats__container\"][1]//div[@class=\"stat__content\"]")
	private WebElement starRecibed;
	
	@FindBy(xpath = "//div[@class=\"profile-stats\"]//div[@class=\"ui-components suite-segment profile-stats__container\"][2]//div[@class=\"stat__content\"]")
	private WebElement starSent;
	
	@FindBy(xpath = "//div[@class=\"profile-stats\"]//div[@class=\"ui-components suite-segment profile-stats__container\"][3]//div[@class=\"stat__content\"]")
	private WebElement starParaEnviar;
	
	
	@FindBy(xpath = "//div[@class=\"tab-panel__item\"]") 
	private WebElement recentTabInactive;
	
	@FindBy(xpath = "//div[@class=\"tab-panel__item tab-panel__item--active\"]") 
	private WebElement recentTabActive;
	
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//span[@class=\"feed-item__avatar-name--cursor\"]")
	private WebElement nombreDelCoworkerAlQueLeEnvieLaEstrella;
	
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//strong[@class=\"feed-footer__full-name\"]")
	private WebElement porQuienEsEnviadaLaEstrella;

	
	@FindBy(xpath = "//p[@class=\"notifications-list__info\"]//span")
	private WebElement youDontHaveNotifications;
	
	@FindBy(xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")
	private WebElement popUpUpInTheNav;
	
	
	public PaginaPrincipalStarOS(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	//toma el nombre y el apellido de la pagina, con una espera previa ya que la pagina tarda en cargar
	public String nombreYApellido () {
		
		     wait(Duration.ofSeconds(10));
		     
		     String nameAndLastName = getText(nombreYApellidoDUsuarix);
		     
			 return nameAndLastName;
	}
 
	
	
	
	//toma el trabajo de la pagina
	public String getTheJob() {
		String trabajo = getText(jobOfTheUser);
		return trabajo;
	}
	
	
	
	
	public int getStarRecibed() {
		String estrellasRecibidas = getText(starRecibed);
		int numStarGive = Integer.parseInt(estrellasRecibidas);
		return numStarGive;
	}
	
	public int getStarSent() {
		String estrellasEnviadas = getText(starSent);
		int numStarSent = Integer.parseInt(estrellasEnviadas);
		return numStarSent;
	}
	
	
	
	
	
	
	public void clickEnPopUp() {
		
		click(popUpUpInTheNav);
		
	}
	
	public void reLoadTheActivity() {
		click(recentTabActive);	
		}
	
	
	
	
	
	
	public String capturarNombreYreemitenteActivityFeed() {
		
		String nombreYApellidoObtenido = getText(nombreDelCoworkerAlQueLeEnvieLaEstrella);
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento + " envia a " + nombreYApellidoObtenido;
		
	}
	
	public String nombreDelReemitenteActivityFeed() {
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento;
		
	}
	
	
	public boolean verificarSiLaNotificacionEstaReadTrueONoFalse() {
		
		String youNotienesNotificaciones = getText(youDontHaveNotifications);
		
		if(youNotienesNotificaciones.equals("You don't have notifications")) {
			System.out.println(youNotienesNotificaciones);
			return true;
		}  
		
		return false;
		
	}
	
	
	
	
	
	
	 
	 
	 public NavBar navigateToNavBar() {
    	 
  			
	return getNextPage(NavBar.class);
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
}
