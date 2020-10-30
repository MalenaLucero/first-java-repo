package ejerciciosAda.minecraft;

public abstract class ArmaQueDispara extends Arma implements Recargable {
	protected int disparosDisponibles;

	public void recargar(int cantidad) {
		disparosDisponibles += cantidad;
		System.out.println("Se cargaron " + cantidad + " municiones");
	}

	public void disparar(int cantidad) {
		for(int i = 0; i < cantidad; i++) {
			if(disparosDisponibles > 0) {
				disparosDisponibles--;
				System.out.println("Se ejecuto un disparo");
			} else {
				System.out.println("No quedan municiones");
			}
		}
	}
	
	public int getDisparosDisponibles() {
		return disparosDisponibles;
	}

}
