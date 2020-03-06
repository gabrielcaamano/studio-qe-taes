package practicopoo;

public class Perro implements SerVivo {

	private String nombre;
    private String raza;
    private int edad;
    private String sexo;
   
    
    public Perro() { }
    
    public Perro(String nombre, String raza, int edad,String sexo, boolean adulto) { 
 	   this.nombre = nombre;
 	   this.raza = raza;
 	   this.edad = edad;
 	   this.sexo = sexo;
 	 
 	 }

    // name 
    public void setName(String nombre) {
 	   this.nombre = nombre;
    }
    
    public String getName() {
 	   return this.nombre;
    }
    
   //Raza
    public void setRaza(String raza) {
 	   this.raza = raza;
    }
    
    public String getRaza() {
 	   return this.raza;
    }
   
   //age
    public void setEdad(int edad) {
 	   this.edad = edad;
    }
    
    public int getEdad() {
 	   return this.edad;
    }
   
   //sex
    public void setSexo(String sexo) {
 	   this.sexo = sexo;
    }
    
    public String getSexo() {
 	   return this.sexo;
    }
   
 
    
    public int cumpleaños( int edad) {
  	   
 	    return edad + 1;
 	   
    }
    
    public boolean isAdulto(int edad) {
 	   if(edad > 5) {
 		   return true;
 	   } else {
 		   return false;
 	   }
   }
    
}
