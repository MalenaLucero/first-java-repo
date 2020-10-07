package ejerciciosAda.teatro;

public class Butaca {
	private int fila;
	private int columna;
	private boolean ocupado = false;
	private int numero;
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
		ocupado = true;
	}
	public void mostrarDatos() {
		System.out.println("Numero: " + numero);
		System.out.println("Fila: " + fila);
		System.out.println("Columna: " + columna);
	}
}
