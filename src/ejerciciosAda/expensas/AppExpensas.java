package ejerciciosAda.expensas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//El pago de expensas se realiza del 1 al 10 de cada mes, si se paga despues,
//se cobra 1% de recargo diario
//solicitar fecha de pago e importe
//calcular el total a pagar

public class AppExpensas {
	
	public static void main(String[] args) throws ParseException {
		Date vencimiento = toDate("10-10-2020");
		Date fechaPago = toDate("5-10-2020");
		float monto = 3200;
		
		Pago nuevoPago = new Pago(monto, fechaPago, vencimiento);
		System.out.println(nuevoPago.toString());
		
	}
	
	public static Date toDate(String fecha) throws ParseException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-mm-yyyy");
		return simpleDate.parse(fecha);
	}
}
