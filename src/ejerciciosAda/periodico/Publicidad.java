package ejerciciosAda.periodico;

public class Publicidad extends Publicacion {
	private static int PRECIO_1 = 100;
	private static int PRECIO_2 = 200;
	
	private int tamano;
	private String marca;
	public Publicidad(int tamano, String marca) {
		this.tamano = tamano;
		this.marca = marca;
		precio = tamano < 200 ? PRECIO_1 : PRECIO_2;
	}
	
	public void mostrarDatos() {
		System.out.println("Tipo: publicidad");
		System.out.println("Marca: " + marca);
		System.out.println("Tamano: " + tamano);
		System.out.println("Precio: $" + precio);
	}
	
	
}
