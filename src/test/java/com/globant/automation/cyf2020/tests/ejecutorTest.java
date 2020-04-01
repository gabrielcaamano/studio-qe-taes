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
	public void iniciarPaginaWeb() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://uat.starmeup.com/login.html?continue=aHR0cHM6Ly91YXQuc3Rhcm1ldXAuY29tLw%3D%3D&origin=SMU&logout=true");
	} 
	
	//@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	

	//@Test
	public void LoginEjercicio1() {
		
		UsuarixStarMeUp usuario = new UsuarixStarMeUp();
		usuario.setEmail("user81@bootcampsqe.com");
		usuario.setContraseña("user81@bootcampsqe.com");
		usuario.setJob("job_jurzv");
		usuario.setNombre("username81");
		usuario.setApellido("feed81");
		
		Login login = new Login(driver);
		PaginaPrincipalStarOS paginaPrincipal = login.navigateToPrincipalPage(usuario.getEmail(), usuario.getContraseña());
		
		
		//Toma los datos y compara para ver si coinciden
		compararNombreApellidoYJob(usuario.getNombre(), usuario.getApellido(), paginaPrincipal.nombreYApellido(), usuario.getJob(), paginaPrincipal.getTheJob());
		
	}
	
	@Test
	public void SendStar() {
		
		UsuarixStarMeUp usuarioB = new UsuarixStarMeUp();
		usuarioB.setEmail("user83@bootcampsqe.com");
		usuarioB.setContraseña("user83@bootcampsqe.com");
		usuarioB.setJob("job_pngty");
		usuarioB.setNombre("username83");
		usuarioB.setApellido("feed83");
		
		Login login1 = new Login(driver);
		PaginaPrincipalStarOS paginaPrincipalB = login1.navigateToPrincipalPage(usuarioB.getEmail(), usuarioB.getContraseña());
		int capturarNumeroDeEstrellasRecibidasUserB = paginaPrincipalB.getStarRecibed();
		
		iniciarPaginaWeb(); //para El usuarioA
		
		UsuarixStarMeUp usuarioA = new UsuarixStarMeUp();
		usuarioA.setEmail("user82@bootcampsqe.com");
		usuarioA.setContraseña("user82@bootcampsqe.com");
		usuarioA.setJob("job_qdqcu");
		usuarioA.setNombre("username82");
		usuarioA.setApellido("feed82");
		
		Login login2 = new Login(driver);
		PaginaPrincipalStarOS paginaPrincipal2 = login2.navigateToPrincipalPage(usuarioA.getEmail(), usuarioA.getContraseña());
		int capturarNumeroDeEstrellasEnviadasUserA = paginaPrincipal2.getStarSent();
		
	/*	
		//navegar al perfil del userB
		PerfilDeCoworker coworkerPerfil = paginaPrincipal2.navigateToPerfilDeCoworker(usuarioB.getEmail());
		
		/*  algo sobre navigateToPrincipalPageDesdePDCoworker, el numero es el tipo de reconocimiento que se le quiere enviar, esta ordenado asi:
		 * 1 = Integrity
		 * 2 = Excellence
		 * 3 = Team Work
		 * 4 = Innovation
		 * 5 = Learning
		 * 6 = Think Big
		 * 
		 * El siguiente campo es para comentarios hacia el coworker.
		 * 
		 *    */
	
		//paginaPrincipal2 = coworkerPerfil.navigateToPrincipalPageDesdePDCoworker(1, "tiene una integración eficaz");
		//vuelvo a la pagina principal
	     //capturo los datos en la variable
		
				
		String nombreYreemitenteActivityFeed = paginaPrincipal2.capturarNombreYreemitenteActivityFeed();
		
		//verificar si las estrellas enviadas se incrementaron en uno
		assertEquals( paginaPrincipal2.getStarSent(), capturarNumeroDeEstrellasEnviadasUserA );
		
		
		//voy hacia el perfil personal del usuario
		PerfilDeUser perfilPersonal = paginaPrincipal2.navigateToPerfilDeUser();
		
		perfilPersonal.clickSentTab();
		
		
		//comparo si los datos recabados son iguales
		assertEquals( perfilPersonal.capturarNombreYreemitentePerfil(), nombreYreemitenteActivityFeed);
		
		
		//voy hacia el usuarioB
		paginaPrincipalB.clickEnLaCampana();
		paginaPrincipalB.darClickEnLaNotificacion();
		paginaPrincipalB.clickEnLaCampana();
		paginaPrincipalB.clickEnPopUp();
		System.out.println(paginaPrincipalB.verificarSiLaNotificacionEstaReadTrueONoFalse());
		paginaPrincipalB.clickEnLaCampana();
		
		//verifico si el numero de estrellas incremento
		assertEquals(capturarNumeroDeEstrellasRecibidasUserB + 1, paginaPrincipal2.getStarRecibed());
		
		
	}
	
	
	
	
	
	
	
   public void compararNombreApellidoYJob(String nombreSetteado,String appellidoSetteado, String nombreYapellidoEnLaPagina, String trabajoSetteado, String trabajoEnLaPagina) {
	  
	   
	   
	   
	   assertEquals( nombreYapellidoEnLaPagina, nombreSetteado + " " + appellidoSetteado);
	   
	   assertEquals(trabajoSetteado, trabajoEnLaPagina);
	   
   }


	
	
}
	

	 


	

