package practicopoo;

public class Argentino extends Persona {
	 private int DNI;
     private String provincia;
     private String barrio;

     
     public Argentino() {
    	 //constructor
     }
     
     
     public Argentino(int DNI, String provincia,String barrio) {
    	 this.DNI = DNI;
    	 this.provincia = provincia;
         this.barrio = barrio;
     }
	
     
     
     public void setDNI(int DNI) {
  	   this.DNI = DNI;
     }
     
     public int getDNI() {
  	   return this.DNI;
     }
     
    //departamento
     public void setProvincia(String provincia) {
  	   this.provincia = provincia;
     }
     
     public String getProvincia() {
  	   return this.provincia;
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
    	 
    	
           System.out.println("Datos de el/la Argentinox: " + "barrio: " + this.barrio 
		  + " " + "provincia: " + this.provincia + " " + "DNI: " + this.DNI);
    }
     
     public void  mudarse(String barrio, String provincia) {
    	 
    	 this.barrio = barrio;
    	 this.provincia = provincia;
     	
  }
   
     
 		
}
