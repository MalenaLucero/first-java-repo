package ejerciciosAda.base.model;

public class Teacher {
	private int id;
	private String name;
	private String lastname;
	private String alternative_name1;
	private String alternative_name2;
	private String description;
	private String image;
	
	public Teacher(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}
	
	public Teacher(int id, String name, String lastname, String alternative_name1,
					String alternative_name2, String description, String image) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.alternative_name1 = alternative_name1;
		this.alternative_name2 = alternative_name2;
		this.description = description;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastnane() {
		return lastname;
	}

	public void setLastnane(String lastmane) {
		this.lastname = lastmane;
	}

	public String getAlternative_name1() {
		return alternative_name1;
	}

	public void setAlternative_name1(String alternative_name1) {
		this.alternative_name1 = alternative_name1;
	}

	public String getAlternative_name2() {
		return alternative_name2;
	}

	public void setAlternative_name2(String alternative_name2) {
		this.alternative_name2 = alternative_name2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String toString() {
		return String.format("ID: %s - Docente: %s %s - Imagen: %s", id, name, lastname, image);
	}
}
