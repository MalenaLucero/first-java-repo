package ejerciciosAda.resumenbancario;

import java.util.Date;

public class Retiro extends Movimiento {

	public Retiro(float monto, Date fecha) {
		super(monto, fecha);
	}
	
	public String toString() {
		return String.format("Tipo: Retiro, Monto: $%s, Fecha: %s", monto, fecha);
	}

}
