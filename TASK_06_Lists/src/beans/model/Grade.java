package beans.model;

public class Grade {
	
	
	
	private String subject;

    private int grade; // value between 0 and 100

   

  

  public Grade(String subject, int grade) {
		super();
		this.subject = subject;
		this.grade = grade;
	}
  
  
  
  
    
  

public String getSubject() {
	return subject;
}


public void SetSubject(String subject) {
	this.subject = subject;
}


public int getGrade() {
	return grade;
}


public void setGrade(int grade) {
	this.grade = grade;
}











@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((subject == null) ? 0 : subject.hashCode());
	return result;
}






@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!(obj instanceof Grade))
		return false;
	Grade other = (Grade) obj;
	if (subject == null) {
		if (other.subject != null)
			return false;
	} else if (!subject.equals(other.subject))
		return false;
	return true;
}








@Override
public String toString() {
	return "Grade [subject=" + subject + ", grade=" + grade + "]";
}












}