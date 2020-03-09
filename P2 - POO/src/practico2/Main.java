package practico2;

import classes.Argentino;
import classes.Cedula;
import classes.Perro;
import classes.Uruguayo;

public class Main {

	public void soyUruguayo(Object nacionalidad) {
		System.out.println(nacionalidad instanceof Uruguayo);

	}

	public static void main(String[] args) {
		
		Uruguayo uruguayo1 = new Uruguayo();
		Argentino argentino1 = new Argentino();
		Perro perro1 = new Perro();
		Argentino argentino2 = new Argentino();
		
		Uruguayo uruguayoPrueba = new Uruguayo();
		uruguayoPrueba.setName("Julio");
		uruguayoPrueba.setLastName("Muniz");
		uruguayoPrueba.setAge(20);
		uruguayoPrueba.setGender("M");
		uruguayoPrueba.setDepto("Montevideo");
		uruguayoPrueba.setBarrio("Centro");
		Cedula ciUruguayoPrueba = new Cedula();
		ciUruguayoPrueba.setNumero(1234567);
		ciUruguayoPrueba.setDigVerificador(8);
		uruguayoPrueba.setCi(ciUruguayoPrueba); // Settear la CI despues de settear los campos de la CI
		System.out.println("Este es un uruguayo de prueba -> " + uruguayoPrueba.getName() + " " + uruguayoPrueba.getLastName() + ", " + uruguayoPrueba.getAge() + " años, " + "sexo: "
		 + uruguayoPrueba.getGender() + ", " +  "CI: " + ciUruguayoPrueba.getNumero() + ciUruguayoPrueba.getDigVerificador() + ", " + uruguayoPrueba.getDepartamento() + ": " + uruguayoPrueba.getBarrio());
		
		
		Argentino argentinoPrueba = new Argentino();
		argentinoPrueba.setName("Andrea");
		argentinoPrueba.setLastName("Ferreira");
		argentinoPrueba.setAge(20);
		argentinoPrueba.setGender("M");
		argentinoPrueba.setDNI("123456789");
		argentinoPrueba.setProvincia("Buenos Aires");
		argentinoPrueba.setBarrio("Belgrano");
		System.out.println("Este es un argentino de prueba -> " + argentinoPrueba.getName() + " " + argentinoPrueba.getLastName() + ", " + argentinoPrueba.getAge() + " años, " + "sexo: " + argentinoPrueba.getGender() + ", " + "DNI: " + argentinoPrueba.getDNI() + ", " + argentinoPrueba.getProvincia() + ": " + argentinoPrueba.getBarrio());
		
		System.out.println();
		
		System.out.println("----- Prueba del método esAdulto() -----");
		perro1.age = 12;
		argentino2.setAge(12);
		System.out.println("La edad de perro1 es " + perro1.getAge() + ", adulto: " + perro1.esAdulto(perro1.getAge()));
		System.out.println("La edad de argentino2 es " + argentino2.getAge() + " , adulto: "+ argentino2.esAdulto(argentino2.getAge()));
	}

}
