package ejerciciosAda.minecraft;

public interface Ejecutable {
	
	default void definirObjetivo(String objetivo) {
		System.out.println("Se definio " + objetivo + " como objetivo");
	}
}
