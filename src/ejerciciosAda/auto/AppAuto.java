package ejerciciosAda.auto;

public class AppAuto {
	public static void main(String[] args) {
		Auto nuevoAuto = new Auto();
		nuevoAuto.subirCambio();
		nuevoAuto.subirCambio();
		nuevoAuto.mostrarDatos();
		nuevoAuto.bajarCambio();
		nuevoAuto.mostrarDatos();
	}
}
