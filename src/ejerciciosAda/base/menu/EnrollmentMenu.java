package ejerciciosAda.base.menu;

import java.sql.Connection;
import java.sql.SQLException;

import ejerciciosAda.base.DAO.EnrollmentDAO;
import ejerciciosAda.base.controller.EnrollmentController;
import ejerciciosAda.base.model.Enrollment;

public class EnrollmentMenu {
	public static void printMenu() {
		System.out.println("------ MENU DE INSCRIPCION ------");
		System.out.println("1. Listar");
		System.out.println("2. Buscar");
		System.out.println("3. Agregar");
		System.out.println("4. Modificar");
		System.out.println("5. Eliminar");
		System.out.println("0. Volver al menu principal");
		System.out.println();
	}
	
	public static void chooseMenuOption(Connection connection, int option) throws SQLException {
		switch(option) {
		case 1:
			EnrollmentController.listEnrollments(connection);
			break;
		case 2:
			EnrollmentController.getEnrollmentById(connection, 1);
			break;
		case 3:
			EnrollmentController.getEnrollmentByCourseAndStudent(connection, 5, 1);
			break;
		case 4:
			Enrollment enrollment = new Enrollment(1, 3);
			EnrollmentController.addEnrollment(connection, enrollment);
			break;
		case 5:
			Enrollment editEnrollment = EnrollmentDAO.findEnrollmentById(connection, 10);
			editEnrollment.setState("aprobado");
			editEnrollment.setYear(2020);
			EnrollmentController.editEnrollment(connection, editEnrollment);
			break;
		case 6:
			EnrollmentController.deleteEnrollment(connection, 11);
			break;
		}
	}
}
