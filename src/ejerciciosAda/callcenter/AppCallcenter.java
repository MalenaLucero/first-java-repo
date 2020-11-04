package ejerciciosAda.callcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//se desea conocer para cada uno de los dias del mes, la cantidad de ventas y de reclamos
//por dia que se realizaron por mes
//listar la informacion generada 
//usar random y list

public class AppCallcenter {
	public static void main(String[] args) {
		Random tipoRandom = new Random();
		Random importeRandom = new Random();
		Random numero = new Random();
		
		List<Venta> ventas = new ArrayList<Venta>();
		List<Reclamo> reclamos = new ArrayList<Reclamo>();
		
		for (int i = 0; i < 30; i++) {
			int tipo = tipoRandom.nextInt(2);
			if(tipo == 0) {
				float importe = importeRandom.nextFloat()*1000000;
				String id = "VNT" + numero.nextInt(999999999);
				Venta venta = new Venta(id, importe);
				ventas.add(venta);
			} else {
				String id = "RCL" + numero.nextInt(999999999);
				Reclamo reclamo = new Reclamo(id, "descripcion");
				reclamos.add(reclamo);
			}
		}
		System.out.println("VENTAS");
		System.out.println("Total: " + ventas.size());
		ventas.forEach(e -> System.out.println(e));
		System.out.println();
		System.out.println("RECLAMOS");
		System.out.println("Total: " + reclamos.size());
		reclamos.forEach(e -> System.out.println(e));
	}
}
