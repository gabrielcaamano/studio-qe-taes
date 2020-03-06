package Clases;
public class Argentino extends Persona{
     private int dNI;
	 private String provincia;
     private String barrio;
     
     
     public Argentino() {
    	 
     }
     public Argentino(int dNI, String provincia, String barrio) {
    	 this.dNI= dNI;
    	 this.provincia= provincia;
    	 this.barrio= barrio;
     }
     
     
     int getdNI() {
    	 return dNI;
     }
     public void setdNI(int newDNI) {
    	 this.dNI= newDNI;
     }
      
     String getprovincia() {
    	 return provincia;
     }
     public void setprovincia(String newProvincia) {
    	 this.provincia= newProvincia;
     }
     
     String getbarrio() {
    	 return barrio;
     }
     public void setbarrio(String newBarrio) {
    	 this.barrio= newBarrio;
     }
     
     
     
     
}
