package ejerciciosAda.naipes;

import java.util.List;

public class Jugador {
	private List<Carta> cartas;
	private int total;
	private boolean perdedor;

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		this.perdedor = this.total > 21;
	}
	
	public boolean isPerdedor() {
		return this.perdedor;
	}
	
	public String toString() {
		return String.format("Total: %s - Perdedor: %s", total, perdedor);
	}
}
