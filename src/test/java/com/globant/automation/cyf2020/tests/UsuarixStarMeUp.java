package com.globant.automation.cyf2020.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.automation.cyf2020.infrastructure.BasePage;

public class UsuarixStarMeUp extends BasePage {

	

	private String email;
    private String contraseña;
    private String job;
    private String nombre;
    private String apellido;
   
  
    public UsuarixStarMeUp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}





		// email
	    public void setEmail(String email) {
	 	   email = email;
	    }
	    
	    public String getEmail() {
	 	   return email;
	    }
	    
	   //contraseña
	    public void setContraseña(String contraseña) {
	 	   contraseña = contraseña;
	    }
	    
	    public String getContraseña() {
	 	   return contraseña;
	    }
	   
	    //Job
	    public void setJob(String job) {
		 	   job = job;
		    }
		    
		public String getJob() {
		 	   return job;
		    }
	
		 public void setNombre(String nombre) {
		 	   nombre = nombre;
		    }
		    
		public String getNombre() {
		 	   return nombre;
		    }
		
		 public void setApellido(String apellido) {
		 	   apellido = apellido;
		    }
		    
		public String getApellido() {
		 	   return apellido;
		    }
}
