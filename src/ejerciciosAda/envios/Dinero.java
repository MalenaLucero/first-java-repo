package ejerciciosAda.envios;

public class Dinero extends Envio {
	public static final float PORCENTAJE = 0.2f;
	
	private float cantidad;
	
	public Dinero(float cantidad, int zona) {
		super(zona);
		this.cantidad = cantidad;
		precioBase = cantidad * PORCENTAJE;
	}

	public float getCantidad() {
		return cantidad;
	}
}
