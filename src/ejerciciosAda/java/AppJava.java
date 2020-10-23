package ejerciciosAda.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ejerciciosAda.MediosDePago.entidades.TarjetaDeCredito;

public class AppJava {
	public static void main(String[] args) throws ParseException {
		String numeroTurno = "123";
		Integer numeroTurnoInteger = Integer.parseInt(numeroTurno);
		int numeroTurnoInt = numeroTurnoInteger.intValue();
		String numeroOriginal = String.valueOf(numeroTurnoInt);
		
		Object object = new Object();
		System.out.println(numeroTurno.getClass().getSuperclass());
		
		TarjetaDeCredito pago = new TarjetaDeCredito(300, "pesos");
		System.out.println(pago.toString());
		
		Date ahora = new Date();
		System.out.println(ahora);
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDate.format(ahora));
		Date fechaPasada = simpleDate.parse("2020-01-01");
		System.out.println(fechaPasada);
		System.out.println(fechaPasada.after(ahora));
		
		System.out.println("CALENDAR");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 1);
		calendar.setTime(ahora);
		calendar.add(Calendar.DATE, -1);
		System.out.println(simpleDate.format(calendar.getTime()));
	}
	
}
