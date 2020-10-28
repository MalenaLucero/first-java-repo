package ejerciciosAda.resumenbancario;

public class Prestamo extends ProductoBancario implements Precancelable{

	public void cancelar(String motivo) {
		System.out.println("Motivo de la cancelacion: " + motivo);
	}

}
