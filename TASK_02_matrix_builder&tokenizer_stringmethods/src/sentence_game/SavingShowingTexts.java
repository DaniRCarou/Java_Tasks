package sentence_game;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SavingShowingTexts {

	public static void main(String[] args) {
	
		
		
		
		
		// Exercise 1

		/* 
		 
		 Write a Java program that can be used to perform a small English test on the user. 
		 The test will consist of the translation of 20 words from English to Spanish. 
		 The test words will be extracted from a matrix of 20 rows and 2 columns. 
		 
		*/
		
		
		Scanner read = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		
		
		
		System.out.println("Write a text:");	
		
		
		String text = read.nextLine();								// Each text must be saved in an object of type String.


		
				
		// Here you should allow the user to enter multiple texts ending when they type the word END.
		
		
		while(!text.contains("END")){		
				
			sb.append(text.toUpperCase() + ";"); 					// All entered texts converted to uppercase must be concatenated (except the word END) into an object of type StringBuilder. Within the StringBuilder object each new text must end with the semicolon character.
			
			System.out.println("Length: " + text.length());			// For each text entered (except the word END) the program must report the number of characters.
					
			System.out.println("Write a text:");			
		
			text = read.nextLine();									// Each text must be saved in an object of type String.			
			
		}
		
		
		
		
		String solution = sb.toString(); 							// We pass to String, a variable of type StringBuilder to be able to use it later in the "stk" object, since it admits a string of characters, or variable of type String
		
				
		StringTokenizer	stk = new StringTokenizer(solution,";"); 	// Finally, we must use an object of the StringTokenizer class to redisplay the texts entered on separate lines.
		
		
		
		
		// It is always read with a while. Check that while there are tokens, do what we indicate
		
		
		while(stk.hasMoreElements()) {
			
			System.out.println(stk.nextElement());
			
		}
		
		
		
		
		read.close();
		
		
		
	}	

}


