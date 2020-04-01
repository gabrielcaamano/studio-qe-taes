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
	
	@FindBy(xpath = "//input[@class=\"suite-search-box__input\"]")
	private WebElement inputSearchNavbar;
	
	@FindBy(xpath = "//button[@class=\"button button--icon button--nomargin suite-search-box__input-button suite-search-box__input-button--secondary-gray button--color-\"]")
	private WebElement buttonSearchNavbar;

	@FindBy(xpath = "//li[@tabindex=\"0\"]")
	private WebElement usuarioBuscado;
	
	@FindBy(xpath = "//div[@class=\"tab-panel__item\"]")
	private WebElement recentTab;
	
	
	
	@FindBy(xpath = "//button[@class=\"button button--icon button--nopadding button--transparent notifications-button button--color-\"]")
	private WebElement campanaNotificationBtn;
	
	@FindBy(xpath = "//div[@class=\"ui-navbar__menu-item menu-item--featureDiscovery\"]//a")
	private WebElement myProfile;
	
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//span[@class=\"feed-item__avatar-name--cursor\"]")
	private WebElement nombreDelCoworkerAlQueLeEnvieLaEstrella;
	
	@FindBy(xpath = "//div[@class=\"ui-components suite-panel feed-item suite-panel--nopadding\"][1]//strong[@class=\"feed-footer__full-name\"]")
	private WebElement porQuienEsEnviadaLaEstrella;
	
	@FindBy(xpath = "//li[@class=\"notifications-item notifications-item--active\"][1]")
	private WebElement primeraNotificacionDeEstrella;
	
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
	
	
	//busca el usuario/a
	
	public void buscarUsuario(String usuarix) {
		type(inputSearchNavbar, usuarix);
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
	
	
	
	public void clickEnLaCampana() {
		click(campanaNotificationBtn);
	}
	
	public void clickElPerfil() {
		click(myProfile);
	}
	
	public void clickEnPopUp() {
		click(popUpUpInTheNav);
	}
	
	
	
	
	public String capturarNombreYreemitenteActivityFeed() {
		
		String nombreYApellidoObtenido = getText(nombreDelCoworkerAlQueLeEnvieLaEstrella);
		String usuarioQueEnviaElReconocimiento = getText(porQuienEsEnviadaLaEstrella);
		return usuarioQueEnviaElReconocimiento + " envia a " + nombreYApellidoObtenido;
		
	}
	
	
	public boolean verificarSiLaNotificacionEstaReadTrueONoFalse() {
		
		String youNotienesNotificaciones = getText(youDontHaveNotifications);
		if(youNotienesNotificaciones == "You don't have notifications") {
			return true;
		}  
		
		return false;
		
	}
	
	public void darClickEnLaNotificacion() {
		 click(primeraNotificacionDeEstrella);
		
	}
	
	
	
	 public PerfilDeCoworker navigateToPerfilDeCoworker(String usuarix) {
		    
		    buscarUsuario(usuarix);
		    click(usuarioBuscado);
		    		
			return getNextPage(PerfilDeCoworker.class);
		}
	 
	 
	
	 
	 public PerfilDeUser navigateToPerfilDeUser() {
		    	 clickElPerfil();
		  			
			return getNextPage(PerfilDeUser.class);
			}
	 
	 
	 
	 
	 
	 
	 
	
	
	
}
