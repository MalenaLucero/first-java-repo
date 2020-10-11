package ejerciciosAda.envios;
import java.util.Scanner;

public class AppEnvios {
	public static void main(String[] args) {
		TituloUtil.imprimirTitulo("Sistema de envios");
		
		Scanner sc = new Scanner(System.in);
		int opcion = solicitarInt("Ingrese una opcion: 1. Carta, 2. Dinero, 3. Paquete, 0. Salir", sc);
		
		while(opcion != 0) {
			switch(opcion) {
			case 1:
				envioDeCarta(sc);
				break;
			case 2:
				envioDeDinero(sc);
				break;
			case 3:
				envioDePaquete(sc);
				break;
			default:
				System.out.println("Opcion incorrecta. Ingresela de nuevo");
			}
			
			System.out.println();
			opcion = solicitarInt("Ingrese una opcion: 1. Carta, 2. Dinero, 3. Paquete, 0. Salir", sc);
		}
		
		TituloUtil.imprimirTitulo("Gracias por usar el sistema de envios");
	}
	
	private static void envioDeCarta(Scanner sc) {
		int cantidad = solicitarInt("Ingrese la cantidad de cartas", sc);
		Carta nuevaCarta = new Carta(cantidad);
		if(nuevaCarta.isEnviable()) {
			int zona = solicitarInt("Ingrese la zona", sc);
			nuevaCarta.setZona(zona);
			System.out.println("Cantidad de cartas: " + nuevaCarta.getCantidad());
			nuevaCarta.mostrarDatos();
		} else {
			System.out.println("Cantidad invalida");
		}
	}
	
	private static void envioDeDinero(Scanner sc) {
		float cantidad = solicitarFloat("Ingrese la cantidad de dinero", sc);
		Dinero nuevoDinero = new Dinero(cantidad);
		if(nuevoDinero.isEnviable()) {
			int zona = solicitarInt("Ingrese la zona", sc);
			nuevoDinero.setZona(zona);
			System.out.println("Cantidad de dinero: $" + nuevoDinero.getCantidad());
			nuevoDinero.mostrarDatos();
		} else {
			System.out.println("Cantidad invalida");
		}
	}
	
	private static void envioDePaquete(Scanner sc) {
		float cantidad = solicitarFloat("Ingrese el peso del paquete", sc);
		Paquete nuevoPaquete = new Paquete(cantidad);
		if(nuevoPaquete.isEnviable()) {
			int zona = solicitarInt("Ingrese la zona", sc);
			nuevoPaquete.setZona(zona);
			System.out.println("Peso del paquete: " + nuevoPaquete.getPeso());
			nuevoPaquete.mostrarDatos();
		} else {
			System.out.println("Peso invalido");
		}
	}

	private static int solicitarInt(String mensaje, Scanner sc) {
		System.out.println(mensaje);
		return sc.nextInt();
	}

	private static float solicitarFloat(String mensaje, Scanner sc) {
		System.out.println(mensaje);
		return sc.nextFloat();
	}
}
