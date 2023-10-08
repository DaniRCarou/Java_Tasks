package basic_elements_control_structures;

public class ControlStructures3 {

	public static void main(String[] args) {
		
		
		// Exercise 4

		/*
		 Create a Java program that generates random numbers between 1 and 10. 
		 Each generated number must be displayed on the screen, ending when the number 7 is generated. 
		 The program must also report how many numbers had to be generated to obtain the 7.
		*/
		
		
		
		
		
		int random = (int)(Math.random() * 10 + 1);
		
		int counter = 0;
		
		while(random != 7) {	
			
			counter ++;
			
			System.out.println(random);
			
			random = (int)(Math.random() * 10 + 1);
			
		}
		
		
		counter ++;
		
		System.out.println("\nFinalmente, se ha obtenido el número " + random + " después de haberse generado " + counter + " números.");
		
		
		
		
		
		
		
		
		
	}

}
