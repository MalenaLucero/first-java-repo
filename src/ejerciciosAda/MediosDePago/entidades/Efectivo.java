package ejerciciosAda.MediosDePago.entidades;

public class Efectivo extends Pago {
	public Efectivo(float monto, String moneda) {
		super(monto, moneda);
		montoMasImpuestos = monto;
	}
	
	@Override
	public boolean validar() {
		return true;
	}
	
	public void mostrarDatos() {
		System.out.println("Medio de pago: efectivo");
		mostrarDatosComunes();
	}
}
