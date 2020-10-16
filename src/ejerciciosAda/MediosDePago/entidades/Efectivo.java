package ejerciciosAda.MediosDePago.entidades;

public class Efectivo extends Pago {
	public Efectivo(float monto, String moneda) {
		super(monto, moneda);
		montoMasImpuestos = monto;
	}
}
