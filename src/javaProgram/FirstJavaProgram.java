package javaProgram;

import javaProgram.innerPackage.Bicicleta;

/** JAVADOC: first comment on this program
 * @author Usuario*/

public class FirstJavaProgram {
	/** Mensaje: descripcion de la clase
	 * @param args*/

	public static void main(String[] args) {
		Bicicleta bici = new Bicicleta();
		bici.setColor("azul");
		bici.mostrarValores();
		bici.acelerar(10);
		bici.mostrarValores();
		bici.frenar(20);
		bici.mostrarValores();
	}
}
