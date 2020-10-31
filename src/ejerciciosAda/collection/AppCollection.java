package ejerciciosAda.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ejerciciosAda.MediosDePago.entidades.TarjetaDeCredito;

public class AppCollection {
	public static void main(String[] args) {
		pruebaList();
		pruebaSet();
	}

	private static void pruebaSet() {
		System.out.println("--SET--");
		Set<String> conj = new HashSet<String>();
		conj.add("uno");
		conj.add("uno");
		conj.add("dos");
		System.out.println(conj.size());
		
		System.out.println("RECORRIDO CON ITERATOR Y WHILE:");
		Iterator<String> it = conj.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("RECORRIDO CON FOREACH:");
		conj.forEach(x -> System.out.println(x));	
	}

	private static void pruebaList() {
		System.out.println("--LIST--");
		List<TarjetaDeCredito> tarjetas = new ArrayList<TarjetaDeCredito>();
		TarjetaDeCredito tarjeta1 = new TarjetaDeCredito(100, "pesos");
		TarjetaDeCredito tarjeta2 = new TarjetaDeCredito(200, "pesos");
		TarjetaDeCredito tarjeta3 = new TarjetaDeCredito(300, "pesos");
		tarjetas.add(tarjeta1);
		tarjetas.add(tarjeta2);
		tarjetas.add(tarjeta3);
		System.out.println(tarjetas);
		System.out.println(tarjetas.size());
		tarjetas.remove(0);
		System.out.println(tarjetas);
		
		System.out.println("RECORRIDO CON FOR:");
		for(int i = 0; i < tarjetas.size(); i++) {
			System.out.println(tarjetas.get(i));
		}
		
		System.out.println("RECORRIDO FOR SIN INDICE:");
		for(TarjetaDeCredito elemento: tarjetas) {
			System.out.println(elemento);
		}
		
		System.out.println("RECORRIDO CON FOREACH:");
		tarjetas.forEach(x -> System.out.println(x));
	}
}
