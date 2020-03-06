
public class Uruguayo extends Persona{
	private Cedula ci;
	private String departamento;
	private String barrio;
	
//	Cedula ci = new Cedula();
	
	public void setCi(Cedula ci) {
		this.ci = ci;
	}
	
	public Cedula getCi() {
		return this.ci;
	}
	
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String getDepartamento() {
		return this.departamento;
	}
	
	
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	public String getBarrio() {
		return this.barrio;
	}
	
	
	public Uruguayo() {
		
	}
	
	
	public void imprimirInfo() {
		System.out.println("Nombre: "+ this.getNombre());
		System.out.println("Apellido: "+ this.getApellido());
		System.out.println("Edad: "+ this.getEdad());
		System.out.println("Sexo: "+ this.getSexo());
		System.out.println("CI: "+ this.getCi().getNumero() + "-" + this.getCi().getDigitoVerificador());
		System.out.println("Departamento: "+ this.getDepartamento());
		System.out.println("Barrio: "+ this.getBarrio());
	}
	
	public void mudarse(String departamento, String barrio) {
		this.setDepartamento(departamento);
		this.setBarrio(barrio);
	}
}
