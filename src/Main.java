import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; // Guardaremos la opcion del usuario

		int[] ejerciciosSelecc = new int[5];
		int pos = 0;
		int opcionSelecc = 0;

		while (!salir) {

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
			System.out.println("11. Salir");
			System.out.println();
			try {

				System.out.println("Escribe una de las opciones:");
				System.out.println();
				opcion = sn.nextInt();

				//public static void guardaEjSelecc() {}
				
				/*
				 * public static void guardarNroEjercicio() { while ( pos < 5) {
				 * ejerciciosSelecc[pos] = opcion; } if (pos == 5) { pos = 0; } }
				 */
				switch (opcion) {
				case 1:
					System.out.println("Has seleccionado el ejercicio 1");
					// EJERCICIO 1
					System.out.println("inicio");
					/*
					 * System.out.print("Por favor, ingrese su sexo: ");
					 * 
					 * String sexo;
					 * 
					 * Scanner scanIn = new Scanner(System.in); sexo = scanIn.nextLine();
					 * 
					 * scanIn.close(); System.out.println(sexo);
					 */
					System.out.println(ejercicio1("F"));
					System.out.println();
					opcionSelecc = 1;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 2:
					System.out.println("Has seleccionado el ejercicio 2");
					// EJERCICIO 2
					System.out.println(ejercicio2());
					System.out.println();
					opcionSelecc = 2;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 3:
					System.out.println("Has seleccionado el ejercicio 3");
					// EJERCICIO 3
					System.out.println(ejercicio3());
					System.out.println();
					opcionSelecc = 3;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 4:
					System.out.println("Has seleccionado el ejercicio 4");
					// EJERCICIO 4
					System.out.print(ejercicio4("casa", "casa"));
					System.out.println();
					opcionSelecc = 4;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 5:
					System.out.println("Has seleccionado el ejercicio 5");
					// EJERCICIO 5
					System.out.println(ejercicio5(121));
					System.out.println();
					opcionSelecc = 5;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 6:
					System.out.println("Has seleccionado el ejercicio 6");
					// EJERCICIO 6
					System.out.println(ejercicio6(1, 1));
					System.out.println();
					opcionSelecc = 6;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 7:
					System.out.println("Has seleccionado el ejercicio 7");
					// EJERCICIO 7
					System.out.println(ejercicio7(1, 7));
					System.out.println();
					opcionSelecc = 7;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 8:
					System.out.println("Has seleccionado el ejercicio 8");
					// EJERCICIO 8
					System.out.println(ejercicio8());
					System.out.println();
					opcionSelecc = 8;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 9:
					System.out.println("Has seleccionado el ejercicio 9");
					// EJERCICIO 9
					ejercicio9("casa");
					System.out.println();
					opcionSelecc = 9;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 10:
					System.out.println("Has seleccionado el ejercicio 10");
					// EJERCICIO 10
					ejercicio10("casa");
					System.out.println();
					opcionSelecc = 10;
					if (pos < 5) {
						ejerciciosSelecc[pos] = opcionSelecc;
					} else {
						pos = 0;
						ejerciciosSelecc[pos] = opcionSelecc;
					}
					pos++;
					break;
				case 11:
					System.out.println();
					salir = true;
					System.out.println("Estos son los ultimos 5 ejercicos que selecionaste:");
					for (int i = 0; i < 5; i++) {
						System.out.print(ejerciciosSelecc[i] + ", ");
					}
					break;
				default:
					System.out.println("Solo números entre 1 y 11");

				}

			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}

		}


	}

	public static Boolean ejercicio1(String sexo) {
		switch (sexo) {
		case "F":
			return true;
		case "M":
			return false;
		default:
			return null;
		}
	}

	/*
	 * public static void ejercicio2() { int[] numbers = new int[20];
	 * 
	 * for (int i = 0; i <= 19; i++ ) { System.out.println("inicio");
	 * System.out.print("Por favor, ingrese un número entero: ");
	 * 
	 * String number;
	 * 
	 * Scanner scanIn = new Scanner(System.in); number = scanIn.nextLine();
	 * numbers[i] = Integer.parseInt(number); scanIn.close();
	 * System.out.println(number); } System.out.println(numbers); }
	 */

	public static boolean ejercicio2() {

		int[] arrayRandom = new int[10];

		for (int i = 0; i <= 9; i++) {
			arrayRandom[i] = (int) (Math.random() * 20) + 1;
			System.out.print(arrayRandom[i] + ", ");
		}
		boolean sumaPos234Par = false;
		sumaPos234Par = ((arrayRandom[2] + arrayRandom[3] + arrayRandom[4]) % 2) == 0;
		if (sumaPos234Par) {
			System.out.println("La suma del valor en las posiciones 2, 3 y 4 es par");
			return true;
		} else {
			System.out.println("La suma del valor en las posiciones 2, 3 y 4 es impar");
			return false;
		}
	}

	public static boolean ejercicio3() {
		int[] numbers = { 5, 3, 39, 7, 6 };
		int i = 0;
		boolean par = false;
		while ((i < numbers.length) && (numbers[i] % 2 != 0)) {
			i++;
		}

		par = numbers.length > i;
		return par;
	}

	public static boolean ejercicio4(String palabra1, String palabra2) {

		return palabra1 == palabra2;
	}

	/*
	 * public static boolean ejercicio52( int capicua ) { String capicuaString =
	 * Integer.toString(capicua); int i = 0; int a = capicuaString.length(); boolean
	 * esCapicua = false; while ( ( (i < a/2) && (a > a/2) ) && (
	 * capicuaString.charAt(i) == capicuaString.charAt(a) ) ) { i++; a--; }
	 * esCapicua = (i < a/2) || (a > a/2); return esCapicua; }
	 */

	public static boolean ejercicio5(int capicua) {

		String capicuaString = Integer.toString(capicua);
		String capicuaInvertido = "";
		for (int x = capicuaString.length() - 1; x >= 0; x--) {
			capicuaInvertido = capicuaInvertido + capicuaString.charAt(x);
		}

		return capicuaString.equals(capicuaInvertido);
	}

	public static boolean ejercicio6(int a, int b) {

		return a < b;
	}

	public static boolean ejercicio7(int a, int b) {

		return a * b == a / b;
	}

	public static boolean ejercicio8() {

		int[] array1 = new int[10];
		int[] array2 = new int[10];
		int contador = 0;

		for (int i = 0; i <= 9; i++) {
			array1[i] = (int) (Math.random() * 20) + 1;
			System.out.print(array1[i] + ", ");
		}

		System.out.println();

		for (int i2 = 0; i2 <= 9; i2++) {
			array2[i2] = (int) (Math.random() * 20) + 1;
			System.out.print(array2[i2] + ", ");
		}

		System.out.println();

		for (int i = 0; i <= 9; i++) {

			for (int a = 0; a <= 9; a++) {

				if (array1[i] == array2[a]) {
					contador = contador + 1;
				}
			}
		}

		return contador >= 2;
	}

	public static void ejercicio9(String palabraInicial) {

		String palabraAlReves = "";

		for (int x = palabraInicial.length() - 1; x >= 0; x--) {
			palabraAlReves = palabraAlReves + palabraInicial.charAt(x);
		}

		System.out.println(palabraAlReves);

	}

	public static void ejercicio10(String palabraConVocales) {

		String vocales = "aeiou";
		String palabraConX = "";

		for (int i = 0; i < palabraConVocales.length(); i++) {

			for (int a = 0; a < vocales.length(); a++) {

				if (palabraConVocales.charAt(i) == vocales.charAt(a)) {
					palabraConX = palabraConVocales.replace(palabraConVocales.charAt(i), 'x');
				}
			}
		}

		System.out.println(palabraConX);
	}

}
