package ejerciciosAda.expensas;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Pago {
	private static final float RECARGO = 0.01f;
	float monto;
	float montoFinal;
	Date fechaPago;
	Date fechaVencimiento;
	
	public Pago(float monto, Date fechaPago, Date fechaVencimiento) {
		this.monto = monto;
		this.fechaPago = fechaPago;
		this.fechaVencimiento = fechaVencimiento;
		int diasDiferencia = diasDiferencia(fechaVencimiento, fechaPago);
		montoFinal = diasDiferencia > 0 ? calcularMontoFinal(diasDiferencia) : monto; 
	}
	
	private float calcularMontoFinal(int diasDiferencia) {
		return (RECARGO * diasDiferencia + 1) * monto;
	}
	
	private static int diasDiferencia(Date fecha1, Date fecha2) {
		Calendar calendar1 = toCalendar(fecha1);
		Calendar calendar2 = toCalendar(fecha2);
		return (int)Duration.between(calendar1.toInstant(), calendar2.toInstant()).toDays();
	}
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
	public String toString() {
		return String.format("Monto inicial: $%s, Monto final: $%s", monto, montoFinal);
	}
}
