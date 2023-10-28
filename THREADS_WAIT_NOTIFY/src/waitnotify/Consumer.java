package waitnotify;



public class Consumer extends Thread{

	
	
	public String name;
	public MyQueue queue;
	
	
	
	
	
	
	
	
	public Consumer(String name, MyQueue queue){
		super();
		this.name = name;
		this.queue = queue;
	}
	
	
	
	
	
	
	
	
	// Each consumer will consum 10 messages with the getMessage() method
	
	public void run(){
		
		// We can replace 'while' for 'for' if we want to send X messages
		// while(true) {
		
		for(int i = 1;i <= 10;i++){
			
			String message = queue.getMessage();
			
			System.out.println(name + " has consumed the message: " + message);
			
		}
		
	}

}
