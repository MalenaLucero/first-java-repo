package ejerciciosAda.base.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejerciciosAda.base.model.Student;

public class StudentDAO {
	public static List<Student> getAll(Connection connection) throws SQLException {
		String listString = "SELECT * FROM alumno";
		PreparedStatement listStudents = connection.prepareStatement(listString);
		ResultSet res = listStudents.executeQuery();
		List<Student> students = new ArrayList<Student>();
		while(res.next()) {
			Student student = new Student(res.getInt("id"), res.getString("nombre"), res.getString("apellido"), res.getString("nombre_alternativo"));
			students.add(student);
		}
		return students;
	}
	
	public static Student findById(Connection connection, int id) throws SQLException {
		String listString = "SELECT * from alumno WHERE id= ?";
		PreparedStatement findStudent = connection.prepareStatement(listString);
		findStudent.setInt(1, id);
		ResultSet res = findStudent.executeQuery();
		Student student = null;
		if(res.next()) {
			student = new Student(res.getInt("id"), res.getString("nombre"), res.getString("apellido"), res.getString("nombre_alternativo"));
		}
		return student;
	}
	
	public static List<Student> findByNameAndLastname(Connection connection, String name, String lastname) throws SQLException {
		String listString = "SELECT * from alumno WHERE nombre = ? AND apellido = ?";
		PreparedStatement findStudents = connection.prepareStatement(listString);
		findStudents.setString(1, name);
		findStudents.setString(2, lastname);
		ResultSet res = findStudents.executeQuery();
		List<Student> students = new ArrayList<Student>();
		while(res.next()) {
			Student student = new Student(res.getInt("id"), res.getString("nombre"), res.getString("apellido"), res.getString("nombre_alternativo"));
			students.add(student);
		}
		return students;
	}
	
	public static List<Student> findByLastname(Connection connection, String lastname) throws SQLException {
		String listString = "SELECT * from alumno WHERE apellido = ?";
		PreparedStatement findStudents = connection.prepareStatement(listString);
		findStudents.setString(1, lastname);
		ResultSet res = findStudents.executeQuery();
		List<Student> students = new ArrayList<Student>();
		while(res.next()) {
			Student student = new Student(res.getInt("id"), res.getString("nombre"), res.getString("apellido"), res.getString("nombre_alternativo"));
			students.add(student);
		}
		return students;
	}
	
	public static int insert(Student student, Connection connection) throws SQLException {
		String insertString = "INSERT INTO alumno (nombre, apellido, nombre_alternativo) values (?, ?, ?)";
		PreparedStatement addStudent = connection.prepareStatement(insertString);
		addStudent.setString(1, student.getName());
		addStudent.setString(2, student.getLastname());
		addStudent.setString(3, student.getAlternative_name());
		return addStudent.executeUpdate();
	}
	
	public static int edit(Connection connection, Student student) throws SQLException {
		String editString = "UPDATE alumno SET nombre = ?, apellido = ?, nombre_alternativo = ? WHERE id = ?";
		PreparedStatement editAlumno = connection.prepareStatement(editString);
		editAlumno.setString(1, student.getName());
		editAlumno.setString(2, student.getLastname());
		editAlumno.setString(3, student.getAlternative_name());
		editAlumno.setInt(4, student.getId());
		return editAlumno.executeUpdate();
	}
	
	public static int delete(int id, Connection connection) throws SQLException {
		String deleteString = "DELETE FROM alumno WHERE id = ?";
		PreparedStatement deleteStudent = connection.prepareStatement(deleteString);
		deleteStudent.setInt(1, id);
		return deleteStudent.executeUpdate();
	}
}
