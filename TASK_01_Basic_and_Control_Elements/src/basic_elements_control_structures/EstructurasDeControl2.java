package basic_elements_control_structures;

public class EstructurasDeControl2 {

	public static void main(String[] args) {
	
		
		
		
		
		// Ejercicio 3

		// Realiza un programa en Java que genere un número al azar entre 1 y 10.
		// Una vez generado, si el número es mayor de 5 mostrará en pantalla el mensaje “Hoy va a ser un gran día”, de lo contrario mostrará el mensaje “Hoy va a ser el mejor día del mundo”.
		
		
		int aleatorio = (int)(Math.random() * 10 + 1);
		
		
		
		if(aleatorio > 5) {		
			
			System.out.println("Hoy va a ser un gran día");
			
		}else
			
			System.out.println("Hoy va a ser el mejor día del mundo");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
