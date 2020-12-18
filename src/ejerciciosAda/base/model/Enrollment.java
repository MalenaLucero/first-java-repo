package ejerciciosAda.base.model;

public class Enrollment {
	private int id;
	private int id_course;
	private int id_student;
	private int average_grade;
	private String state;
	private int year;
	
	public Enrollment(int id_course, int id_student) {
		this.id_course = id_course;
		this.id_student = id_student;
		this.state = "en curso";
		this.year = 2021;
	}
	
	public Enrollment(int id, int id_course, int id_student, int average_grade, String state, int year) {
		this.id = id;
		this.id_course = id_course;
		this.id_student = id_student;
		this.average_grade = average_grade;
		this.state = state;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public int getId_course() {
		return id_course;
	}

	public void setId_course(int id_course) {
		this.id_course = id_course;
	}

	public int getId_student() {
		return id_student;
	}

	public void setId_student(int id_student) {
		this.id_student = id_student;
	}

	public int getAverage_grade() {
		return average_grade;
	}

	public void setAverage_grade(int average_grade) {
		this.average_grade = average_grade;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		if(this.state.equals("en curso")) {
			return String.format("ID: %s - ID alumno: %s - ID curso: %s", id, id_student, id_course);
		} else {
			return String.format("ID: %s - ID alumno: %s - ID curso: %s - Estado: %s - Promedio: %s - Año: %s",
								id, id_student, id_course, state, average_grade, year);
		}
	}
}
