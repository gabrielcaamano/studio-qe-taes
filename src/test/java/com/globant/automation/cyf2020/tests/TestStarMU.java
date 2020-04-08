package com.globant.automation.cyf2020.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestStarMU {
    private WebDriver driver;
   
 User1StarMeUp users= new User1StarMeUp("user71@bootcampsqe.com","user71@bootcampsqe.com", "username71", "feed71","job_zhchc");
 User1StarMeUp users2= new User1StarMeUp("user72@bootcampsqe.com","user72@bootcampsqe.com", "username72", "feed72","job_zhchc" );
    
    @BeforeMethod
	public void openStarMeUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://uat.starmeup.com/login.html");	
    }
    
    @Test 
    public void testStarMeUp() {
    	LoginPageSMU ingresar= new LoginPageSMU(driver);
    	String resultPage= ingresar.ingresaUser(users.getUsuario());
    	HomeSMU resultPage1= ingresar.ingresaPasswordYnavega(users.getContrasena());
    	String[] nameSurname= resultPage1.nombreApellido().split(" ");
    	String nombre = nameSurname[0]; 
    	String apellido= nameSurname[1];
    	Assert.assertEquals(users.getNombre(), nombre, "no son iguales");
    	Assert.assertEquals(users.getApellido(), apellido, "apellidos diferentes");
    	Assert.assertEquals(users.getTrabajo(), resultPage1.infoTrabajo(), "no son iguales");
    	LoginPageSMU salir= resultPage1.saliendo();
    	String resultPage2= ingresar.ingresaUser(users2.getUsuario());
    	HomeSMU resultPage3= ingresar.ingresaPasswordYnavega(users2.getContrasena());
    	String resultPage4= resultPage1.OtroUsuario("username71 feed71");
    	OtroUsuario resultPage5=resultPage1.navigateToOtroUsuario();
    	sendStar star= resultPage5.clickStar();
    	star.teamWorkStar();
    	String message=star.write(" Gracias por ayudarme en mi proyecto, fue de mucha ayuda");
    	
  }
    
}    
