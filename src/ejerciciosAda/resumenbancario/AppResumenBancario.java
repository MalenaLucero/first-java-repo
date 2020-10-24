package ejerciciosAda.resumenbancario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//el resumen bancario del cliente tiene los ultimos seis movimientos de la cuenta
//los movimientos tienen fecha, importe y pueden ser retiros o depositos
//se pide ingresar los movimientos y luego listarlos ordenados de menor a mayor
//entre las fechas dadas o bien todos los movimientos

public class AppResumenBancario {
	public static final int CANTIDAD_MOVIMIENTOS = 5;
	
	public static void main(String[] args) throws ParseException {
		Movimiento[] movimientos = new Movimiento[CANTIDAD_MOVIMIENTOS];
		cargarMovimientos(movimientos);
		System.out.println("MOVIMIENTOS CARGADOS");
		imprimirMovimientos(movimientos);
		
		Movimiento[] movimientosPorMonto = movimientos.clone();
		ordenarPorMonto(movimientosPorMonto);
		System.out.println();
		System.out.println("MOVIMIENTOS ORDENADOS POR MONTO");
		imprimirMovimientos(movimientosPorMonto);
		
		Movimiento[] movimientosPorFecha = movimientos.clone();
		ordenarPorFecha(movimientosPorFecha);
		System.out.println();
		System.out.println("MOVIMIENTOS ORDENADOR POR FECHA");
		imprimirMovimientos(movimientosPorFecha);
		
		
	}
	
	private static void ordenarPorFecha(Movimiento[] movimientos) {
		for (int i = 0; i < movimientos.length - 1; i++) {
            for (int j = 0; j < movimientos.length - 1; j++) { 
            	if (movimientos[j].getFecha().getTime() > movimientos[j + 1].getFecha().getTime()) {
                    Movimiento temp = movimientos[j + 1];
                    movimientos[j + 1] = movimientos[j];
                    movimientos[j] = temp;
                }
            }
        }
		
	}

	private static void cargarMovimientos(Movimiento[] movimientos) throws ParseException {
		float monto = 100;
		String fecha = "24-10-2020";
		Deposito nuevoDeposito = new Deposito(monto, formatearFecha(fecha));
		
		float monto1 = 300;
		String fecha1 = "22-10-2020";
		Deposito nuevoDeposito1 = new Deposito(monto1, formatearFecha(fecha1));
		
		float monto2 = 200;
		String fecha2 = "23-10-2020";
		Retiro nuevoRetiro = new Retiro(monto2, formatearFecha(fecha2));
		
		float monto3 = 400;
		String fecha3 = "20-10-2020";
		Retiro nuevoRetiro3 = new Retiro(monto3, formatearFecha(fecha3));
		
		float monto4 = 50;
		String fecha4 = "25-10-2020";
		Retiro nuevoRetiro4 = new Retiro(monto4, formatearFecha(fecha4));
		
		movimientos[0] = nuevoDeposito;
		movimientos[1] = nuevoDeposito1;
		movimientos[2] = nuevoRetiro;
		movimientos[3] = nuevoRetiro3;
		movimientos[4] = nuevoRetiro4;
	}

	public static Date formatearFecha(String fecha) throws ParseException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-mm-yyyy");
		return simpleDate.parse(fecha);
	}
	
	public static void imprimirMovimientos(Movimiento[] movimientos) {
		for(Movimiento mov: movimientos) {
			System.out.println(mov.toString());
		}
	}
	
	public static void ordenarPorMonto(Movimiento[] movimientosPorMonto) {
		for (int i = 0; i < movimientosPorMonto.length - 1; i++) {
            for (int j = 0; j < movimientosPorMonto.length - 1; j++) { 
            	if (movimientosPorMonto[j].getMonto() > movimientosPorMonto[j + 1].getMonto()) {
                    Movimiento temp = movimientosPorMonto[j + 1];
                    movimientosPorMonto[j + 1] = movimientosPorMonto[j];
                    movimientosPorMonto[j] = temp;
                }
            }
        }
	}
}
