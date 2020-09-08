package ejerciciosCaleb;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterators {
	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
		names.push("Caleb");
		names.push("Sue");
		names.push("Sally");
		System.out.println(names);
		
		System.out.println("-----ITERATOR IMPLEMENTATION-----");
		Iterator<String> it = names.iterator();
		
		System.out.println("-----ITERATOR PRINTED WITH WHILE-----");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		names.add(2, "Susan");
		System.out.println("-----LINKED LIST PRINTED WITH FOR EACH-----");
		for(String s:names) {
			System.out.println(s);
		}
	}
}
