package ejerciciosAda;

import java.util.Scanner;

public class EjercicioAhorcado {
	public static final int INTENTOS = 5;
	
	public static void main(String[] args) {
		imprimirTitulo();
		Scanner sc = new Scanner(System.in);
		String palabraSecreta = cargarPalabraSecreta(sc);
		boolean espacios[] = inicializarArrayBooleanos(palabraSecreta);
		int errores = 0;
		imprimirMensajeInicial();
		
		while(!partidaTerminada(espacios) && errores < INTENTOS) {
			imprimirProgreso(espacios, palabraSecreta);
			char letra = cargarLetra(sc);
			boolean letraIncluida = palabraSecreta.indexOf(letra) != -1;
			if(letraIncluida) {
				procesarLetra(letra, espacios, palabraSecreta);
				System.out.println("Muy bien!");
			} else {
				errores++;
				imprimirIntentosRestantes(errores);
			}
		}
		imprimirEstado(errores);
		imprimirPalabraSecreta(palabraSecreta);
	}
	
	private static void imprimirMensajeInicial() {
		System.out.println();
		System.out.println("Tenés " + INTENTOS + " intentos");
		System.out.println("Empezamos!");
	}

	private static void imprimirTitulo() {
		String titulo = "Bienvenido al juego del ahorcado!";
		dibujarTrayecto(titulo.length(), "~");
		System.out.println();
		System.out.println(titulo.toUpperCase());
		dibujarTrayecto(titulo.length(), "~");
		System.out.println();
	}

	private static void imprimirIntentosRestantes(int errores) {
		int intentosRestantes = INTENTOS - errores;
		System.out.println();
		System.out.println("No :(");
		System.out.println("Te quedan " + intentosRestantes + " intentos");
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

	private static void procesarLetra(char letra, boolean[] espacios, String palabraSecreta) {
		for(int i=0; i<palabraSecreta.length(); i++) {
			if(palabraSecreta.charAt(i) == letra) {
				espacios[i] = true;
			}
		}
	}

	private static char cargarLetra(Scanner sc) {
		System.out.println("Ingresá una letra:");
		String letra = sc.next();
		return letra.charAt(0);
	}

	private static boolean partidaTerminada(boolean[] espacios) {
		for(boolean b:espacios) {
			if(!b) return false;
		}
		return true;
	}

	private static String cargarPalabraSecreta(Scanner sc) {
		System.out.println("Ingresá la palabra secreta:");
		return sc.next();
	}

	private static boolean[] inicializarArrayBooleanos(String palabraSecreta) {
		boolean arr[] = new boolean[palabraSecreta.length()];
		for(boolean b: arr) b=false;
		return arr;
	}

	private static void imprimirProgreso(boolean[] espacios, String palabraSecreta) {
		System.out.println();
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
	
	private static void dibujarTrayecto(int longitud, String simbolo) {
		for(int i=0; i<longitud; i++) {
			System.out.print(simbolo);
		}
	}
}
