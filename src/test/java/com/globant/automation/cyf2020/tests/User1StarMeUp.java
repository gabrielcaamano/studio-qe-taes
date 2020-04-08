package com.globant.automation.cyf2020.tests;


public class User1StarMeUp {
private String usuario;
private String contrasena;
private String nombre;
private String apellido;
private String trabajo;

    public User1StarMeUp(String user,String clave, String name, String lastname, String job){
    	usuario= user;
    	contrasena= clave;
    	nombre= name;
    	apellido= lastname;
    	trabajo= job;
    }
    
	public String getUsuario() {
		return this.usuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}
	
	public String getTrabajo() {
		return this.trabajo;
	}

	
}
