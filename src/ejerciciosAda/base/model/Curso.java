package ejerciciosAda.base.model;

public class Curso {
	private int id;
	private String name;
	private int id_teacher;
	private int id_catedra;
	
	public Curso(String name) {
		this.name = name;
	}
	
	public Curso(int id, String name, int id_teacher, int id_catedra) {
		this.id = id;
		this.name = name;
		this.id_teacher = id_teacher;
		this.id_catedra = id_catedra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeacher() {
		return id_teacher;
	}

	public void setTeacher(int id_teacher) {
		this.id_teacher = id_teacher;
	}
	
	public int getCatedra() {
		return id_catedra;
	}

	public void setCatedra(int id_catedra) {
		this.id_catedra = id_catedra;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return String.format("ID: %s - Curso: %s", id, name);
	}
}
