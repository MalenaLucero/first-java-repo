package ejerciciosAda;

import java.util.Scanner;

public class Ejercicio214Envios {
	private static final int AMERICA_DEL_NORTE = 11;
	private static final int AMERICA_CENTRAL = 10;
	private static final int AMERICA_DEL_SUR = 12;
	private static final int EUROPA = 24;
	private static final int ASIA = 27;
	private static final int PESO_MAXIMO = 5000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String zona = "";
		//calcular tarifa segun zona
		int tarifa = 0;
		while(tarifa == 0) {
			//pedir zona
			System.out.println("Ingresar la zona:");
			zona = sc.next();
			switch(zona.toLowerCase()) {
			case "norte":
				tarifa = AMERICA_DEL_NORTE;
				break;
			case "central":
				tarifa = AMERICA_CENTRAL;
				break;
			case "sur":
				tarifa = AMERICA_DEL_SUR;
				break;
			case "europa":
				tarifa = EUROPA;
				break;
			case "asia":
				tarifa = ASIA;
				break;
			default:
				System.out.println("Zona de envio incorrecta");
				break;
			}
		}
		
		//pedir peso del paquete
		int peso = 0;
		while(peso < 1) {
			System.out.println("Ingresar el peso del paquete en gramos:");
			peso = sc.nextInt();
			if(peso > PESO_MAXIMO) {
				System.out.println("Peso excesivo");
				peso = 0;
			}
		}
		
		System.out.println("zona: " + zona);
		System.out.println("peso: " + peso + " gramos");
		System.out.println("tarifa: $" + tarifa);
		
		//calcular el precio total
		int precioTotal = peso * tarifa;
		System.out.println("Precio total: $" + precioTotal);
		
		sc.close();
	}
}
