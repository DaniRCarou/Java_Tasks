package basic_elements_control_structures;

public class EstructurasDeControl3 {

	public static void main(String[] args) {
		
		
		// Ejercicio 4

		// Realiza un programa en Java que vaya generando n�meros al azar entre 1 y 10. 
		// Cada n�mero generado debe mostrarse en pantalla, terminando cuando se genere el n�mero 7. 
		// El programa tambi�n deber� informar sobre cu�ntos n�meros se han tenido que generar para obtener el 7.
		
		
		
		
		
		int aleatorio = (int)(Math.random() * 10 + 1);
		
		int contador = 0;
		
		while(aleatorio != 7) {	
			
			contador ++;
			
			System.out.println(aleatorio);
			
			aleatorio = (int)(Math.random() * 10 + 1);
			
		}
		
		
		contador ++;
		
		System.out.println("\nFinalmente, se ha obtenido el n�mero " + aleatorio + " despu�s de haberse generado " + contador + " n�meros.");
		
		
		
		
		
		
		
		
		
	}

}
