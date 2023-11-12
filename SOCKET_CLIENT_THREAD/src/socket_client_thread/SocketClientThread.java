package socket_client_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;




// In this example we are going to make the client send phrases to the server and the server will have to count the number of letters in the phrase.

// The connection will remain open until the client sends the word "END" to the server.

// In this case, the same connection will be used for all the exchange of messages from the client to the server.





public class SocketClientThread {
	
	
	
	
	// IP and Port to which we are going to connect
	
	public static final int PORT = 2018;
	
	public static final String IP_SERVER = "localhost";
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
		System.out.println("\n --------------------- Client Application ---------------------\n ");
		
		
		
		
		
		// -------------------------------------- In an object of type InetSocketAddrese the address and port will be passed as parameters ---------------------------
		
		
		
		
		
		// In this object we are going to encapsulate the IP and the port to which we are going to connect

		InetSocketAddress serverAddress = new InetSocketAddress(IP_SERVER, PORT);	
		
		
		
		
		
		// -------------------------------------- An object is created, inside of "try with resources", to write through the console and to be closed automatically ---------------------------
		
		
		
		try (Scanner sc = new Scanner(System.in)){
			
			
			
			
			
						
			System.out.println("CLIENT: Waiting for the server to accept the connection");
			
						
			
			
		// -------------------------------------- An object is created to establish a connection with the server ------------------------------------	
			
			
			
			Socket socketToServer = new Socket();
			
			
			
			
		// -------------------------------------- the connection is established with the server, by using an  type Socket object method with the connection address, inside of "try with resources", to write through the console and to be closed automatically ---------------------------	
		
			
			
			
			socketToServer.connect(serverAddress);
			
			
			
			
			
			System.out.println("CLIENT: Connection established... to " + IP_SERVER + " through port " + PORT);

			
			
			
			
			
			
		// -------------------------------------- An object is created, which contains an input method of Socket type Object ---------------------------
			
			
			
			
			InputStreamReader input = new InputStreamReader(socketToServer.getInputStream());			
	
			
			
			
			
			
		// -------------------------------------- An object is created, which permits to read input data line by line besides character by character ---------------------------
			
			
			
			BufferedReader bufferInput = new BufferedReader(input);		
			
			
		
			
			
		// -------------------------------------- An object is created, which contains an output method of Socket type Object  ---------------------------
			
			
			PrintStream output = new PrintStream(socketToServer.getOutputStream());
			
			
			
			
			
			
			String text = "";			
			
			boolean continuar = true;			
			
			do {
				
				
				
				
				// -------------------------------------- It is asked to enter numbers values to send them to server  ---------------------------	
				
				
				System.out.println("CLIENT: Write a message (End to finish): ");				
				
				
				text = sc.nextLine(); // Sentence which will be sent to count		
				
				
				
				
				
				
		// -------------------------------------- The content of the variable operands with the numbers is sent to the server. ---------------------------
				
				
				
				output.println(text); 
				
				
				
				System.out.println("CLIENT: Waiting answer ...... ");	
				
				
				
				
				
		// ------------------------------------- The information received is saved in a variable so that it can be printed later. -------------------------------	
				
				
				String answer = bufferInput.readLine();
				
		
		
				
		// ---------------------- The answer will be compared. If the answer is "OK", the variable "continuar" will change to false and the main program will continue after of the "do" instruction --------------------------
				
								
				if("OK".equalsIgnoreCase(answer)) {
					
					continuar = false;
					
				}else {
					
					System.out.println("CLIENTE: Servidor responde, numero de letras: " + answer);
					
				}	
				
			
			}while(continuar);
			
			// The connection has to be closed
			
			socketToServer.close();
			
		} catch (UnknownHostException e) {
			
			System.err.println("CLIENT: Server address not found" + IP_SERVER);
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.err.println("CLIENT: output/input Error");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("CLIENT: Error -> " + e);
			e.printStackTrace();
			
		}
		
		
		System.out.println("CLIENT: End of the program");
		
	}
	
}
