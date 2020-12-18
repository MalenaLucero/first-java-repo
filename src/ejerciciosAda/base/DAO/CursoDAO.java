package ejerciciosAda.base.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejerciciosAda.base.model.Curso;

public class CursoDAO {
	public static List<Curso> getCourses(Connection connection) throws SQLException {
		String listString = "SELECT * from curso";
		PreparedStatement listCourses = connection.prepareStatement(listString);
		ResultSet res = listCourses.executeQuery();
		List<Curso> courses = new ArrayList<Curso>();
		while(res.next()) {
			Curso curso = new Curso(res.getInt("id"), res.getString("nombre"), res.getInt("id_docente"), res.getInt("id_catedra"));
			courses.add(curso);
		}
		return courses;
	}
	
	public static Curso findCourseById(Connection connection, int id) throws SQLException {
		String listString = "SELECT * from curso where id=?";
		PreparedStatement listCourses = connection.prepareStatement(listString);
		listCourses.setInt(1, id);
		ResultSet res = listCourses.executeQuery();
		Curso course = null;
		if(res.next()) {
			course = new Curso(res.getInt("id"), res.getString("nombre"), res.getInt("id_docente"), res.getInt("id_catedra"));
		}
		return course;
	}
	
	public static Curso findCourseByName(Connection connection, String name) throws SQLException {
		String listString = "SELECT * from curso where nombre=?";
		PreparedStatement listCourses = connection.prepareStatement(listString);
		listCourses.setString(1, name);
		ResultSet res = listCourses.executeQuery();
		Curso course = null;
		if(res.next()) {
			course = new Curso(res.getInt("id"), res.getString("nombre"), res.getInt("id_docente"), res.getInt("id_catedra"));
		}
		return course;
	}
	
	public static int insertCourse(Curso course, Connection connection) throws SQLException {
		String insertString = "INSERT INTO curso (nombre) values (?)";
		PreparedStatement addCourse = connection.prepareStatement(insertString);
		addCourse.setString(1, course.getName());
		return addCourse.executeUpdate();
	}
	
	public static int editCourse(Connection connection, Curso course) throws SQLException {
		String editString = "UPDATE curso SET nombre = ?, id_docente = ?, id_catedra = ? WHERE id = ?";
		PreparedStatement editCourse = connection.prepareStatement(editString);
		int res = 0;
		if(course.getName().length() == 0 || course.getName() == null) {
			System.out.println("El nombre del curso es requerido");
		} else {
			editCourse.setString(1, course.getName());
			if(course.getTeacher() == 0) {
				editCourse.setNull(2, java.sql.Types.NULL);
			} else {
				editCourse.setInt(2, course.getTeacher());
			}
			if(course.getCatedra() == 0) {
				editCourse.setNull(3, java.sql.Types.NULL);
			} else {
				editCourse.setInt(3, course.getCatedra());
			}
			editCourse.setInt(4, course.getId());
			res = editCourse.executeUpdate();
		}
		return res;
	}
	
	public static int deleteCourse(int id, Connection connection) throws SQLException {
		String deleteString = "DELETE FROM curso WHERE id = ?";
		PreparedStatement deleteCourse = connection.prepareStatement(deleteString);
		deleteCourse.setInt(1, id);
		return deleteCourse.executeUpdate();
	}
}
