package basic_elements_control_structures;

public class BasicElements {

	public static void main(String[] args) {
		
		
		
		// Exercise 1

		// Declara una variable llamada num1 y as�gnale un valor al azar del 1 al 20. 
		// Luego declara otra variable llamada num2. 
		// Si num1 est� comprendido entre 5 y 15 (ambos inclusive) asigna a num2 el resultado de la operaci�n num1+15, de lo contrario asigna a num2 el resultado de la operaci�n num1+5.
		// Al final muestra en pantalla el valor de ambas variables.
		
		
		
		int num1 = 10;
		
		int num2 = 0;
		
		
		
		if(num1 >=5 & num1 <=15) {
			
			num2 = num1+15;
			
		}else 
			num2 = num1+5;
		
		
		
		System.out.println("El valor de la variable num1 es: " + num1 + "\n" + "El valor de la variable num2 es: " + num2);
		
		
		

	}

}
