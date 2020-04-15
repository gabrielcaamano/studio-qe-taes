package com.globant.automation.cyf2020.tests;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;


public class ProfileOfCoworker extends BasePage{

	

	@FindBy(xpath = "//button[contains(@class, 'profile-board__btn-wrapper-button')]")
	private WebElement sendStarBTN;
	
	@FindBy(xpath = "//button[@class=\"button button--nomargin-right button--transparent button--color-\"]")
	private WebElement sendStarBtnComfirm;
	
	@FindBy(xpath = "//div[@class=\"value-icon\"]")
	private WebElement integrityBTN;
	
	@FindBy(xpath = "//div[@class=\"value-icon\"][2]")
	private WebElement excellenceBTN;
	
	@FindBy(xpath = "//div[@class=\"value-icon\"][3]")
	private WebElement teamworkBTN;
	
	@FindBy(xpath = "//div[@class=\"value-icon\"][4]")
	private WebElement innovationBTN;
	
	@FindBy(xpath = "//div[@class=\"value-icon\"][5]")
	private WebElement learningBTN;
	
	@FindBy(xpath = "//div[@class=\"value-icon\"][6]")
	private WebElement thinkBigBTN;
	
	@FindBy(xpath = "//div[@class=\"notranslate public-DraftEditor-content\"]")
	private WebElement whyMessageInput;
	
	@FindBy(xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")
	private WebElement popUspDeArriba;
	
	@FindBy(xpath = "//i[@class=\"close large icon confirmation__close\"]")
	private WebElement cerrarConfirmacionDeEnvioDeEstrella;	
	
	@FindBy(xpath = "//div[@class=\"ui-navbar__logo-container\"]//a")
	private WebElement volverAlaPaginaDeInicio;
	
	
	
	
	public ProfileOfCoworker(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public WebElement valorAEnviar(ChooseARecognition opcion) {

		switch (opcion) {
		case INTEGRITY:

			return integrityBTN;

		case EXCELLENCE:

			return excellenceBTN;

		case TEAMWORK:

			return teamworkBTN;

		case INNOVATION:
			
			return innovationBTN;

		case LEARNING:

			return learningBTN;

		case THINK_BIG:

			return thinkBigBTN;

		default:
			System.out.println("solo ingrese las opciones disponibles");
		}
		return excellenceBTN;

	}	

	
	
	
	private void escribirUnaNota(String notaOcomentario) {
		type(whyMessageInput, notaOcomentario);
		
	}
	
	public void enviarUnaEstrellaBtn() {
		click(sendStarBTN);
	}
	
	
	public void clickParaComfirmarEnvioDStar() {
		click(sendStarBtnComfirm);
	}
	
	
	
	public void selectValueAndSendAStar(ChooseARecognition value) {

		WebElement valueBtn = valorAEnviar(value);
		click(valueBtn);

	}
	
	public enum ChooseARecognition {
		 
		INTEGRITY("Integrity"),
		EXCELLENCE("Excellence"),
		TEAMWORK("Teamwork"),
		INNOVATION("Innovation"),
		LEARNING("Learning"),
		THINK_BIG("Think big");

		private final String valueStr;

		ChooseARecognition(String valueStr) {
			this.valueStr = valueStr;
		}
		
		public String getValue() {
			return valueStr;
		}
				 
		}
	
	 public ActivityFeedStarOS navigateToPrincipalPageFromPDCoworker(ChooseARecognition value, String notaOcomentario) {
		 enviarUnaEstrellaBtn();
		 wait(Duration.ofSeconds(6));
		 click(popUspDeArriba);
		 selectValueAndSendAStar(value);
		
		 escribirUnaNota(notaOcomentario);
		 clickParaComfirmarEnvioDStar();
		 wait(Duration.ofSeconds(3));
		 click(cerrarConfirmacionDeEnvioDeEstrella);    
		 click(volverAlaPaginaDeInicio);                                           
			return getNextPage(ActivityFeedStarOS.class);
		}
	 
	
	
	
	 

}