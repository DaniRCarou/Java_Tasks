package abstraction_model;

public class Student extends Person {
	
	
	
	
	private String grade;
	

	public Student(String nif, String name, String address, String phone, String grade) {
		super(nif, name, address, phone);
		this.grade = grade;
		
		
		
	}
	
	

	


	public String getGrade() {
		return grade;
	}
	
	

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

	@Override
	public String work() {
		
		return "Student " + getName() + " is going to study for the grade " + grade + ".";
		
	}
	
	
	
	
	
	// Class methods
	
	public String doingExamn() {
			
		return "Student " + getName() + " is going to do an exam.";
			
	}
	
		
	
	
	
	
	
	@Override
	public String toString() {
		return "Alumno [Nif: " + getNif() + ", Name: " + getName() + ", Address: " + getAddress()
				+ ", Phone: " + getPhone() + " Grade: " + grade + "]" ;
	}
	
	
	
	
	

}
