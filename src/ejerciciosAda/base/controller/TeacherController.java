package ejerciciosAda.base.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejerciciosAda.base.DAO.EnrollmentDAO;
import ejerciciosAda.base.DAO.TeacherDAO;
import ejerciciosAda.base.model.Enrollment;
import ejerciciosAda.base.model.Teacher;

public class TeacherController {
	public static void listTeachers(Connection connection) throws SQLException {
		System.out.println("Listado de docentes");
		List<Teacher> teachers = TeacherDAO.getTeachers(connection);
		if(teachers.size() == 0) {
			System.err.println("No se encontraron docentes");
		} else {
			for(Teacher teacher: teachers) {
				System.out.println(teacher);
			}
		}
	}
	
	public static void getEnrollmentById(Connection connection, int id) throws SQLException {
		Enrollment enrollment = EnrollmentDAO.findEnrollmentById(connection, id);
		if(enrollment == null) {
			System.err.println("No se encontro la inscripcion");
		} else {
			System.out.println(enrollment);
		}
	}
	
	public static void getEnrollmentByCourseAndStudent(Connection connection, int id_course, int id_student) throws SQLException {
		List<Enrollment> enrollments = EnrollmentDAO.findEnrollmentByCourseAndStudent(connection, id_course, id_student);
		if(enrollments.size() == 0) {
			System.err.println("No se encontraron inscripciones");
		} else {
			for(Enrollment enrollment: enrollments) {
				System.out.println(enrollment);
			}
		}
	}
	
	public static void addEnrollment(Connection connection, Enrollment enrollment) throws SQLException {
		System.out.println("Agregar inscripcion");
		List<Enrollment> overlappingEnrollments = EnrollmentDAO.findEnrollmentByCourseAndStudent(connection, enrollment.getId_course(), enrollment.getId_student());
		boolean isSameYear = false;
		for(Enrollment overlappingEnrollment: overlappingEnrollments) {
			if(overlappingEnrollment.getYear() == enrollment.getYear()) isSameYear = true;
		}
		if(!isSameYear) {
			int res = EnrollmentDAO.insertEnrollment(enrollment, connection);
			if(res == 1) {
				System.out.println("La inscripcion se realizo de manera exitosa");
			} else {
				System.err.println("No se pudo realizar la inscripcion");
			}
		} else {
			System.err.println("El alumno ya esta inscripto en el curso");
		}	
	}

	public static void editEnrollment(Connection connection, Enrollment enrollment) throws SQLException {
		int res = EnrollmentDAO.editEnrollment(connection, enrollment);
		if(res == 1) {
			System.out.println("Se realizo la modificacion");
		} else {
			System.err.println("No se realizo la modificacion");
		}
	}
	
	public static void deleteEnrollment(Connection connection, int id) throws SQLException {
		System.out.println("Eliminar inscripcion");
		int res = EnrollmentDAO.deleteEnrollment(id, connection);
		if(res == 1) {
			System.out.println("La inscripcion se elimino correctamente");
		} else {
			System.err.println("No se elimino la inscripcion. Verificar que exista.");
		}
	}
}
