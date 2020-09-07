package ejerciciosCaleb;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
		
		System.out.println("-----QUEUE-----");
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
		
		System.out.println("-----STACK-----");
		names.push("Caleb");
		names.push("Sue");
		names.push("Sally");
		System.out.println(names);
		System.out.println("names.pop()");
		names.pop();
		System.out.println(names);
		System.out.println("names.pop()");
		names.pop();
		System.out.println(names);
	}
}
