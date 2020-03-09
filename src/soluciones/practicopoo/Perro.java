package soluciones.practicopoo;

public class Perro implements SerVivo {

	private String nombre;
	private String raza;
	private char sexo;
	private int edad;
	
	public Perro() {
		
	}
	
	@Override
	public void cumpleanios() {
		edad++;

	}

	@Override
	public boolean esAdulto() {
		return edad > 2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
