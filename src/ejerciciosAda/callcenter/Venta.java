package ejerciciosAda.callcenter;

public class Venta {
	String id;
	float importe;
	
	public Venta(String id, float importe) {
		this.id = id;
		this.importe = importe;
	}
	
	public String toString() {
		return "ID: " + id + " - Importe: $" + importe;
	}
}
