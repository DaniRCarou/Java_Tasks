package sentence_game;

import java.util.Scanner;

public class Sentences {

	public static void main(String[] args) {
		
		
		
		
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
