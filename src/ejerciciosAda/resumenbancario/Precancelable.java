package ejerciciosAda.resumenbancario;

public interface Precancelable {
	
	void cancelar(String motivo);
	
	default void mostrarMensaje() {
		System.out.println("Metodo default");
	}

}
