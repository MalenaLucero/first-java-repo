package ejerciciosAda.naipes;

import java.util.HashMap;
import java.util.Map;

public class MapaDeValores {
	public static Map<Valores, Integer> getValores() {
		Map<Valores, Integer> mapaDeValores =  new HashMap<Valores, Integer>();
		mapaDeValores.put(Valores.A, 1);
		mapaDeValores.put(Valores.DOS, 2);
		mapaDeValores.put(Valores.TRES, 3);
		mapaDeValores.put(Valores.CUATRO, 4);
		mapaDeValores.put(Valores.CINCO, 5);
		mapaDeValores.put(Valores.SEIS, 6);
		mapaDeValores.put(Valores.SIETE, 7);
		mapaDeValores.put(Valores.OCHO, 8);
		mapaDeValores.put(Valores.NUEVE, 9);
		mapaDeValores.put(Valores.DIEZ, 10);
		mapaDeValores.put(Valores.J, 10);
		mapaDeValores.put(Valores.Q, 10);
		mapaDeValores.put(Valores.K, 10);
		return mapaDeValores;
	}
}
