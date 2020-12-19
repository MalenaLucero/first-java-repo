package ejerciciosAda.base.model;

public class Enrollment {
	private int id;
	private int id_course;
	private int id_student;
	private String enrollment_state;
	private int id_teacher;
	private String division;
	private int grade1;
	private int grade2;
	private int average_grade;
	private String state;
	private int year;
	
	public Enrollment(int id_course, int id_student) {
		this.id_course = id_course;
		this.id_student = id_student;
		this.enrollment_state = "activo";
		this.division = "A";
		this.state = "en curso";
		this.year = 2021;
	}
	
	public Enrollment(int id, int id_course, int id_student, String enrollment_state, int id_teacher,
			String division, int grade1, int grade2, int average_grade, String state, int year) {
		this.id = id;
		this.id_course = id_course;
		this.id_student = id_student;
		this.enrollment_state = enrollment_state;
		this.id_teacher = id_teacher;
		this.division = division;
		this.grade1 = grade1;
		this.grade2 = grade2;
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
		if(average_grade < 1 || average_grade > 10) {
			System.out.println("Promedio invalido");
		} else {
			this.average_grade = average_grade;
		}
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
	
	public String getEnrollment_state() {
		return enrollment_state;
	}

	public void setEnrollment_state(String enrollment_state) {
		this.enrollment_state = enrollment_state;
	}

	public int getId_teacher() {
		return id_teacher;
	}

	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getGrade1() {
		return grade1;
	}

	public void setGrade1(int grade1) {
		this.grade1 = grade1;
	}

	public int getGrade2() {
		return grade2;
	}

	public void setGrade2(int grade2) {
		this.grade2 = grade2;
	}

	public String toString() {
		if(this.average_grade == 0) {
			return String.format("ID: %s - ID alumno: %s - ID curso: %s", id, id_student, id_course);
		} else {
			return String.format("ID: %s - ID alumno: %s - ID curso: %s - Estado: %s - Promedio: %s - Año: %s",
								id, id_student, id_course, state, average_grade, year);
		}
	}
}
