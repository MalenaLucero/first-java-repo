package ejerciciosAda.naipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//generar la baraja de naipes inglesas y mezclarlas (52)
//que intente repartir las cartas y esten desordenadas. Una carta a cada jugador
//el juego es blackjack

public class AppNaipes {
	public static void main(String[] args) {
		List<Carta> mazo = generarMazo();
		Collections.shuffle(mazo);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--JUGADOR 1--");
		Jugador jugador1 = new Jugador();
		repartir(jugador1, mazo, sc);
		
		System.out.println("--JUGADOR 2--");
		Jugador jugador2 = new Jugador();
		repartir(jugador2, mazo, sc);
		
		definirGanador(jugador1, jugador2);
	}

	private static void definirGanador(Jugador jugador1, Jugador jugador2) {
		if(jugador1.isPerdedor() && jugador2.isPerdedor()) {
			System.out.println("No gano nadie");
		} else if(jugador1.isPerdedor()) {
			System.out.println("Gano el jugador 2");
		} else if(jugador2.isPerdedor()) {
			System.out.println("Gano el jugador 1");
		} else {
			if(jugador1.getTotal() == jugador2.getTotal()) {
				System.out.println("Empate");
			} else if(jugador1.getTotal() > jugador2.getTotal()) {
				System.out.println("Gano el jugador 1");
			} else {
				System.out.println("Gano el jugador 2");
			}
		}
	}

	private static void repartir(Jugador jugador, List<Carta> mazo, Scanner sc) {
		List<Carta> cartasRepartidas = new ArrayList<Carta>();
		pedirCartas(sc, cartasRepartidas, mazo);
		int total = sumarCartas(cartasRepartidas);
		jugador.setCartas(cartasRepartidas);
		jugador.setTotal(total);
		System.out.println("Total: " + jugador.getTotal());
	}

	private static int sumarCartas(List<Carta> jugador) {
		int total = 0;
		for(Carta carta: jugador) {
			total += MapaDeValores.getValores().get(carta.getValor());
		}
		return total;
	}

	private static void pedirCartas(Scanner sc, List<Carta> jugador1, List<Carta> mazo) {
		int opcion = 0;
		do {
			Carta carta = mazo.remove(0);
			System.out.println(carta);
			jugador1.add(carta);
			System.out.println("Desea otra carta (1. Si - 2. No)");
			opcion = sc.nextInt();
		} while (opcion == 1);
	}

	private static List<Carta> generarMazo() {
		List<Carta> mazo = new ArrayList<Carta>();
		
		for(int i = 0; i < 2; i++) {
			mazo.add(new Carta(true));
		}
		
		for(Valores valor: Valores.values()) {
			for(Palos palo: Palos.values()) {
				mazo.add(new Carta(valor, palo));
			}
		}
		
		return mazo;
	}
}
