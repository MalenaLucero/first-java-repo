package ejerciciosAda.pasajes;

import java.util.ArrayList;
import java.util.List;

//aplicacion de venta de pasajes de omnibus
//capacidad por bus de cinco asientos
//solicitar la venta de pasajes con los siguientes campos:
//DNI del pasajero, cantidad de pasajes que solicita
//existe solo un viaje por dia y las ventas son para ese dia
//si no hay asientos disponibles, informar al usuario
//lanzar una excepcion y ademas que le intente reservar el siguiente dia (sysout)

public class AppBus {
	private static final int MAX_PASAJES = 5;
	
	public static void main(String[] args) throws SinLugarException {
		List<Pasaje> pasajes = new ArrayList<Pasaje>();
		Pasaje[] nuevosPasajes = cargarPasajes("11111111", 6);
		
		try {
			agregarPasajes(pasajes, nuevosPasajes);
			System.out.println("Pasajes agregados");
		} catch(SinLugarException e) {
			System.out.println("No hay mas lugar");
		}
	}

	private static void agregarPasajes(List<Pasaje> pasajes, Pasaje[] nuevosPasajes) throws SinLugarException {
		if((pasajes.size() + nuevosPasajes.length) <= MAX_PASAJES) {
			for(Pasaje pasaje: nuevosPasajes) {
				pasajes.add(pasaje);
			}
		} else {
			throw new SinLugarException();
		}
	}

	private static Pasaje[] cargarPasajes(String dni, int cantidad) {
		Pasaje[] nuevosPasajes = new Pasaje[cantidad];
		for(int i = 0; i < cantidad; i++) {
			Pasaje pasaje = new Pasaje(dni);
			nuevosPasajes[i] = pasaje;
		}
		return nuevosPasajes;
	}
}
