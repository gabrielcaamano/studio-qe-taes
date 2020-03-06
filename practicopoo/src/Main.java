import Clases.Argentino;
import Clases.Persona;
import Clases.Uruguayo;
public class Main {

	public static void main (String[] args) {
		Persona objetoPersona = new Persona ();
		System.out.println(objetoPersona.cumpleaños(20));
	}
	public void main1 (String[] args) {
		Uruguayo objetoUruguayo = new Uruguayo ();
		//System.out.println(objetoUruguayo.imprimirInfo());
	}
		
	Uruguayo uruguayo1= new Uruguayo();
	Argentino argentino1= new Argentino();

	public boolean soyUruguayo(Object pers) {
		System.out.println(pers instanceof Uruguayo);
	}
	public boolean soyUruguayo() {
		return true;
	
		return false;
			


}
                                          