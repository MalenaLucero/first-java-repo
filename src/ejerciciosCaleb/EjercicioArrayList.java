package ejerciciosCaleb;

import java.util.ArrayList;

public class EjercicioArrayList {
	public static void main(String[] args) {
		ArrayList<String> strlist = new ArrayList<String>();
		strlist.add("hola");
		strlist.add(0, "chau");
		strlist.remove(0);
		imprimirArrayList(strlist);
		strlist.set(0, "chau de nuevo");
		
		imprimirArrayList(strlist);
		System.out.println(strlist.indexOf("chau de nuevo"));
		System.out.println(strlist.contains("chau de nuevo"));
		System.out.println(strlist.isEmpty());
		strlist.clear();
		System.out.println(strlist.isEmpty());
		
		System.out.println("---------------");
		
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		intlist.add(1);
		intlist.add(2);
		intlist.add(3);
		imprimirArrayListInt(intlist);
	}

	private static void imprimirArrayList(ArrayList<String> strlist) {
		for(int i=0; i<strlist.size(); i++) {
			System.out.println(strlist.get(i));
		}
	}
	
	private static void imprimirArrayListInt(ArrayList<Integer> strlist) {
		for(int i=0; i<strlist.size(); i++) {
			System.out.println(strlist.get(i));
		}
	}
}
