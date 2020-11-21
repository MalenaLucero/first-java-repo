package ejerciciosAda.productos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

//se venden productos por la web de la empresa y se dispone de 100 productos con codigo numerico
//esos productos tienen un codigo secuencial desde 1 a 100 y un precio que va desde 5 hasta 20 pesos
//realizar un algoritmo que venda 10 productos al azar con una cantidad determinada y calcule 
//el precio total de la operacion
//aleatorios para enteros y para decimales (double)

public class AppProductos {
	
	private static final int PRECIO_BASE = 5;
	private static final int RANGO_PRECIOS = 15;
	
	public static void main(String[] args) {
		Producto[] productos = new Producto[100];
		
		for(int i=0; i < productos.length; i++) {
			int codigo = i + 1;
			Random r = new Random();
			double randomValue = 5 + 15 * r.nextDouble();
			productos[i] = new Producto(codigo, Math.round(randomValue * 100.0) / 100.0);
		}
		
		List<Venta> ventas = new ArrayList<Venta>(); 
		for(int i=0; i < 10; i++) {
			Venta venta = new Venta(productos[aleatorioEntero(Optional.of(100))], aleatorioEntero(Optional.empty()));
			ventas.add(venta);
		}
		
		System.out.println("Ventas:");
		for(Venta prod: ventas) { System.out.println(prod); }
		
		double total = ventas.stream().mapToDouble(x -> x.getPrecioFinal()).sum();
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		System.out.println();
		System.out.println("Total: $" + decimalFormat.format(total));
		
	}
	
	private static int aleatorioEntero(Optional<Integer> valorMaximo) {
		int enteroPorDefecto = 20;
		Random randomEntero = new Random();
		if(valorMaximo.isPresent()) {
			return randomEntero.nextInt(valorMaximo.get());
		} else {
			return randomEntero.nextInt(enteroPorDefecto);
		}
		
	}
}
