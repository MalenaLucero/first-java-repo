package ejerciciosAda.base.util;

public class MenuUtil {
	public static void printMainMenu() {
		System.out.println("------ MENU PRINCIPAL ------");
		System.out.println("1. Cursos");
		System.out.println("2. Alumnos");
		System.out.println("3. Inscripciones");
		System.out.println("0. Salir");
		System.out.println();
	}
	
	public static void printInscriptionsMenu() {
		System.out.println("------ MENU DE INSCRIPCIONES ------");
		System.out.println("1. Inscribir alumno");
		System.out.println("2. Modificar inscripcion");
		System.out.println("3. Eliminar inscripcion");
		System.out.println("4. Buscar alumnos por curso");
		System.out.println("5. Listar inscripciones");
		System.out.println("0. Volver al menu principal");
		System.out.println();
	}
}
