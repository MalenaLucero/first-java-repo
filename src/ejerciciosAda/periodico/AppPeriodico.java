package ejerciciosAda.periodico;

import java.util.Scanner;

//Existen publicaciones que pueden ser notas (escritas o video) y publicidad
//el portal puede tener 10 publicaciones online
//las publicidades se cobran en funcion del tamaño que ocupan en la pantalla
//las notas tienen autor, seccion, etc
//descubrir las clases y atributos necesarios para modelar el sistema
//conocer el total facturado en la publicacion

public class AppPeriodico {
	private static int TOTAL_PUBLICACIONES = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Publicacion[] publicaciones = new Publicacion[TOTAL_PUBLICACIONES];
		float totalFacturado = 0;
		
		for(int i=0; i<TOTAL_PUBLICACIONES; i++) {
			int tipo = solicitarInt("Ingresar tipo de publicacion: 1.Nota, 2.Publicidad, 0.Salir", sc);
			if(tipo == 1) {
				String titulo = solicitarString("Ingresar titulo", sc);
				String autor = solicitarString("Ingresar autor", sc);
				Nota nuevaNota = new Nota(titulo, autor);
				publicaciones[i] = nuevaNota;
			} else if(tipo == 2) {
				int tamano = solicitarInt("Ingresar tamaño", sc);
				Publicidad nuevaPublicidad = new Publicidad(tamano);
				publicaciones[i] = nuevaPublicidad;
				totalFacturado += nuevaPublicidad.getPrecio();
				System.out.println(totalFacturado);
			}
		}
		
		System.out.println(totalFacturado);

	}
	
	private static String solicitarString(String mensaje, Scanner sc) {
		System.out.println(mensaje);
		return sc.next();
	}
	
	private static float solicitarFloat(String mensaje, Scanner sc) {
		System.out.println(mensaje);
		return sc.nextFloat();
	}
	
	private static int solicitarInt(String mensaje, Scanner sc) {
		System.out.println(mensaje);
		return sc.nextInt();
	}

}
