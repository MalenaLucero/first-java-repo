package ejerciciosAda;

import java.util.Scanner;

//Se tienen una linea de 4 cajas
//se solicita el numero de caja y el importe
//la carga finaliza con importe cero
//informar la cantidad de facturas cobradas por cada y promedio facturado
public class EjercicioCajas {

	public static void main(String[] args) {
		int cajas[] = new int[4];
		
		for(int i: cajas) cajas[i] = 0;
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.println("Ingresar el numero de caja (1, 2, 3, o 4) o 0 para terminar");
			int caja = sc.nextInt();
			if(caja == 0) {
				flag = false;
			} else if(caja < 0 || caja > 4){
				System.out.println("Se ingreso un numero de caja invalido");
				flag = false;
			}
			if(flag) {
				boolean internalFlag = true;
				while(internalFlag) {
					System.out.println("Ingresar el importe o 0 para terminar de cargar");
					int importe = sc.nextInt();
					if(importe == 0) internalFlag = false; 
					cajas[caja-1] += importe;
				}
				System.out.println("Caja: " + caja + " Importe: $" + cajas[caja-1]);
			}
		}
		sc.close();
		
		int totalFacturado = 0;
		System.out.print("Importe por caja: ");
		for(int i: cajas) {
			System.out.print(cajas[i] + " ");
			totalFacturado = totalFacturado + cajas[i];
		}
		System.out.println();
		
		float promedio = totalFacturado / cajas.length;
		System.out.println("Promedio facturado: $" + promedio);
	}

}
