package ejerciciosAda.auto;

//clase Auto: 
//int numeroCambio
//int velocidad
//Tiene cinco velocidades y para hacer un cambio debo tener la velocidad adecuada
//0 auto detenido
//1-10 => numeroCambio = 1
//11-20 => numeroCambio = 2
//21-31 => numeroCambio = 3
//31-40 => numeroCambio = 4
//41+ => numeroCambio = 5
//programar getters y setters y los metodos acelerar, frenar segun sea posible
//y metodos subirCambio y bajarCambio
//subir cambio y luego acelerar validando la velocidad

public class Auto {
	private static final int[][] VELOCIDADES = {{0, 0}, {1, 10}, {11, 20}, {21, 31}, {31, 40}, {41, 100}};
	private static final int TOTAL_CAMBIOS = 5;
	
	private int cambio;
	private int velocidad;
	
	public int getCambio() {
		return cambio;
	}
	public void setCambio(int cambio) {
		this.cambio = cambio;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void subirCambio() {
		setCambio(getCambio()+1);
	}
	
	public void bajarCambio() {
		setCambio(getCambio()-1);
	}
	
	public void detener() {
		if(getCambio() == 1) {
			setCambio(0);
		}
	}
	
	public void acelerar(int masVelocidad) {
		int velocidadEsperada = velocidad + masVelocidad;
		if((velocidadEsperada/10) == cambio - 1) {
			setVelocidad(velocidadEsperada);
		} else {
			System.out.println("No se puede acelerar con este cambio");
		}
	}
	
	public void frenar(int menosVelocidad) {
		int velocidadEsperada = velocidad - menosVelocidad;
		if((velocidadEsperada/10) == cambio - 1) {
			setVelocidad(velocidadEsperada);
		} else {
			System.out.println("No se puede frenar con este cambio");
		}
	}
	
	public void mostrarDatos() {
		System.out.println("Numero de cambio: " + cambio);
		System.out.println("Velocidad: " + VELOCIDADES[cambio][1]);
	}
	
	

}
