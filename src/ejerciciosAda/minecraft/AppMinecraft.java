package ejerciciosAda.minecraft;

//tenemos diferentes tipo de armas
//chuchillo, revolver, arco y flecha
//tenemos la interfaz recargable con dos metodos: recargar(cant) y disparar()
//implementar esos metodos en las clases correspondientes

public class AppMinecraft {
	public static void main(String[] args) {
		Revolver revolver = new Revolver();
		revolver.definirObjetivo("lata");
		revolver.disparar(5);
		revolver.disparar(7);
	}
}
