package ejerciciosAda.base.menu;

import java.sql.Connection;
import java.sql.SQLException;

import ejerciciosAda.base.DAO.StudentDAO;
import ejerciciosAda.base.controller.StudentController;
import ejerciciosAda.base.model.Student;

public class StudentMenu {
	public static void printMenu() {
		System.out.println("------ MENU DE ALUMNOS ------");
		System.out.println("1. Listar alumnos");
		System.out.println("2. Buscar alumno");
		System.out.println("3. Agregar alumno");
		System.out.println("4. Modificar alumno");
		System.out.println("5. Eliminar alumno");
		System.out.println("0. Volver al menu principal");
		System.out.println();
	}
	
	public static void chooseMenuOption(Connection connection, int option) throws SQLException {
		switch(option) {
		case 1:
			StudentController.listStudents(connection);
			break;
		case 2:
			StudentController.getStudentById(connection, 2);
			break;
		case 3:
			StudentController.getStudentsByLastname(connection, "Kurou");
			break;
		case 4:
			Student student = new Student("Touru", "Oikawa", "及川徹");
			StudentController.addStudent(connection, student);
			break;
		case 5:
			Student editStudent = StudentDAO.findStudentById(connection, 14);
			editStudent.setName("Kenma");
			StudentController.editStudent(connection, editStudent);
			break;
		case 6:
			StudentController.deleteStudent(connection, 2);
			break;
		}
	}
}
