package ejerciciosAda;

import java.util.Scanner;

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
		boolean jugadores[] = {true, false};
		int contador = 0;
		
		while(!partidaTerminada(tablero) && contador < 9) {
			mostrarTurno(jugadores);
			ingresarJugada(jugadores, tablero, sc);
			mostrarTablero(tablero);
			if(!partidaTerminada(tablero)) {
				contador++;
				cambiarJugador(jugadores);
			}; 
		}
		sc.close();
		
		System.out.println();
		System.out.println("¡PARTIDA TERMINADA!");
		if(contador < 9) {
			imprimirMensajeGanador(jugadores);
		} else {
			System.out.println("No gano nadie :(");
		}	
	}

	private static void imprimirTitulo() {
		String titulo = "      TATETI      ";
		dibujarTrayecto(titulo);
		System.out.println(titulo);
		dibujarTrayecto(titulo);
	}

	private static void mostrarTurno(boolean[] jugadores) {
		System.out.println();
		if(jugadores[0]) {
			System.out.println("Turno del jugador 0:");
		} else {
			System.out.println("Turno del jugador X:");
		}
		
	}

	private static void imprimirMensajeGanador(boolean[] jugadores) {
		if(jugadores[0]) {
			System.out.println("Gano el jugador O!");
		} else {
			System.out.println("Gano el jugador X!");
		}
	}

	private static boolean partidaTerminada(char[][] tablero) {
		if(tablero[0][0] != ' ' && tablero[0][0] == tablero[0][1] && tablero[0][1] == tablero[0][2]) {
			return true;
		} else if (tablero[1][0] != ' ' && tablero[1][0] == tablero[1][1] && tablero[1][1] == tablero[1][2]) {
			return true;
		} else if (tablero[2][0] != ' ' && tablero[2][0] == tablero[2][1] && tablero[2][1] == tablero[2][2]) {
			return true;
		} else if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0]) {
			return true;
		} else if (tablero[0][1] != ' ' && tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1]) {
			return true;
		} else if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2]) {
			return true;
		} else if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
			return true;
		} else if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
			return true;
		}
		return false;
	}

	private static void ingresarJugada(boolean[] jugadores, char[][] tablero, Scanner sc) {
		int posiciones[] = new int[2];
		ingresarFilaYColumna(posiciones, sc);
		while(!posicionValida(posiciones, tablero)) {
			System.out.println("Posiciones ocupadas. Ingresalas de nuevo");
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
		System.out.println("Ingresar columna");
		posiciones[1] = sc.nextInt() - 1;
	}

	private static boolean posicionValida(int[] posiciones, char[][] tablero) {
		if(posiciones[0] < 0 || posiciones[0] > FILAS ||
			posiciones[1] < 0 || posiciones[1] > FILAS) {
			return false;
		} else if(tablero[posiciones[0]][posiciones[1]] != ' ') {
			return false;
		}
		return true;
	}

	private static void mostrarTablero(char[][] tablero) {
		System.out.println();
		for(int i=0; i<FILAS; i++) {
			for(int j=0; j<COLUMNAS; j++) {
				if(j != COLUMNAS-1) {
					System.out.print(tablero[i][j] + " | ");
				} else {
					System.out.print(tablero[i][j]);
				}
			}
			System.out.println();
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
	
	private static void dibujarTrayecto(String titulo) {
		for(int i=0; i<titulo.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}
