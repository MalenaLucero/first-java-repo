package ejerciciosAda.periodico;

public class Nota extends Publicacion {
	private String autor;
	private String titulo;
	
	public Nota(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		precio = 0;
	}
	
	public String toString() {
		return String.format("Tipo: nota, Titulo: %s, Autor: %s", titulo, autor);
	}
}
