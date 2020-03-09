package classes;


public class Uruguayo extends Persona {

	private Cedula ci;
	private String depto;
	private String barrio;

	public Uruguayo() {

	}

	public Cedula getCi() {

		return ci;
	}

	public String getDepartamento() {

		return depto;

	}

	public String getBarrio() {

		return barrio;
		
	}
	
	public void setCi(Cedula cedula) {
		
		this.ci = cedula;
		
	}
	
	public void setDepto(String depto) {
		
		this.depto = depto;
		
	}
	
	public void setBarrio(String barrio) {
		
		this.barrio = barrio;
		
	}

	public void imprimirInfo(String name, String lastname, int age, String gender, String ci, String depto,
			String barrio) {

		System.out.println("Nombre: " + name);
		System.out.println("Apellido " + lastname);
		System.out.println("Edad: " + age);
		System.out.println("Género: " + gender);
		System.out.println("CI: " + ci);
		System.out.println("Departamento: " + depto);
		System.out.println("Barrio: " + barrio);

	}

	public void setMudarse(String desdeBarrio, String hastaBarrio, String desdeDepto, String hastaDepto) {

		desdeBarrio = hastaBarrio;
		desdeDepto = hastaDepto;

	}
}
