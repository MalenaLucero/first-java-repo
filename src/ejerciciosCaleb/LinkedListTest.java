package ejerciciosCaleb;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
		names.add("Caleb");
		names.add("Sue");
		names.add("Sally");
		System.out.println(names);
		System.out.println("names.remove()");
		names.remove();
		System.out.println(names);
		System.out.println("names.remove()");
		names.remove();
		System.out.println(names);
		System.out.println("names.remove()");
		names.remove();
		System.out.println(names);
	}
}
