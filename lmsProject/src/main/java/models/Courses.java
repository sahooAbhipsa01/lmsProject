package models;

public class Courses {
	private int id;
    private String name;
    private int instructorId;
	public Courses(int id, String name, int instructorId) {
		super();
		this.id = id;
		this.name = name;
		this.instructorId = instructorId;
	}
	public Courses() {}
	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", instructorId=" + instructorId + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

}
