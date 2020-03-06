package Clases;
public class Uruguayo extends Persona{ 

		private int cI;
		private String departamento;
		private String barrio;

	     public Uruguayo() {
	    	 
	     }
	     public Uruguayo(int cI, String departamento, String barrio) {
				this.cI= cI;
				this.departamento= departamento;
				this.barrio= barrio;
		 }
			

		 int getcI() {
		    return cI;
		  }
		 public void setcI(int newcI) {
			    this.cI = newcI;
			  }
	

		 String getDepartamento() {
		    return departamento;
		  }
		 public void setDepartamento(String newDepartamento) {
			    this.departamento = newDepartamento;
			  }
		 

		 String getBarrio() {
		    return barrio;
		  }
		 public void setBarrio(String newBarrio) {
			    this.barrio = newBarrio;
			  }
		 
		 public void imprimirInfo() {
			 System.out.println(this.getNombre());
			 System.out.println(this.getApellido());
			 System.out.println(this.getEdad());
			 System.out.println(this.getSexo());
			 System.out.println(this.getAdulto());
			 System.out.println(this.getcI());
			 System.out.println(this.getDepartamento());
			 System.out.println(this.getBarrio());
		 }
		 
		 public void mudarse(String departamento, String barrio) {
			 this.setBarrio(barrio);
			 this.setDepartamento(departamento);
				  }
			 
			
		 }

			 
			 
		 

