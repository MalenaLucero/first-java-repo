package ejerciciosAda.productos;

import java.text.DecimalFormat;

public class Producto {
	private int codigo;
	private double precio;
	
	public Producto(int codigo, double precio) {
		this.codigo = codigo;
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return String.format("Codigo: %s - Precio: $%s", codigo, decimalFormat.format(precio));
	}
}
