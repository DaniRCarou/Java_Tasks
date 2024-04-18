package restservice.client.entity;

// THIS IS A NORMAL JAVA BEAN

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
