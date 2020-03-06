
public class Persona implements SerVivo{

	private String nombre;
	private String apellido;
	private int edad;
	private String sexo;

	public Persona() {
	
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return this.apellido;
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
	
	
	
	public int cumpleaños() {
		return this.edad = this.edad +1;
	}
	
	public boolean esAdulto() {
		if (this.edad >= 18) {
			return true;
		}else {
			return false;
		}
	}
}

