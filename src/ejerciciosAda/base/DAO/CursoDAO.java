package ejerciciosAda.base.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejerciciosAda.base.model.Curso;

public class CursoDAO {
	public static List<Curso> getAll(Connection connection) throws SQLException {
		String listString = "SELECT * from curso";
		PreparedStatement listCourses = connection.prepareStatement(listString);
		ResultSet res = listCourses.executeQuery();
		List<Curso> courses = new ArrayList<Curso>();
		while(res.next()) {
			Curso curso = new Curso(res.getInt("id"), res.getString("nombre"), res.getInt("id_catedra"));
			courses.add(curso);
		}
		return courses;
	}
	
	public static Curso findById(Connection connection, int id) throws SQLException {
		String listString = "SELECT * from curso where id=?";
		PreparedStatement listCourses = connection.prepareStatement(listString);
		listCourses.setInt(1, id);
		ResultSet res = listCourses.executeQuery();
		Curso course = null;
		if(res.next()) {
			course = new Curso(res.getInt("id"), res.getString("nombre"), res.getInt("id_catedra"));
		}
		return course;
	}
	
	public static Curso findByName(Connection connection, String name) throws SQLException {
		String listString = "SELECT * from curso where nombre=?";
		PreparedStatement listCourses = connection.prepareStatement(listString);
		listCourses.setString(1, name);
		ResultSet res = listCourses.executeQuery();
		Curso course = null;
		if(res.next()) {
			course = new Curso(res.getInt("id"), res.getString("nombre"), res.getInt("id_catedra"));
		}
		return course;
	}
	
	public static int insert(Curso course, Connection connection) throws SQLException {
		String insertString = "INSERT INTO curso (nombre) values (?)";
		PreparedStatement addCourse = connection.prepareStatement(insertString);
		addCourse.setString(1, course.getName());
		return addCourse.executeUpdate();
	}
	
	public static int edit(Connection connection, Curso course) throws SQLException {
		String editString = "UPDATE curso SET nombre = ?, id_catedra = ? WHERE id = ?";
		PreparedStatement editCourse = connection.prepareStatement(editString);
		editCourse.setString(1, course.getName());
		if(course.getCatedra() == 0) {
			editCourse.setNull(2, java.sql.Types.NULL);
		} else {
			editCourse.setInt(2, course.getCatedra());
		}
		editCourse.setInt(3, course.getId());
		return editCourse.executeUpdate();
	}
	
	public static int delete(int id, Connection connection) throws SQLException {
		String deleteString = "DELETE FROM curso WHERE id = ?";
		PreparedStatement deleteCourse = connection.prepareStatement(deleteString);
		deleteCourse.setInt(1, id);
		return deleteCourse.executeUpdate();
	}
}
