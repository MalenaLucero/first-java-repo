package ejerciciosAda.base.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejerciciosAda.base.DAO.TeacherDAO;
import ejerciciosAda.base.model.Teacher;
import ejerciciosAda.base.util.ResponseUtil;

public class TeacherController {
	public static void listAll(Connection connection) throws SQLException {
		System.out.println("Listado de docentes");
		List<Teacher> teachers = TeacherDAO.getAll(connection);
		if(teachers.size() == 0) {
			System.err.println("No se encontraron docentes");
		} else {
			for(Teacher teacher: teachers) {
				System.out.println(teacher);
			}
		}
	}
	
	public static void getById(Connection connection, int id) throws SQLException {
		System.out.println("Buscar docente por ID");
		Teacher teacher = TeacherDAO.findById(connection, id);
		if(teacher == null) {
			System.err.println("No se encontro el docente");
		} else {
			System.out.println(teacher);
		}
	}
	
	public static void getByLastname(Connection connection, String lastname) throws SQLException {
		System.out.println("Buscar docentes por apellido");
		List<Teacher> teachers = TeacherDAO.findByLastname(connection, lastname);
		if(teachers.size() == 0) {
			System.err.println("No se encontraron docentes");
		} else {
			for(Teacher teacher: teachers) {
				System.out.println(teacher);
			}
		}
	}
	
	public static void insert(Connection connection, Teacher teacher) throws SQLException {
		System.out.println("Agregar docente");
		int res = TeacherDAO.insert(teacher, connection);
		ResponseUtil.addMessage(res);
	}

	public static void edit(Connection connection, Teacher teacher) throws SQLException {
		System.out.println("Editar docente");
		int res = TeacherDAO.edit(connection, teacher);
		ResponseUtil.editMessage(res);
	}
	
	public static void delete(Connection connection, int id) throws SQLException {
		System.out.println("Eliminar docente");
		int res = TeacherDAO.delete(id, connection);
		ResponseUtil.deleteMessage(res);
	}
}
