package ejerciciosAda.collection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppExceptionPrueba {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresar numero:");
		try {
			int numero = sc.nextInt();
			System.out.println("numero: " + numero);
		} catch(InputMismatchException | IndexOutOfBoundsException e) {
			System.out.println("Input mismatch");
		} catch(NullPointerException e) {
			System.out.println("Null pointer exception");
		} catch(Exception e) {
			System.out.println("Exception");
		}
		sc.close();
	}
}
