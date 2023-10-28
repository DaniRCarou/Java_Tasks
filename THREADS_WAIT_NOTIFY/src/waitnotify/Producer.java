package waitnotify;


// This class will produce messages

public class Producer extends Thread{

	
	
	
	public String name;
	public MyQueue queue;
	
	
	
	
	
	public Producer(String name, MyQueue queue){
		super();
		this.name = name;
		this.queue = queue;
	}
	
	
	
	
	
	
	// Each producer will produce 10 messages with the addMessage() method
	
	public void run(){
		
		for(int i = 1;i <= 10;i++){
			
			String message = name + " - " + i; // Producer 1 - 1
			
			queue.addMessage(message);
			
		}
		
	}
	
	
	
	
	
	
	

}
