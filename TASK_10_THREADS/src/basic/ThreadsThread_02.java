package basic;


// Creating threads by extending the Thread class

public class ThreadsThread_02 extends Thread {

	
	
	
	
		// Variable whose value is entered through the constructor
	
		private String printValue;
		
		
		
		
		
		

		// Constructor 
		
		public ThreadsThread_02(String printValue) {
			
			this.printValue = printValue;
			
		}

			
		
		
		
		
		
		
		// You have to override the run method 																						| Debemos sobreescribir el método run
		// We have to understand the run method as an independent thread, whose duration will be the duration of the method itself. | Tenemos que entender el método run, como un hilo independiente, cuya duración será la duración del propio método.
		
		@Override
		public void run() {
			
			
			System.out.println("Starting thread: " + Thread.currentThread().getName());  
			
			
			
			
			for (int i = 0; i < 20; i++) {
				

				try {
					
					Thread.sleep(500); // Simulation of task that sleeps the thread for 500 milliseconds 							| Simulación de tarea que duerme el hilo durante 500 milisegundos
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				

				System.out.println("Thread: " + Thread.currentThread().getName() + " , says: " + printValue + " cycle: " + i);
				
				
			}
			
			
			
			
			System.out.println("Thread: " + Thread.currentThread().getName() + " finished");
			
		
			
			
		} // the thread ends here			
		
		
		
		
		
		
		
	

}
