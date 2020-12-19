package ejerciciosAda.base.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejerciciosAda.base.model.Student;

public class StudentDAO {
	public static List<Student> getStudents(Connection connection) throws SQLException {
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
	
	public static Student findStudentById(Connection connection, int id) throws SQLException {
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
	
	public static List<Student> findStudentByNameAndLastname(Connection connection, String name, String lastname) throws SQLException {
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
	
	public static List<Student> findStudentByLastname(Connection connection, String lastname) throws SQLException {
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
	
	public static int insertStudent(Student student, Connection connection) throws SQLException {
		String insertString = "INSERT INTO alumno (nombre, apellido, nombre_alternativo) values (?, ?, ?)";
		PreparedStatement addStudent = connection.prepareStatement(insertString);
		addStudent.setString(1, student.getName());
		addStudent.setString(2, student.getLastname());
		if(student.getAlternative_name() == null || student.getAlternative_name().length() == 0) {
			addStudent.setNull(3, java.sql.Types.NULL);
		} else {
			addStudent.setString(3, student.getAlternative_name());
		}
		return addStudent.executeUpdate();
	}
	
	public static int editStudent(Connection connection, Student student) throws SQLException {
		String editString = "UPDATE alumno SET nombre = ?, apellido = ?, nombre_alternativo = ? WHERE id = ?";
		PreparedStatement editAlumno = connection.prepareStatement(editString);
		int res = 0;
		if(student.getName().length() == 0 || student.getName() == null) {
			System.out.println("El nombre es requerido");
		} else if (student.getLastname().length() == 0 || student.getLastname() == null){
			System.out.println("El apellido es requerido");
		} else {
			editAlumno.setString(1, student.getName());
			editAlumno.setString(2, student.getLastname());
			if(student.getAlternative_name() == null || student.getAlternative_name().length() == 0) {
				editAlumno.setNull(3, java.sql.Types.NULL);
			} else {
				editAlumno.setString(3, student.getAlternative_name());
			}
			editAlumno.setInt(4, student.getId());
			res = editAlumno.executeUpdate();
		}
		return res;
	}
	
	public static int deleteStudent(int id, Connection connection) throws SQLException {
		String deleteString = "DELETE FROM alumno WHERE id = ?";
		PreparedStatement deleteStudent = connection.prepareStatement(deleteString);
		deleteStudent.setInt(1, id);
		return deleteStudent.executeUpdate();
	}
}
