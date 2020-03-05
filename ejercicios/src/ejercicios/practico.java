package ejercicios;
import java.util.Arrays;
import java.util.Scanner;

public class practico {
	
	public static void main(String[] args) {
		
		 Scanner sn = new Scanner(System.in);
	       boolean salir = false;
	       int opcion; //Guardarda la opcion del/la usuarix
	       int guardar[] = new int[5];
	       int i = 0;
	       while(!salir){
	            
	           System.out.println("1. Opcion 1");
	           System.out.println("2. Opcion 2");
	           System.out.println("3. Opcion 3");
	           System.out.println("4. Opcion 4");
	           System.out.println("5. Opcion 5");
	           System.out.println("6. Opcion 6");
	           System.out.println("7. Opcion 7");
	           System.out.println("8. Opcion 8");
	           System.out.println("9. Opcion 9");
	           System.out.println("10.Opcion 10");
	           System.out.println("11. Salir");
	            
	           System.out.println("Seleccione uno de los ejercicios");
	           opcion = sn.nextInt();
	          
	           
	          
	           
	         
	           
	           switch(opcion){
	               case 1:
	                   System.out.println("Has seleccionado la opcion 1");
	                   guardar[i] = 1;
	                   i = i + 1;
	                   ejercicio1('F');
	                   break;
	               case 2:
	                   System.out.println("Has seleccionado la opcion 2");
	                   guardar[i] = 2;
	                   i = i + 1;
	                   ejercicio2();
	                   break;
	               case 3:
	                   System.out.println("Has seleccionado la opcion 3");
	                   guardar[i] = 3;
	                   i = i + 1;
	                   ejercicio3();
	                   break;
	               case 4:
		               System.out.println("Has seleccionado la opcion 4");
		               guardar[i] = 4;
		               i = i + 1;
		               ejercicio4();
		                   break;
	                case 5:
		               System.out.println("Has seleccionado la opcion 5");
		               guardar[i] = 5;
		               i = i + 1;
		               ejercicio5(123454321);
		               i = i + 1;
		                   break;
	                case 6:
		                   System.out.println("Has seleccionado la opcion 6");
		                   guardar[i] = 6;
		                   i = i + 1;
		                   ejercicio6();
		                   break;
	                case 7:
		                   System.out.println("Has seleccionado la opcion 7");
		                   guardar[i] = 7;
		                   i = i + 1;
		                   ejercicio7();
		                   break;
		            case 8:
		                   System.out.println("Has seleccionado la opcion 8");
		                   guardar[i] = 8;
		                   i = i + 1;
		                   ejercicio8();
		                   
		                   break;
	                case 9:
		                   System.out.println("Has seleccionado la opcion 9");
		                   guardar[i] = 9;
		                   i = i + 1;
		                   ejercicio9();
		                   break;
	                case 10:
		                   System.out.println("Has seleccionado la opcion 10");
		                   guardar[i] = 10;
		                   i = i + 1;
		                   ejercicio10();
		                   break;
	                case 11:
	                   salir=true;
	                    System.out.println(Arrays.toString(guardar));
	                   break;
	                default:
	                   System.out.println("Solo números entre 1 y 11");
	           }
	           if(guardar[4] > 0) {
	        	   i = 4;
	        	   guardar[0] = guardar[1];
	        	   guardar[1] = guardar[2];
                   guardar[2] = guardar[3];
                   
                   guardar[3] = guardar[4];
                   
	           }
	       }
	        
	    }
	     
	
		

	public static void ejercicio1(char fOm) {
		System.out.println("ingrese F si su genero es femenino o M si es masculino");
		System.out.println("si presiona F le da true y si presiona M le da false");
		char femenino = 'F';
		char masculino = 'M';
		
		
		if(fOm == femenino) {
			
		System.out.println(true);
			
		} else if (fOm == masculino) {
			System.out.println(false);
		} else {
			System.out.println((String)null);
		}
	
		
		
	} 
	
public static void ejercicio2() {
		
		System.out.println("este es el ejercicio 2");
		
		int[] numer = {1, 2, 3, 4, 5};
		

		
		int suma = numer[2] + numer[3] + numer[4]; 
		
		System.out.println(suma);
		
		int resultado = suma / 2; 
		
		if (resultado * 2 == suma) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		
		}
	
	
	
public static void ejercicio3() {
	
	System.out.println("este es el ejercicio 3");
	
	int[] numer = {1, 3, 6, 3, 3, 3, 7, 3, 3, 13};
	
	int ui = 0;
	
	for (int i = 0; numer.length > i && ui == 0 ; i++) {
       
		int resultado =  numer[i] / 2; 
		
		if (resultado * 2 == numer[i]){
			ui = ui +1;
			System.out.println(true);
			
		} 
		}
	
    if (ui == 0) {
    	System.out.println(false);
    }
} 


public static void ejercicio4() {
	
	System.out.println("este es el ejercicio 4");
	
	String palabra1 = "hola";
	String palabra2 = "hola";
	
	if (palabra1 == palabra2 || (palabra1 != null && palabra1.equals(palabra2))) {
		System.out.println(true);
	}
	else {
		System.out.println(false);
	}
	
	
}

public static void ejercicio5(int numerosC) {
	System.out.println("este es el ejercicio 9");
	
	int cadenaNum = numerosC;
	
	String sCadenaNum = Integer.toString(cadenaNum);
	String sCadenaInvertida = ""; 
	for (int x=sCadenaNum.length()-1;x>=0;x--) {
		 sCadenaInvertida = sCadenaInvertida + sCadenaNum.charAt(x);
	
}  
	
	System.out.println(sCadenaInvertida.equals(sCadenaNum));



} 

public static void ejercicio6() {
	System.out.println("este es el ejercicio 6");
	int a = 33;
	int b = 2;
	
	if (a < b) {
		System.out.println(false);
	} else { System.out.println(false); } 
}

public static void ejercicio7() {
	System.out.println("este es el ejercicio 7");
	int a = 33;
	int b = 2;
	
	if ((a * b) == (a / b)) {
		System.out.println(true);
	} else { System.out.println(false); } 
}

public static void ejercicio8() {
	System.out.println("este es el ejercicio 8");
	
	int[]  cadenA = {1, 10, 11, 2, 3, 9, 12, 3, 3, 13};

	int[]  cadenB = {2, 3, 2, 2, 2, 3, 2, 2, 2, 12};
	
	int incrementador = 0;
	
	for (int a = 0, t = 0; cadenA.length > t ;t++ ) {
		   a = cadenA[t]; 
		for (int b = 0, i = 0; cadenA.length > i ; i++) {
			 b = cadenB[i];
			if (b == a) {
				incrementador = incrementador + 1;
				cadenB[i] = cadenB[i]  + 50;
				break;
			}
		}
	}
	
	System.out.println(incrementador);
	
} 

public static void ejercicio9() {
	System.out.println("Ingrese un texto o palabra:");
	Scanner scan9 = new Scanner(System.in);
	String sCadena = scan9.nextLine();
	String sCadenaInvertida = "";
	for (int x=sCadena.length()-1;x>=0;x--) {
		 sCadenaInvertida = sCadenaInvertida + sCadena.charAt(x);
	
}  
	
	System.out.println(sCadenaInvertida);



} 


public static void ejercicio10() {
	System.out.println("Ingrese una palabra y sus vocales seran cambiadas:");
	
	Scanner scan9 = new Scanner(System.in);
	String sCadena = scan9.nextLine();
	
	sCadena = sCadena.replace('a','x').replace('e','x').replace('i','x')
            .replace('o','x').replace('u','x');
    String respuesta = "Respuesta: ";
    System.out.println(respuesta + sCadena);

} 




}









