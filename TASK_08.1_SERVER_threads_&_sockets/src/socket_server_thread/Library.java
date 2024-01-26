package socket_server_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;



public class Library implements Runnable{

	
	
	
	
	private ArrayList<Book> library = new ArrayList<>(); // This is our Library
	
	private Thread thread; // We need to create this atribute use the thread
	
	private Socket socketToClient; // We use it to comunicate the library with the client
	
	
	
	
	
	
	// Constructor where a new thread is created and started
	
	public Library(Socket socketToCliente) {		
		super();		
		
		loadingBooks();
		
		this.socketToClient = socketToCliente;
		
		thread = new Thread(this);
		
		thread.start();
		
	}
	
	
	
	
	
	// Books are entered in our library automatically
	
	private void loadingBooks() {
	
	library.add(new Book("1234", 20, "Ricardo falacias", "Me and my friend"));
	
	library.add(new Book("5678", 30, "Alba Nada", "Schreck"));
	
	library.add(new Book("9012", 40, "Juan Todo", "the ham"));
	
	library.add(new Book("3456", 50, "María Roca", "My java teacher"));
	
	library.add(new Book("7890", 60, "Juan Todo", "A bad night"));
	
	}
	
	
	
	
	
	
	// This method must be synchronized to avoid two users add a book at the same time
	
	private synchronized void addBook (Book book) {
		
		library.add(book);	
		
	}
	
	
	
	
	
	// The run method starts a thread
	
	@Override
	public void run() {	
		
		
		
		try {
			
			
			// Every time we create a thread, there will be a directly comunication with the client
			
			PrintStream output = new PrintStream(socketToClient.getOutputStream());
			
			InputStreamReader input = new InputStreamReader(socketToClient.getInputStream());
			
			BufferedReader bufferInput = new BufferedReader(input);
			
			
			
			
			
			boolean pursue = true;	// Continue. It is always true until the client push 0		
			
			while (pursue) {	
				
				
				
				String receivedString = bufferInput.readLine();	// Information comes in here
				
				String[] data = receivedString.split("-"); // Information is separated thanks to the split "-"
				
				
				
				int caso = Integer.parseInt(data[0]); 	
				
				String complement = data[1];					
				
				int price = Integer.parseInt(data[2]);      
								
				String author = data[3];
				
				String title = data[4];
						
				
								
				if (caso == 0) {	
					
					
					output.println("OK");
					
					System.out.println(thread.getName() + " has closed the communication.");
					
					pursue = false; // Continue. It is always true until the client push 0
					
					
				} else if (caso == 1) {		
					

					ArrayList<Book> shelf = new ArrayList<Book>();
					
					
					for(Book book: library) {
						
						if(book.getIsbn().equalsIgnoreCase(complement)) 						
							
							shelf.add(book);						
						
					}
					
					
					output.println(shelf);
					
					
				  } else if (caso == 2) {
					  
					  ArrayList<Book> shelf = new ArrayList<Book>();
					  
						for(Book book: library) {
							
							if(book.getTitle().equalsIgnoreCase(title))						
							
								shelf.add(book);						
							
						}
						
						
						output.println(shelf);
						
						
				  }	else if (caso == 3) {	
					  
					  ArrayList<Book> shelf = new ArrayList<Book>();
							
							for(Book book: library) {
								
								if(book.getAuthor().equalsIgnoreCase(author)) 						
								
									shelf.add(book);						
								
							}
							
							
							output.println(shelf);
							
					
				  }	else if (caso == 4) {									 		
							
					  			
					  
								addBook(new Book(complement, price, author, title) );
								
								output.println("added");							
							
								
					
				  } else
					  
					  output.println("NO");				
			
			
			}
			
			
			
			
			socketToClient.close();
			
			
			
			
		} catch (IOException e) {
			
			System.err.println("LettersCounterThread: Input/output ERROR");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("LettersCounterThread: ERROR");
			e.printStackTrace();
			
		}		
		
		
		
	}



}
