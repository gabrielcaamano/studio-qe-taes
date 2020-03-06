package classes;

public class Uruguayo extends Persona {
	private int cI;
	private String dep;
	private String bar;
 
	public Uruguayo() {
		super();
	}
	 public Uruguayo (int cI, String dep ,String bar) {
	     this.cI = cI; 
		 this.dep = dep;
		 this.bar= bar; }
	 
	// setters
	 public void setCi(int newCi) {
	     this.cI = newCi;
	 }
	 
	 public void setDep(String newDep) {
	     this.dep = newDep;
	 }
	 public void setBar (String newBar) {
	     this.bar =newBar;
	 }
	 
	 //getters
	 
	 public int getcI() {
		return this.cI;
	}
	 public String getDep() {
		return this.dep;
	}
	 public String getBar() {
		return this.bar;
	}
	
	 public void printInfo() {
	     getName();
		 getLastName();
	     getAge();
	     getAdultOrNot();
	     getDep();
		 getBar();
		 getcI();
		
	 }
	
	 public void mudarse() {
		//
		
	 }
 
}
