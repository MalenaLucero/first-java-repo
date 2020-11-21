package ejerciciosAda.productos;

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
		return String.format("Codigo: %s - Precio: %s", codigo, precio);
	}
}
