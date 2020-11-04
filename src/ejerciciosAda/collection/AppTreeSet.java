package ejerciciosAda.collection;

import java.util.Set;
import java.util.TreeSet;

public class AppTreeSet {
	public static void main(String[] args) {
		MiComparator miComparator = new MiComparator();
		Set<String> set = new TreeSet<String>(miComparator);
		set.add("c");
		set.add("b");
		set.add("d");
		set.add("0002");
		set.add("0011");
		set.add("0001");
		set.add("ahora");
		set.add("antes");
		System.out.println(set);
	}
}
