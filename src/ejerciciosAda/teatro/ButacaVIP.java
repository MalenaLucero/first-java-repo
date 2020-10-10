package ejerciciosAda.teatro;

public class ButacaVIP extends Butaca{
	
	private boolean incluyeBebida;
	
	public ButacaVIP(int posicion) {
		super(posicion);
		incluyeBebida = false;
	}
	
	public ButacaVIP(int posicion, boolean incluyeBebida) {
		super(posicion);
		this.incluyeBebida = incluyeBebida;
	}
	
	public boolean isIncluyeBebida() {
		return incluyeBebida;
	}
	
	public void setIncluyeBebida(boolean incluyeBebida) {
		this.incluyeBebida = incluyeBebida;
	}
	
	public int getPrecio(){
		if(incluyeBebida) {
			return precio + 10;
		} else {
			return precio + 5;
		}
	}
}
