package ejerciciosAda.agenda;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Actividad {
	String titulo;
	Date fecha;
	String horaDeInicio;
	String horaDeFinalizacion;
	
	public Actividad(String titulo, Date fecha) {
		this.titulo = titulo;
		this.fecha = fecha;
	}
	
	public Actividad(String titulo, Date fecha, String horaDeInicio) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.horaDeInicio = horaDeInicio;
	}
	
	public Actividad(String titulo, Date fecha, String horaDeInicio, String horaDeFinalizacion) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.horaDeInicio = horaDeInicio;
		this.horaDeFinalizacion = horaDeFinalizacion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public String getFechaFormateada() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
		return simpleDate.format(fecha);
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getHoraDeInicio() {
		return horaDeInicio;
	}

	public String getHoraDeFinalizacion() {
		return horaDeFinalizacion;
	}

	public String getHash() {
		return titulo + getFecha();
	}
	
	public String toString() {
		if(horaDeInicio != null && horaDeFinalizacion != null) {
			return String.format("%s: %s - %s", titulo, horaDeInicio, horaDeFinalizacion);
		} else if(horaDeInicio != null) {
			return String.format("%s: desde %s", titulo, horaDeInicio);
		} else {
			return String.format("%s", titulo);
		}
	}
}
