package ejerciciosAda.MediosDePago;

import java.util.Scanner;

import ejerciciosAda.MediosDePago.entidades.Cheque;
import ejerciciosAda.MediosDePago.entidades.Efectivo;
import ejerciciosAda.MediosDePago.entidades.TarjetaDeCredito;

//Se desea registrar los pagos realizados por los clientes
//Se reciben pagos en efectivo, cheque o tarjeta de credito
//Se desea conocer el total pagado por los diferentes medios
//Se ingresan los pagos hasta el ingreso de importe 0.

public class AppMediosDePago {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Efectivo[] pagosEfectivo = new Efectivo[10];
		Cheque[] pagosCheque = new Cheque[10];
		TarjetaDeCredito[] pagosTarjeta = new TarjetaDeCredito[10];
		int[] contadores = new int[3];
		
		float monto = solicitarFloat("Ingresar el importe o 0 para salir", sc);
		while(monto != 0) {
			int medioDePago = solicitarInt("Medio de pago: 1.Efectivo, 2.Cheque, 3.Tarjeta", sc);
			switch(medioDePago) {
			case 1:
				generarPagoEfectivo(monto, contadores, pagosEfectivo);
				break;
			case 2:
				generarPagoCheque(monto, contadores, pagosCheque);
				break;
			case 3:
				generarPagoTarjeta(monto, contadores, pagosTarjeta);
				break;
			default:
				System.out.println("Medio de pago invalido");
			}
			monto = solicitarFloat("Ingresar el importe o 0 para salir", sc);
		}
		
	}
	
	private static void generarPagoTarjeta(float monto, int[] contadores, TarjetaDeCredito[] pagosTarjeta) {
		TarjetaDeCredito nuevoPago = new TarjetaDeCredito(monto, "pesos");
		pagosTarjeta[contadores[2]] = nuevoPago;
		contadores[2]++;
	}

	private static void generarPagoCheque(float monto, int[] contadores, Cheque[] pagosCheque) {
		Cheque nuevoPago = new Cheque(monto, "pesos");
		pagosCheque[contadores[1]] = nuevoPago;
		contadores[1]++;
	}

	private static void generarPagoEfectivo(float monto, int[] contadores, Efectivo[] pagosEfectivo) {
		Efectivo nuevoPago = new Efectivo(monto, "pesos");
		pagosEfectivo[contadores[0]] = nuevoPago;
		contadores[0]++;
	}

	private static float solicitarFloat(String mensaje, Scanner sc) {
		System.out.println(mensaje);
		return sc.nextFloat();
	}
	
	private static int solicitarInt(String mensaje, Scanner sc) {
		System.out.println(mensaje);
		return sc.nextInt();
	}

}
