package ejerciciosAda;

import java.util.Scanner;
//paquetes con miniscula y guiones

//un tablero de 3x3
//dos jugadores que ingresan las coordenadas por teclado
//una vez que lo tengo, muestro el tablero
//verificar si es posible la posicion y ver si hay ganador
//mientras no haya ganador continua el siguiente

public class EjercicioTateti {
	public static int FILAS = 3;
	private static int COLUMNAS = 3;
	
	public static void main(String[] args) {
		imprimirTitulo();
		Scanner sc = new Scanner(System.in);
		char tablero[][] = inicializarTablero();
		String nombreJugadores[] = ingresarNombreJugadores(sc);
		boolean jugadores[] = {true, false};
		int contador = 0;
		
		while(!partidaTerminada(tablero) && contador < 9) {
			mostrarTurno(jugadores, nombreJugadores);
			ingresarJugada(jugadores, tablero, sc);
			mostrarTablero(tablero);
			if(!partidaTerminada(tablero)) {
				contador++;
				cambiarJugador(jugadores);
			}; 
		}
		sc.close();
		
		imprimirMensajeFinal(contador, jugadores, nombreJugadores);	
	}

	private static void imprimirMensajeFinal(int contador, boolean[] jugadores, String[] nombreJugadores) {
		System.out.println();
		System.out.println("¡PARTIDA TERMINADA!");
		if(contador < 9) {
			imprimirGanador(jugadores, nombreJugadores);
		} else {
			System.out.println("No gano nadie :(");
		}
	}

	private static String[] ingresarNombreJugadores(Scanner sc) {
		String nombres[] = new String[2];
		for(int i=0; i<nombres.length; i++) {
			System.out.println("Ingrese el nombre del jugador " + (i+1));
			nombres[i] = sc.next();
		}
		return nombres;
	}

	private static void imprimirTitulo() {
		String titulo = "      TATETI      ";
		dibujarTrayecto(titulo.length(), "=");
		System.out.println(titulo);
		dibujarTrayecto(titulo.length(), "=");
	}

	private static void mostrarTurno(boolean[] jugadores, String[] nombres) {
		System.out.println();
		if(jugadores[0]) {
			System.out.println("Turno de " + nombres[0] + ":");
		} else {
			System.out.println("Turno de " + nombres[1] + ":");
		}
		
	}

	private static void imprimirGanador(boolean[] jugadores, String[] nombres) {
		String nombreGanador = null;
		if(jugadores[0]) {
			nombreGanador = nombres[0];
		} else {
			nombreGanador = nombres[1];
		}
		String mensaje = "¡Ganó " + nombreGanador + " !";
		System.out.println();
		dibujarTrayecto(mensaje.length(), "~");
		System.out.println(mensaje.toUpperCase());
		dibujarTrayecto(mensaje.length(), "~");
	}

	private static boolean partidaTerminada(char[][] tablero) {
		for(int i=0; i<FILAS; i++) {
			//FILAS IGUALES
			if(tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
				return true;
			}
			//COLUMNAS IGUALES
			if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
				return true;
			}
		}
		//DIAGONALES
		if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
			return true;
		} else if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
			return true;
		}
		return false;
	}

	private static void ingresarJugada(boolean[] jugadores, char[][] tablero, Scanner sc) {
		int posiciones[] = new int[2];
		ingresarFilaYColumna(posiciones, sc);
		while(posicionInvalida(posiciones, tablero)) {
			System.out.println("Ingresa de nuevo fila y columna");
			ingresarFilaYColumna(posiciones, sc);
		}
		ingresarJugadaEnTablero(jugadores, posiciones, tablero);
	}

	private static void ingresarJugadaEnTablero(boolean[] jugadores, int[] posiciones, char[][] tablero) {
		if(jugadores[0]) {
			tablero[posiciones[0]][posiciones[1]] = 'O';
		} else {
			tablero[posiciones[0]][posiciones[1]] = 'X';
		}
		
	}

	private static void cambiarJugador(boolean[] jugadores) {
		jugadores[0] = !jugadores[0];
		jugadores[1] = !jugadores[1];
	}

	private static void ingresarFilaYColumna(int[] posiciones, Scanner sc) {
		System.out.println("Ingresar fila");
		posiciones[0] = sc.nextInt() - 1;
		while(posiciones[0] < 0 || posiciones[0] > FILAS - 1) {
			System.out.println("Numero invalido. Ingreselo de nuevo:");
			posiciones[0] = sc.nextInt() - 1;
		}
		System.out.println("Ingresar columna");
		posiciones[1] = sc.nextInt() - 1;
		while(posiciones[1] < 0 || posiciones[1] > COLUMNAS - 1) {
			System.out.println("Numero invalido. Ingreselo de nuevo:");
			posiciones[1] = sc.nextInt() - 1;
		}
	}

	private static boolean posicionInvalida(int[] posiciones, char[][] tablero) {
		if(tablero[posiciones[0]][posiciones[1]] != ' ') {
			System.out.println("Posicion ocupadas");
			return true;
		}
		return false;
	}

	private static void mostrarTablero(char[][] tablero) {
		System.out.println();
		dibujarTrayecto(4*3 + 1, "-");
		for(int i=0; i<FILAS; i++) {
			for(int j=0; j<COLUMNAS; j++) {
				if(j == 0) {
					System.out.print("| ");
				}
				if(j != COLUMNAS-1) {
					System.out.print(tablero[i][j] + " | ");
				} else {
					System.out.print(tablero[i][j]);
				}
				if (j == COLUMNAS-1) {
					System.out.print(" |");
				}
			}
			System.out.println();
			dibujarTrayecto(4*3 + 1, "-");
		}
	}

	private static char[][] inicializarTablero() {
		char tablero[][] = new char[FILAS][COLUMNAS];
		for(int i=0; i<FILAS; i++) {
			for(int j=0; j<COLUMNAS; j++) {
				tablero[i][j] = ' ';
			}
		}
		return tablero;
	}
	
	private static void dibujarTrayecto(int longitud, String simbolo) {
		for(int i=0; i<longitud; i++) {
			System.out.print(simbolo);
		}
		System.out.println();
	}
}
