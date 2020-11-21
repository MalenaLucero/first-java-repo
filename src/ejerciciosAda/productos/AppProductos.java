package ejerciciosAda.productos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//se venden productos por la web de la empresa y se dispone de 100 productos con codigo numerico
//esos productos tienen un codigo secuencial desde 1 a 100 y un precio que va desde 5 hasta 20 pesos
//realizar un algoritmo que venda 10 productos al azar con una cantidad determinada y calcule 
//el precio total de la operacion
//aleatorios para enteros y para decimales (double)

public class AppProductos {
	public static void main(String[] args) {
		Producto[] productos = new Producto[100];
		
		for(int i=0; i < productos.length; i++) {
			int codigo = i + 1;
			Random r = new Random();
			double randomValue = 5 + (20 - 5) * r.nextDouble();
			productos[i] = new Producto(codigo, randomValue);
		}
		
		List<Producto> productosRandom = new ArrayList<Producto>(); 
		for(int i=0; i < 10; i++) {
			int numero = (int) (Math.random() * 100 + 1);
			productosRandom.add(productos[numero - 1]);
		}
		
		System.out.println("Productos random:");
		for(Producto prod: productosRandom) { System.out.println(prod); }
		
		double total = productosRandom.stream().mapToDouble(x -> x.getPrecio()).sum();
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		System.out.println();
		System.out.println("Total: $" + decimalFormat.format(total));
	}
}
