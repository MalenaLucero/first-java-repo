package ejerciciosAda.naipes;

public class Carta {
	private Palos palo;
	private Valores valor;
	private boolean comodin;
	
	public Carta(Valores valor, Palos palo) {
		this.palo = palo;
		this.valor = valor;
		this.comodin = false;
	}
	
	public Valores getValor() {
		return valor;
	}
	
	public Carta(boolean comodin) {
		this.comodin = true;
	}
	
	public String toString() {
		if(this.comodin) {
			return "Comodin";
		} else {
			return String.format("%s de %s", valor, palo);
		}
	}
}
