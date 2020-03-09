package classes;

import interfaces.SerVivo;

public class Perro implements SerVivo {

	private String nombre;
	private String raza;
	public int age;
	private String gender;

	public Perro() {

	}

	public String getNombre() {

		return nombre;
	}

	public String getRaza() {

		return raza;

	}

	public int getAge() {

		return age;

	}

	private String getGender() {

		return gender;

	}

	public boolean esAdulto(int edad) {

		return edad >= 2;

	}

	public void cumpleaños() {

		this.age = age + 8;

	}

	@Override
	public boolean esAdulto() {
		// TODO Auto-generated method stub
		return false;
	}

}
