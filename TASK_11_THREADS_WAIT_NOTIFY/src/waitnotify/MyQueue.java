package waitnotify;

import java.util.LinkedList;
import java.util.Queue; // Interface 

public class MyQueue {
	
	
	
	
	// Maximum number of Strings that the queue will accept
	
	public final static int MAX_ELEMENTS = 3;
	
	
	
	// A queue is perfect to implement this example
	// A queue uses a FIFO structure -> First In First Out 
	
	private Queue<String> queue = new LinkedList<>();
	
	
	
	
	
	
	
	
	
	
	// THIS METHOD IS SYNCHRONIZED !!!!!
	// It means that if a thread uses this method, automatically, both "get" and "add" methods cannot be used by any other thread. 
	
	
	public synchronized String getMessage(){
		
		
		// If the queue it큦 empty, it큦 not possible to remove any other element, until another thread enters an element
				
		while(queue.size() == 0){
			
			
			try {
				
				wait();
			
				// The wait() method, unlike the sleep(), the thread will not wake up after a time, but will wake up when it is notified by the notify() method.
				// Additionally, we release the thread's monitor, so another thread that is trying to enter some synchronized method will be able to do so.
				// The wait() and notify() methods can only be called in a synchronized block or method
				
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			
		}
		
		
	
		// To get an element from the queue. This method is defined in the "Queue" interface
		
		String chain = queue.poll();
		
		
		// It notifies to a thread which is in waiting (wait()) state
		
		notify();
		
		return chain;
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	// THIS METHOD IS SYNCHRONIZED !!!!!
	// It means that if a thread uses this method, automatically, both "get" and "add" methods cannot be used by any other thread until the method has been executed or the wait() method.
	
	public synchronized void addMessage(String message){
		
		
		// If the queue it큦 full, it큦 not possible to enter any other element, until another thread release space for another element
	
		while(queue.size() == MAX_ELEMENTS){  //3
			
			
			try {
				
				wait();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			
		}
		
		
		
		// to add an element in the queue. This method is defined in the "Queue" interface
		
		queue.offer(message);
		
		
		// It notifies to a thread which is in waiting (wait()) state
		
		notify();
		
		
	}
	
}