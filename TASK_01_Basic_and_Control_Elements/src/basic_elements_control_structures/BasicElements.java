package basic_elements_control_structures;

public class BasicElements {

	public static void main(String[] args) {		
		
		
		// Exercise 1
		

		/*
		 
		 Declare a variable called num1 and assign it a random value from 1 to 20. 
		 Then declare another variable called num2. 
		 If num1 is between 5 and 15 (inclusive), it assigns the result of the num1+15 operation to num2, otherwise it assigns the result of the num1+5 operation to num2. 
		 At the end it shows the value of both variables on the screen.
		
		*/
		
		
		
		int num1 = 10;
		
		int num2 = 0;
		
		
		
		if(num1 >=5 & num1 <=15) {
			
			num2 = num1+15;
			
		}else 
			num2 = num1+5;
		
		
		
		System.out.println("The value of the num1 variable is: " + num1 + "\n" + "The value of the num2 variable is: " + num2);
		
		
		

	}

}
