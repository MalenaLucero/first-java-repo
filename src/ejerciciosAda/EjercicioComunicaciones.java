package ejerciciosAda;

import java.util.Scanner;

//Una empresa de comunicaciones ofrece servicio de telefonía, banda ancha y tv digital. 
//Cada uno de los servicios tiene un precio diferente 
//(Telefonía: 10, Banda ancha: 15, TV, 20).
//Se desea contar cuántos clientes optan por cada servicio
//para luego conocer la facturación de cada uno de los servicios.
//Se deben ingresar los clientes por número (cliente = 0 para finalizar) 


public class EjercicioComunicaciones {
	private static final int TELEFONIA_TARIFA = 10;
	private static final int BANDA_ANCHA_TARIFA = 15;
	private static final int TV_TARIFA = 20;
	
	
	public static void main(String[] args) {
		int servicios[] = { 0, 0, 0 }; //telefonia, banda ancha, tv 
		int clientes[] = new int[100];
		
		Scanner sc = new Scanner(System.in);
		int cliente = -1;
		int clientesAcumulador = 0;
		while(cliente != 0) {
			System.out.println("Ingrese el numero de cliente");
			cliente = sc.nextInt();
			if(cliente != 0) {
				clientes[clientesAcumulador] = cliente;
				System.out.println("Ingrese servicio");
				int servicio = sc.nextInt();
				if(servicio == 1) {
					servicios[0] += 1;
				} else if(servicio == 2) {
					servicios[1] += 1;
				} else if(servicio == 3){
					servicios[2] += 1;
				}
			}
		}
		System.out.println(servicios[0]);
		System.out.println(servicios[1]);
		System.out.println(servicios[2]);
	}
}
