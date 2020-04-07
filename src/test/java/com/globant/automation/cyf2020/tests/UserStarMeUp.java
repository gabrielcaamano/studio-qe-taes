package com.globant.automation.cyf2020.tests;

public class UserStarMeUp {

	private String email;
	private String contraseña;
	private String job;
	private String nombre;
	private String apellido;

	public UserStarMeUp(String email, String contraseña, String job, String nombre, String apellido) {
		this.contraseña = contraseña;
		this.job = job;
		this.nombre = nombre;
		this.apellido = apellido;

	}

	public UserStarMeUp() {
		// TODO Auto-generated constructor stub
	}

	// email
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	// contraseña
	public void setPassword(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getPassword() {
		return contraseña;
	}

	// Job
	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}
}
