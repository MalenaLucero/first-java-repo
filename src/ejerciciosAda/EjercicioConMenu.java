package ejerciciosAda;

import java.util.Scanner;

//Ejercicio : 
//Desarrollar un sistema que permita el ingreso de totales recaudados de lunes a viernes, 
//donde ademas se pueda modificar uno de los valores ingresados seleccionando el numero de dia.
//Tambien se deberan poder listar los valores ingresados.(opcional ordenado de mayor a menor)
//Todas las funciones se codificaran en un menu con valores enteros hasta que el usuario ingrese 
//cero para salir. (1. agregar  2. listar 3. modificar 0. salir)

public class EjercicioConMenu {
	public static final String DIAS[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
	public static final String OPCIONES_MENU[] = {
			"1. Agregar valores totales recaudados",
			"2. Listas los valores totales recaudados",
			"3. Modificar los valores totales recaudados",
			"0. Salir"
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = -1;
		int totalesRecaudados[] = new int[DIAS.length];
		
		while(opcion != 0) {
			System.out.println("Ingresar opcion");
			imprimirMenu();
			opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println(OPCIONES_MENU[0]);
				AgregarValores(totalesRecaudados, sc);
				break;
			case 2:
				System.out.println(OPCIONES_MENU[1]);
				ListarValores(totalesRecaudados);
				break;
			case 3:
				System.out.println(OPCIONES_MENU[2]);
				ModificarValores(totalesRecaudados, sc);
				break;
			default:
				System.out.println("Ninguna de las anteriores");
				break;
			}
		}
		System.out.println("Gracias por usar este programa");
	}

	private static void ModificarValores(int[] totalesRecaudados, Scanner sc) {
		System.out.println("Ingresar numero de dia:");
		int dia = sc.nextInt();
		System.out.println("Ingresar valor modificado:");
		totalesRecaudados[dia-1] = sc.nextInt();
		System.out.println("Nuevo valor del dia " + DIAS[dia] + ": " + totalesRecaudados[dia-1]);
	}

	private static void ListarValores(int[] totalesRecaudados) {
		for(int i: totalesRecaudados) System.out.print(i + " ");
		System.out.println();
	}

	private static void AgregarValores(int[] totalesRecaudados, Scanner sc) {
		for(int i=0; i<totalesRecaudados.length; i++) {
			System.out.println("Ingrese el total recaudado del " + DIAS[i] + ":");
			totalesRecaudados[i] = sc.nextInt();
		}
		System.out.println("carga finalizada");
	}

	private static void imprimirMenu() {
		for(String i: OPCIONES_MENU) System.out.println(i);
	}
}
