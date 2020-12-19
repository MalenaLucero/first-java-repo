package ejerciciosAda.base.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejerciciosAda.base.model.Enrollment;

public class EnrollmentDAO {
	public static List<Enrollment> getEnrollments(Connection connection) throws SQLException {
		String listString = "SELECT * FROM inscripcion";
		PreparedStatement listEnrollments = connection.prepareStatement(listString);
		ResultSet res = listEnrollments.executeQuery();
		List<Enrollment> enrollments = new ArrayList<Enrollment>();
		while(res.next()) {
			Enrollment enrollment = new Enrollment(res.getInt("id"), res.getInt("id_curso"), res.getInt("id_alumno"),
					res.getInt("promedio"), res.getString("estado"), res.getInt("ciclo_lectivo"));
			enrollments.add(enrollment);
		}
		return enrollments;
	}
	
	public static Enrollment findEnrollmentById(Connection connection, int id) throws SQLException {
		String listString = "SELECT * FROM inscripcion WHERE id= ?";
		PreparedStatement findEnrollment = connection.prepareStatement(listString);
		findEnrollment.setInt(1, id);
		ResultSet res = findEnrollment.executeQuery();
		Enrollment enrollment = null;
		if(res.next()) {
			enrollment = new Enrollment(res.getInt("id"), res.getInt("id_curso"), res.getInt("id_alumno"),
					res.getInt("promedio"), res.getString("estado"), res.getInt("ciclo_lectivo"));
		}
		return enrollment;
	}
	
	public static List<Enrollment> findEnrollmentByCourseAndStudent(Connection connection, int id_course, int id_student) throws SQLException {
		String listString = "SELECT * FROM inscripcion WHERE id_curso = ? AND id_alumno = ?";
		PreparedStatement findEnrollments = connection.prepareStatement(listString);
		findEnrollments.setInt(1, id_course);
		findEnrollments.setInt(2, id_student);
		ResultSet res = findEnrollments.executeQuery();
		List<Enrollment> enrollments = new ArrayList<Enrollment>();
		while(res.next()) {
			Enrollment enrollment = new Enrollment(res.getInt("id"), res.getInt("id_curso"), res.getInt("id_alumno"),
					res.getInt("promedio"), res.getString("estado"), res.getInt("ciclo_lectivo"));
			enrollments.add(enrollment);
		}
		return enrollments;
	}
	
	public static int insertEnrollment(Enrollment enrollment, Connection connection) throws SQLException {
		String insertString = "INSERT INTO inscripcion (id_curso, id_alumno, promedio, estado, ciclo_lectivo)"
								+ "values (?, ?, ?, ?, ?)";
		PreparedStatement addEnrollment = connection.prepareStatement(insertString);
		addEnrollment.setInt(1, enrollment.getId_course());
		addEnrollment.setInt(2, enrollment.getId_student());
		if(enrollment.getAverage_grade() == 0) {
			addEnrollment.setNull(3, java.sql.Types.NULL);
		} else {
			addEnrollment.setInt(3, enrollment.getAverage_grade());
		}
		if(enrollment.getState() == null || enrollment.getState().length() == 0) {
			addEnrollment.setNull(4, java.sql.Types.NULL);
		} else {
			addEnrollment.setString(4, enrollment.getState());
		}
		if(enrollment.getYear() == 0) {
			addEnrollment.setNull(5, java.sql.Types.NULL);
		} else {
			addEnrollment.setInt(5, enrollment.getYear());
		}
		return addEnrollment.executeUpdate();
	}
	
	public static int editEnrollment(Connection connection, Enrollment enrollment) throws SQLException {
		String editString = "UPDATE inscripcion SET id_curso = ?, id_alumno = ?, promedio = ?,"
							+ " estado = ?, ciclo_lectivo = ? WHERE id = ?";
		PreparedStatement editEnrollment = connection.prepareStatement(editString);
		int res = 0;
		if(enrollment.getId_course() == 0 || enrollment.getId_student() == 0) {
			System.out.println("El ID de curso y alumno son requeridos");
		} else if (enrollment.getYear() == 0){
			System.out.println("El año es requerido");
		} else if (enrollment.getState() == null || enrollment.getState().length() == 0) {
			System.out.println("El estado es requerido");
		} else {
			editEnrollment.setInt(1, enrollment.getId_course());
			editEnrollment.setInt(2, enrollment.getId_student());
			editEnrollment.setString(4, enrollment.getState());
			editEnrollment.setInt(5, enrollment.getYear());
			if(enrollment.getAverage_grade() == 0) {
				editEnrollment.setNull(3, java.sql.Types.NULL);
			} else {
				editEnrollment.setInt(3, enrollment.getAverage_grade());
			}
			editEnrollment.setInt(6, enrollment.getId());
			res = editEnrollment.executeUpdate();
		}
		return res;
	}
	
	public static int deleteEnrollment(int id, Connection connection) throws SQLException {
		String deleteString = "DELETE FROM inscripcion WHERE id = ?";
		PreparedStatement deleteEnrollment = connection.prepareStatement(deleteString);
		deleteEnrollment.setInt(1, id);
		return deleteEnrollment.executeUpdate();
	}
}
