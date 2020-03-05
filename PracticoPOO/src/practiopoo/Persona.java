package practiopoo;

public class Persona {
/* nombre, apellido, edad, sexo y adulto */
	
	private String name;
	private String lastName;
	private int age;
	private char sex;
	private String adultOrNot;
	
 public Persona() {}
 
 public Persona(String name, String lastName,int age, char sex,String adultOrNot) {
     this.name = name; 
	 this.lastName = lastName;
	 this.age= age;
	 this.sex= sex;
	 this.adultOrNot= adultOrNot;
	 
 }
 
	 // setters
 public void setName(String nomb) {
     this.name = nomb;
 }
 
 public void setLastName(String apellido) {
     this.lastName = apellido;
 }
 public void setAge (int edad) {
     this.age =edad;
 }
 
 public void setSex(char sexo) {
     this.sex = sexo;
 }
 public void setAdultOrNot(String esAdulto) {
     this.adultOrNot= esAdulto;
 }
 
 //getters
 
   String getName() {
     return this.name;
 }
   String getLastName() {
	     return this.lastName;
	 }
 
}
