
public class Main {
	
	public static void main(String[] args) {
		Uruguayo uru = new Uruguayo();
		Argentino ar = new Argentino();
		Cedula ci = new Cedula();
		
		ci.setNumero(5621685);
		ci.setDigitoVerificador(2);
		
		
		uru.setNombre("Juana");
		uru.setApellido("Garcia");
		uru.setEdad(23);
		uru.setSexo("femenino");
		uru.setCi(ci);
		uru.setDepartamento("Montevideo");
		uru.setBarrio("Centro");
		
		ar.setNombre("Pedro");
		ar.setApellido("Fernández");
		ar.setEdad(48);
		ar.setSexo("masculino");
		ar.setDni(56329841);
		ar.setProvincia("Buenos Aires");
		ar.setBarrio("Palermo");
		
		
		Perro dog = new Perro();
		
		dog.setNombre("Tomy");
		dog.setEdad(12);
		dog.setRaza("Caniche");
		dog.setSexo("masculino");
		
		Argentino arg = new Argentino();
		
		arg.setNombre("Pedrito");
		arg.setApellido("Fernández");
		arg.setEdad(12);
		arg.setSexo("masculino");
		arg.setDni(56329841);
		arg.setProvincia("Buenos Aires");
		arg.setBarrio("Palermo");
		
		
		System.out.println("Primera iteración de imprimirInfo()\n");
		uru.imprimirInfo();
		System.out.println();
		System.out.println("Se muda el día de su cumpleaños\n");
		uru.mudarse("Canelones", "Santa Rosa");
		uru.cumpleaños();
		System.out.println("Segunda iteración de imprimirInfo()\n");
		uru.imprimirInfo();
				
		System.out.println("\n");
		System.out.println("¿Argentino es uruguayo? " + soyUruguayo(arg));
		System.out.println("¿Uruguayo es uruguayo? " + soyUruguayo(uru));
		

		System.out.println("\n");
		System.out.println("Perro adulto (mayor de 4 años): " + dog.esAdulto());
		System.out.println("Argentino adulto (mayor de 18 años): " + arg.esAdulto());
	}
	
	
	public static boolean soyUruguayo(Persona person){
		return person instanceof Uruguayo;	
	}
	
}
