import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static int[] ultimosEjercicios = new int [5];
	private static int b = 7;
	private static int a = 13;

	public static void main(String[] args) {
		ultimosEjercicios[0] = 0;
		ultimosEjercicios[1] = 0;
		ultimosEjercicios[2] = 0;
		ultimosEjercicios[3] = 0;
		ultimosEjercicios[4] = 0;

		
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; 
	        
		while(!salir){
	            
	    	System.out.println("1. Ejercicio 1");
	    	System.out.println("2. Ejercicio 2");
	    	System.out.println("3. Ejercicio 3");
	    	System.out.println("4. Ejercicio 4");
	    	System.out.println("5. Ejercicio 5");
	    	System.out.println("6. Ejercicio 6");
	    	System.out.println("7. Ejercicio 7");
	    	System.out.println("8. Ejercicio 8");
	    	System.out.println("9. Ejercicio 9");
	    	System.out.println("10. Ejercicio 10");
	    	System.out.println("11. Mostrar los últimos 5 ejercicios ejecutados");
	    	System.out.println("12. Salir");
	            
	    	System.out.println("Escribe una de las opciones");
	    	opcion = sn.nextInt();
	            
	    	switch(opcion){
	    		case 1:
	    			System.out.println("Ingrese el sexo: ");

	    			String sexo;

	    			Scanner scanIn = new Scanner(System.in);
	    			sexo = scanIn.nextLine();

	    			scanIn.close();
	    			System.out.println(sexo);

	    			System.out.println(ejercicio1(sexo));
	    			
	    			break;
	    		case 2:
	    			int[] arreglo2 = new int[10];

	    			int j = 1;
	    			for (int i = 0; i < 10; i++) {
	    				arreglo2[i] = j;
	    				j = j + 1;
	    			}

	    			System.out.println(ejercicio2(arreglo2));
	    			break;
	    		case 3:
	    			int[] arreglo3 = new int[3];
	    			arreglo3[0] = 1;
	    			arreglo3[1] = 2;
	    			arreglo3[2] = 3;
	    					
	    			System.out.println(ejercicio3(arreglo3));
	    			
	    			break;
	    		case 4:
	    			char[] palabra1 = new char[4];
	    			 palabra1[0] = 'a';
	    			 palabra1[1] = 'a';
	    			 palabra1[2] = 'a';
	    			 palabra1[3] = 'a';
	    			
	    			 char[] palabra2 = new char[5];
	    			 palabra2[0] = 'a';
	    			 palabra2[1] = 'a';
	    			 palabra2[2] = 'a';
	    			 palabra2[3] = 'a';
	    			 palabra2[4] = 'a';
	    			 
	    			 System.out.println(ejercicio4(palabra1, palabra2));
	    			 
	    			break;
	    		case 5:
	    			int capicua = 12421;
	    			System.out.println(ejercicio5(capicua));
	    			
	    			break;
	    		case 6:
	    			int numero6 = 7;
	    			System.out.println(ejercicio6(numero6));
	    			
	    			break;
	    		case 7:
	    			System.out.println(ejercicio7());
	    			
	    			break;
	    		case 8:
	    			int[] arreglo8a = new int[3];
	    			arreglo8a[0] = 3;
	    			arreglo8a[1] = 3;
	    			arreglo8a[2] = 3;

	    			int[] arreglo8b = new int[4];
	    			arreglo8b[0] = 3;
	    			arreglo8b[1] = 99;
	    			arreglo8b[2] = 1;
	    			
	    			System.out.println(ejercicio8(arreglo8a, arreglo8b));
	    			
	    			break;
	    		case 9:
	    			String palabra = "hola";
	    			System.out.println(ejercicio9(palabra));
	    			
	    			break;
	    		case 10:    			
	    			String palabraVocales = "hola";
	    			System.out.println(ejercicio10(palabraVocales));
	    			
	    			break;
	    		case 11: 
	    			System.out.println(Arrays.toString(ultimosEjercicios));
	    			break;
	    		case 12:
	    			salir=true;
	    			break;
	    		default:
	    			System.out.println("Solo números entre 1 y 10");
	           }
	            
	       }
	}

	public static Boolean ejercicio1(String sexo) {
		
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 1;
		
		if (sexo.equals("F")) {
			return true;
		} else if (sexo.equals("M")) {
			return false;
		} else {
			return null;
		}

	}

	public static boolean ejercicio2(int[] array2) {
		
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 2;
		
		if ((array2[2] + array2[3] + array2[4]) % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean ejercicio3(int[] array3) {
		int i = 0;
		while (array3[i] % 2 != 0 && i < array3.length-1) {
			i++;
		}

		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 3;
		
		if (array3[i] % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean ejercicio4(char[] palabra1, char[] palabra2) {
		int i=0;
		while ( i < palabra1.length-1  && i < palabra2.length-1 && palabra1[i] == palabra2[i]) {
			i++;
		}
		
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 4;
		
		if (palabra1[i] != palabra2[i] || palabra1.length != palabra2.length) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean ejercicio5(int numero) {
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 5;
		
		String num = Integer.toString(numero);
		String numRevez = "";
		for(int i=num.length()-1; i>=0; i= i-1) {
			numRevez += num.charAt(i);
		}

		return numRevez.contentEquals(num);
	}
		
	
	public static boolean ejercicio6(int num) {
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 6;
		if (num < b) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean ejercicio7() {
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 7;
		return a*b == a/b;
	}

	public static boolean ejercicio8(int[] A, int[] B) {
		int cont = 0;
				
		for (int j = 0; j < A.length; j++) {
			for (int k = 0; k < B.length; k++) {
				if (A[j] == B[k]) {
					cont++;
					B[k] = B[k] + 100;
					break;
				}
				
			}
		}
		
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 8;

		if (cont>=2) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static String ejercicio9(String palabra) {
		String palabraRevez = "";
		for(int i=palabra.length()-1; i>=0; i= i-1) {
			palabraRevez += palabra.charAt(i);
		}
		
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 9;
		
		return palabraRevez;
	}
	
	public static String ejercicio10(String palabra) {
		String palabraNueva = palabra.replace('a', 'x').replace('e', 'x').replace('i', 'x').replace('o', 'x').replace('u', 'x');
		/*for(int i=palabra.length()-1; i>=0; i= i-1) {
			if (palabra.charAt(i) == 'a' || palabra.charAt(i) == 'e' || palabra.charAt(i) == 'i' || palabra.charAt(i) == 'o' || palabra.charAt(i) == 'u') {
				palabra.replace('a', 'x');  
			} 
		}*/
		
		ultimosEjercicios[0] = ultimosEjercicios[1];
		ultimosEjercicios[1] = ultimosEjercicios[2];
		ultimosEjercicios[2] = ultimosEjercicios[3];
		ultimosEjercicios[3] = ultimosEjercicios[4];
		ultimosEjercicios[4] = 10;
		
		return palabraNueva;
		
	}

}
