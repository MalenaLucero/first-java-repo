package ejerciciosAda.base.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejerciciosAda.base.DAO.CursoDAO;
import ejerciciosAda.base.model.Curso;

public class CursoController {
	public static void listCourses(Connection connection) throws SQLException {
		System.out.println("Listado de cursos");
		List<Curso> courses = CursoDAO.getCourses(connection);
		if(courses.size() == 0) {
			System.err.println("No se encontraron cursos");
		} else {
			for(Curso course: courses) {
				System.out.println(course);
			}
		}
	}
	
	public static void getCourseById(Connection connection, int id) throws SQLException {
		Curso course = CursoDAO.findCourseById(connection, id);
		if(course == null) {
			System.err.println("No se encontro el curso");
		} else {
			System.out.println(course);
		}
	}
	
	public static void getCourseByName(Connection connection, String name) throws SQLException {
		Curso course = CursoDAO.findCourseByName(connection, name);
		if(course == null) {
			System.err.println("No se encontro el curso");
		} else {
			System.out.println(course);
		}
	}
	
	public static void addCourse(Connection connection, Curso course) throws SQLException {
		System.out.println("Agregar curso");
		if(CursoDAO.findCourseByName(connection, course.getName()) == null) {
			int res = CursoDAO.insertCourse(course, connection);
			if(res == 1) {
				System.out.println("Se agrego el curso");
			} else {
				System.err.println("No se agrego el curso");
			}
		} else {
			System.err.println("El curso ya existe");
		}
	}

	public static void modificarCurso(Connection connection, Curso course) throws SQLException {
		int res = CursoDAO.editCourse(connection, course);
		if(res == 1) {
			System.out.println("Se realizo la modificacion");
		} else {
			System.err.println("No se realizo la modificacion");
		}
	}
	
	public static void deleteCourse(Connection connection, int id) throws SQLException {
		System.out.println("Eliminar curso");
		int res = CursoDAO.deleteCourse(id, connection);
		if(res == 1) {
			System.out.println("El curso se elimino correctamente");
		} else {
			System.err.println("No se elimino el curso. Verificar que exista.");
		}
	}
}
