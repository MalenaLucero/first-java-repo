package ejerciciosAda.teatro;

public class TituloUtil {
	public static void imprimirTitulo(String titulo) {
		System.out.println();
		dibujarTrayecto(titulo.length(), "=");
		System.out.println(titulo.toUpperCase());
		dibujarTrayecto(titulo.length(), "=");
	}
	
	private static void dibujarTrayecto(int longitud, String simbolo) {
		for(int i=0; i<longitud; i++) {
			System.out.print(simbolo);
		}
		System.out.println();
	}
}
