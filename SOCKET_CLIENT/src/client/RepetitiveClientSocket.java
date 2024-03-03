package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;




/*

In this example we are going to see how we can collect two numbers from a client application and send them to the server so that it returns a response with the result of the sum of both.
SERVER MUST RUN

*/





public class RepetitiveClientSocket {
	
	
	
	
	
	//IP and Port to which we are going to connect
	
	public static final int PORT = 2017;
	public static final String IP_SERVER = "localhost";

	
	
	
	public static void main(String[] args) {
		
		
		
		
		
		System.out.println(" -----------------------      CLIENT APPLICATION     -----------------------\n ");

		// In this object we are going to encapsulate the IP and the port to which we are going to connect

		InetSocketAddress serverAddress = new InetSocketAddress(IP_SERVER, PORT);

				
		
		
		
			
		
		// In this case we don´t ned to include a socket object inside the "try (with resources)", because it has to be opened continuously through the operator "do while"
		
		try (Scanner sc = new Scanner(System.in);){
		
			
			
			
			boolean continuing = true;	
			
			// We will use "do while" to comunicate continuously with the server	
					
			do {	
				
				
				
				// ASKING FOR THE NUMBERS
				// We ask the user for the numbers to add
				
				System.out.println("CLIENT: Enter the numbers to add");		
				
				String number1 = sc.nextLine(); 
				String number2 = sc.nextLine(); 
				
				
				// MODE OF SENDING INFORMATION
				// It is stablished how the numbers will be sent. With a hyphen "-", between the numbers.
				
				String operands = number1 + "-" + number2;
				
				
				
				
				
								
				// Now is created a socket object to connect with the server
				
				Socket socketToServer = new Socket();
				
				// STARTING THE CONNECTION
				
				System.out.println("CLIENT: Waiting for the server to accept the connection");
				
				// Connection is established
				
				socketToServer.connect(serverAddress);					
						
				// Connection was established
				
				System.out.println("CLIENTE: established connection... to " + IP_SERVER + " through port " + PORT);	
					
				
				
				
				
				// INFORMATION OUTPUT
				// An object is created that allows us to send information to the server
								
				PrintStream output = new PrintStream(socketToServer.getOutputStream());
				
				// The information is sent through the Stream
				
				output.println(operands);

				
				
				
				
				
				// INFORMATION INPUT
				// An object is created that allow us to read the server output

				InputStreamReader input = new InputStreamReader(socketToServer.getInputStream());
						
				// This object allows us to read data from the server line by line instead of character by character like the InputStreamReader class
				
				BufferedReader bf = new BufferedReader(input);
				
				
				
				
				
				System.out.println("CLIENT: Waiting for server result...");			
				
				// In the next line the main thread will wait until the server responds.
				
				String result = bf.readLine(); // 7
					
				System.out.println("CLIENT: The result of the sum is: " + result);
				
				
				
				
				
				
				// At this point the client will be asked if they wish to continue
				
				System.out.println("CLIENT: Do you want to continue? Y/N");
				
				String sContinue = sc.nextLine();
				
				
				
				
				
				// If the client doesn´t want to continue, the bucle "do while" ends and this client application ends
				
				if (sContinue.equalsIgnoreCase("n")) {
					
					continuing = false;
					
				}
				
				
				
				
				// The socketToServer has to be closed, because it is not inside the "try with resources"
				
				socketToServer.close();
				
				
				
			} while (continuing);	
			
			
			
		}catch (UnknownHostException e) {
			
			System.err.println("CLIENT: Server address not found" + IP_SERVER);			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.err.println("CLIENT: input/output Error");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("CLIENT: Error -> " + e);
			e.printStackTrace();
			
		}
		
		
		System.out.println("CLIENT: End of the program");
		
	}

}
