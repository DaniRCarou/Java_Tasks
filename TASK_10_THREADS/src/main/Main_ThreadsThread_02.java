
package main;

import basic.ThreadsThread_02;



// WE WILL START TWO THREADS WITH DIFERENTS VALUES


public class Main_ThreadsThread_02 {

	public static void main(String[] args) {
		
		
		
		
		
		// This object will create a thread
		
		ThreadsThread_02 thread1 = new ThreadsThread_02("Value 1");
		
		thread1.setName("Thread1");                        	// we set the thread name, with setName() method
		
		
		
		// This object will create a second thread
		
		ThreadsThread_02 thread2 = new ThreadsThread_02("Value 2");
		
		thread2.setName("Thread2");						   	// we set the thread name, with setName() method
		
		
		
		try {
			
			System.out.println("Waiting  5 seconds to start the threads.. :)");
			
			Thread.sleep(5000); // Sleeping 5 seconds
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		// We start both threads, executing the start() method. The start() method will execute the run() method of threads_02 class
		// If we use directly, the method run(), directly like this -> thread1.run(); -> the program would be executed sequentially, not in parallel
		// There will be thre threads running, the main thread, thread1 and thread2
		
		thread1.start();		
		thread2.start();
		
		
		
		
		
		System.out.println("Main thread stopping");


		
		
		
	} // The program ends here, when all the threads are finished

}
