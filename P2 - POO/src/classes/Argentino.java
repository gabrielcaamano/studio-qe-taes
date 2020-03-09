package classes;

public class Argentino extends Persona {

	private String DNI;
	private String provincia;
	private String barrio;

	public Argentino() {

	}

	public String getDNI() {

		return DNI;

	}

	public String getProvincia() {

		return provincia;

	}

	public String getBarrio() {

		return barrio;

	}
	
	public void setDNI(String DNI) {
		
		this.DNI = DNI;
		
	}
	
	public void setProvincia(String provincia) {
		
		this.provincia = provincia;
		
	}
	
	public void setBarrio(String barrio) {
		
		this.barrio = barrio;
		
	}

}
