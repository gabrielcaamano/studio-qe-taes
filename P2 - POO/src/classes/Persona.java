package classes;

import interfaces.serVivo;
//import practico2.Main.Argentino;
//import practico2.Main.Perro;
//import practico2.Main.Uruguayo;
	
	public class Persona implements serVivo {
		// Atributos de la clase
		private String name;
		private String lastname;
		private int age;
		private String gender;

		// Constructor
		public Persona() {

		}

		// Métodos de la clase
		public void setCumpleaños() {

			age++;

		}

		public String getName() {

			return name;

		}

		public String getLastName() {

			return lastname;

		}

		public int getAge() {

			return age;

		}

		public String getGender() {

			return gender;

		}

		public void cumpleaños() {
			// The body of cumpleaños() is provided here
			this.age = age++;

		}

		public boolean esAdulto(int edad) {

			return edad >= 18;

		}

		public void setAge(int age) {

			this.age = age;
		}

		@Override
		public boolean esAdulto() {
			// TODO Auto-generated method stub
			return false;
		}

	}


