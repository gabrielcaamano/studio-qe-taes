package practiopoo;

public class Uruguayo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*atributos privados CI, Departamento, Barrio, con sus respectivos 
		 getters and setters y su constructor por defecto vacío */

		 public class Uruguaye extends Persona {
			 private int cedula;
			 private String depart;
			 private String barrio;
			 
			 public Uruguaye() {}
			 
			 public Uruguaye(String name, String lastName,int age, char sex,String adultOrNot, int cedula, String depart, String barrio) {
			  super(name, lastName, age, sex, adultOrNot);
			  this.cedula = cedula; 
				 this.depart = depart;
				 this.barrio= barrio;
			  
			 }
			 public void setCedula(int newCedula) {
			     this.cedula = newCedula;
			 }
			 
			 public void setDepart(String newDepart) {
			     this.depart = newDepart;
			 }
			 public void setBarrio (String newBarrio) {
			     this.barrio =newBarrio;
			 }
			 public int getCedula() {
			     return this.cedula;
			 }
			   public String getDepart() {
				     return this.depart;
				 }
			 public String getBarrio() {
				   return this.barrio;
			 }
			 
			 

		  /*por último 
		 incluir dos métodos, uno que imprima en pantalla todos los datos de 
		 la persona uruguaya llamado “imprimirInfo” y otro que se llame “mudarse”
		  el cual modifica el departamento y el barrio.*/
		 
			// Uruguaye lani = new Uruguaye();
					 
			 public void imprimirInfo() {
				 
				 System.out.println(getName());
				 System.out.println(getLastName());
				 System.out.println(getAge());
			     System.out.println(getSex());
			     System.out.println(getAdultOrNot());
			     System.out.println(getCedula());
			     System.out.println(getDepart());
			     System.out.println(getBarrio());
			 }
		 
			 public void mudarse() {
				 
			 }
	}

	}
}
