package ejerciciosAda;

import java.util.Collections;
import java.util.Scanner;

public class EjercicioCiudadesSimple {
	public static void main(String[] args) {
				mostrarTitulo("Bienvenido al programa");
				
				int distanciaEntreEstaciones[] = solicitarInformacion();
				
				for(int i:distanciaEntreEstaciones) {
					dibujarTrayecto(i, "=");
					System.out.print("*");
				}
	}
	
	private static int[] solicitarInformacion() {
		Scanner sc = new Scanner(System.in);
		
		// CANTIDAD DE ESTACIONES INTERMEDIAS
		System.out.println("Ingresar la cantida de estaciones intermedias");
		int estacionesCantidad = sc.nextInt();
		
		int estacionesDistancias[] = new int[estacionesCantidad];
		System.out.println("Ingrese la distancia de las estaciones");
		for(int i=0; i<estacionesDistancias.length; i++) {
				System.out.println("Estacion " + (i+1) + ":");
				int distancia = sc.nextInt();
				estacionesDistancias[i] = distancia;
		}
		sc.close();
		
		return estacionesDistancias;
	}

	private static void mostrarTitulo(String titulo) {
		dibujarTrayecto(titulo.length(), "=");
		System.out.println();
		System.out.println(titulo.toUpperCase());
		dibujarTrayecto(titulo.length(), "=");
		System.out.println();
	}

	private static void dibujarTrayecto(int distancia, String simbolo) {
		for(int i=0; i<distancia; i++) {
			System.out.print(simbolo);
		}
	}
}
