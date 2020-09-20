package ejerciciosAda;

import java.util.Arrays;
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
			"2. Listar los totales recaudados por dia",
			"3. Listar los totales recaudados de menor a mayor",
			"4. Modificar los valores totales recaudados",
			"0. Salir"
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = -1;
		int totalesRecaudados[] = new int[DIAS.length];
		
		while(opcion != 0) {
			imprimirMenu();
			opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				imprimirTitulo(opcion);
				AgregarValores(totalesRecaudados, sc);
				break;
			case 2:
				imprimirTitulo(opcion);
				ListarValoresPorDia(totalesRecaudados);
				break;
			case 3:
				imprimirTitulo(opcion);
				ListarValoresOrdenados(totalesRecaudados);
				break;
			case 4:
				imprimirTitulo(opcion);
				ModificarValores(totalesRecaudados, sc);
				break;
			}
		}
		System.out.println();
		System.out.println("Gracias por usar este programa");
	}
	
	private static void imprimirTitulo(int i) {
		String titulo = OPCIONES_MENU[i - 1];
		dibujarTrayecto(titulo.length(), "=");
		System.out.println(titulo.toUpperCase());
		dibujarTrayecto(titulo.length(), "=");
		System.out.println();
	}

	private static void ListarValoresOrdenados(int[] totalesRecaudados) {
		int aux[] = totalesRecaudados.clone();
		Arrays.sort(aux);
		for(int i: aux) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void ModificarValores(int[] totalesRecaudados, Scanner sc) {
		System.out.println("Ingresar numero de dia:");
		int dia = sc.nextInt();
		System.out.println("Ingresar valor modificado:");
		totalesRecaudados[dia-1] = sc.nextInt();
		System.out.println("Nuevo valor del dia " + DIAS[dia-1] + ": " + totalesRecaudados[dia-1]);
	}

	private static void ListarValoresPorDia(int[] totalesRecaudados) {
		for(int i=0; i<totalesRecaudados.length; i++) {
			System.out.println(DIAS[i] + ": " + totalesRecaudados[i]);
		}
	}

	private static void AgregarValores(int[] totalesRecaudados, Scanner sc) {
		for(int i=0; i<totalesRecaudados.length; i++) {
			System.out.println("Ingrese el total recaudado del " + DIAS[i] + ":");
			totalesRecaudados[i] = sc.nextInt();
		}
		System.out.println("carga finalizada");
	}

	private static void imprimirMenu() {
		System.out.println();
		System.out.println("-----------------MENU-----------------");
		for(String i: OPCIONES_MENU) System.out.println(i);
		System.out.println("--------------------------------------");
		System.out.println("Ingresar opcion:");
	}
	
	private static void dibujarTrayecto(int longitud, String simbolo) {
		for(int i=0; i<longitud; i++) {
			System.out.print(simbolo);
		}
		System.out.println();
	}
}
