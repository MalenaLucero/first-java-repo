package ejerciciosAda.productos;

import java.text.DecimalFormat;

public class Venta {
	private Producto producto;
	private int cantidad;
	private double precioFinal;
	
	public Venta(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioFinal = producto.getPrecio() * cantidad;
	}
	
	public double getPrecioFinal() {
		return precioFinal;
	}
	
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return String.format("Codigo: %s - Cantidad: %s - Precio Final: $%s",
								producto.getCodigo(), cantidad, decimalFormat.format(precioFinal));
	}
}
