package socket_server_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;



// This thread will count the number of letters in the phrase that the client sends.

// The connection will remain open until the client sends the word "END" to the server.

// Receives the socket that the server opens with the client and with which it will maintain the conversation



public class LettersCounterThread implements Runnable{
	
	
	
	
	private Thread thread;
	
	private static int clientNumb = 0;
	
	private Socket socketToClient;	
	
	
	
	
	
	public LettersCounterThread(Socket socketToClient) {
		
		clientNumb++;
		
		thread = new Thread(this, "Client:" + clientNumb);
		
		this.socketToClient = socketToClient;
		
		thread.start();
		
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void run() {
		
		
		System.out.println("Establishing comunication with " + thread.getName());
		
		PrintStream output = null;
		
		InputStreamReader input = null;
		
		BufferedReader bufferInput = null;
		
		
		
		
		try {			
			
			
			// Output from server to client
			
			output = new PrintStream(socketToClient.getOutputStream());
				
			
			
			// input from server to client
			 
			input = new InputStreamReader(socketToClient.getInputStream());
			
			bufferInput = new BufferedReader(input);
				
			
			
			// Inputs are processed until the text from the client is: "END"
			
			String text = "";
			
			boolean continuar = true;				
			
			while (continuar) {
				
				
				
				
			text = bufferInput.readLine();
				
			
			
			
				
			// trim() is a method that removes leading and trailing whitespace
				
				if (text.trim().equalsIgnoreCase("END")) {					
										
					output.println("OK");
					
					System.out.println(thread.getName() + " ha cerrado la comunicacion");
					
					continuar = false;
					
				} else {
					
					// letters that the sentence contains, are counted
					
					int lettersNumber = text.trim().length();
					
					System.out.println(thread.getName() + " dice: " + text + " y tiene " + lettersNumber + " letras");
					
					// it sends the answer to the client
					
					output.println(lettersNumber);
				}
				
			}
			
			
			// Socket it is closed
			
			socketToClient.close();
			
			
		} catch (IOException e) {
			
			System.err.println("HiloContadorLetras: Error de entrada/salida");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("HiloContadorLetras: Error");
			e.printStackTrace();
			
		}
		
	}
	
}
