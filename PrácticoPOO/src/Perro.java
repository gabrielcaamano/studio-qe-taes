
public class Perro implements SerVivo{

	private String nombre;
	private String raza;
	private int edad;
	private String sexo;

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public String getRaza() {
		return this.raza;
	}
	
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	
	public Perro() {
		
	}
	
	public int cumpleaños() {
		return this.edad++;
	}
	
	public boolean esAdulto() {
		if (this.edad >= 4) {
			return true;
		}else {
			return false;
		}
	}
}
