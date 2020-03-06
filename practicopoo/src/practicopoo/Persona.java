package practicopoo;

public class Persona implements SerVivo {
       private String nombre;
       private String apellido;
       private int edad;
       private String sexo;
     
       
       public Persona() { }
       
       public Persona(String nombre, String apellido, int edad,String sexo, boolean adulto) { 
    	   this.nombre = nombre;
    	   this.apellido = apellido;
    	   this.edad = edad;
    	   this.sexo = sexo;
    	   
    	 }
       
       public int cumpleaños( int edad) {
    	   
    	    return edad + 1;
    	   
       }
       
       public boolean isAdulto(int edad) {
     	   if(edad > 17) {
     		   return true;
     	   } else {
     		   return false;
     	   }
       }
       
       // name 
       public void setName(String nombre) {
    	   this.nombre = nombre;
       }
       
       public String getName() {
    	   return this.nombre;
       }
       
      //second name
       public void setApellido(String apellido) {
    	   this.apellido = apellido;
       }
       
       public String getApellido() {
    	   return this.apellido;
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
      
      
      
       
       }


