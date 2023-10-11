package sentence_game;

import java.util.Scanner;

public class EnglishTest {

	public static void main(String[] args) {
		

		// Exercise 3 (optional)

		/*
			Write a Java program that works according to the following specifications:

			- It should allow the user to enter multiple texts ending when typing the word END. Each text must be saved in an object of type String.
			- For each text entered (except the word END) the program must report the number of characters.
			- All the entered texts converted to uppercase must be concatenated (except the word END) into an object of type StringBuilder.
			- Within the StringBuilder object each new text must end with the semicolon character.
			- Finally, we must use an object of the StringTokenizer class to redisplay the texts entered on separate lines.
		
		*/
		
	
		
					int successes = 0;
					
					int failures = 0;
					
		
		
		
		
		// The scanner class must be imported, because it is in a different folder than the String, System class, which is in the root directory
		
		
		Scanner read = new Scanner(System.in);
		
		
		
		
		

		// Matrix containing 20 English words and the translation of each one.
		
		
		
		String matrizIngles[][] = {
				
				{"bear", "oso"}, 
				{"cat", "gato"}, 
				{"cheetah", "guepardo"}, 
				{"dog", "perro"}, 
				{"eagle", "águila"}, 
				{"fish", "pez"}, 
				{"frog", "rana"}, 
				{"horse", "caballo"}, 
				{"lion", "leon"}, 
				{"lizard", "lagarto"}, 
				{"meerkat", "suricata"}, 
				{"monkey", "mono"}, 
				{"orangutan", "orangután"}, 
				{"panther", "pantera"}, 
				{"parrot", "loro"}, 
				{"pig", "cerdo"}, 
				{"tiger", "tigre"}, 
				{"toad", "sapo"}, 
				{"tortoise", "tortuga"}, 
				{"yegua", "mare"}, 
				
		};
		
		
		
		
		
		
		
		
		
		
		
		// First I go through the Array one by one		
				
		for (int i=0; i<matrizIngles.length; i++) {			
			
			
						
			for(int j = 0; j < 1; j++) {	
				
				
			// The first time it shows the word to be translated on the screen in position i = 0 and j = 0; ("bear")
				
			System.out.println("Traduce: " + matrizIngles[i][j]);			
								
								
				
			}		
			
			
			
			// The introduction of the word is required
			
			String animal = read.next();			
					
			
			
			
			
			// Now I continue going through the Array, at position i = 0, because I am still inside the main array that is still at position i = 0
			
			
			for(int j = 1; j < 2; j++) {
				
				
				
				
				
				
			// Here I save the word that is in position i=0 and j=1 in a variable				
				
			String traduc = matrizIngles[i][j];
			
			
				
				
				
			
			// Now I compare the word at position i=0 and j=1 with the word saved in the animal variable, which was the text entered by the console
			// If they are equal, it indicates it is correct and if they are not equal I say it is incorrect and show the word that corresponds to that position
				
			if(animal.equals(traduc)) {
					
				System.out.println("Es correcto");
					
				// add a success
					
				successes ++;
					
			}else {
					
				System.out.println("No es correcto, es un: " + matrizIngles[i][j] );
					
				// add a failure
					
				failures ++;
					
			}			
			
				
				
				
				
							
			}	
			
			
			
			
			
			read.close();
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		System.out.println("\nEND OF THE TEST\n\nYou have had " + successes + " successes.\nYou have had " + failures + " failures.");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
