package abstraction_model;

public class Profesor extends Person {
	
	
	
	
	private String competencies;
	
	

	


	public Profesor(String nif, String name, String address, String phone, String competencies) {
		super(nif, name, address, phone);
		this.competencies = competencies;
	}
	
	
	
	
	
	
	
	public String getCompetencies() {
		return competencies;
	}



	public void setCompetencies(String competencies) {
		this.competencies = competencies;
	}







	@Override
	public String work() {
		// TODO Auto-generated method stub
		return "Profesor " + getName() + " is going to teach a class.";
	}




	
	
	
	
	// Class methods
	
	public String givingGrade() {
		
		return "Profesor " + getName() + " is going to revise exams";
		
	}







	@Override
	public String toString() {
		return "Profesor [Nif: " + getNif() + ", Name: " + getName() + ", Address: " + getAddress()
				+ ", Phone: " + getPhone() + " Competencies: " + competencies + "]" ;
	}

	
	
	

	


	

}
