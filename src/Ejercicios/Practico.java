package Ejercicios;

import java.util.Scanner;
import java.util.Arrays;

public class Practico {
	static int[] ejerciciosFinales = { 6, 7, 8, 9, 10 };

	public static void main(String[] args) {
		
		boolean salir = false;
		while (!salir) {
			Scanner in = new Scanner(System.in);
			System.out.println("------------- MENU -------------\n");
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
			System.out.println("11. Ejercicio 11");
			System.out.println("12. Ejercicio 12");
			System.out.println("13. Salir\n\n\n");

			System.out.println("Elije una de las opcion:");
			int choice = in.nextInt();
			switch (choice) {

			case 1:
				System.out.println(ejercicio1('M'));
				break;
			case 2:
				System.out.println(ejercicio2());
				break;
			case 3:
				System.out.println(ejercicio3());
				break;
			case 4:
				System.out.println(ejercicio4());
				break;
			case 5:
				ejercicio5();
				break;
			case 6:
				System.out.println(ejercicio6(1, 2));
				break;
			case 7:
				System.out.println(ejercicio7(8, 4));
				break;
			case 8:
				System.out.println(ejercicio8());
				break;
			case 9:
				ejercicio9();
				break;
			case 10:
				ejercicio10();
				break;
			case 11:
				System.out.println(Arrays.toString(ejerciciosFinales));
				break;
			case 12:
				ejercicio12();
				break;
			case 13:
				System.out.println("Gracias por tu tiempo!!!");
				salir = true;
				break;

			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// ejercicio1

	public static Boolean ejercicio1(char genero) {
		if (genero == 'F') {
			return true;
		}

		else if (genero == 'M') {
			return false;
		}

		else {
			return null;
		}
	}

	// ejercicio2
	public static Boolean ejercicio2() {
		int[] number = { 1, 2, 3, 4, 5, 6 };
		int suma = number[2] + number[3] + number[4];

		if (suma % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// ejercicio3
	public static Boolean ejercicio3() {
		int[] number = { 1, 3, 3, 2, 5, 5 };
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 0) {
				return true;
			}
		}
		return false;

	}

	// ejercicio4
	public static Boolean ejercicio4() {
		String palabra1 = ("Hola");
		String palabra2 = ("Hola");
		if (palabra1 == palabra2) {
			return true;
		} else
			return false;
	}

	// ejercicio5
	public static void ejercicio5() {
		int numerosC = 1231321;
		String numerosC1 = Integer.toString(numerosC);
		String numeroInvertido = "";
		for (int i = numerosC1.length() - 1; i >= 0; i--) {
			numeroInvertido = numeroInvertido + numerosC1.charAt(i);
		}
		System.out.println(numerosC1.equals(numeroInvertido));
	}

	// ejercicio6
	public static boolean ejercicio6(int a, int b) {
		if (a < b) {
			return true;
		} else
			return false;

	}

	// ejercicio7
	public static boolean ejercicio7(int a, int b) {
		if (a * b == a % b) {
			return true;
		} else
			return false;
	}

	// ejercicio8
	public static boolean ejercicio8() {
		int[] array1 = { 1, 2, 3, 4 };
		int[] array2 = { 3, 4, 5, 6 };
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1.length; j++) {
				if (array1[i] == array2[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// ejercicio9
	public static void ejercicio9() {
		String palabra = "romina";
		String palabraInvertida = "";
		for (int i = palabra.length() - 1; i >= 0; i--) {
			palabraInvertida = palabraInvertida + palabra.charAt(i);
		}
		System.out.println(palabraInvertida);
	}

	// ejercicio10
	public static void ejercicio10() {
		String palabra1 = "romina";
		palabra1 = palabra1.replace('o', 'x').replace('i', 'x').replace('a', 'x');
		System.out.println(palabra1);
	}

	// ejercicio11
	public static void ejercicio11() {

	}

	// ejercicio12
	public static void ejercicio12() {
		System.out.println("Ejercicio7:");
		System.out.println(ejercicio7(8, 4));

		System.out.println("Ejercicio8:");
		System.out.println(ejercicio8());

		System.out.println("Ejercicio9:");
		ejercicio9();

		System.out.println("Ejercicio10:");
		ejercicio10();

		System.out.println("Ejercicio11:");
		System.out.println(Arrays.toString(ejerciciosFinales));
	}

}
