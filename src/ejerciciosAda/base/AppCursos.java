package ejerciciosAda.base;

import java.sql.Connection;
import java.sql.SQLException;

import ejerciciosAda.base.DAO.AdminDB;
import ejerciciosAda.base.DAO.CursoDAO;
import ejerciciosAda.base.DAO.EnrollmentDAO;
import ejerciciosAda.base.DAO.StudentDAO;
import ejerciciosAda.base.controller.CursoController;
import ejerciciosAda.base.controller.EnrollmentController;
import ejerciciosAda.base.controller.StudentController;
import ejerciciosAda.base.model.Curso;
import ejerciciosAda.base.model.Enrollment;
import ejerciciosAda.base.model.Student;
import ejerciciosAda.base.util.MenuUtil;

public class AppCursos {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = AdminDB.obtenerConexion();
		System.out.println("Bienvenido al sistema de cursos");
		MenuUtil.printMainMenu();
		int option = 3;
	
		switch(option) {
		case 1:
			courses(connection);
			break;
		case 2: 
			students(connection);
			break;
		case 3:
			enrollment(connection);
			break;
		}
		System.out.println("Programa finalizado");
	}

	private static void courses(Connection connection) throws SQLException {
		MenuUtil.printCoursesMenu();
		int courseOption = 6;
		switch(courseOption) {
		case 1:
			CursoController.listCourses(connection);
			break;
		case 2:
			CursoController.getCourseById(connection, 1);
			break;
		case 3:
			CursoController.getCourseByName(connection, "mongo db");
			break;
		case 4:
			Curso course = new Curso("python");
			CursoController.addCourse(connection, course);
			break;
		case 5:
			Curso editCourse = CursoDAO.findCourseById(connection, 14);
			editCourse.setTeacher(0);
			CursoController.modificarCurso(connection, editCourse);
			break;
		case 6:
			CursoController.deleteCourse(connection, 16);
			break;
		}
	}
	
	private static void students(Connection connection) throws SQLException {
		MenuUtil.printStudentsMenu();
		int studentOption = 4;
		switch(studentOption) {
		case 1:
			StudentController.listStudents(connection);
			break;
		case 2:
			StudentController.getStudentById(connection, 2);
			break;
		case 3:
			StudentController.getStudentsByLastname(connection, "Kurou");
			break;
		case 4:
			Student student = new Student("Touru", "Oikawa", "及川徹");
			StudentController.addStudent(connection, student);
			break;
		case 5:
			Student editStudent = StudentDAO.findStudentById(connection, 14);
			editStudent.setName("Kenma");
			StudentController.editStudent(connection, editStudent);
			break;
		case 6:
			StudentController.deleteStudent(connection, 2);
			break;
		}
	}
	
	private static void enrollment(Connection connection) throws SQLException {
		int enrollmentOption = 5;
		switch(enrollmentOption) {
		case 1:
			EnrollmentController.listEnrollments(connection);
			break;
		case 2:
			EnrollmentController.getEnrollmentById(connection, 1);
			break;
		case 3:
			EnrollmentController.getEnrollmentByCourseAndStudent(connection, 5, 1);
			break;
		case 4:
			Enrollment enrollment = new Enrollment(1, 3);
			EnrollmentController.addEnrollment(connection, enrollment);
			break;
		case 5:
			Enrollment editEnrollment = EnrollmentDAO.findEnrollmentById(connection, 5);
			editEnrollment.setAverage_grade(10);
			EnrollmentController.editEnrollment(connection, editEnrollment);
			break;
		case 6:
			EnrollmentController.deleteEnrollment(connection, 6);
			break;
		}
	}
}
