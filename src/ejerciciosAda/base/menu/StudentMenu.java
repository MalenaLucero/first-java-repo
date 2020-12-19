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
			StudentController.listAll(connection);
			break;
		case 2:
			StudentController.getById(connection, 2);
			break;
		case 3:
			StudentController.getByLastname(connection, "Kurou");
			break;
		case 4:
			Student student = new Student("Touru", "Oikawa", "及川徹");
			StudentController.insert(connection, student);
			break;
		case 5:
			Student editStudent = StudentDAO.findById(connection, 14);
			editStudent.setName("Kenma");
			StudentController.edit(connection, editStudent);
			break;
		case 6:
			StudentController.delete(connection, 2);
			break;
		}
	}
}
