package ejerciciosAda;

import java.util.Scanner;

public class EjercicioAhorcado {
	public static final int INTENTOS = 5;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palabraSecreta = cargarPalabraSecreta(sc);
		boolean espacios[] = inicializarArrayBooleanos(palabraSecreta);
		int errores = 0;
		
		while(!partidaTerminada(espacios) && errores < INTENTOS) {
			imprimirProgreso(espacios, palabraSecreta);
			char letra = cargarLetra(sc);
			boolean letraIncluida = procesarLetra(letra, espacios, palabraSecreta);
			if(!letraIncluida) errores++;
			imprimirIntentosRestantes(letraIncluida, errores);
		}
		
		imprimirEstado(errores);
		imprimirPalabraSecreta(palabraSecreta);
		
	}

	private static void imprimirIntentosRestantes(boolean letraIncluida, int errores) {
		System.out.println();
		if(letraIncluida) {
			System.out.println("Muy bien!");
		} else {
			System.out.println("Ño :(");
		}
		int intentosRestantes = INTENTOS - errores;
		System.out.println("Te quedan " + intentosRestantes + " intentos");
		System.out.println();
	}

	private static void imprimirPalabraSecreta(String palabraSecreta) {
		System.out.println("La palabra secreta era " + palabraSecreta);
	}

	private static void imprimirEstado(int errores) {
		System.out.println();
		System.out.println("PARTIDA TERMINADA!");
		if(errores < INTENTOS) {
			System.out.println("GANASTE!");
		} else {
			System.out.println("PERDISTE :(");
		}
	}

	private static boolean procesarLetra(char letra, boolean[] espacios, String palabraSecreta) {
		boolean letraIncluida = false;
		for(int i=0; i<palabraSecreta.length(); i++) {
			if(palabraSecreta.charAt(i) == letra) {
				espacios[i] = true;
				letraIncluida = true;
			}
		}
		return letraIncluida;
	}

	private static char cargarLetra(Scanner sc) {
		System.out.println("Ingresar una letra:");
		String letraString = sc.next();
		char letraChar = letraString.charAt(0);
		return letraChar;
	}

	private static boolean partidaTerminada(boolean[] espacios) {
		boolean terminado = true;
		for(boolean b:espacios) {
			if(!b) terminado = false; 
		}
		return terminado;
	}

	private static String cargarPalabraSecreta(Scanner sc) {
		System.out.println("Ingrese la palabra secreta:");
		String palabra = sc.next();
		return palabra;
	}

	private static boolean[] inicializarArrayBooleanos(String palabraSecreta) {
		boolean arr[] = new boolean[palabraSecreta.length()];
		for(boolean b: arr) b=false;
		return arr;
	}

	private static void imprimirProgreso(boolean[] espacios, String palabraSecreta) {
		for(int i=0; i<espacios.length; i++) {
			if(espacios[i]) {
				System.out.print(palabraSecreta.charAt(i) + " "); 
			} else {
				System.out.print("_ ");
			}
		}
		System.out.println();
		System.out.println();
	}

	private static void imprimirArray(boolean[] arr) {
		for(boolean b: arr) System.out.print(b + " ");
		System.out.println();
	}
}
