package javaProgram.innerPackage;

public class Bicicleta {
	private int velocidad;
	private String color;
	
	// source -> generate getters y setters
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	private void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void acelerar(int aceleracion) {
		setVelocidad(velocidad + aceleracion);
	}
	
	public void frenar(int menosVelocidad) {
		if(velocidad - menosVelocidad >= 0) {
			setVelocidad(velocidad - menosVelocidad);
		} else {
			System.out.println("La velocidad actual no permite frenar con " + menosVelocidad);
		}
	}
	
	public void detener() {
		if(velocidad < 5) {
			setVelocidad(0);
		} else {
			System.out.println("No se puede frenar a esta velocidad");
		}
	}
	
	public void mostrarValores() {
		System.out.println("Velocidad: " + velocidad);
		System.out.println("Color: " + color);
	}
	
	

}
