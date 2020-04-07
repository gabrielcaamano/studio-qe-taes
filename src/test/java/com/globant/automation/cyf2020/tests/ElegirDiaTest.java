package com.globant.automation.cyf2020.tests;

import java.util.Scanner;

import org.testng.annotations.Test;

public class ElegirDiaTest {

	@Test
	public void diaDeLaSemana() {
		ElegirDia Lunes = ElegirDia.LUNES;

		// Devuelve un String con el nombre de la constante
		System.out.println(Lunes.name());
		System.out.println(Lunes.toString());

		// Devuelve el contenido de los atributos
		System.out.println(Lunes.getMensaje());

		switchDiaSemana(1);

	}

	public void switchDiaSemana(int opcion) {

		Scanner sn = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println(" ");
			System.out.println("1. Lunes");
			System.out.println("2. Martes");
			System.out.println("3. Miercoles");
			System.out.println("4. Jueves");
			System.out.println("5. Viernes");
			System.out.println("6. Sabado");
			System.out.println("7. Domingo");
			System.out.println("10. Salir");
			System.out.println(" ");

			System.out.println("--- Seleccione uno de los dias de la semana ---");
			System.out.println(" ");
			opcion = sn.nextInt();
			
			
			System.out.println("EL MENSAJE PARA ESTE DIA ES: " + ElegirDia.values()[opcion - 1].getMensaje());
			/*
			switch (opcion) {
			case 1:
				ElegirDia Lunes = ElegirDia.LUNES;
				System.out.println("EL MENSAJE PARA ESTE DIA ES: " + Lunes.getMensaje());
				break;
			case 2:
				ElegirDia Martes = ElegirDia.MARTES;
				System.out.println("EL MENSAJE PARA ESTE DIA ES: " + Martes.getMensaje());
				break;
			case 3:
				ElegirDia Miercoles = ElegirDia.MIERCOLES;
				System.out.println("EL MENSAJE PARA ESTE DIA ES: " + Miercoles.getMensaje());
				break;
			case 4:
				ElegirDia Jueves = ElegirDia.JUEVES;
				System.out.println("EL MENSAJE PARA ESTE DIA ES: " + Jueves.getMensaje());
				break;
			case 5:
				ElegirDia Viernes = ElegirDia.VIERNES;
				System.out.println("EL MENSAJE PARA ESTE DIA ES: " + Viernes.getMensaje());

				break;
			case 6:
				ElegirDia Sabado = ElegirDia.SABADO;
				System.out.println("EL MENSAJE PARA ESTE DIA ES: " + Sabado.getMensaje());
				break;
			case 7:
				ElegirDia Domingo = ElegirDia.DOMINGO;
				System.out.println("EL MENSAJE PARA ESTE DIA ES: " + Domingo.getMensaje());
				break;

			case 10:
				salir = true;
				System.out.println("Se termina el ejercicio");
				break;
			default:
				System.out.println("Solo números entre 1 y 7");
			}  */

		} 

	}

}
