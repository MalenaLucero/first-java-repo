package ejerciciosAda.MediosDePago.entidades;

//clase abstracta
//no se puede instanciar
//se fuerza a usar las subclases
//si no hay subclases, se fuerza a crearlas con extends para heredar de la clase abstracta
//las clases abstractas son las unicas que pueden tener metodos abstractos
//los metodos abstractos no tienen cuerpo, solo firma

public abstract class Pago {
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
	
	public abstract boolean validar();
	
	public void mostrarDatosComunes() {
		System.out.println("Monto: $" + monto);
		System.out.println("Monto mas impuestos: $" + montoMasImpuestos);
		System.out.println("Moneda: " + moneda);
	}
}
