package basic;

public class Threads_01 {

	public static void main(String[] args) {
		
		
		
		 
		// HERE THE MAIN THREAD WILL BE START, in this case there will only be one thread  // AQUÍ NACERÁ EL HILO PRINCIPAL, en este caso solamente habrá un hilo 
		

		// You can get the name of the thread using the static method currentThread()  // Podemos obtener el nombre del hilo  	
		
		System.out.println("Starting thread: " + Thread.currentThread().getName());
		
		
		
		
		
		for (int i = 0; i < 20; i++) {
			
			
					try {
						
		// This method serves to stop the thread we pass through for X milliseconds  // Este método sirve para parar X milisegundos el hilo por el que pasamos
		// 500 milliseconds in this case //500 milisegundos en este caso o medio segundo  
						
						Thread.sleep(500);
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
						
					}
					
					
		// the loop control variable is printed on each thread iteration  // imprimimos en cada iteraciÃ³n del hilo la variable de control de bucle
					
					System.out.println("Thread: " + Thread.currentThread().getName() + " , says: " + i);
					
					
		}
		
		
		
		
		
		
				System.out.println("Thread: " + Thread.currentThread().getName() + " ended");
				
				
		

	}  // AQUÍ MORIRÁ EL HILO PRINCIPAL  // HERE, WILL END THE MAIN THREAD 

}
