package ejerciciosAda.envios;

public class Envio {
	protected static final int PRECIO_ZONA_1 = 1;
	protected static final int PRECIO_ZONA_2 = 2;
	protected static final int PRECIO_ZONA_3 = 3;
	
	protected int zona;
	protected float precioBase;
	protected boolean enviable;
	
	public void setZona(int zona) {
		if(zona == 1 || zona == 2) {
			this.zona = zona;
		} else {
			this.zona = 3;
		}
	}

	public int getZona() {
		return zona;
	}
	
	public boolean isEnviable() {
		return enviable;
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
	
	public void mostrarDatos() {
		System.out.println("Zona: " + zona);
		System.out.println("Precio final: $" + getPrecioFinal());
		System.out.println("Enviable: " + enviable);
	}
}
