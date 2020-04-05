package com.globant.automation.cyf2020.tests;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EjecutorTest {

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
		driver.manage().window().maximize();
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
		PaginaPrincipalStarOS paginaPrincipal = login.navigateToPrincipalPage(usuario.getEmail(), usuario.getPassword());
		
		
		//Take the data and compare to see if they match
		compararNombreApellidoYJob(usuario.getNombre(), usuario.getApellido(), paginaPrincipal.nombreYApellido(), usuario.getJob(), paginaPrincipal.getTheJob());
		
	}
	
	//@Test
	public void SendStar1Y2() {
		
		UsuarixStarMeUp usuarioB = new UsuarixStarMeUp();
		usuarioB.setEmail("user85@bootcampsqe.com");
		usuarioB.setContraseña("user85@bootcampsqe.com");
		
		
		Login login1 = new Login(driver);
		PaginaPrincipalStarOS paginaPrincipalB = login1.navigateToPrincipalPage(usuarioB.getEmail(), usuarioB.getPassword());
		int capturarNumeroDeEstrellasRecibidasUserB = 0;
		capturarNumeroDeEstrellasRecibidasUserB = paginaPrincipalB.getStarRecibed();
		NavBar barraDeNavegacion = paginaPrincipalB.navigateToNavBar();
		login1 = barraDeNavegacion.desloguearse();
		
		//userA is created
		UsuarixStarMeUp usuarioA = new UsuarixStarMeUp();
		usuarioA.setEmail("user82@bootcampsqe.com");
		usuarioA.setContraseña("user82@bootcampsqe.com");
		
		
		//for the userA
		PaginaPrincipalStarOS paginaPrincipal2 = login1.navigateToPrincipalPage(usuarioA.getEmail(), usuarioA.getPassword());
		
		int capturarNumeroDeEstrellasEnviadasUserA = paginaPrincipal2.getStarSent();
		
		NavBar barraDeNavegacionA = paginaPrincipal2.navigateToNavBar();
		
		//driver at user profile
		PerfilDeCoworker coworkerPerfil = barraDeNavegacionA.navigateToPerfilDeCoworker(usuarioB.getEmail());
		
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
		
		paginaPrincipal2 = coworkerPerfil.navigateToPrincipalPageDesdePDCoworker(3, ":O"); 
		//vuelvo a la pagina principal
	    
	    //capturo los datos en la variable
		
		paginaPrincipal2.reLoadTheActivity();
		String nombreYreemitenteActivityFeed = paginaPrincipal2.capturarNombreYreemitenteActivityFeed();
		
		//verificar si las estrellas enviadas se incrementaron en uno
		assertEquals( paginaPrincipal2.getStarSent(), capturarNumeroDeEstrellasEnviadasUserA );
		
		
		//voy hacia el perfil personal del usuario
		PerfilDeUser perfilPersonal = barraDeNavegacionA.navigateToPerfilDeUser();
		
		
		perfilPersonal.clickSentTab();
		
		String nombreYreemitenteActivityFeed2 = perfilPersonal.capturarNombreYreemitentePerfil();
		//comparo si los datos recabados son iguales
		assertEquals(nombreYreemitenteActivityFeed2, nombreYreemitenteActivityFeed);
		
		//voy hacia el usuarioB
		
	
		
	    barraDeNavegacionA.desloguearse();
	    paginaPrincipalB = login1.navigateToPrincipalPage(usuarioB.getEmail(), usuarioB.getPassword());
		
		barraDeNavegacion.clickEnLaCampana();
	    barraDeNavegacion.darClickEnLaNotificacion();
	    
	    barraDeNavegacion.clickEnLaCampana();
		
	    assertEquals(true, paginaPrincipalB.verificarSiLaNotificacionEstaReadTrueONoFalse()); 
	    
		barraDeNavegacion.clickEnLaCampanaActiva();
		
		barraDeNavegacion.navigateToPaginaPrincipal();
		
		//verifico si el numero de estrellas incremento
		assertEquals(capturarNumeroDeEstrellasRecibidasUserB , paginaPrincipal2.getStarRecibed());    
		
		String reemitenteActivityFeedUserB = paginaPrincipal2.nombreDelReemitenteActivityFeed();
		
		//voy hacia el perfil personal del usuario
	    PerfilDeUser perfilPersonalUserB = barraDeNavegacion.navigateToPerfilDeUser();
	    	
	    
	  //comparo si los datos recabados son iguales
	   assertEquals( perfilPersonalUserB.nombreDelReemitente(), reemitenteActivityFeedUserB);
	   
	}
	
	
	
	
	@Test
	public void SendStar3() {
		
		UsuarixStarMeUp userB = new UsuarixStarMeUp();
		userB.setEmail("user85@bootcampsqe.com");
		userB.setContraseña("user85@bootcampsqe.com");
		
		Login login = new Login(driver);
		PaginaPrincipalStarOS principalPage = login.navigateToPrincipalPage(userB.getEmail(), userB.getPassword());
		NavBar barraDeNavegacion = principalPage.navigateToNavBar();
		
		PerfilDeUser perfilPersonalUser = barraDeNavegacion.navigateToPerfilDeUser();
		int cantidadDeComentarios1 = 0;
		cantidadDeComentarios1 =+ perfilPersonalUser.cantidadDeComentarios();
		System.out.println(cantidadDeComentarios1);
		
		perfilPersonalUser.clicktoOpenComments();
		System.out.println(perfilPersonalUser.primercomentarioExisteOno());
		
		 barraDeNavegacion.desloguearse();
		 
		 UsuarixStarMeUp userA = new UsuarixStarMeUp();
		 userA.setEmail("user82@bootcampsqe.com");
		 userA.setContraseña("user82@bootcampsqe.com");
		 
		 principalPage = login.navigateToPrincipalPage(userA.getEmail(), userA.getPassword());
		 
	     perfilPersonalUser.clickSentTab();
	     
	     String enviarComentarioYguardar = perfilPersonalUser.escribirUnComentario(" Holas");
	     perfilPersonalUser.clickPopUpRight();
	     perfilPersonalUser.clickForSentTheComent();
	     perfilPersonalUser.clickPopUpInMyProfile();
	     
	     //perfilPersonalUser.clicktoOpenComments();
	     String getCommentType = perfilPersonalUser.primercomentarioExisteOno();
	     System.out.println(getCommentType);
	     barraDeNavegacion.desloguearse();
	     
	     //start session the userB again
	     principalPage = login.navigateToPrincipalPage(userB.getEmail(), userB.getPassword());
	     perfilPersonalUser.clickPopUpInMyProfile(); // close a pop up that blocks an action
	     barraDeNavegacion.clickEnLaCampana();
		 barraDeNavegacion.darClickEnLaNotificacion();
		 
		 //get the comment in the notifications 
		 //perfilPersonalUser.clicktoOpenComments();
		 String getCommentTypeInNotifications = perfilPersonalUser.primercomentarioExisteOno();
		 
		 System.out.println(getCommentTypeInNotifications);
		 
		 int cantidadDeComentarios2 = 0;
			cantidadDeComentarios2 =+ perfilPersonalUser.cantidadDeComentarios();
			System.out.println(cantidadDeComentarios2);
		 
		 assertEquals(getCommentType, getCommentTypeInNotifications);
		
	     assertEquals(cantidadDeComentarios2, cantidadDeComentarios1 + 1);
	}
	
	
	
	
	
	
	
	
	
	
   public void compararNombreApellidoYJob(String nombreSetteado,String appellidoSetteado, String nombreYapellidoEnLaPagina, String trabajoSetteado, String trabajoEnLaPagina) {
	  
	   
	   
	   
	   assertEquals( nombreYapellidoEnLaPagina, nombreSetteado + " " + appellidoSetteado);
	   
	   assertEquals(trabajoSetteado, trabajoEnLaPagina);
	   
   }


	
	
}
	

	 


	

