package ejerciciosAda;

import java.util.Scanner;

public class Ejercicio203Lapices {
	private final static int PRECIO_MAYORISTA = 85;
	private final static int PRECIO_MINORISTA = 90;
	private final static int CANTIDAD_MAYORISTA = 1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresar la cantidad de lapices que quiere comprar:");
		int cantidadCompra = sc.nextInt();
		
		int precioTotal = 0;
		if(cantidadCompra >= CANTIDAD_MAYORISTA) {
			precioTotal = cantidadCompra * PRECIO_MAYORISTA;
		} else if (cantidadCompra < CANTIDAD_MAYORISTA && cantidadCompra > 0) {
			precioTotal = cantidadCompra * PRECIO_MINORISTA;
		} else {
			System.out.println("La cantidad ingresada no es valida");
		}
		
		if(precioTotal > 0) {
			System.out.println("Precio total: $" + precioTotal);
		}
		
		sc.close();
	}
}
