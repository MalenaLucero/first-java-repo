package ejerciciosAda.teatro;

import java.util.Scanner;

//Se venden boletos de una funcion numerados del 0-49. Cada uno de esos boletos
//se corresponde con una butaca que tiene fila y columna.
//Solicitar que asiento elige la persona al  comprarlo y marcarlo (de alguna manera)
//Se ingresan valores de fila hasta que se ingrese fila 0
//Listar los asientos vendidos
public class AppTeatro {
	private static final int ASIENTOS_TOTALES = 50;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Butaca[] butacas = inicializarButacas();
		
		imprimirTitulo("Carga de asientos");
		cargarAsientos(butacas, sc);
		mostrarTeatro(butacas);
		
		imprimirTitulo("Mostrar informacion de asientos");
		mostrarInfoAsientos(butacas, sc);
		
		imprimirTitulo("Programa finalizado");
	}

	private static void mostrarInfoAsientos(Butaca[] butacas, Scanner sc) {
		int numero = solicitarPosicion("numero de asiento", sc);
		while(numero != 99) {
			int indice = numero - 1;
			if(butacas[indice].isOcupado()) {
				butacas[indice].mostrarDatos();
				System.out.println();
			} else {
				System.out.println("Butaca libre sin datos");
			}
			numero = solicitarPosicion("numero de asiento", sc);
		}
	}

	private static void cargarAsientos(Butaca[] butacas, Scanner sc) {
		int numero = solicitarPosicion("numero de asiento", sc);
		while(numero != 99) {
			int indice = numero - 1;
			if(!butacas[indice].isOcupado()) {
				butacas[indice].setNumero(numero);
				int fila = solicitarPosicion("fila", sc);
				butacas[indice].setFila(fila);
				int columna = solicitarPosicion("columna", sc);
				butacas[indice].setColumna(columna);
			} else {
				System.out.println("Butaca ocupada");
			}
			numero = solicitarPosicion("numero de asiento", sc);
		}
	}

	private static Butaca[] inicializarButacas() {
		Butaca[] butacas = new Butaca[ASIENTOS_TOTALES];
		for(int i=0; i<butacas.length; i++) {
			butacas[i] = new Butaca(); 
		}
		return butacas;
	}

	private static void mostrarTeatro(Butaca[] butacas) {
		for(int i=0; i<butacas.length; i++) {
			if(i%10 == 0) System.out.println();
			System.out.print(butacas[i].getNumero());
		}
		System.out.println();
	}

	private static int solicitarPosicion(String string, Scanner sc) {
		System.out.println("Ingresar " + string + ":");
		int num = sc.nextInt();
		while(!esValido(num)) {
			System.out.println("Numero invalido. Ingreselo de nuevo");
			System.out.println("Ingresar " + string + ":");
			num = sc.nextInt();
		}
		return num;
	}
	
	private static boolean esValido(int num) {
		boolean valido = false;
		if(num == 99) {
			valido = true;
		} else if (num > 0 && num < 51) {
			valido = true;
		} 
		return valido;
	}

	private static void imprimirTitulo(String titulo) {
		System.out.println();
		dibujarTrayecto(titulo.length(), "=");
		System.out.println(titulo.toUpperCase());
		dibujarTrayecto(titulo.length(), "=");
	}
	
	private static void dibujarTrayecto(int longitud, String simbolo) {
		for(int i=0; i<longitud; i++) {
			System.out.print(simbolo);
		}
		System.out.println();
	}

}
