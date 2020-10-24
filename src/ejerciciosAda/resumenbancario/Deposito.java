package ejerciciosAda.resumenbancario;

import java.util.Date;

public class Deposito extends Movimiento{

	public Deposito(float monto, Date fecha) {
		super(monto, fecha);
	}
	
	public String toString() {
		return String.format("Tipo: Deposito, Monto: $%s, Fecha: %s", monto, fecha);
	}

}
