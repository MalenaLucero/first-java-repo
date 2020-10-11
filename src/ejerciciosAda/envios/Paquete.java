package ejerciciosAda.envios;

public class Paquete extends Envio {
	public static final int PESO_MAXIMO = 5000;
	
	private float peso;
	
	public Paquete(float peso) {
		this.peso = peso;
		enviable = peso < PESO_MAXIMO && peso > 0;
		precioBase = peso;
	}
	
	public float getPeso() {
		return peso;
	}

	public boolean isEnviable() {
		return enviable;
	}
}
