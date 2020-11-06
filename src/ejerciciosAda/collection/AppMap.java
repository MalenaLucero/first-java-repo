package ejerciciosAda.collection;

import java.util.HashMap;
import java.util.Map;

public class AppMap {
	public static void main(String[] args) {
		Map<String, String> diccionario = new HashMap<String, String>();
		diccionario.put("hola", "konnichiwa");
		diccionario.put("chau", "sayounara");
		System.out.println(".size(): " + diccionario.size());
		System.out.println(".keySet(): " + diccionario.keySet());
		System.out.println("Recorrido con .forEach():");
		diccionario.keySet().forEach(key -> System.out.println(diccionario.get(key)));
	}

}
