package soluciones.practicopoo;

public class Uruguayo extends Persona {

	private Cedula ci;
	private String departamento;
	private String barrio;
	
	public Uruguayo() {
		
	}
	
	public void imprimirInfo() {
		System.out.println("CI: "+ ci.getNumero() +"-"+ ci.getDigitoVerificador() +". Dpto: "+ departamento +". Barrio: "+ barrio +".");
	}
	
	public void mudarse(String departamento, String barrio) {
		this.departamento = departamento;
		this.barrio = barrio;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Cedula getCi() {
		return ci;
	}

	public void setCi(Cedula ci) {
		this.ci = ci;
	}
	
	
	
	
}
