package ejerciciosAda.pasajes;

public class Pasaje {
	private String dni;

	public Pasaje(String dni) {
		this.dni = dni;
	}
	
	public String toString() {
		return String.format("DNI: %s", dni);
	}
}
