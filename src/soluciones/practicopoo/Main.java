package soluciones.practicopoo;

public class Main {

	public static void main(String[] args) {
		Argentino arg = new Argentino();
		arg.setNombre("Horacio");
		arg.setApellido("Fernández");
		arg.setProvincia("Buenos Aires");
		arg.setBarrio("Nuñez");
		arg.setEdad(30);
		arg.setSexo('M');
		arg.setDni("36977661");
		
		Uruguayo uru = new Uruguayo();
		uru.setNombre("Marcela");
		uru.setApellido("Rodríguez");
		uru.setDepartamento("Montevideo");
		uru.setBarrio("La Blanqueada");
		uru.setEdad(27);
		uru.setSexo('F');
		Cedula ci = new Cedula();
		ci.setNumero(5858765);
		ci.setDigitoVerificador(1);
		uru.setCi(ci);
		
		System.out.println("Un uruguayo es uruguayo? " + soyUruguayo(uru));
		System.out.println("Un argentino es uruguayo? " + soyUruguayo(arg));
		
		Perro perro = new Perro();
		perro.setNombre("Firulais");
		perro.setEdad(12);
		perro.setRaza("Border Collie");
		perro.setSexo('M');
		
		System.out.println("El argentino es adulto? "+ arg.esAdulto());
		System.out.println("El perro es adulto? "+ perro.esAdulto());

	}
	
	public static boolean soyUruguayo(Persona persona) {
		return persona instanceof Uruguayo;
	}

}
