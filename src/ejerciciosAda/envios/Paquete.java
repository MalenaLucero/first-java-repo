package ejerciciosAda.envios;

public class Paquete {
	private static final int PRECIO_ZONA_1 = 1;
	private static final int PRECIO_ZONA_2 = 2;
	private static final int PRECIO_ZONA_3 = 3;
	
	private float peso;
	private int zona;
	private boolean enviable;
	
	public Paquete(float peso, int zona) {
		this.peso = peso;
		this.zona = zona;
		this.enviable = peso < 5000;
	}
	
	public float getPeso() {
		return peso;
	}

	public int getZona() {
		return zona;
	}

	public boolean isEnviable() {
		return enviable;
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
