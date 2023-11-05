package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {
	
	
	public static final int PORT = 2017;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		
		
		System.out.println(" -----------------------      SERVER APPLICATION     -----------------------\n ");
		
		
		
		
				
		// DATA ENTRY FROM CLIENT
		// Variable created to allow us to read the information from the client output
		
		InputStreamReader input = null;
		
		
		
		
		
		// DATA OUTPUT FROM SERVER
		// Variable created to allow us to send information to the client
		
		PrintStream output = null;
		
		
		
		
		
		// A Socket variable is created to establish a connection with the client
		
		Socket socketToClient = null;
		
		
		// In this object we are going to encapsulate the PORT of the machine, we don´t need the IP 
		
		InetSocketAddress address = new InetSocketAddress(PORT);
		
		
		
		
		
		// A ServerSocket object is created to create a Socket object automatically
		
		try (ServerSocket serverSocket = new ServerSocket()){			
			
			
			
			
			
			// serverSocket has to be ready to receive requests from the client through the Port we stablished (It has to be the same as the one established in the client application)			
			
			serverSocket.bind(address);
			

			// The requests received by the server will be added
			
			int request = 0;
			
			
			
			
			
			// The server is continually waiting for incoming requests 
			
			while(true){	
				
				
								
				
				
				System.out.println("SERVER: Waiting for request through port: " + PORT);				
				
				// At this point, the program will stop until a client request comes in, and it will be at that moment that a Socket object is created.
				
				socketToClient = serverSocket.accept();
				
				System.out.println("\n----------------- REQUEST NUMBER: " + ++request + " -------------------------\n"); // with "++request" automatically 1 is added to "int request"
				
				System.out.println("SERVER: request number: " + request + " received");
				
				
				
				
				
				// INFORMATION INPUT
				// An object is created that allow us to read the client output
				
				input = new InputStreamReader(socketToClient.getInputStream());
				
				// This object allows us to read data from the client line by line instead of character by character like the InputStreamReader class
				
				BufferedReader bf = new BufferedReader(input);
				
				
				
				
				
				System.out.println("SERVER: Waiting for client information...");	
				
				// In the next line the main thread will wait until the client asks.
				
				String stringReceived = bf.readLine(); // 3-4				
				
				System.out.println("SERVER: I received from the client: " + stringReceived);
				
				// It is known that the client sends us the information "number-number", so it is indicated that the information will come with a split "-"
				
				String[] operators = stringReceived.split("-");
				
				// The first number is saved in this variable but it has to be changed to Integer. The number is  3
				
				int iNumber1 = Integer.parseInt(operators[0]);
				
				// The second number is saved in this variable but it has to be changed to Integer. The number is  4
				
				int iNumber2 = Integer.parseInt(operators[1]); // The first number is saved in this variable but it has to be changed to Integer. The number is  34
				
				
				
				
				
				// It´s time to calculate the result
				
				int result = iNumber1 + iNumber2; // 7 
				
				System.out.println("SERVER: The calculation of the numbers is: " + result);
				
				
				
				
				
				
				// The result is sent to the client
				output = new PrintStream(socketToClient.getOutputStream());
				output.println(result);	
				
				
				
				
				
				// It´s time to close the connections
				
				socketToClient.close();
				
			}
			
		} catch (IOException e) {
			
			System.err.println("SERVERR: input/output error");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("SERVER: Error -> " + e);
			e.printStackTrace();
			
		}
		
	} // End of the program
}
