package ejerciciosAda.resumenbancario;

import java.util.Date;

public class Movimiento {
	protected float monto;
	protected Date fecha;
	
	public Movimiento(float monto, Date fecha) {
		this.monto = monto;
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public Date getFecha() {
		return fecha;
	}

}
