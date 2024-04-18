package main;

import basic.ThreadsRunnable_03;

public class Main_ThreadsRunnable_03 {

	public static void main(String[] args) {


		
		
		
		// An object is created that implements runnable
		// Runnable class doesn´t contains the start() method like the Thread class
		// Because of that, you have to create a Thread type object and pass it the Runnable type object that has been created
		
		ThreadsRunnable_03 thread1 = new ThreadsRunnable_03("Value 1");
		
				
		// We create an object of type Thread (which is really the object that is capable of creating threads) and pass it an object of type Runnable
		
		Thread t1 = new Thread(thread1);
		
				
		t1.setName("thread1");                    // We set the thread name, with setName() method				
				
			
		
		// A second object is created that implements runnable
		
		ThreadsRunnable_03 thread2 = new ThreadsRunnable_03("Value 2");
				
		Thread t2 = new Thread(thread2,"Thread2");	// We set the thread name, directly through the constructor of the Thread class
		
		
		
		
		
		
		
		
		
		try {
			
			System.out.println("Waiting  5 seconds to start the threads.. :)");
			
			Thread.sleep(5000); // Sleeping 5 seconds
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		// We start both threads, executing the start() method. The start() method will execute the run() method of threads_02 class
		// If we use directly, the method run(), directly like this -> thread1.run(); -> the program would be executed sequentially, not in parallel
		// There will be thre threads running, the main thread, thread1 and thread2
		
		t1.start();		
		t2.start();
		
		
		
		
		
		System.out.println("Main thread stopping");
		
		
		
		
				
	}

}
