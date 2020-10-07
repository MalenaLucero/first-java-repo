package ejerciciosAda.envios;

public class Paquete {
	private static final int PRECIO_ZONA_1 = 1;
	private static final int PRECIO_ZONA_2 = 2;
	private static final int PRECIO_ZONA_3 = 3;
	
	private float peso;
	private int zona;
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}
	
	public float calcularPrecio() {
		float precio = 0;
		switch(zona) {
		case 1: precio = PRECIO_ZONA_1 * peso;
			break;
		case 2: precio = PRECIO_ZONA_2 * peso;
			break;
		case 3: precio = PRECIO_ZONA_3 * peso;
			break;
		}
		return peso * zona;
	}
}
