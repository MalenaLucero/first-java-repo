package ejerciciosAda.auto;

public class AppAuto {
	public static void main(String[] args) {
		//para simular parametros:
		//run => run configurations => arguments
		if(args != null && args.length > 0) {
			for(int i=0; i< args.length; i++) {
				System.out.println(args[i]);
			}
		}
		System.out.println("Primer parametro: " + args[0]);
		
		Auto nuevoAuto = new Auto();
		nuevoAuto.subirCambio();
		nuevoAuto.subirCambio();
		nuevoAuto.mostrarDatos();
		nuevoAuto.bajarCambio();
		nuevoAuto.mostrarDatos();
	}
}
