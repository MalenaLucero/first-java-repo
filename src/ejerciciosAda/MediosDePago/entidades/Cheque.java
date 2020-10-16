package ejerciciosAda.MediosDePago.entidades;

public class Cheque extends Pago {
	public static final float RECARGO = 0.2f;
	
	private String numero;
	private String librador;
	private String banco;
	
	public Cheque(float monto, String moneda) {
		super(monto, moneda);
		montoMasImpuestos = monto + monto * RECARGO;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLibrador() {
		return librador;
	}

	public void setLibrador(String librador) {
		this.librador = librador;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
}
