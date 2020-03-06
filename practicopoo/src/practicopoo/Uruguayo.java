package practicopoo;

public class Uruguayo extends Persona {
		
		 private int CI;
	     private String departamento;
	     private String barrio;

	     
	     public Uruguayo() {
	    	 //constructor
	     }
	     
	     
	     public Uruguayo(int CI, String departamento,String barrio) {
	    	 this.CI = CI;
	    	 this.departamento = departamento;
	         this.barrio = barrio;
	     }
		
	     
	     
	     public void setCI(Cédula Cédula) {
	  	   this.CI = CI;
	     }
	     
	     public int getCI() {
	  	   return this.CI;
	     }
	     
	    //departamento
	     public void setDepartamento(String departamento) {
	  	   this.departamento = departamento;
	     }
	     
	     public String getDepartamento() {
	  	   return this.departamento;
	     }
	    
	    //barrio
	     public void setBarrio(String barrio) {
	  	   this.barrio = barrio;
	     }
	     
	     public String getBarrio() {
	  	   return this.barrio;
	     }

	    //metodos
	     
	     public void   imprimirInfo() {
	    	 
	    	
	           System.out.println("Datos de el/la Uruguayx: " + "barrio: " + this.barrio 
			  + " " + "departamento: " + this.departamento + " " + "CI: " + this.CI);
	    }
	     
	     public void  mudarse(String barrio, String departamento) {
	    	 
	    	 this.barrio = barrio;
	    	 this.departamento = departamento;
	     	
	  }
	   
	     
	 		
	}

