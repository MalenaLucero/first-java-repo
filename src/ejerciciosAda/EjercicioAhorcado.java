package ejerciciosAda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class EjercicioAhorcado {
	public static final int INTENTOS = 5;
	
	public static void main(String[] args) throws IOException {
		imprimirTitulo();
		Scanner sc = new Scanner(System.in);
		//String palabraSecreta = cargarPalabraSecreta(sc);
		String palabraSecreta = getPalabra();
		System.out.println(palabraSecreta);
		boolean espacios[] = inicializarArrayBooleanos(palabraSecreta);
		int errores = 0;
		int intentos = 0;
		char letrasIngresadas[] = new char[palabraSecreta.length() + INTENTOS];
		imprimirMensajeInicial();
		
		while(!partidaTerminada(espacios) && errores < INTENTOS) {
			imprimirProgreso(espacios, palabraSecreta);
			char letra = cargarLetra(sc);
			if(!letraYaIngresada(letrasIngresadas, letra)) {
				letrasIngresadas[intentos] = letra;
				intentos++;
				if(palabraSecreta.indexOf(letra) != -1) {
					procesarLetra(letra, espacios, palabraSecreta);
					System.out.println("Muy bien!");
				} else {
					errores++;
					imprimirIntentosRestantes(errores);
				}
			} else {
				errores++;
				imprimirIntentosRestantes(errores);
			}
		}
		imprimirEstado(errores);
		imprimirPalabraSecreta(palabraSecreta);
	}

	private static void imprimirPersonita() {
		System.out.println(" O");
		System.out.print("/" + "|" + "\\");
		System.out.println();
		System.out.print("/ " + "\\");
	}

	private static boolean letraYaIngresada(char[] letrasIngresadas, char letra) {
		for(char c: letrasIngresadas) {
			if(c == letra) return true;
		}
		return false;
	}

	private static void imprimirMensajeInicial() {
		System.out.println();
		System.out.println("Tenés " + INTENTOS + " intentos");
		System.out.println("Empezamos!");
	}

	private static void imprimirTitulo() {
		String titulo = "Bienvenido al juego del ahorcado";
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
		return Character.toUpperCase(sc.next().charAt(0));
	}

	private static boolean partidaTerminada(boolean[] espacios) {
		for(boolean b:espacios) {
			if(!b) return false;
		}
		return true;
	}

	private static String cargarPalabraSecreta(Scanner sc) {
		System.out.println("Ingresá la palabra secreta:");
		return sc.next().toUpperCase();
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
	
	private static String getPalabra() throws IOException {
		System.out.println("Buscando palabra en ingles...");
		URL url = new URL("https://random-word-api.herokuapp.com/word?number=1");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		in.close();
		return content.substring(2, content.length() - 2).toUpperCase();
	}
}
