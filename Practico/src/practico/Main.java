package practico;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] ultimosEjercicios = { 6, 7, 8, 9, 10 };

	public static void main(String[] args) {
		System.out.println("Inicio\n\n");
		
		// here starts my menu
		 Scanner in = new Scanner(System.in);
		
		 boolean quit= false;
		
		 while(!quit) {
		 
		// menu
		  System.out.println("1\t Sexo");
	        System.out.println("2\t Par");
	        System.out.println("3\t AtLeastOne");
	        System.out.println("4\t Equal");
	        System.out.println("5\t Capicua");
	        System.out.println("6\t aLessThan");
	        System.out.println("7\t SameNum");
	        System.out.println("8\t AtLeastTwo");
	        System.out.println("10\t Reversed");
	        System.out.println("11\t UltimosEjercicios");
	        System.out.println("12\t Ultimos5Ejercicios");
	        System.out.println("13\t Would you like to quit?\n\n\n");
	        System.out.println("Please enter your choice:");
	        
	        //Get user's choice
	        int choice=in.nextInt();
	         
	        //Display the title of the chosen module
	        switch (choice) {
	            case 1:System.out.println(sexo('M')); 
		   break;
	            case 2: System.out.println(par());
	                    break;
	            case 3:  System.out.println(atLeastOne());
	                    break;
	            case 4: System.out.println(equal());
	                     break;
	            case 5:capicua(123454301);
		   break;
	            case 6:System.out.println(aLessThan(2,8));
	                    break;
	            case 7:  System.out.println(sameNum(8,8));
	                    break;
	            case 8: System.out.println(atLeastTwo());
	                     break;
	            case 9:reversed();
		   break;
	            case 10: changeVocal();
	                    break;
	            case 11: ultimosEjercicios();
	                    break;
	            case 12: ultimos5Ejercicios();
	            break;
	            case 13: 
	            	System.out.println("Yes or No?");
	            	Scanner in2 = new Scanner(System.in);
	    	        String choice2 = in2.nextLine();
	    	        if(choice2.equals("yes")) {
		            	quit= true;
		            	System.out.println("Goodbye");
	    	        } else {
		            	System.out.println("Continue...");
	    	        }
	    	        
	            break;
	                     
	            default: System.out.println("Invalid choice");
	   }//end of switch
		 }
     
	       
	}

	/*
	 * System.out.println(sexo('M')); System.out.println(par());
	 * System.out.println(atLeastOne()); System.out.println(equal());
	 * capicua(123454301); System.out.println(aLessThan(2,8));
	 * System.out.println(sameNum(2,8)); System.out.println(atLeastTwo());
	 * reversed(); changeVocal(); ultimosEjercicios();
	 */

	/* ejercicio 1 */

	public static Boolean sexo(char sex) {
		System.out.println("ejercicio 1");
		if (sex == 'F') {
			return true;
		}

		else if (sex == 'M') {
			return false;
		} else
			return null;

	}

	/* ejercicio 2 */

	public static boolean par() {
		System.out.println("ejercicio 2");

		int[] numb = { 45, 50, 43, 52, 41 };

		int suma = numb[2] + numb[3] + numb[4];

		if (suma % 2 == 0) {
			return true;
		}

		else
			return false;

	}

	/* ejercicio 3 */

	public static boolean atLeastOne() {
		System.out.println("ejercicio 3");

		int[] numb = { 45, 51, 43, 53, 47, 53 };

		for (int i = 0; i < numb.length; i++) {
			if (numb[i] % 2 == 0) {
				return true;
			}
		}
		return false;

	}

	/* ejercicio 4 */

	public static boolean equal() {
		System.out.println("ejercicio 4");
		String word1 = ("hi");
		String word2 = ("hello");

		if (word1 == word2) {
			return true;
		} else
			return false;

	}
	/* ejercicio 5 */

	public static void capicua(int p) {
		System.out.println("ejercicio 5");
		int numb = p;
		String numStr = Integer.toString(numb);
		String numStrInvertida = "";
		for (int i = numStr.length() - 1; i >= 0; i--) {
			numStrInvertida = numStrInvertida + numStr.charAt(i);
		}
		System.out.println(numStrInvertida.equals(numStr));

	}

	/* ejercicio 6 */

	public static boolean aLessThan(int a, int b) {
		System.out.println("ejercicio 6");

		if (a < b) {
			return true;
		}

		else
			return false;
	}

	/* ejercicio 7 */
	public static boolean sameNum(int a, int b) {
		System.out.println("ejercicio 7");

		if (a * b == a / b) {
			return true;
		}

		else
			return false;
	}

	/* ejercicio 8 */
	public static boolean atLeastTwo() {
		System.out.println("ejercicio 8");
		int[] x = { 1, 2, 7, 9, 3, 5, 6 };
		int[] y = { 8, 2, 6, 4, 99, 21 };
		int[] z = { 22, 123, 15, 67 };
		for (int i = 0; i < x.length && i < y.length; i++) {
			if (x[i] == y[i]) {
				return true;
			}
		}
		return false;
	}
	/* ejercicio 9 */

	public static void reversed() {
		System.out.println("ejercicio 9");
		String name = "mhelani";
		String result = "";
		for (int i = name.length() - 1; i >= 0; i--) {
			result = result + name.charAt(i);
		}
		System.out.println(result);
	}

	/* ejercicio 10 */

	public static void changeVocal() {
		System.out.println("ejercicio 10");
		String word = "aceituna";
		String changedWord = word.replace("a", "x").replace("e", "x").replace("i", "x").replace("o", "x").replace("u",
				"x");

		System.out.println(changedWord);
	}

	// ejercicio 11
	public static void ultimosEjercicios() {
		System.out.println("ejercicio 11");
		System.out.println(Arrays.toString(ultimosEjercicios));

	}

	/* ejercicio 12 */
	public static void ultimos5Ejercicios() {
		System.out.println(sameNum(2, 8));
		System.out.println(atLeastTwo());
		reversed();
		changeVocal();
		ultimosEjercicios();

	}

}
