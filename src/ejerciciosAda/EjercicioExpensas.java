package ejerciciosAda;

import java.util.Scanner;

//Se desea calcular el total de expensas a pagar de un edificio de 4 pisos
//que tiene un departamento por piso desde planta baja hasta el último piso.
//Se deben ingresar los valores de cada departamento
//y luego informar el importe de expensas promedio

public class EjercicioExpensas {
	public static final String[] DEPARTAMENTOS = {"PB", "1", "2", "3"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float expensas[] = new float[DEPARTAMENTOS.length];
		float acumulador = 0;
		
		for(int i=0; i < DEPARTAMENTOS.length; i++) {
			System.out.println("Ingrese las expensas del piso " + DEPARTAMENTOS[i]);
			expensas[i] = sc.nextFloat();
			acumulador += expensas[i];
		}
		
		float promedio = acumulador / DEPARTAMENTOS.length;
		
		System.out.println("Total: $" + acumulador);
		System.out.println("Promedio: $" + promedio);
	}
}
