package ejerciciosCaleb;

import java.util.Iterator;
import java.util.TreeSet;

public class TreesetExample {
	public static void main(String[] args) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		addToTree(tree);
		iterateTree(tree);
		checkIfItContainsANumber(tree);
	}

	private static void checkIfItContainsANumber(TreeSet<Integer> tree) {
		System.out.println("CHECK IF IT CONTAINS 1: " + tree.contains(1));
		System.out.println("CHECK IF IT CONTAINS 6: " + tree.contains(6));
	}

	private static void iterateTree(TreeSet<Integer> tree) {
		System.out.println("ITERATE THROUGH TREE");
		Iterator<Integer> iterator = tree.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	private static void addToTree(TreeSet<Integer> tree) {
		System.out.println("ADD TO TREE");
		tree.add(1);
		tree.add(1);
		tree.add(5);
		tree.add(2);
		tree.add(2);
		tree.add(4);
		tree.add(3);
	}
}
