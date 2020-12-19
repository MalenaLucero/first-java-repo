package ejerciciosAda.base;

import java.sql.Connection;
import java.sql.SQLException;

import ejerciciosAda.base.DAO.AdminDB;
import ejerciciosAda.base.menu.CourseMenu;
import ejerciciosAda.base.menu.EnrollmentMenu;
import ejerciciosAda.base.menu.MenuTeacher;
import ejerciciosAda.base.menu.StudentMenu;
import ejerciciosAda.base.util.MenuUtil;

//1. ABML de profes
//2. Inscripcion y cancelacion de inscripcion -> columna estado_inscripcion 1 Activo 0:Cancelado
// Inscripcion y cancelacion por Id de estudiante y Id de curso
//3. Agregar 2 notas a la tabla inscripcion (int)
//4. Agregar columna id_profesor en la inscripcion
//5. Agregar columna comision (varchar) en la inscripcion
//5. 2 Listados de inscripcion:
//a - esutiantes de un curso seleccionado (a eleccion)
//b - notas de un estudiante en un curso

public class AppCursos {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = AdminDB.obtenerConexion();
		System.out.println("Bienvenido al sistema de cursos");
		MenuUtil.printMainMenu();
		int option = 4;
	
		switch(option) {
		case 1:
			courses(connection);
			break;
		case 2: 
			students(connection);
			break;
		case 3:
			enrollment(connection);
			break;
		case 4:
			teacher(connection);
			break;
		}
		System.out.println("Programa finalizado");
	}

	private static void courses(Connection connection) throws SQLException {
		CourseMenu.printMenu();
		int option = 6;
		CourseMenu.chooseMenuOption(connection, option);
	}
	
	private static void students(Connection connection) throws SQLException {
		StudentMenu.printMenu();
		int option = 1;
		StudentMenu.chooseMenuOption(connection, option);
	}
	
	private static void enrollment(Connection connection) throws SQLException {
		EnrollmentMenu.printMenu();
		int option = 5;
		EnrollmentMenu.chooseMenuOption(connection, option);
	}
	
	private static void teacher(Connection connection) throws SQLException {
		MenuTeacher.printMenu();
		int option = 1;
		MenuTeacher.chooseMenuOption(connection, option);
	}
}
