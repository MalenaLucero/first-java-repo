package ejerciciosAda.periodico;

public class Nota extends Publicacion {
	private String autor;
	private String titulo;
	
	public Nota(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		precio = 0;
	}
	
	public void mostrarDatos() {
		System.out.println("Tipo: nota");
		System.out.println("Titulo: " + titulo);
		System.out.println("Autor: " + autor);
	}
}
