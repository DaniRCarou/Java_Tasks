package beans.model;
import java.util.ArrayList;

public class Student {
	

	
	private String name;
	
	private int register;
	
	// private ArrayList<Calificacion> calificaciones = new ArrayList<>();
	
	private ArrayList<Grade> grades;
	
	
	public Student() {
		super();
		grades = new ArrayList<>();
	}




	public Student(String name, int register) {
		super();
		this.name = name;
		this.register = register;
		grades = new ArrayList<>(); // Starting array
	}
	
	


	public String getName() {
		return name;
	}



	public int getRegister() {
		return register;
	}


	public ArrayList<Grade> getGrades() {
		return grades;
	}



	public void addcalificacion(String subject, int grade) {

       grades.add(new Grade(subject, grade));		
		
	}
	
	
	
	public double averageGrade() {
		
		int sum = 0;
		for (Grade ele: grades) {
			
			sum += ele.getGrade();
			
		}
		
		return sum / grades.size();
		
	}
	
	
	
	
	
	
	
	
	




	@Override
	public String toString() {
		return "Student [name=" + name + ", register=" + register + ", grades=" + grades + "]";
	}





	
	
	

	
	
	
	

}
