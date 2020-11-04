package ejerciciosAda.callcenter;

public class Reclamo {
	String id;
	String descripcion;
	
	public Reclamo(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return "ID: " + id + " - Descripcion: " + descripcion;
	}

}
