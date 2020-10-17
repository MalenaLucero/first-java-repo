package ejerciciosAda.periodico;

public class Publicidad extends Publicacion {
	private static int PRECIO_1 = 100;
	private static int PRECIO_2 = 200;
	
	private int tamano;
	public Publicidad(int tamano) {
		this.tamano = tamano;
		precio = tamano < 200 ? PRECIO_1 : PRECIO_2;
	}
	
	
}
