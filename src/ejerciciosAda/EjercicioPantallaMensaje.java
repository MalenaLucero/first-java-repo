package ejerciciosAda;

import java.util.Scanner;

//hacer un recuadro con un caracter elegido
//y en la linea del medio, centrado, escribir la palabra pasada por parametro
//el alto del recuadro debe pasarse por parametro

public class EjercicioPantallaMensaje {
	public static final int ANCHO = 90;
	public static final int ALTO = 5;
	public static final String SIMBOLO = "#";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresar palabra:");
		String palabra = sc.nextLine();
		sc.close();
		dibujarPantalla(palabra);
	}

	private static void dibujarPantalla(String palabra) {
		for(int i=0; i<ALTO; i++) {
			if(i == 0 || i == ALTO - 1) {
				dibujarTrayecto(false);
			} else if (i == ALTO/2) {
				centrarPalabra(palabra);
			} else {
				dibujarTrayecto(true);
			}
		}
	}
	
	private static void dibujarTrayecto(boolean centroVacio) {
		for(int i=0; i<ANCHO; i++) {
			if(i == 0 || i == ANCHO - 1) {
				System.out.print(SIMBOLO);
			} else if(centroVacio){
				System.out.print(" ");
			} else {
				System.out.print(SIMBOLO);
			}
		}
		System.out.println();
	}

	private static void centrarPalabra(String palabra) {
		int comienzoPalabra = (ANCHO/2)-(palabra.length()/2);
		int finalPalabra = 0;
		if(palabra.length() % 2 == 0) {
			finalPalabra = (ANCHO/2)+(palabra.length()/2)-1;
		} else {
			finalPalabra = (ANCHO/2)+(palabra.length()/2);
		}
		
		for(int i=0; i<ANCHO; i++) {
			if(i == 0 || i == ANCHO - 1) {
				System.out.print(SIMBOLO);
			} else if (i < comienzoPalabra || i > finalPalabra){
				System.out.print(" ");
			} else if (i == comienzoPalabra) {
				System.out.print(palabra);
			}
		}
		System.out.println();
	}
}
