package ejerciciosAda.base.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejerciciosAda.base.DAO.CursoDAO;
import ejerciciosAda.base.model.Curso;
import ejerciciosAda.base.util.ResponseUtil;

public class CursoController {
	public static void listAll(Connection connection) throws SQLException {
		System.out.println("Listado de cursos");
		List<Curso> courses = CursoDAO.getAll(connection);
		if(courses.size() == 0) {
			System.err.println("No se encontraron cursos");
		} else {
			for(Curso course: courses) {
				System.out.println(course);
			}
		}
	}
	
	public static void getById(Connection connection, int id) throws SQLException {
		System.out.println("Buscar curso por ID");
		Curso course = CursoDAO.findById(connection, id);
		if(course == null) {
			System.err.println("No se encontro el curso");
		} else {
			System.out.println(course);
		}
	}
	
	public static void getByName(Connection connection, String name) throws SQLException {
		System.out.println("Buscar curso por nombre");
		Curso course = CursoDAO.findByName(connection, name);
		if(course == null) {
			System.err.println("No se encontro el curso");
		} else {
			System.out.println(course);
		}
	}
	
	public static void insert(Connection connection, Curso course) throws SQLException {
		System.out.println("Agregar curso");
		if(CursoDAO.findByName(connection, course.getName()) == null) {
			int res = CursoDAO.insert(course, connection);
			ResponseUtil.addMessage(res);
		} else {
			System.err.println("El curso ya existe");
		}
	}

	public static void edit(Connection connection, Curso course) throws SQLException {
		System.out.println("Editar curso");
		int res = CursoDAO.edit(connection, course);
		ResponseUtil.editMessage(res);
	}
	
	public static void delete(Connection connection, int id) throws SQLException {
		System.out.println("Eliminar curso");
		int res = CursoDAO.delete(id, connection);
		ResponseUtil.deleteMessage(res);
	}
}
