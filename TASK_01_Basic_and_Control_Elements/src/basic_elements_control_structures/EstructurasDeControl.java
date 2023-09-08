package basic_elements_control_structures;

public class EstructurasDeControl {

	public static void main(String[] args) {
		
		
		
	// Ejercicio 2

	// Necesitamos contar en orden inverso de 10 en 10 desde 100 hasta 10 (100, 90, 80, …, 10). 
	// Realiza dos programas en Java, cada uno de ellos con dos estructuras de control distintas, que realicen la tarea indicada.	
		
		
		System.out.println("------------while-----------\n");
		
		
		int num = 100;
		
		
		while(num >= 10){
		
		System.out.println(num);	
			
		num -= 10;			
			
		}
		
		
		
		
		
		System.out.println("\n------------do while-----------\n");
		
		
		
		
		
		
		int num2 = 100;
		
		
		do {
			
			System.out.println(num2);	
			
			num2 -= 10;				
			
		}while(num2 >= 10);
				
		
		
		
		
		
		System.out.println("\n------------for-----------\n");
		
		
		
		
		
		for( int i = 100; i >= 10; i -= 10) {
				
			System.out.println(i);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
