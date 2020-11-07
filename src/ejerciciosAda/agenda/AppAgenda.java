package ejerciciosAda.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//se desea registrar una agenda con actividades por dia
//las actividades se ingresan por teclado (actividad y fecha)
//una fecha puede tener varias actividades
//al terminar el ingreso, mostrar las actividades por fecha

public class AppAgenda {
	public static void main(String[] args) throws ParseException {
		Map<Date, List<Actividad>> agenda = new TreeMap<Date, List<Actividad>>();
		primeraCarga(agenda);
		imprimirAgenda(agenda);
	}
	
	private static void imprimirAgenda(Map<Date, List<Actividad>> agenda) {
		agenda.forEach((k, v) -> {
			System.out.println(k);
			for(Actividad act: v) {
				System.out.println(act.toString());
			}
			System.out.println();
		});
	}

	private static void primeraCarga(Map<Date, List<Actividad>> agenda) throws ParseException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
		
		Date date1 = simpleDate.parse("07-11-2020");
		Actividad actividad1 = new Actividad("Clase de backend", date1, "09:00", "13:00");
		cargarActividad(agenda, actividad1);
		
		Actividad actividad2 = new Actividad("Clase de japones", date1, "14:00", "16:00");
		cargarActividad(agenda, actividad2);
		
		Date date3 = simpleDate.parse("08-11-2020");
		Actividad actividad3 = new Actividad("Sesion de estudio", date3, "15:00");
		cargarActividad(agenda, actividad3);
		
		Date date4 = simpleDate.parse("09-11-2020");
		Actividad actividad4 = new Actividad("Cumpleaños", date4);
		cargarActividad(agenda, actividad4);
		
		Actividad actividad5 = new Actividad("Reunion", date4);
		cargarActividad(agenda, actividad5);
		
		Date date6 = simpleDate.parse("11-11-2020");
		Actividad actividad6 = new Actividad("Audioria", date6);
		cargarActividad(agenda, actividad6);
	}

	private static void cargarActividad(Map<Date, List<Actividad>> agenda, Actividad actividad) throws ParseException {
		Date fecha = actividad.getFecha();
		if(agenda.containsKey(fecha)) {
			agenda.get(fecha).add(actividad);
		} else {
			List<Actividad> actividades = new ArrayList<Actividad>();
			actividades.add(actividad);
			agenda.put(fecha, actividades);
		}
	}
}
