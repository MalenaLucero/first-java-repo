package ejerciciosAda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EjercicioFechas {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("ddMMyyyy");
		Date birthday = simpleDate.parse("10031990");
		Date futureDay = simpleDate.parse("03032022");
		
		//Date
		Date hoy = new Date();
		Date otroHoy = new Date(hoy.getTime());
		System.out.println(hoy.before(birthday));
		System.out.println(otroHoy.after(birthday));
		System.out.println(hoy.compareTo(birthday));
		System.out.println(hoy.compareTo(futureDay));
		System.out.println(hoy.compareTo(hoy));
		
		//Calendar
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DATE, 10);
		Date amonth = new Date(rightNow.getTimeInMillis());
		System.out.println(simpleDate.format(amonth));
	}
}
