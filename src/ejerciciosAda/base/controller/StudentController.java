package ejerciciosAda.base.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejerciciosAda.base.DAO.CursoDAO;
import ejerciciosAda.base.DAO.StudentDAO;
import ejerciciosAda.base.model.Curso;
import ejerciciosAda.base.model.Student;

public class StudentController {
	public static void listStudents(Connection connection) throws SQLException {
		System.out.println("Listado de alumnos");
		List<Student> students = StudentDAO.getStudents(connection);
		if(students.size() == 0) {
			System.err.println("No se encontraron alumnos");
		} else {
			for(Student student: students) {
				System.out.println(student);
			}
		}
	}
	
	public static void getStudentById(Connection connection, int id) throws SQLException {
		Student student = StudentDAO.findStudentById(connection, id);
		if(student == null) {
			System.err.println("No se encontro el alumno");
		} else {
			System.out.println(student);
		}
	}
	
	public static void getStudentsByLastname(Connection connection, String lastname) throws SQLException {
		List<Student> students = StudentDAO.findStudentByLastname(connection, lastname);
		if(students.size() == 0) {
			System.err.println("No se encontraron alumnos");
		} else {
			for(Student student: students) {
				System.out.println(student);
			}
		}
	}
	
	public static void addStudent(Connection connection, Student student) throws SQLException {
		System.out.println("Agregar alumno");
		List<Student> overlappingStudents = StudentDAO.findStudentByNameAndLastname(connection, student.getName(), student.getLastname());
		if(overlappingStudents.size() == 0) {
			int res = StudentDAO.insertStudent(student, connection);
			if(res == 1) {
				System.out.println("Se agrego el alumno");
			} else {
				System.err.println("No se agrego el alumno");
			}
		} else {
			System.err.println("Ya existe un alumno con ese nombre y apellido");
		}	
	}

	public static void editStudent(Connection connection, Student student) throws SQLException {
		int res = StudentDAO.editStudent(connection, student);
		if(res == 1) {
			System.out.println("Se realizo la modificacion");
		} else {
			System.err.println("No se realizo la modificacion");
		}
	}
	
	public static void deleteStudent(Connection connection, int id) throws SQLException {
		System.out.println("Eliminar alumno");
		int res = StudentDAO.deleteStudent(id, connection);
		if(res == 1) {
			System.out.println("El alumno se elimino correctamente");
		} else {
			System.err.println("No se elimino el alumno. Verificar que exista.");
		}
	}
}
