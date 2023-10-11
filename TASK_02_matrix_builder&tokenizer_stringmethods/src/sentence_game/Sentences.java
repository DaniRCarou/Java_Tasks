package sentence_game;

import java.util.Scanner;

public class Sentences {

	public static void main(String[] args) {
		
		
		
		// Exercise 2

		/* 
		 
		 Write a Java program that works according to the following specifications: 

		    - It must allow the user to enter text via keyboard.
		    - The length of the text (number of characters) will be displayed on the screen.
		    - The text will be displayed in capital letters.
		    - The text will be displayed separated by words (each word on one line) using the split() method.
		    - The number of lowercase letters will be counted.
		    - A triangle will be displayed with the entered text.
		
		 */
		
		
		Scanner read = new Scanner(System.in);
		
		
		System.out.println("Write a text: ");
		
		
		
		
		String sentence = read.nextLine();	
		
		
		
		
		System.out.println("The number of the letters in the sentence is: " + sentence.length());
		
		System.out.println("The sentence in capital letters is: " + sentence.toUpperCase());
		
		String[] atributesSentence = sentence.split(" ");
		
		
		
		System.out.println("word by word");
		
		for(String atributes: atributesSentence) {			
			
			System.out.println(" " + atributes); // loop through the array
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		int n_lowercase = 0;
		
		for ( int i = 0; i < sentence.length(); i++) {
			
			if (Character.isLowerCase(sentence.charAt(i))) {
				
				n_lowercase ++;
				
			}
						
		}
		
		
		System.out.println("There are " + n_lowercase + " lowercase letters.");
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("THE TRIANGLE");
		
		
		
		for ( int i = sentence.length() ; i >=0; i--) {
			
			System.out.println(sentence.substring(0,i));
			
			
						
		}
		
		
		
		
		
		read.close();
		

	}

}
