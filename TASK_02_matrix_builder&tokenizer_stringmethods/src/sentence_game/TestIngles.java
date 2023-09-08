package sentence_game;

import java.util.Scanner;

public class TestIngles {

	public static void main(String[] args) {
		

		
		// Creo dos variables, una para los aciertos y otra para los fallos
		
					int aciertos = 0;
					
					int fallos = 0;
					
		
		
		
		
		// La clase scanner hay que importarla, porque está en una carpeta distinta a la clase String, System, que se encuentran en el directorio raíz
		
		
		Scanner read = new Scanner(System.in);
		
		

		// Matriz que contiene 20 palabras en inglés y la traducción de cada una.
		
		
		
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
		
		
		
		
		
		
		
		
		
		
		
		// Primero recorro de uno en uno el Array
		// Este Array contiene 3 "i"
		// Entra en el primer "i", {"bear", "oso"} mientras sea menor que el tamaño de las "i", es decir que 3
		
				
		for (int i=0; i<matrizIngles.length; i++) {
			
			
			
			
			
			
			
			// Cada "i"Tiene 2 "j"
			// Entra en el primer "j", "bear"
			// Presenta por pantalla que traduzca el "i=0", "j=0" ->"bear", mientras "j" sea menor que 1. Es decir que solo coja la posición 0
			
			
			for(int j = 0; j < 1; j++) {	
				
				
				// La primera vez muestra por pantalla la palabra a traducir en la pos i = 0 y j = 0; ("bear")
				
				System.out.println("Traduce: " + matrizIngles[i][j]);			
								
								
				
				}		
			
			
			
				
			
			
			
			// Se pide la introducción de la palabra
			
			String animal = read.next();
			
			
			
					
			
			
			
			
			// Ahora sigo recorriendo el Array, en la posición i = 0, porque aún sigo dentro del array principal que aún está en la posición i = 0
			
			
			for(int j = 1; j < 2; j++) {	
				
				
				
				// Aquí guardo en una variable la palabra que se encuentra en la posición i=0 y j=1				
				
				String traduc = matrizIngles[i][j];
				
				
				
				// Ahora comparo la palabra de la posición i=0 y j=1 con la palabra guardada en la variable animal, que fue el texto introducido por consola
				// Si son iguales, digo que es correcto y si no son iguales digo que es incorrecto y muestro la palabra que se corresponde con esa posición
				
				if(animal.equals(traduc)) {
					
					System.out.println("Es correcto");
					
					// añado un acierto
					
					aciertos ++;
					
				}else {
					
					System.out.println("No es correcto, es un: " + matrizIngles[i][j] );
					
					// añado un fallo
					
					fallos ++;
					
				}
				
							
			}	
			
			
			
			
			
			read.close();
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		System.out.println("\nFIN DEL TEST\n\nHas tenido " + aciertos + " aciertos.\nHas tenido " + fallos + " fallos.");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
