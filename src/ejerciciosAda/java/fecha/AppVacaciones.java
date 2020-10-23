package ejerciciosAda.java.fecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// Cargar la fecha de inicio de vacaciones de un grupo de empleados
// grupo de cinco empleados
// informar cual de ellos se ira primero de vacaciones

public class AppVacaciones {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		String[] fechas = {"2021-02-01", "2021-01-01", "2021-04-01", "2021-03-01", "2021-05-01"};
		Date[] fechasFormateadas = new Date[fechas.length];
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		
		Date min = null;
		int indice = 0;
		for(int i=0; i<fechas.length; i++) {
			fechasFormateadas[i] = simpleDate.parse(fechas[i]);
			if(min == null || min.after(fechasFormateadas[i])) {
				min = fechasFormateadas[i];
				indice = i;
			}
		}
		
		System.out.println(indice);
		System.out.println(esMayorDeEdad(simpleDate.parse("2010-10-03")));
		
	}
	
	private static boolean esMayorDeEdad(Date fechaNacimiento) {
		Calendar hoy = Calendar.getInstance();
		hoy.add(Calendar.YEAR, -18);
		if(fechaNacimiento.before(hoy.getTime())) {
			return true;
		} else {
			return false;
		}
	}
	
}
