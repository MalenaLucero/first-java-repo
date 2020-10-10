package ejerciciosAda.envios;
import java.util.Scanner;

public class AppEnvios {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TituloUtil.imprimirTitulo("Sistema de envios");
		int opcion = solicitarInt("Ingrese una opcion: 1.Carta, 2.Dinero, 3.Paquete", sc);
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
		case 99:
			opcion = 99;
			break;
		default:
			System.out.println("Opcion incorrecta. Ingresela de nuevo");
		}
	}
	
	private static void envioDeCarta(Scanner sc) {
		int cantidad = solicitarInt("Ingrese la cantidad de cartas", sc);
		int zona = solicitarInt("Ingrese la zona", sc);
		Carta nuevaCarta = new Carta(cantidad, zona);
		System.out.println("Cantidad de cartas: " + nuevaCarta.getCantidad());
		System.out.println("Zona: " + nuevaCarta.getZona());
		System.out.println("Precio final: " + nuevaCarta.getPrecioFinal());
	}
	
	private static void envioDeDinero(Scanner sc) {
		float cantidad = solicitarInt("Ingrese la cantidad de dinero", sc);
		int zona = solicitarInt("Ingrese la zona", sc);
		Dinero nuevoDinero = new Dinero(cantidad, zona);
		System.out.println("Cantidad de dinero: $" + nuevoDinero.getCantidad());
		System.out.println("Zona: " + nuevoDinero.getZona());
		System.out.println("Precio final: " + nuevoDinero.getPrecioFinal());
	}
	
	private static void envioDePaquete(Scanner sc) {
		float cantidad = solicitarInt("Ingrese el peso del paquete", sc);
		int zona = solicitarInt("Ingrese la zona", sc);
		Paquete nuevoPaquete = new Paquete(cantidad, zona);
		System.out.println("Peso del paquete: " + nuevoPaquete.getPeso());
		System.out.println("Zona: " + nuevoPaquete.getZona());
		System.out.println("Precio final: " + nuevoPaquete.getPrecioFinal());
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
