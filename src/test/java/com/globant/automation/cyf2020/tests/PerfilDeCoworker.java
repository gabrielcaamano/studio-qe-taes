package com.globant.automation.cyf2020.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class PerfilDeCoworker extends BasePage{

	

	@FindBy(xpath = "//button[@class=\"button profile-board__btn-wrapper-button button--color-black\"]")
	private WebElement sendStarBTN;
	
	@FindBy(xpath = "//button[@class=\"button button--nomargin-right button--transparent button--color-\"]")
	private WebElement sendStarBtnComfirm;
	
	@FindBy(xpath = "//div[@class=\"what-value what-value--horizontal\"]//div[@class=\"value-icon\"][1]")
	private WebElement integrityBTN;
	
	@FindBy(xpath = "//div[@class=\"what-value what-value--horizontal\"]//div[@class=\"value-icon\"][2]")
	private WebElement excellenceBTN;
	
	@FindBy(xpath = "//div[@class=\"what-value what-value--horizontal\"]//div[@class=\"value-icon\"][3]")
	private WebElement teamworkBTN;
	
	@FindBy(xpath = "//div[@class=\"what-value what-value--horizontal\"]//div[@class=\"value-icon\"][4]")
	private WebElement innovationBTN;
	
	@FindBy(xpath = "//div[@class=\"what-value what-value--horizontal\"]//div[@class=\"value-icon\"][5]//img")
	private WebElement learningBTN;
	
	@FindBy(xpath = "//div[@class=\"what-value what-value--horizontal\"]//div[@class=\"value-icon\"][6]")
	private WebElement thinkBigBTN;
	
	@FindBy(xpath = "//div[@class=\"notranslate public-DraftEditor-content\"]")
	private WebElement whyMessageInput;
	
	@FindBy(xpath = "//span[@class=\"suite-discovery suite-discovery__smu suite-discovery__smu--bottom suite-discovery__smu--open\"]")
	private WebElement popUspDeArriba;
	
	@FindBy(xpath = "//i[@class=\"close large icon confirmation__close\"]")
	private WebElement cerrarConfirmacionDeEnvioDeEstrella;	
	
	@FindBy(xpath = "//div[@class=\"ui-navbar__logo-container\"]//a")
	private WebElement volverAlaPaginaDeInicio;
	
	
	     			
	
	
	public PerfilDeCoworker(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void valorAEnviar(int opcion) {
	
		switch(opcion){
     case 1:
    	 click(integrityBTN);
         break;
     case 2:
    	 click(excellenceBTN);
         break;
     case 3:
    	 click(teamworkBTN);
         break;
     case 4:
         
    	 click(innovationBTN);
             break;
     case 5:
         
    	  click(learningBTN);
      
             break;
     case 6:
            
    	  click(thinkBigBTN);
             break;
     
      default:
         System.out.println("Solo números entre 1 y 6");
	 } 
	
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
	
	
	
	
	
	 public PaginaPrincipalStarOS navigateToPrincipalPageDesdePDCoworker(int opcion, String notaOcomentario) {
		 enviarUnaEstrellaBtn();
		 wait(Duration.ofSeconds(6));
		 click(popUspDeArriba);
		 valorAEnviar(opcion);
		
		 escribirUnaNota(notaOcomentario);
		 clickParaComfirmarEnvioDStar();
		 wait(Duration.ofSeconds(3));
		 click(cerrarConfirmacionDeEnvioDeEstrella);
		 click(volverAlaPaginaDeInicio);
			return getNextPage(PaginaPrincipalStarOS.class);
		}
	 
	
	
	
	
	
}