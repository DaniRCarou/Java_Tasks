package test;

import beans.model.Student;
import beans.model.Grade;

public class Main {

	public static void main(String[] args) {
		
		
		
		Student stu1 = new Student("Juan", 123);
		
		stu1.addcalificacion("Matemáticas", 60);
		stu1.addcalificacion("Lengua", 55);
		stu1.addcalificacion("Inglés", 93);
		stu1.addcalificacion("Física", 82);
		stu1.addcalificacion("Educación física", 82);
		stu1.addcalificacion("Biología y geología", 58);
		
		
		
		
		System.out.println(stu1.getName() + " - " + stu1.getRegister() + "\n");
		
		
		
		for (Grade ele: stu1.getGrades()) { 
		
		System.out.println(ele.getSubject() + ": " + ele.getGrade() + "\n");
		
		}
		
		
		
		System.out.println("AVERAGE GRADE: " + stu1.averageGrade());
		

	}

}
