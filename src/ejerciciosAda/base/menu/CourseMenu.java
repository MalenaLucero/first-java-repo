package ejerciciosAda.base.menu;

import java.sql.Connection;
import java.sql.SQLException;

import ejerciciosAda.base.DAO.CursoDAO;
import ejerciciosAda.base.controller.CursoController;
import ejerciciosAda.base.model.Curso;

public class CourseMenu {
	public static void printMenu() {
		System.out.println("------ MENU DE CURSOS ------");
		System.out.println("1. Listar cursos");
		System.out.println("2. Buscar curso");
		System.out.println("3. Agregar curso");
		System.out.println("4. Modificar curso");
		System.out.println("5. Eliminar curso");
		System.out.println("0. Volver al menu principal");
		System.out.println();
	}
	
	public static void chooseMenuOption(Connection connection, int option) throws SQLException {
		switch(option) {
		case 1:
			CursoController.listAll(connection);
			break;
		case 2:
			CursoController.getById(connection, 1);
			break;
		case 3:
			CursoController.getByName(connection, "mongo db");
			break;
		case 4:
			Curso course = new Curso("python");
			CursoController.insert(connection, course);
			break;
		case 5:
			Curso editCourse = CursoDAO.findById(connection, 17);
			CursoController.edit(connection, editCourse);
			break;
		case 6:
			CursoController.delete(connection, 17);
			break;
		}
	}
}
