package Clases;

import javax.swing.Spring;

public class Persona {
		 private String nombre; 
		 private String apellido; 
		 private int edad; 	
		 private char sexo;
		 private String adulto;
				 
		public Persona() {
			
		}
		
		public Persona(String nombre, String apellido, int edad, char sexo, String adulto) {
			this.nombre= nombre;
			this.apellido= apellido;
			this.edad= edad;
			this.sexo= sexo;
			this.adulto= adulto;	
		}
		
		 String getNombre() {
		    return nombre;
		  }
		 public void setNombre(String newNombre) {
			    this.nombre = newNombre;
			  }
	 
		 
		 String getApellido() {
			    return apellido;
			  }
			 public void setApellido(String newApellido) {
				    this.apellido = newApellido;
				  }
		 
			 
	      int getEdad() {
			return edad;
		}
		  public void setEdad(int newEdad) {
		  	this.edad= newEdad;
		}

		  
	      char getSexo() {
			return sexo;
		}
		  public void setSexo(char newSexo) {
		  	this.sexo= newSexo;
		}

			  
		 String getAdulto() {
		   return adulto;
		  }
		 public void setAdulto(String newAdulto) {
		   this.adulto = newAdulto;
			 }

		 
		 public int cumpleaños(int edad) {   
		    return edad+1;
			}
		 	 
}
