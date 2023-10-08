package test;

import beans.model.Student;
import beans.model.Grade;

public class Main {

	public static void main(String[] args) {
		
		
		
		Student stu1 = new Student("Juan", 123);
		
		stu1.addcalificacion("Matem�ticas", 60);
		stu1.addcalificacion("Lengua", 55);
		stu1.addcalificacion("Ingl�s", 93);
		stu1.addcalificacion("F�sica", 82);
		stu1.addcalificacion("Educaci�n f�sica", 82);
		stu1.addcalificacion("Biolog�a y geolog�a", 58);
		
		
		
		
		System.out.println(stu1.getName() + " - " + stu1.getRegister() + "\n");
		
		
		
		for (Grade ele: stu1.getGrades()) { 
		
		System.out.println(ele.getSubject() + ": " + ele.getGrade() + "\n");
		
		}
		
		
		
		System.out.println("AVERAGE GRADE: " + stu1.averageGrade());
		

	}

}
