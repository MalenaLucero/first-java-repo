package ejerciciosAda.envios;
import java.util.Scanner;

public class AppEnvios {
	public static void main(String[] args) {
		TituloUtil.imprimirTitulo("Sistema de envios");
		Envio[] envios = new Envio[10];
		
		Scanner sc = new Scanner(System.in);
		int opcion = solicitarInt("Ingrese una opcion: 1. Carta, 2. Dinero, 3. Paquete, 0. Salir", sc);
		
		while(opcion != 0) {
			switch(opcion) {
			case 1:
				envioDeCarta(sc, envios);
				break;
			case 2:
				envioDeDinero(sc, envios);
				break;
			case 3:
				envioDePaquete(sc, envios);
				break;
			default:
				System.out.println("Opcion incorrecta. Ingresela de nuevo");
			}
			
			System.out.println();
			opcion = solicitarInt("Ingrese una opcion: 1. Carta, 2. Dinero, 3. Paquete, 0. Salir", sc);
		}
		sc.close();
		
		TituloUtil.imprimirTitulo("Gracias por usar el sistema de envios");
	}
	
	private static void envioDeCarta(Scanner sc, Envio[] envios) {
		int cantidad = solicitarInt("Ingrese la cantidad de cartas", sc);
		Carta nuevaCarta = new Carta(cantidad);
		ingresarZona(nuevaCarta, sc);
	}

	private static void envioDeDinero(Scanner sc, Envio[] envios) {
		float cantidad = solicitarFloat("Ingrese la cantidad de dinero", sc);
		Dinero nuevoDinero = new Dinero(cantidad);
		ingresarZona(nuevoDinero, sc);
	}
	
	private static void envioDePaquete(Scanner sc, Envio envios[]) {
		float cantidad = solicitarFloat("Ingrese el peso del paquete", sc);
		Paquete nuevoPaquete = new Paquete(cantidad);
		ingresarZona(nuevoPaquete, sc);
	}
	
	private static void ingresarZona(Envio nuevoEnvio, Scanner sc) {
		if(nuevoEnvio.isEnviable()) {
			int zona = solicitarInt("Ingrese la zona (1, 2, 3)", sc);
			nuevoEnvio.setZona(zona);
			nuevoEnvio.mostrarDatosComunes();
		} else {
			System.out.println("Numero invalido");
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
