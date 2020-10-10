package ejerciciosAda.envios;

public class Carta extends Envio {
	public static final float PRECIO = 10;
	
	private int cantidad;

	public Carta(int cantidad, int zona) {
		super(zona);
		this.cantidad = cantidad;
		precioBase = cantidad * PRECIO;
	}
	
	public int getCantidad() {
		return cantidad;
	}
}
