package ejerciciosAda.envios;

public class Envio {
	protected static final int PRECIO_ZONA_1 = 1;
	protected static final int PRECIO_ZONA_2 = 2;
	protected static final int PRECIO_ZONA_3 = 3;
	
	protected int zona;
	protected float precioBase;
	
	public Envio(int zona) {
		this.zona = zona;
	}
	
	public int getZona() {
		return zona;
	}

	public float getPrecioFinal() {
		float precio = 0;
		switch(zona) {
		case 1:
			precio = PRECIO_ZONA_1 * precioBase;
			break;
		case 2:
			precio = PRECIO_ZONA_2 * precioBase;
			break;
		case 3:
			precio = PRECIO_ZONA_3 * precioBase;
			break;
		}
		return precio;
	}
}
