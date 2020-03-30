package com.globant.automation.cyf2020.tests;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ejecutorTest {

	//https://uat.starmeup.com/login.html?continue=aHR0cHM6Ly91YXQuc3Rhcm1ldXAuY29tLw%3D%3D&origin=SMU&logout=true
	//pagina a la que hay que ir
	
private WebDriver driver;
	
	
	@BeforeClass
	public void beforeClasss() {
		System.out.println("Inicia el test");
	}
	
	
	
    @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://uat.starmeup.com/login.html?continue=aHR0cHM6Ly91YXQuc3Rhcm1ldXAuY29tLw%3D%3D&origin=SMU&logout=true");
	} 
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	

	@Test
	public void ejercicio1() {
		
		UsuarixStarMeUp usuario = new UsuarixStarMeUp(driver);
		usuario.setEmail("user81@bootcampsqe.com");
		usuario.setContraseña("user81@bootcampsqe.com");
		usuario.setJob("job_jurzv");
		usuario.setNombre("username81");
		usuario.setApellido("feed81");
		
		Login login = new Login(driver);
		PaginaPrincipalStarOS paginaPrincipal = login.navigateToPrincipalPage(usuario.getEmail(), usuario.getContraseña());
		
		compararNombreApellidoYJob(usuario.getNombre(), usuario.getApellido(), paginaPrincipal.nombreYApellidoArray(), usuario.getJob(), paginaPrincipal.getTheJob());
		
	}
	
	
	
   public void compararNombreApellidoYJob(String nombreSetteado,String appellidoSetteado, String[] nombreYapellidoEnLaPagina, String trabajoSetteado, String trabajoEnLaPagina) {
	   
	   String nombreYapellidoConcat = nombreYapellidoEnLaPagina[0] +" "+ nombreYapellidoEnLaPagina[1];
	   
	   assertEquals( nombreYapellidoConcat, nombreSetteado + " " + appellidoSetteado);
	   
	   assertEquals(trabajoSetteado, trabajoEnLaPagina);
	   
   }


	
	
}
	

	 


	

