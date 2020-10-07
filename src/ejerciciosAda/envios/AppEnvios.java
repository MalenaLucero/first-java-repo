package ejerciciosAda.envios;

import java.util.Scanner;

public class AppEnvios {
	public static void main(String[] args) {
		System.out.println("Sistema de envios");
		System.out.println();
		
		float pesoEnvio = solicitarPesoEnvio();
		int zona = 0;
		while(pesoEnvio != 0) {
			zona = solicitarZona();
			Paquete paq = new Paquete();
			paq.setPeso(pesoEnvio);
			paq.setZona(zona);
			float precioTotal = paq.calcularPrecio();
			System.out.println("El valor del envio es: " + precioTotal);
			pesoEnvio = solicitarPesoEnvio();
		}
	}

	private static int solicitarZona() {
		System.out.println("Ingrese zona de envio");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static float solicitarPesoEnvio() {
		System.out.println("Ingrese peso del envio");
		Scanner sc = new Scanner(System.in);
		return sc.nextFloat();
	}
	
}
