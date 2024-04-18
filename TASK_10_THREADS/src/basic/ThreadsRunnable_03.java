package basic;


// Creating threads implementing the Runnable class
// This is the most recommended way. Because by extending, you only can extend one time. 
// By implementing Runnable is posible to doit several times.

public class ThreadsRunnable_03 implements Runnable {
	
	
	
	
	
	
		// Variable whose value is entered through the constructor
	
		private String printValue;
			
			
			
			
			
		
		

		// Constructor 
			
		public ThreadsRunnable_03(String printValue) {
				
				this.printValue = printValue;
				
			}	
		
		
		
		
		
		
		

		// You have to implement the run method, because Runnable is an interface and doesn�t have functionality 																	| Debemos sobreescribir el m�todo run
		// The run method is like an independent thread, whose duration will be the duration of the method itself. 	| Tenemos que entender el m�todo run, como un hilo independiente, cuya duraci�n ser� la duraci�n del propio m�todo.
				
		@Override
		public void run() {
			
			
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());
		
		
		for (int i = 0; i < 20; i++) {
			

			try {
				
				Thread.sleep(500);
				
			} catch (InterruptedException e) {				
				
				e.printStackTrace();
				
			}
			

			System.out.println("Hilo: " + Thread.currentThread().getName() + " , dice: " + printValue + " ciclo: " + i);
		
		}
		
		
		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
		
		
		
		
		for(int i = 0; i<= 9;i++) {
			
		}	
		
		
		
		
	}		
	
	
	

}
