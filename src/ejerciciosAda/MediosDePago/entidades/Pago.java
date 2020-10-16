package ejerciciosAda.MediosDePago.entidades;

public class Pago {
	protected float monto;
	protected float montoMasImpuestos;
	protected int id;
	protected String moneda;
	
	public Pago(float monto, String moneda) {
		this.monto = monto;
		this.moneda = moneda;
	}

	public float getMonto() {
		return monto;
	}
	
	public void mostrarDatosComunes() {
		System.out.println("Monto: $" + monto);
		System.out.println("Monto mas impuestos: $" + montoMasImpuestos);
		System.out.println("Moneda: " + moneda);
	}
	
}
