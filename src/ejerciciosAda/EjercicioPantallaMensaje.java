package ejerciciosAda;

import java.util.Scanner;

//hacer un recuadro con un caracter elegido
//y en la linea del medio, centrado, escribir la palabra pasada por parametro
//el alto del recuadro debe pasarse por parametro

public class EjercicioPantallaMensaje {
	public static final int WIDTH = 90;
	//public static final int HEIGHT = 6;
	public static final String SIMBOLO = "#";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresar palabra:");
		String palabra = sc.nextLine();
		sc.close();
		dibujarPantalla(palabra);
	}

	private static void dibujarPantalla(String palabra) {
		dibujarTrayecto();
		centrarPalabra(palabra, false);
		centrarPalabra(palabra, true);
		centrarPalabra(palabra, false);
		dibujarTrayecto();
	}
	
	private static void centrarPalabra(String palabra, boolean imprimirPalabra) {
		int comienzoPalabra = (WIDTH/2)-(palabra.length()/2);
		int finalPalabra = 0;
		if(palabra.length() % 2 == 0) {
			finalPalabra = (WIDTH/2)+(palabra.length()/2)-1;
		} else {
			finalPalabra = (WIDTH/2)+(palabra.length()/2);
		}
		
		for(int i=0; i<WIDTH; i++) {
			if(i == 0 || i == WIDTH - 1) {
				System.out.print(SIMBOLO);
			} else {
				if(imprimirPalabra) {
					if(i < comienzoPalabra) {
						System.out.print(" ");
					} else if (i == comienzoPalabra) {
						System.out.print(palabra);
					} else if (i > finalPalabra) {
						System.out.print(" ");
					}
				} else {
					System.out.print(" ");
				}
			}
		}
		System.out.println();
	}

	private static void dibujarTrayecto() {
		for(int i=0; i<WIDTH; i++) {
			System.out.print(SIMBOLO);
		}
		System.out.println();
	}
}
