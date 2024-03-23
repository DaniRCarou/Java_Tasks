package restservice.model.entity;


// This is the entity we will work with in our REST service
// The basic operations that can be performed with this entity are: Create, Delete, Update and read. This is called a CRUD


public class VideoGame {
	
	
	private int id;
	private String name;
	private String company;
	private int grade;

	
	
	public VideoGame() {
		super();
	}



	public VideoGame(int id, String name, String company, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.grade = grade;
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



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "VideoGame [id=" + id + ", name=" + name + ", company=" + company + ", grade=" + grade + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
