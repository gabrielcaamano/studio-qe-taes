package persona;

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
 public void setName(String newName) {
     this.name = newName;
 }
 
 public void setLastName(String newLastName) {
     this.lastName = newLastName;
 }
 public void setAge (int newAge) {
     this.age =newAge;
 }
 
 public void setSex(char newSex) {
     this.sex = newSex;
 }
 public void setAdultOrNot(String newAdultOrNot) {
     this.adultOrNot= newAdultOrNot;
 }
 
 //getters
 
   String getName() {
     return this.name;
 }
   String getLastName() {
	     return this.lastName;
	 }
   
   int getAge() {
	   return this.age;
   }
   
   char getSex() {
	   return this.sex;
   }
   
   String getAdultOrNot() {
	   return this.adultOrNot;
   }
  
   public int birthday() {
	   return getAge() + 1;
   }
 
} 

