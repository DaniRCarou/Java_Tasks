package socket_server_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;



public class Library implements Runnable{

	
	
	private ArrayList<Book> library = new ArrayList<>();
	
	private Thread thread;
	
	private Socket socketToClient;
	
	
	
	
	public Library(Socket socketToCliente) {		
		super();		
		
		loadBooks();
		
		this.socketToClient = socketToCliente;
		
		thread = new Thread(this);
		
		thread.start();
		
	}
	
	
	
	
	private void loadBooks() {
	
	library.add(new Book("1234", 20, "Ricardo falacias", "Me and my friend"));
	
	library.add(new Book("5678", 30, "Alba Nada", "Schreck"));
	
	library.add(new Book("9012", 40, "Juan Todo", "the ham"));
	
	library.add(new Book("3456", 50, "María Roca", "My java teacher"));
	
	library.add(new Book("7890", 60, "Juan Todo", "A bad night"));
	
	}
	
	
	
	
	
	
	
	
	@Override
	public void run() {	
		
		
		
		try {
			
			
			PrintStream output = new PrintStream(socketToClient.getOutputStream());
			
			InputStreamReader input = new InputStreamReader(socketToClient.getInputStream());
			
			BufferedReader bufferInput = new BufferedReader(input);
			
			
			
			
			
			boolean pursue = true;	// Continuar			
			
			while (pursue) {	
				
				
				
				String receivedString = bufferInput.readLine();	
				
				String[] data = receivedString.split("-");	
				
				
				
				int caso = Integer.parseInt(data[0]); 	
				
				String complement = data[1];					
				
				int price = Integer.parseInt(data[2]);      
								
				String author = data[3];
				
				String title = data[4];
						
				
								
				if (caso == 0) {	
					
					
					output.println("OK");
					
					System.out.println(thread.getName() + " has closed the communication.");
					
					pursue = false;
					
					
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
							
								library.add(new Book(complement, price, author, title));
								
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
