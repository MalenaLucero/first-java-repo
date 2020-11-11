package ejerciciosAda.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AppStream {
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(1);
		numeros.add(3);
		numeros.add(2);
		System.out.println(numeros);
		IntStream mapToInt = numeros.stream().mapToInt(i -> i.intValue());
		System.out.println("MapToInt: " + mapToInt);
		int total = numeros.stream().mapToInt(i -> i.intValue()).sum();
		System.out.println("total: " + total);
		int maximo = numeros.stream().mapToInt(i -> i.intValue()).max().getAsInt();
		System.out.println("maximo: " + maximo);
		int minimo = numeros.stream().mapToInt(i -> i.intValue()).min().getAsInt();
		System.out.println("minimo: " + minimo);
		double promedio = numeros.stream().mapToInt(i -> i.intValue()).average().getAsDouble();
		System.out.println("promedio: " + promedio);
		boolean isIncluded = numeros.stream().mapToInt(i -> i.intValue()).anyMatch(n -> n == 1);
		System.out.println("El 1 esta incluido: " + isIncluded);
		boolean areAllIncluded = numeros.stream().mapToInt(i -> i.intValue()).allMatch(n -> n == 1);
		System.out.println("Todos los numeros son 1: " + areAllIncluded);
		int[] greaterThanOne = numeros.stream().mapToInt(i -> i.intValue()).filter(n -> n > 1).toArray();
		System.out.print("Mayores a 1: ");
		for(int i: greaterThanOne) System.out.print(i + " ");
		System.out.println();
		int[] sortedArray = numeros.stream().mapToInt(i -> i.intValue()).sorted().toArray();
		System.out.print("Sorted: ");
		for(int i: sortedArray) System.out.print(i + " ");
		System.out.println();
	}
}
