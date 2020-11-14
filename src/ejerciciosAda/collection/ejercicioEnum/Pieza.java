package ejerciciosAda.collection.ejercicioEnum;

public class Pieza {
	private Figura figura;
	private Color color;
	
	public Pieza(Figura figura, Color color) {
		this.figura = figura;
		this.color = color;
	}
	
	public String toString() {
		return String.format("Figura: %s - Color: %s", figura, color);
	}
}
