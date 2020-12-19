package ejerciciosAda.base.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejerciciosAda.base.DAO.EnrollmentDAO;
import ejerciciosAda.base.model.Enrollment;
import ejerciciosAda.base.util.ResponseUtil;

public class EnrollmentController {
	public static void listAll(Connection connection) throws SQLException {
		System.out.println("Listado de inscripciones");
		List<Enrollment> enrollments = EnrollmentDAO.getAll(connection);
		if(enrollments.size() == 0) {
			System.err.println("No se encontraron inscripciones");
		} else {
			for(Enrollment enrollment: enrollments) {
				System.out.println(enrollment);
			}
		}
	}
	
	public static void getById(Connection connection, int id) throws SQLException {
		Enrollment enrollment = EnrollmentDAO.findById(connection, id);
		if(enrollment == null) {
			System.err.println("No se encontro la inscripcion");
		} else {
			System.out.println(enrollment);
		}
	}
	
	public static void getByCourseAndStudent(Connection connection, int id_course, int id_student) throws SQLException {
		List<Enrollment> enrollments = EnrollmentDAO.findByCourseAndStudent(connection, id_course, id_student);
		if(enrollments.size() == 0) {
			System.err.println("No se encontraron inscripciones");
		} else {
			for(Enrollment enrollment: enrollments) {
				System.out.println(enrollment);
			}
		}
	}
	
	public static void insert(Connection connection, Enrollment enrollment) throws SQLException {
		System.out.println("Agregar inscripcion");
		List<Enrollment> overlappingEnrollments = EnrollmentDAO.findByCourseAndStudent(connection, enrollment.getId_course(), enrollment.getId_student());
		boolean isSameYear = false;
		for(Enrollment overlappingEnrollment: overlappingEnrollments) {
			if(overlappingEnrollment.getYear() == enrollment.getYear()) isSameYear = true;
		}
		if(!isSameYear) {
			int res = EnrollmentDAO.insert(enrollment, connection);
			ResponseUtil.addMessage(res);
		} else {
			System.err.println("El alumno ya esta inscripto en el curso");
		}	
	}

	public static void edit(Connection connection, Enrollment enrollment) throws SQLException {
		System.out.println("Editar inscripcion");
		int res = EnrollmentDAO.edit(connection, enrollment);
		ResponseUtil.editMessage(res);
	}
	
	public static void delete(Connection connection, int id) throws SQLException {
		System.out.println("Eliminar inscripcion");
		int res = EnrollmentDAO.delete(id, connection);
		ResponseUtil.deleteMessage(res);
	}
}
