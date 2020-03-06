package classes;

import interfaces.serVivo;

public class Perro implements serVivo {

	private String nombre;
	private String raza;
	private int age;
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

	public boolean esAdulto() {

		return age >= 2;

	}

	public void cumpleaños() {

		this.age = age + 8;

	}

	public void setAge(int age) {

		this.age = age;

	}

}
