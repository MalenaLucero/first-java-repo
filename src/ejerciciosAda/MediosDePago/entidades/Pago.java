package ejerciciosAda.MediosDePago.entidades;

public class Pago {
	protected float monto;
	protected float montoMasImpuestos;
	protected int id;
	protected String moneda;
	
	public Pago(float monto, String moneda) {
		this.monto = monto;
	}

	public float getMonto() {
		return monto;
	}
	
}
