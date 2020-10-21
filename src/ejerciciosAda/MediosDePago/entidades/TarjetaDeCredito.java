package ejerciciosAda.MediosDePago.entidades;

public class TarjetaDeCredito extends Pago {
	public static final float RECARGO = 0.3f;
	
	private String numero;
	private String vencimiento;
	private String titular;
	private String codigoSeguridad;
	
	public TarjetaDeCredito(float monto, String moneda) {
		super(monto, moneda);
		montoMasImpuestos = monto + monto * RECARGO;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}
	
	@Override
	public boolean validar() {
		if(numero.length() > 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public void mostrarDatos() {
		System.out.println("Medio de pago: tarjeta");
		mostrarDatosComunes();
	}
	
	public String toString() {
		return moneda + " " + monto;
	}
}
