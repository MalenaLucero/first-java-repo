package ejerciciosAda.envios;

public class Carta extends Envio {
	public static final float PRECIO = 10;
	public static final int CANTIDAD_MAXIMA = 300;
	
	private int cantidad;
	
	public Carta(int cantidad) {
		this.cantidad = cantidad;
		enviable = cantidad < CANTIDAD_MAXIMA && cantidad > 0;
		precioBase = enviable ? cantidad * PRECIO : 0;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void mostrarDatos() {
		System.out.println("Cantidad de cartas: " + cantidad);
		mostrarDatosComunes();
	}
}
