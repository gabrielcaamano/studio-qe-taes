package practicopoo;

public class Main {
	
	public static void main(String[] args) {
		Argentino Argentinoa = new Argentino();
		Uruguayo Uruguayoa = new Uruguayo();
	    //soyUruguayo(Uruguayoa);
		Cédula identi = new Cédula();
		
		Perro Dogo = new Perro();
		
		
		Dogo.setName("Firulais");
		Dogo.setRaza("Terrier");
		Dogo.setEdad(12);
		Dogo.setSexo("Hembra");
		
		
		System.out.println(Dogo.isAdulto(Dogo.getEdad()));
		
		Argentinoa.setName("Giorno");
		Argentinoa.setApellido("Joestar");
		Argentinoa.setEdad(12);
		Argentinoa.setSexo("Hombre");
		
		
		System.out.println(Argentinoa.isAdulto(Argentinoa.getEdad()));
		
	}
	
	//Dogo.getEdad()
	//Argentinoa.getEdad()
	
	

	public static boolean soyUruguayo(Persona persona) {
		
		
		
			 return persona instanceof Uruguayo;

		
		
	}

}
