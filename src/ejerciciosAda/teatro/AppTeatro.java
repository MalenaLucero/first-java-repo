package ejerciciosAda.teatro;

import java.util.Scanner;

//Se venden boletos de una funcion numerados del 0-49. Cada uno de esos boletos
//se corresponde con una butaca que tiene fila y columna.
//Solicitar que asiento elige la persona al  comprarlo y marcarlo (de alguna manera)
//Se ingresan valores de fila hasta que se ingrese fila 0
//Listar los asientos vendidos
public class AppTeatro {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Butaca[] butacas = new Butaca[50];
		for(int i=0; i<50; i++) {
			butacas[i] = new Butaca(); 
		}
		int numero = 0;
		while(numero != 99) {
			numero = solicitarPosicion("numero de asiento", sc);
			Butaca butaca = new Butaca();
			System.out.println(butaca.isOcupado());
			if(!butaca.isOcupado()) {
				butaca.setNumero(numero);
			} else {
				System.out.println("Butaca ocupada");
			}
		}
		
	}

	private static int solicitarPosicion(String string, Scanner sc) {
		System.out.println("Ingresar: " + string);
		return sc.nextInt();
	}

}
