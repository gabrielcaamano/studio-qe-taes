package classes;

import interfaces.SerVivo;
//import practico2.Main.Argentino;
//import practico2.Main.Perro;
//import practico2.Main.Uruguayo;
	
	public class Persona implements SerVivo {
		// Atributos de la clase
		private String name;
		private String lastname;
		private int age;
		private String gender;

		// Constructor
		public Persona() {

		}

		// M�todos de la clase
		public void setCumplea�os() {

			age++;

		}
		
		public void setName(String nombre) {
			
			this.name = nombre;
			
		}
		
		public void setLastName(String lastname) {
			
			this.lastname = lastname;
			
		}

		public void setAge(int age) {

			this.age = age;
		}

		public void setGender(String gender) {
			
			this.gender = gender;
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

		public void cumplea�os() {
			// The body of cumplea�os() is provided here
			this.age = age++;

		}

		public boolean esAdulto(int edad) {

			return edad >= 18;

		}
		

		@Override
		public boolean esAdulto() {
			// TODO Auto-generated method stub
			return false;
		}

	}


