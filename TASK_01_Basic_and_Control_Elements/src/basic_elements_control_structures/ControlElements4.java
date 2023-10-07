package basic_elements_control_structures;

public class ControlElements4 {

	public static void main(String[] args) {
		
		
		// Exercise 5

		// Realiza un programa en Java que genere un n�mero al azar entre 1 y 5. 
		// Una vez generado deber�s utilizar una estructura alternativa m�ltiple (switch) para escribir en pantalla una cadena de texto diferente, seg�n el n�mero generado.
		
		
		int aleatorio = (int)(Math.random() * 10 + 1);  // tambi�n valdr�a -> aleatorio = (int) (Math.random()*5+1);
		
		
		
		while(aleatorio > 5) {			
			
			aleatorio = (int)(Math.random() * 10 + 1);			
			
		}
		
		
		
		switch(aleatorio){
		
		case 1: 
			
		System.out.println("Hello");
			
			break; 							// Sin "break" no leer�a cada l�nea y solo mostrar�a la l�nea "default" // Without "break" it wouldn�t read each line and would only show the "default" line
			
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
