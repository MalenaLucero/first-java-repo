package ejerciciosAda.envios;

public class Dinero extends Envio {
	public static final float PORCENTAJE = 0.2f;
	public static final int DINERO_MAXIMO = 100000;
	
	private float cantidad;
	
	public Dinero(float cantidad) {
		this.cantidad = cantidad;
		enviable = cantidad < DINERO_MAXIMO && cantidad > 0;
		precioBase = enviable ? cantidad * PORCENTAJE : 0;
	}

	public float getCantidad() {
		return cantidad;
	}
}
