package ejerciciosAda.envios;

public class Paquete extends Envio {
	private float peso;
	private boolean enviable;
	
	public Paquete(float peso, int zona) {
		super(zona);
		this.peso = peso;
		this.enviable = peso < 5000;
		precioBase = peso;
	}
	
	public float getPeso() {
		return peso;
	}

	public boolean isEnviable() {
		return enviable;
	}
}
