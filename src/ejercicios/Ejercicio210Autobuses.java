package ejercicios;
import java.util.Scanner;

public class Ejercicio210Autobuses {
	private static final int MINIMO_PASAJEROS = 20;
	private static final String BUS_A = "a";
	private static final String BUS_B = "b";
	private static final String BUS_C = "c";

	public static void main(String[] args) {
		int a = 2;
		float b = 2.5f;
		int c = 3;
		
		//scanner es una clase que lee
		//scanner es un metodo contructor
		Scanner sc = new Scanner(System.in);
		
		//pedir la cantidad de personas
		System.out.println("Ingresar la cantidad de pasajeros:");
		int cantPasajeros = sc.nextInt();
		
		//pedir la cantidad de kilometros
		System.out.println("Ingresar la cantidad de kilometros:");
		int totalKilometros = sc.nextInt();
		
		//pedir el tipo de autobus
		System.out.println("Ingresar el tipo de autobus:");
		
		String tipoDeAutobus = sc.next();
		System.out.println(tipoDeAutobus == "a");
		
		System.out.println(tipoDeAutobus);
		float tarifa = 0;
		
		/*if(tipoDeAutobus.equals("a")) {
			tarifa = a;
		} else if(tipoDeAutobus.equals("b")) {
			tarifa = b;
		} else if(tipoDeAutobus.equals("c")) {
			tarifa = c;
		}*/
		
		switch(tipoDeAutobus.toLowerCase()) {
		case BUS_A:
			tarifa = a;
			break;
		case BUS_B:
			tarifa = b;
			break;
		case BUS_C:
			tarifa = c;
			break;
		}
		
		if(cantPasajeros < 20) {
			cantPasajeros = MINIMO_PASAJEROS;
		}
		
		//sacar precio total
		double precioTotal = totalKilometros * tarifa * cantPasajeros;
		System.out.println("Precio total: " + precioTotal);
		
		sc.close();
	}
}
