package ejerciciosAda.resumenbancario;

public class PlazoFijo extends ProductoBancario implements Precancelable{

	public void cancelar(String motivo) {
		System.out.println("Motivo de cancelacion: " + motivo);
	}

}
