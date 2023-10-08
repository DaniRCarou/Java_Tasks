package basic_elements_control_structures;

public class ControlStructures {

	public static void main(String[] args) {
		
		
		
		// Exercise 2

		/*		 
		  We need to count in reverse order of 10 by 10 from 100 to 10 (100, 90, 80, …, 10). 
		  Create two Java programs, each with two different control structures, that perform the indicated task.		
		*/
		
		
		System.out.println("------------while-----------\n");
		
		
		int num = 100;
		
		
		while(num >= 10){
		
		System.out.println(num);	
			
		num -= 10;			
			
		}
		
		
		
		
		
		System.out.println("\n------------do while-----------\n");
		
		
		
		
		
		
		int num2 = 100;
		
		
		do {
			
			System.out.println(num2);	
			
			num2 -= 10;				
			
		}while(num2 >= 10);
				
		
		
		
		
		
		System.out.println("\n------------for-----------\n");
		
		
		
		
		
		for( int i = 100; i >= 10; i -= 10) {
				
			System.out.println(i);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
