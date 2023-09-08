package basic_elements_control_structures;

public class EstructurasDeControl3 {

	public static void main(String[] args) {
		
		
		// Ejercicio 4

		// Realiza un programa en Java que vaya generando números al azar entre 1 y 10. 
		// Cada número generado debe mostrarse en pantalla, terminando cuando se genere el número 7. 
		// El programa también deberá informar sobre cuántos números se han tenido que generar para obtener el 7.
		
		
		
		
		
		int aleatorio = (int)(Math.random() * 10 + 1);
		
		int contador = 0;
		
		while(aleatorio != 7) {	
			
			contador ++;
			
			System.out.println(aleatorio);
			
			aleatorio = (int)(Math.random() * 10 + 1);
			
		}
		
		
		contador ++;
		
		System.out.println("\nFinalmente, se ha obtenido el número " + aleatorio + " después de haberse generado " + contador + " números.");
		
		
		
		
		
		
		
		
		
	}

}
