package ejerciciosAda.naipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//generar la baraja de naipes inglesas y mezclarlas (52)
//que intente repartir las cartas y esten desordenadas. Una carta a cada jugador
//el juego es blackjack

public class AppNaipes {
	public static void main(String[] args) {
		List<Carta> mazo = generarMazo();
		Collections.shuffle(mazo);
		
		List<Carta> jugador1 = new ArrayList<Carta>();
		List<Carta> jugador2 = new ArrayList<Carta>();
		
		repartir(mazo, jugador1, 1);
		repartir(mazo, jugador2, 1);
		
		System.out.println(jugador1);
		System.out.println(jugador2);
	}

	private static void repartir(List<Carta> mazo, List<Carta> jugador, int cantidad) {
		for(int i = 0; i < cantidad; i++) {
			Carta aux = mazo.get(0);
			jugador.add(aux);
			mazo.remove(aux);
		}
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
