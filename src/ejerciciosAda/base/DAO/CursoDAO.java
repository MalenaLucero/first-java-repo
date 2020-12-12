package ejerciciosAda.base.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejerciciosAda.base.model.Curso;

public class CursoDAO {
	public static List<Curso> listarCursos(Connection connection) throws SQLException {
		String listString = "SELECT * from curso";
		PreparedStatement listCourses = connection.prepareStatement(listString);
		ResultSet res = listCourses.executeQuery();
		List<Curso> courses = new ArrayList<Curso>();
		while(res.next()) {
			Curso curso = new Curso(res.getString("name"), res.getString("teacher"));
			curso.setId(res.getInt("id"));
			courses.add(curso);
		}
		return courses;
	}
	
	public static Curso findCourseById(int id, Connection connection) throws SQLException {
		String listString = "SELECT * from curso where id=?";
		PreparedStatement listCourses = connection.prepareStatement(listString);
		listCourses.setInt(1, id);
		ResultSet res = listCourses.executeQuery();
		List<Curso> courses = new ArrayList<Curso>();
		while(res.next()) {
			Curso curso = new Curso(res.getString("name"), res.getString("teacher"));
			curso.setId(res.getInt("id"));
			courses.add(curso);
		}
		return courses.get(0);
	}
	
	public static int insertCourse(Curso course, Connection connection) throws SQLException {
		String insertString = "INSERT INTO curso (name, teacher) values (?, ?)";
		PreparedStatement addCourse = connection.prepareStatement(insertString);
		addCourse.setString(1, course.getName());
		addCourse.setString(2, course.getTeacher());
		return addCourse.executeUpdate();
	}
}
