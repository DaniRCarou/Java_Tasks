package sentence_game;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GuardarMostrarTexto {

	public static void main(String[] args) {
	
		
		
		
		Scanner read = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		
		
		
		System.out.println("Write a text:");	
		
		
		String text = read.nextLine();	// Cada texto debe guardarse en un objeto de tipo String.	
		
		
		
		// Aquí debe permitir al usuario introducir varios textos terminando cuando escriba la palabra FIN.
		
		while(!text.contains("FIN")){		
				
			sb.append(text.toUpperCase() + ";"); // Se deben ir concatenando todos los textos introducidos convertidos a mayúsculas (menos la palabra FIN) en un objeto de tipo StringBuilder. Dentro del objeto StringBuilder cada texto nuevo debe terminar con el carácter punto y coma.
			
			System.out.println("Length: " + text.length());	// Por cada texto introducido (menos la palabra FIN) el programa debe informar del número de caracteres.			
					
			System.out.println("Write a text:");			
		
			text = read.nextLine();	// Cada texto debe guardarse en un objeto de tipo String.			
			
		}
		
		
		
		
		String solution = sb.toString(); // Pasamos a String, una variable de tipo StringBuilder para poder utulizarla a continuación en el "stk" ya que admite una cadena de caracteres, o variable de tipo String
		
				
		StringTokenizer	stk = new StringTokenizer(solution,";"); // Por último, debemos utilizar un objeto de la clase StringTokenizer para volver a mostrar los textos introducidos en líneas separadas.			
		
		
		// Siempre se lee con un while	
		// Comprueba que mientras haya tokens realice lo que indicamos
		
		while(stk.hasMoreElements()) {
			
			System.out.println(stk.nextElement());
			
		}
		
		
		
		
		read.close();
		
		
		
	}	

}


