package basic_elements_control_structures;

public class EstructurasDeControl2 {

	public static void main(String[] args) {
	
		
		
		
		
		// Ejercicio 3

		// Realiza un programa en Java que genere un n�mero al azar entre 1 y 10.
		// Una vez generado, si el n�mero es mayor de 5 mostrar� en pantalla el mensaje �Hoy va a ser un gran d�a�, de lo contrario mostrar� el mensaje �Hoy va a ser el mejor d�a del mundo�.
		
		
		int aleatorio = (int)(Math.random() * 10 + 1);
		
		
		
		if(aleatorio > 5) {		
			
			System.out.println("Hoy va a ser un gran d�a");
			
		}else
			
			System.out.println("Hoy va a ser el mejor d�a del mundo");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
