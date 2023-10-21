package basic;



//"Threads" objects can be created and started automatically (see constructor of ThreadsThis_04 class)




public class ThreadsThis_04 implements Runnable {

	
	
	
	
	// Variable whose value is entered through the constructor
	
	private String printValue;
	
	
	
	
	
	

	// Constructor
	
	public ThreadsThis_04(String printValue, String threadName) {
		
		this.printValue = printValue;
		
		Thread t1 = new Thread(this,threadName);    // This variable will contain the Runnable object from this, this object
		
		t1.start();									// it starts the thread t1
		
	}

	
	
	
	
	
	
	
	// You have to implement the run method, because Runnable is an interface and doesn�t have functionality 																	| Debemos sobreescribir el m�todo run
	// The run method is like an independent thread, whose duration will be the duration of the method itself. 	| Tenemos que entender el m�todo run, como un hilo independiente, cuya duraci�n ser� la duraci�n del propio m�todo.
				
	@Override
	public void run() {
		
		
		System.out.println("Starting thread: " + Thread.currentThread().getName());  
		
		
		
		
		for (int i = 0; i < 20; i++) {
			

			try {
				
				Thread.sleep(500); // Simulation of task that sleeps the thread for 500 milliseconds 							| Simulaci�n de tarea que duerme el hilo durante 500 milisegundos
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			

			System.out.println("Thread: " + Thread.currentThread().getName() + " , says: " + printValue + " cycle: " + i);
			
			
		}
		
		
		
		
		System.out.println("Thread: " + Thread.currentThread().getName() + " finished");
			
	
	}
		
		
		
}
