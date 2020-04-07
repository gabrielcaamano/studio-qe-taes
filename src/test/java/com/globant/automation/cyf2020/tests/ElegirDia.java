package com.globant.automation.cyf2020.tests;

public enum ElegirDia {

	LUNES("Empieza la semana"),
	MARTES("Ya falta menos"), 
	MIERCOLES("Ombligo de semana"), 
	JUEVES("JUERNES"), 
	VIERNES("Happy weekend!"), 
	SABADO("Have fun!"),
	DOMINGO("Dormir hasta tarde");
	
	private String mensaje;
	
	
	private ElegirDia (String mensaje){
		this.mensaje = mensaje;
		
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}

	
	
}
