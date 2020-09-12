package ejerciciosAda;

import java.util.Collections;
import java.util.Scanner;

//
//En un trayecto entre dos ciudades se deben realizar paradas intermedias. 
//Se desea conocer cuantas paradas
//se van a realizar en el viaje y la longitud de los trayectos en kilometros. 
//Se desea conocer la longitud
//promedio entre ciudades y 
//cuales son las paradas mas cercanas

//inicio
//*------- * ---------------- * ----- * ----------- *
//   40            100            15      60


public class EjercicioCiudades {
	public static final String TERMINAL_SALIDA = "LEMOS";
	public static final String TERMINAL_LLEGADA = "LACROZE";
	public static final int DISTANCIA_TOTAL = 60;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// CANTIDAD DE ESTACIONES INTERMEDIAS
		System.out.println("Ingresar la cantida de estaciones intermedias");
		int estacionesCantidad = sc.nextInt();
		//int estacionesCantidad = 3;
		
		// NOMBRES DE LAS ESTACIONES
		System.out.println("Ingresar los nombres de las estaciones:");
		String estacionesNombres[] = new String[estacionesCantidad + 2];
		//String estacionesNombres[] = {"LEMOS", "Devoto", "Artigas", "Palermo", "LACROZE"};
		for(int i=0; i < estacionesNombres.length; i++) {
			if(i == 0) {
				estacionesNombres[0] = TERMINAL_SALIDA;
			} else if(i == estacionesNombres.length -1) {
				estacionesNombres[estacionesNombres.length - 1] = TERMINAL_LLEGADA;
			} else {
				System.out.println("Estacion " + i + ":");
				estacionesNombres[i] = sc.next();
			}
			
		}
		//for(String i: estacionesNombres) System.out.print(i + " ");
		
		// DISTANCIA ENTRE LAS ESTACIONES
		int estacionesDistancias[] = new int[estacionesCantidad + 2];
		//int estacionesDistancias[] = {0, 10, 20, 20, 10}; 
		int acumuladorDistancia = 0;
		System.out.println("Ingrese la distancia de las estaciones");
		System.out.println("Tenga en cuenta que la distancia total es " + DISTANCIA_TOTAL);
		for(int i=0; i<estacionesDistancias.length; i++) {
			if(i == 0) {
				estacionesDistancias[0] = 0;
			} else if(i == estacionesDistancias.length -1) {
				estacionesDistancias[estacionesDistancias.length - 1] = DISTANCIA_TOTAL - acumuladorDistancia;
			} else {
				System.out.println(estacionesNombres[i] + ":");
				int distancia = sc.nextInt();
				acumuladorDistancia += distancia;
				while(acumuladorDistancia > DISTANCIA_TOTAL || distancia < 1) {
					acumuladorDistancia -= distancia;
					System.out.println("La distancia es invalida. Ingresela de nuevo:");
					System.out.println(estacionesNombres[i] + ":");
					distancia = sc.nextInt();
					acumuladorDistancia += distancia;
				}
				estacionesDistancias[i] = distancia;
			}
		}
		//for(int i:estacionesDistancias) System.out.print(i + " ");
		
		// UBICACION DEL USUARIO
		System.out.println();
		System.out.println("Ingrese su ubicacion para encontrar la estacion mas cercana:");
		int ubicacion = sc.nextInt();
		//int ubicacion = 31;
		while(ubicacion < 1 || ubicacion > DISTANCIA_TOTAL - 1) {
			System.out.println("Ubicacion invalida. Ingresela de nuevo:");
			ubicacion = sc.nextInt();
		}
		
		// CALCULO DE ESTACION MAS CERCANA
		int indiceEstacionesCercanas[] = new int[2]; 
		int distanciaEstacionesCercanas[] = new int[2];
		int acumulador = 0;
		for(int i=0; i<estacionesDistancias.length; i++) {
			acumulador += estacionesDistancias[i];
			if(ubicacion > acumulador) {
				acumulador += estacionesDistancias[i+1];
				if(ubicacion < acumulador) {
					indiceEstacionesCercanas[0] = i;
					indiceEstacionesCercanas[1] = i + 1;
					distanciaEstacionesCercanas[0] = acumulador - estacionesDistancias[i+1];
					distanciaEstacionesCercanas[1] = acumulador;
					acumulador -= estacionesDistancias[i+1];
				}else {
					acumulador -= estacionesDistancias[i+1];
				}
			}
		}
		//for(int i: distanciaEstacionesCercanas) System.out.println(i);
		
		String estacionMasCercana = null;
		if(ubicacion - distanciaEstacionesCercanas[0] < distanciaEstacionesCercanas[1] - ubicacion) {
			estacionMasCercana = estacionesNombres[indiceEstacionesCercanas[0]];
		} else {
			estacionMasCercana = estacionesNombres[indiceEstacionesCercanas[1]];
		}
		System.out.println();
		System.out.println("La estacion mas cercana es " + estacionMasCercana.toUpperCase());
		
		
		// UBICACION EN PANTALLA
		System.out.println();
		System.out.println("TU UBICACION EN EL MAPA:");
		System.out.println();
		int tramoUbicacion = ubicacion;
		for(int i=0; i<indiceEstacionesCercanas[1]; i++) {
			tramoUbicacion += estacionesNombres[i].length();
			tramoUbicacion += 4;
		}
		System.out.print(String.join("", Collections.nCopies(tramoUbicacion, " ")));
		System.out.print("*");
		System.out.println();
		
		// RECORRIDO DEL TREN
		int aux = 0;
		for(int i=0; i< estacionesNombres.length; i++) {
			String tramo = String.join("", Collections.nCopies(estacionesDistancias[i], "="));
			System.out.print(tramo + " |" + estacionesNombres[i] + "| ");
			aux += estacionesDistancias[i];
		}
		sc.close();
	}

}
