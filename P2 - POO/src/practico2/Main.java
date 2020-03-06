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
		
		perro1.setAge(1);

	}
	
}
