package basic_elements_control_structures;

public class ControlElements4 {

	public static void main(String[] args) {
		
		
		// Exercise 5

		/*
		 Create a Java program that generates a random number between 1 and 5. 
		 Once generated, you must use a multiple alternative structure (switch) to write a different text string on the screen, 
		 depending on the number generated.
		*/


		
		int random = (int)(Math.random() * 10 + 1);  // also -> random = (int) (Math.random()*5+1);
		
		
		
		while(random > 5) {			
			
			random = (int)(Math.random() * 10 + 1);			
			
		}
		
		
		
		switch(random){
		
		case 1: 
			
		System.out.println("Hello");
			
			break; 							// Without "break" couldn´t read each line and only would show the line "default"
			
		case 2:
			
		System.out.println("Good morning");
				
			break; 	
			
		case 3:  
			
		System.out.println("Good afternoon");
		
			break;
		
		case 4:  
			
		System.out.println("Good night");
					
			break; 
		
		case 5:  
			
			System.out.println("bye bye");
			
		default: 
			
			System.out.println("That is a wrong number");					
		
		}
		
		
		

	}

}
