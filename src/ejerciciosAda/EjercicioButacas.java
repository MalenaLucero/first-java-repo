package ejerciciosAda;

import java.util.Scanner;

//Se venden boletos de una funcion numerados del 0-49. Cada uno de esos boletos
//se corresponde con un asiento
//Solicitar que asiento elige la persona al  comprarlo y marcarlo con un valor 1
//hasta que se ingrese asiento numero 99
//Listar los asientos vendidos

public class EjercicioButacas {
	private static final int ASIENTOS_DISPONIBLES = 10;
	
	public static void main(String[] args) {
		mostrarTitulo("Bienvenido al sistema de venta de boletos");
		int asientos[] = new int[ASIENTOS_DISPONIBLES];
		asientos = inicializarAsientos(asientos);
		int totalAsientosOcupados = procesamiento(asientos);
		
		System.out.println("Asientos ocupados: " + totalAsientosOcupados);
		int asientosLibres = ASIENTOS_DISPONIBLES - totalAsientosOcupados;
		System.out.println("Asientos libres: " + asientosLibres);
		
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

	private static int procesamiento(int[] asientos) {
		int totalAsientosOcupados = 0;
		int asientoSolicitado = 0;
		Scanner sc = new Scanner(System.in);
		while(asientoSolicitado != 99) {
			System.out.println("Ingresar numero de asiento");
			asientoSolicitado = sc.nextInt();
			boolean asientoValido = validarAsiento(asientoSolicitado);
			if(asientoValido) {
				if(asientos[asientoSolicitado -1] == 0) {
					System.out.println("Asiento disponible. Venta confirmada");
					asientos[asientoSolicitado -1] = 1;
					totalAsientosOcupados += 1;
				} else {
					System.out.println("Asiento no disponible");
				}
			} else if(!asientoValido && asientoSolicitado != 99) {
				System.out.println("Asiento invalido");
			}
		}
		if(totalAsientosOcupados == asientos.length) {
			System.out.println("Ya no quedan asientos disponibles");
		}
		sc.close();
		return totalAsientosOcupados;
	}

	private static int[] inicializarAsientos(int[] asientos) {
		for(int i=0; i<asientos.length; i++) {
			asientos[i] = 0;
		}
		return asientos;
	}

	private static boolean validarAsiento(int asiento) {
		if(asiento > 0 && asiento < ASIENTOS_DISPONIBLES + 1) {
			return true;
		} else {
			return false;
		}
	}
}
