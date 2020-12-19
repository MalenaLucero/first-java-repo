package ejerciciosAda.base.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejerciciosAda.base.model.Enrollment;

public class EnrollmentDAO {
	public static List<Enrollment> getAll(Connection connection) throws SQLException {
		String listString = "SELECT * FROM inscripcion";
		PreparedStatement listEnrollments = connection.prepareStatement(listString);
		ResultSet res = listEnrollments.executeQuery();
		List<Enrollment> enrollments = new ArrayList<Enrollment>();
		while(res.next()) {
			Enrollment enrollment = new Enrollment(res.getInt("id"), res.getInt("id_curso"), res.getInt("id_alumno"),
					res.getString("estado_inscripcion"), res.getInt("id_docente"), res.getString("comision"), res.getInt("nota1"),
					res.getInt("nota2"), res.getInt("promedio"), res.getString("estado_cursada"), res.getInt("ciclo_lectivo"));
			enrollments.add(enrollment);
		}
		return enrollments;
	}
	
	public static Enrollment findById(Connection connection, int id) throws SQLException {
		String listString = "SELECT * FROM inscripcion WHERE id= ?";
		PreparedStatement findEnrollment = connection.prepareStatement(listString);
		findEnrollment.setInt(1, id);
		ResultSet res = findEnrollment.executeQuery();
		Enrollment enrollment = null;
		if(res.next()) {
			enrollment = new Enrollment(res.getInt("id"), res.getInt("id_curso"), res.getInt("id_alumno"),
					res.getString("estado_inscripcion"), res.getInt("id_docente"), res.getString("comision"), res.getInt("nota1"),
					res.getInt("nota2"), res.getInt("promedio"), res.getString("estado_cursada"), res.getInt("ciclo_lectivo"));
		}
		return enrollment;
	}
	
	public static List<Enrollment> findByCourseAndStudent(Connection connection, int id_course, int id_student) throws SQLException {
		String listString = "SELECT * FROM inscripcion WHERE id_curso = ? AND id_alumno = ?";
		PreparedStatement findEnrollments = connection.prepareStatement(listString);
		findEnrollments.setInt(1, id_course);
		findEnrollments.setInt(2, id_student);
		ResultSet res = findEnrollments.executeQuery();
		List<Enrollment> enrollments = new ArrayList<Enrollment>();
		while(res.next()) {
			Enrollment enrollment = new Enrollment(res.getInt("id"), res.getInt("id_curso"), res.getInt("id_alumno"),
					res.getString("estado_inscripcion"), res.getInt("id_docente"), res.getString("comision"), res.getInt("nota1"),
					res.getInt("nota2"), res.getInt("promedio"), res.getString("estado_cursada"), res.getInt("ciclo_lectivo"));
			enrollments.add(enrollment);
		}
		return enrollments;
	}
	
	public static int insert(Enrollment enrollment, Connection connection) throws SQLException {
		String insertString = "INSERT INTO inscripcion (id_curso, id_alumno, estado_inscripcion, id_docente, comision, nota1, nota2, promedio, estado_cursada, ciclo_lectivo)"
								+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement addEnrollment = connection.prepareStatement(insertString);
		addEnrollment.setInt(1, enrollment.getId_course());
		addEnrollment.setInt(2, enrollment.getId_student());
		addEnrollment.setString(3, enrollment.getEnrollment_state());
		if(enrollment.getId_teacher() == 0) {
			addEnrollment.setNull(4, java.sql.Types.NULL);
		} else {
			addEnrollment.setInt(4, enrollment.getId_teacher());
		}
		addEnrollment.setString(5, enrollment.getDivision());
		if(enrollment.getGrade1() == 0) {
			addEnrollment.setNull(6, java.sql.Types.NULL);
		} else {
			addEnrollment.setInt(6, enrollment.getGrade1());
		}
		if(enrollment.getGrade2() == 0) {
			addEnrollment.setNull(7, java.sql.Types.NULL);
		} else {
			addEnrollment.setInt(7, enrollment.getGrade2());
		}
		if(enrollment.getAverage_grade() == 0) {
			addEnrollment.setNull(8, java.sql.Types.NULL);
		} else {
			addEnrollment.setInt(8, enrollment.getAverage_grade());
		}
		addEnrollment.setString(9, enrollment.getState());
		addEnrollment.setInt(10, enrollment.getYear());
		return addEnrollment.executeUpdate();
	}
	
	public static int edit(Connection connection, Enrollment enrollment) throws SQLException {
		String editString = "UPDATE inscripcion SET id_curso = ?, id_alumno = ?, estado_inscripcion = ?,"
				+ "id_docente = ?, comision = ?, nota1 = ?, nota2 = ?, promedio = ?,"
				+ "estado_cursada = ?, ciclo_lectivo = ? WHERE id = ?";
		PreparedStatement editEnrollment = connection.prepareStatement(editString);
		editEnrollment.setInt(1, enrollment.getId_course());
		editEnrollment.setInt(2, enrollment.getId_student());
		editEnrollment.setString(3, enrollment.getEnrollment_state());
		if(enrollment.getId_teacher() == 0) {
			editEnrollment.setNull(4, java.sql.Types.NULL);
		} else {
			editEnrollment.setInt(4, enrollment.getId_teacher());
		}
		editEnrollment.setString(5, enrollment.getDivision());
		if(enrollment.getGrade1() == 0) {
			editEnrollment.setNull(6, java.sql.Types.NULL);
		} else {
			editEnrollment.setInt(6, enrollment.getGrade1());
		}
		if(enrollment.getGrade2() == 0) {
			editEnrollment.setNull(7, java.sql.Types.NULL);
		} else {
			editEnrollment.setInt(7, enrollment.getGrade2());
		}
		if(enrollment.getAverage_grade() == 0) {
			editEnrollment.setNull(8, java.sql.Types.NULL);
		} else {
			editEnrollment.setInt(8, enrollment.getAverage_grade());
		}
		editEnrollment.setString(9, enrollment.getState());
		editEnrollment.setInt(10, enrollment.getYear());
		editEnrollment.setInt(11, enrollment.getId());
		return editEnrollment.executeUpdate();
	}
	
	public static int delete(int id, Connection connection) throws SQLException {
		String deleteString = "DELETE FROM inscripcion WHERE id = ?";
		PreparedStatement deleteEnrollment = connection.prepareStatement(deleteString);
		deleteEnrollment.setInt(1, id);
		return deleteEnrollment.executeUpdate();
	}
}
