package ejerciciosAda;

import java.util.Scanner;

//Se venden boletos de una funcion numerados del 0-49. Cada uno de esos boletos
//se corresponde con un asiento
//Solicitar que asiento elige la persona al  comprarlo y marcarlo con un valor 1
//hasta que se ingrese asiento numero 99
//Listar los asientos vendidos

public class EjercicioButacas {
	private static final int ASIENTOS_DISPONIBLES = 50;
	
	public static void main(String[] args) {
		mostrarTitulo("Bienvenido al sistema de venta de boletos");
		int asientosCargados[] = cargarAsientos();
		int asientosOcupados[] = filtrarAsientos(asientosCargados, 1);
		int asientosLibres[] = filtrarAsientos(asientosCargados, 0);
		imprimirAsientos(asientosOcupados, "ocupados");
		imprimirAsientos(asientosLibres, "libres");
		imprimirTeatro(asientosCargados, 5);
	}
	
	private static void mostrarTitulo(String titulo) {
		dibujarTrayecto(titulo.length(), "=");
		System.out.println();
		System.out.println(titulo.toUpperCase());
		dibujarTrayecto(titulo.length(), "=");
		System.out.println();
	}
	
	private static int[] cargarAsientos() {
		int asientos[] = inicializarAsientos();
		Scanner sc = new Scanner(System.in);
		int asientoSolicitado = 0;
		boolean teatroLleno = false;
		while(asientoSolicitado != 99 && !teatroLleno) {
			System.out.println("Ingresar numero de asiento o 99 para finalizar:");
			asientoSolicitado = sc.nextInt();
			boolean asientoValido = validarAsiento(asientoSolicitado);
			if(asientoValido) {
				boolean asientoVacio = verificarAsientoVacio(asientoSolicitado, asientos);
				if(asientoVacio) {
					System.out.println("Asiento disponible. Venta confirmada");
					asientos[asientoSolicitado -1] = 1;
					teatroLleno = verificarTeatroLleno(asientos);
				} else {
					System.out.println("Asiento no disponible");
				}
			} else if(!asientoValido && asientoSolicitado != 99) {
				System.out.println("Asiento invalido");
			}
		}
		if(teatroLleno) {
			System.out.println("Teatro Lleno. No quedan mas asientos disponibles");
		}
		dibujarTrayecto(30, "-");
		System.out.println();
		System.out.println("Carga de asientos finalizada".toUpperCase());
		sc.close();
		return asientos;
	}
	
	private static int[] inicializarAsientos() {
		int asientos[] = new int[ASIENTOS_DISPONIBLES];
		for(int i:asientos) {
			i = 0;
		}
		return asientos;
	}	

	private static void dibujarTrayecto(int longitud, String simbolo) {
		for(int i=0; i<longitud; i++) {
			System.out.print(simbolo);
		}
	}

	private static boolean verificarTeatroLleno(int[] asientos) {
		boolean flag = true;
		for(int i=0; i<asientos.length; i++) {
			if(asientos[i] == 0) {
				flag = false;
			}
		}
		return flag;
	}

	private static boolean verificarAsientoVacio(int asientoSolicitado, int[] asientos) {
		if(asientos[asientoSolicitado -1] == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean validarAsiento(int asiento) {
		if(asiento > 0 && asiento < ASIENTOS_DISPONIBLES + 1) {
			return true;
		} else {
			return false;
		}
	}
	
	private static int[] filtrarAsientos(int[] asientosCargados, int tipo) {
		int acumulador = 0;
		for(int i=0; i<asientosCargados.length; i++) {
			if(asientosCargados[i] == tipo) acumulador += 1;
		}
		int asientosOcupados[] = new int[acumulador];
		int nuevoAcumulador = 0;
		for(int i=0; i<asientosOcupados.length; i++) {
			boolean flag = true;
			while(flag) {
				if(asientosCargados[nuevoAcumulador] == tipo) {
					asientosOcupados[i] = nuevoAcumulador + 1;
					nuevoAcumulador += 1;
					flag = false;
				} else {
					nuevoAcumulador += 1;
				}
			}
		}
		return asientosOcupados;
	}
	
	private static void imprimirAsientos(int[] asientos, String tipo) {
		dibujarTrayecto(30, "-");
		System.out.println();
		int total = asientos.length;
		System.out.println("Total de asientos " + tipo + ": " + total);
		System.out.print("Asientos " + tipo + ": ");
		imprimirArray(asientos);
		System.out.println();
	}
	
	private static void imprimirArray(int[] arr) {
		for(int i:arr) System.out.print(i + " ");
	}
	
	private static void imprimirTeatro(int[] asientosCargados, int filas) {
		System.out.println();
		int corte = asientosCargados.length/filas;
		int acumulador = 0;
		for(int i=0; i<asientosCargados.length; i++) {
			imprimirAsiento(asientosCargados[i]);
			acumulador += 1;
			if(acumulador == corte) {
				System.out.println();
				acumulador = 0;
			}
		}
	}
	
	private static void imprimirAsiento(int num) {
		if(num == 0) {
			System.out.print(" ○");
		} else {
			System.out.print(" ●");
		}
	}
}
