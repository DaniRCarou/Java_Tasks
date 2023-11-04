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


public class ClientSocket {
	
	
	
	
	//IP and Port to which we are going to connect
	
	public static final int PORT = 2017;
	public static final String IP_SERVER = "localhost";
	
	
	
	public static void main(String[] args) {
		
		
		
		
		
		System.out.println(" -----------------------      CLIENT APPLICATION     -----------------------\n ");
		
		
		// In this object we are going to encapsulate the IP and the port to which we are going to connect

		InetSocketAddress serverAddress = new InetSocketAddress(IP_SERVER, PORT);
		
		
		
		// A Socket Object is created to connect with the server
		
		try (Scanner sc = new Scanner(System.in); Socket socketToServer = new Socket()) {
					
			
			
			
			
			// ASKING FOR THE NUMBERS
			// We ask the user for the numbers to add
			
			System.out.println("CLIENT: Enter the numbers to add");		
			
			String number1 = sc.nextLine(); // Let's assume the number 3
			String number2 = sc.nextLine(); // Let's assume the number 4
						
			
			
			
			
			// MODE OF SENDING INFORMATION
			// It is stablished how the numbers will be sent. With a hyphen "-", between the numbers.
			
			String operandos = number1 + "-" + number2; // 3-4
			
					
			
			
						
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
			
			output.println(operandos);//3-4
			
			
			
			
			
			// INFORMATION INPUT
			// An object is created that allow us to read the server output

			InputStreamReader input = new InputStreamReader(socketToServer.getInputStream());
					
			// This object allows us to read data from the server line by line instead of character by character like the InputStreamReader class
			
			BufferedReader bf = new BufferedReader(input);
			
			
			
			
			
			System.out.println("CLIENT: Waiting for server result...");			
			
			// In the next line the main thread will wait until the server responds.
			
			String result = bf.readLine(); // 7
				
			System.out.println("CLIENT: The result of the sum is: " + result); // 7
			 			
			
			
			
			
		} catch (UnknownHostException e) {
			
			System.err.println("CLIENT: Server address not found" + IP_SERVER);			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.err.println("CLIENT: Input/Output Error");			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("CLIENT: Error -> " + e);
			e.printStackTrace();
		}
		
		System.out.println("CLIENT: End of program");
		
	}

}
