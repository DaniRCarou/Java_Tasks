package socket_server_thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;




 // In this case, a thread will be opened for each request made by the server in order to process several simultaneous requests from different clients.



public class SocketServerThread {
	
	
	
	public static final int PORT = 2018;
	
	
	
	public static void main(String[] args) {
		
		
		
		
		
		
		System.out.println(" ------------------ SERVER WITH THREADS APPLICATION ------------------- ");
				
		
		
		
		
		int petition = 0;
		
		
		
		// An object called server of type ServerSocket is created
		
		try (ServerSocket server = new ServerSocket()){	
			
			
			
			
			
			
		// -------------------------------------- The adress and the port will be saved in a type InetSocketAddress object ---------------------------
			
			
			
			
			
			InetSocketAddress address = new InetSocketAddress(PORT);                              // This object will save the address of the static atribute "PORT"
			
			
			
			
		// -------------------------------------- The server object created previously, within the "try with resources", permanently listens for requests through the indicated port ---------------------------------	
			
			
			server.bind(address); 

			System.out.println("SERVER: Waiting petition through the port " + PORT);
			
			
			
			
			
			
			
			
			while (true) {
				
				
				
				// -------------------------------------- The connection is established with the client by accepting the request using a method of the Socket type object  ---------------------------	
				
				
				
				
				Socket socketToClient = server.accept();											// For each accepted client request, a different socket object is created.

				
				System.out.println("SERVER: petition number " + ++petition + " recived");
				
				
				
				
				
				
				
				// ------------------------------------------ A thread is created where the accepted client request is encapsulated ---------------------------------------------------
				
				
				
				// A new thread is opened and the main thread is releasedAbrimos un hilo nuevo y so that it can receive requests from other clients
				
				new LettersCounterThread(socketToClient);
				
				
			}			
			
			
		} catch (IOException e) {
			
			System.err.println("SERVER: input/output error");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("SERVER: Error");
			e.printStackTrace();
			
		}
	}
}
