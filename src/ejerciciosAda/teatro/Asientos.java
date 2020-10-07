package ejerciciosAda.teatro;

public class Asientos {
	private static int FILAS = 5;
	private static int COLUMNAS = 10;
	private boolean ocupado;
	
	private int[][] asientos = new int[FILAS][COLUMNAS];

	public int[][] getAsientos() {
		return asientos;
	}

	public void setAsientos(int fila, int columna) {
		if(asientos[fila][columna] == 0) {
			asientos[fila][columna] = 1;
		}
	}
	

}
