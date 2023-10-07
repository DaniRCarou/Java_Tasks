package abstraction_test;

import abstraction_model.Administrative;
import abstraction_model.Profesor;
import abstraction_model.Student;

public class Main {

	public static void main(String[] args) {
		
		
		
		Profesor prof1 = new Profesor("9875a", "Juan", "calle 1", "098564275", "matemáticas");
		
		Student student1 = new Student("84957b", "Raul", "calle 2", "89798067", "1");
		
		Administrative adm1 = new Administrative("84957c", "Brais", "calle 3", "89465067", "calls");
		
		
		
		System.out.println("-------------------String--------------------");
		
		System.out.println(prof1);
		
		System.out.println(student1);
		
		System.out.println(adm1);
		
		
		System.out.println("-------------------work()--------------------");
		
		System.out.println(prof1.work());
		
		System.out.println(student1.work());
		
		System.out.println(adm1.work());
		
		
		System.out.println("-------------------tasks--------------------");
		
		System.out.println(student1.call(prof1));
		
		System.out.println(student1.work());
		
		System.out.println(prof1.work());
		
		System.out.println(adm1.work());
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
