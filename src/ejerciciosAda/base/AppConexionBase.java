package ejerciciosAda.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AppConexionBase {
	public static void main(String[] args) {
		System.out.println("Bienvenido al sistema de cursos");
		
		try {
			System.out.println("Estableciendo conexion a la base de datos...");
			Connection connection = AdminDB.obtenerConexion();
			System.out.println("Conectado a la base de datos");
			Scanner sc = new Scanner(System.in);
			int opcion = menuOpciones(sc);
			while(opcion != 0) {
				switch(opcion){
				case 1:
					altaAlumno(sc, connection);
					break;
				case 2:
					modificarAlumno(sc, connection);
					break;
				case 3:
					eliminarAlumno(sc, connection);
					break;
				case 4:
					listarAlumnos(connection);
					break;
				case 5:
					buscarAlumno(sc, connection);
					break;
				case 6:
					inscribirAlumno(sc, connection);
					break;
				}
				opcion = menuOpciones(sc);
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Programa finalizado");
	}

	private static void inscribirAlumno(Scanner sc, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		System.out.println("ID alumno:");
		int idAlumno = sc.nextInt();
		System.out.println("ID curso:");
		int idCurso = sc.nextInt();
		statement.executeUpdate("insert into inscripcion (id_alumno, id_curso) values ("+ idAlumno +", "+ idCurso +")");
		System.out.println("Alumno inscripto correctamente");
	}

	private static void buscarAlumno(Scanner sc, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		System.out.println("ID:");
		int searchId = sc.nextInt();
		ResultSet res = statement.executeQuery("select * from alumno where id=" + searchId);
		while(res.next()) {
			String nombre = res.getString(2);
			String apellido = res.getString(3);
			int id = res.getInt(1);
			System.out.println(id + " " + nombre + " " + apellido);
		}
	}

	private static void eliminarAlumno(Scanner sc, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		System.out.println("ID:");
		int id = sc.nextInt();
		statement.executeUpdate("delete from alumno where id="+ id );
		System.out.println("Alumno eliminado");
	}

	private static void modificarAlumno(Scanner sc, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		System.out.println("ID:");
		int id = sc.nextInt();
		System.out.println("Nombre:");
		String nombre = sc.next();
		statement.executeUpdate("update alumno set nombre = '"+ nombre +"' where id="+ id );
		System.out.println("Alumno modificado");
	}

	private static void listarAlumnos(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery("select * from alumno");
		while(res.next()) {
			String nombre = res.getString(2);
			String apellido = res.getString(3);
			int id = res.getInt(1);
			System.out.println(id + " " + nombre + " " + apellido);
		}
	}

	private static void altaAlumno(Scanner sc, Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		System.out.println("Nombre:");
		String nombre = sc.next();
		System.out.println("Apellido:");
		String apellido = sc.next();
		statement.executeUpdate("insert into alumno (nombre, apellido) values ('"+ nombre +"', '"+ apellido +"')");
		System.out.println("Alumno creado");
	}

	private static int menuOpciones(Scanner sc) {
		System.out.println("Menu:");
		System.out.println("1. Alta alumno");
		System.out.println("2. Modificar alumno");
		System.out.println("3. Eliminar alumno");
		System.out.println("4. Listar alumnos");
		System.out.println("5. Buscar alumno por id");
		System.out.println("6. Inscribir alumno");
		System.out.println("0. Salir");
		return sc.nextInt();
	}
}
