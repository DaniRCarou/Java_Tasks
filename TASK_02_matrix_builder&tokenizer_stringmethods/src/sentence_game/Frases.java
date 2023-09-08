package sentence_game;

import java.util.Scanner;

public class Frases {

	public static void main(String[] args) {
		
		
		
		
		Scanner read = new Scanner(System.in);
		
		
		System.out.println("Escribe un texto: ");
		
		
		
		
		String sentence = read.nextLine();	
		
		
		
		
		System.out.println("El número de letras de la frase es: " + sentence.length());
		
		System.out.println("La frase en mayúsculas: " + sentence.toUpperCase());
		
		String[] atributosSentence = sentence.split(" ");
		
		
		
		System.out.println("Palabra a palabra");
		
		for(String atributos: atributosSentence) {
			
			
			System.out.println(" " + atributos); // Recorremos el array
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		int n_minusculas = 0;
		
		for ( int i = 0; i < sentence.length(); i++) {
			
			if (Character.isLowerCase(sentence.charAt(i))) {
				
				n_minusculas ++;
				
			}
						
		}
		
		
		System.out.println("Hay " + n_minusculas + " letras minúsculas.");
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("EL TRIÁNGULO");
		
		
		
		for ( int i = sentence.length() ; i >=0; i--) {
			
			System.out.println(sentence.substring(0,i));
			
			
						
		}
		
		
		
		
		
		read.close();
		

	}

}
