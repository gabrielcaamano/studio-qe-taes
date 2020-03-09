package practico2;

import classes.Argentino;
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
		
		perro1.age = 12;
		argentino2.setAge(12);
		System.out.println("La edad de perro1 es " + perro1.getAge() + ", adulto: " + perro1.esAdulto(perro1.getAge()));
		System.out.println("La edad de argentino2 es " + argentino2.getAge() + " , adulto: "+ argentino2.esAdulto(argentino2.getAge()));
	}

}
