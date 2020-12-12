package ejerciciosAda.base.model;

public class Curso {
	private int id;
	private String name;
	private String teacher;
	
	public Curso(String name, String teacher) {
		this.name = name;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return String.format("ID: %s - Curso: %s - Docente: %s", id, name, teacher);
	}
}
