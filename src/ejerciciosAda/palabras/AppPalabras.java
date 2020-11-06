package ejerciciosAda.palabras;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//buscar un texto (parrafo)
//metodo split de String separa un string en array de string dado un character
//guardamos en una variable el texto seleccionado
//generar un mapa que contenga la palabra y la cantidad de veces que se repitio esa palabra en el texto
//obtener la palabra que mas se repite

public class AppPalabras {
	public static void main(String[] args) {
		String parrafo = "Vamos a construir un ejemplo de Hello World Kotlin Qué es Kotlin Kotlin es un lenguaje de programación nuevo que se ejecuta sobre la máquina virtual y que ha sido diseñado para trabajar tanto con aplicaciones móviles como en aplicaciones web server side Kotlin es un lenguaje que simplifica sobre manera la forma que tenemos de trabajar con el mundo Java Generando una sintaxis más sencilla y natural simplificando nuestra forma de trabajar sin alejarse de la esencia del lenguaje. Supongamos que tenemos una clase Persona e imprimimos su información en la consola. El código en Java es muy sencillo pero todos podemos estar de acuerdo en que no es compacto";
		String[] palabras = parrafo.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			String toLowerCase = palabras[i].toLowerCase();
			palabras[i] = toLowerCase;
		}
		Map<String, Integer> mapaDePalabras = new HashMap<String, Integer>();
		for(String palabra: palabras) {
			if(mapaDePalabras.containsKey(palabra)) {
				int cantidad = mapaDePalabras.get(palabra);
				mapaDePalabras.put(palabra, ++cantidad);
			} else {
				mapaDePalabras.put(palabra, 1);
			}
		}
		System.out.println(mapaDePalabras);
		
		int max = 0;
		String maxKey = null;
		Iterator<String> iterador = mapaDePalabras.keySet().iterator();
		while(iterador.hasNext()) {
			String key = (String) iterador.next();
			int valor = mapaDePalabras.get(key);
			if (valor > max) {
				max = valor;
				maxKey = key;
			}
		}
		System.out.println(maxKey);
		System.out.println(max);
	}
}
