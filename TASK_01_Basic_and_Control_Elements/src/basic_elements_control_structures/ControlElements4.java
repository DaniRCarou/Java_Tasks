package basic_elements_control_structures;

public class ControlElements4 {

	public static void main(String[] args) {
		
		
		// Exercise 5

		// Realiza un programa en Java que genere un número al azar entre 1 y 5. 
		// Una vez generado deberás utilizar una estructura alternativa múltiple (switch) para escribir en pantalla una cadena de texto diferente, según el número generado.
		
		
		int aleatorio = (int)(Math.random() * 10 + 1);  // también valdría -> aleatorio = (int) (Math.random()*5+1);
		
		
		
		while(aleatorio > 5) {			
			
			aleatorio = (int)(Math.random() * 10 + 1);			
			
		}
		
		
		
		switch(aleatorio){
		
		case 1: 
			
		System.out.println("Hello");
			
			break; 							// Sin "break" no leería cada línea y solo mostraría la línea "default" // Without "break" it wouldn´t read each line and would only show the "default" line
			
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
