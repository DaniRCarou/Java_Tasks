package socket_client_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;




public class SocketClientThread {
	
	
	
	
	
	static Scanner sc;
	
	public static final int PORT = 2018;
	
	public static final String IP_SERVER = "localhost";
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
		
		
		InetSocketAddress serverAddress = new InetSocketAddress(IP_SERVER, PORT);	
		
		
		
		
		
		
		try{	
			
			
			
			sc = new Scanner(System.in);
			
			
			
			
			Socket socketToServer = new Socket();					
			
			socketToServer.connect(serverAddress);		
			
			
			
			
			InputStreamReader input = new InputStreamReader(socketToServer.getInputStream());		
			
			BufferedReader bufferInput = new BufferedReader(input);	
			
			
			
			
			PrintStream output = new PrintStream(socketToServer.getOutputStream());
			
			
			
			
			
			String isbn = null;
			
			int price = 0;
			
			String author = null;
			
			String title = null;
			
			
			
			
			
			
			int option = 0;
			
			String text = "";	
			
			do {
				
				
				
				option = menu(); // The menu is displayed in the console, an option must be selected and after that will be saved on this variable (option).
				
				
			
				
			// Now, this option would be compare with every case to display a message and introduce new data to send them to the server.
				
			switch(option) {
			
			
					
				
				case 1:				
					
					System.out.println("Selected option: " + option + " -> Please, enter the ISBN code:");	// Displayed message			
					
					
					text = sc.nextLine(); // Enters ISBN code through console
					
					String data = option + "-" + text + "-" + 0 + "-" + null + "-" + null; // Here all the data is gathered, separated by a hyphen and the data that is not entered through the console will be filled in as null
					
					output.println(data);	// data is sent
					
					
					break;
					
				case 2:				
					
					System.out.println("Selected option: " + option + " -> Please, enter the book title");					
					
					
					text = sc.nextLine();
					
					data = option + "-" + isbn + "-" + price + "-" + author  + "-" + title ;
					
					output.println(data);	
					
					
					break;
					
				case 3:				
										
					System.out.println("Selected option: " + option + " -> Please, enter the book's author");	
					
					
					text = sc.nextLine();
					
					data = option + "-" + isbn + "-" + price + "-" + author  + "-" + title ;
					
					output.println(data);
					
					
					break;
					
				case 4:				
					
					System.out.println("Selected option: " + option + " -> Please, enter the book's data");
					
					
					System.out.println("\nISBN: ");
					
					isbn = sc.nextLine();
					
					
					System.out.println("\nPRICE: ");			
					
					price = sc.nextInt();					
					
					sc.nextLine();					
					
					
					System.out.println("\nAUTHOR: ");
					
					author = sc.nextLine();
					
					
					System.out.println("\nTITLE: ");
					
					title = sc.nextLine();
					
					
					data = option + "-" + isbn + "-" + price + "-" + author  + "-" + title ;
									
					
					output.println(data);
					
					
					break;
					
					
				case 0: 
					
					data = option + "-" + isbn + "-" + price + "-" + author  + "-" + title ;
					
					output.println(data);				
					
					break;					
					
								
					default: 
						
						System.out.println("wrong option");
				
				
			}
			
			
							
			String answer = bufferInput.readLine(); // INPUT	
			
			
			
			if(answer.trim().equalsIgnoreCase("OK"))	{
				
				
			System.out.println( answer + ", Communication closed"); // CONSOLE	
			
			
			}else if (answer.trim().equalsIgnoreCase("NO")) {	
				
				
				System.out.println("\nTHE REQUESTED BOOK DOES NOT EXIST\n"); // CONSOLE	
				
			
			}else if (answer.trim().equalsIgnoreCase("added")) {	
				
				
				System.out.println("\nTHE BOOK HAS BEEN ADDED SUCCESSFULLY\n"); // CONSOLE	
				
			
			}else	
				
				
				System.out.println("\nThe requested book is: " + answer + "\n"); // CONSOLE	
			
			
				
			}while(option!=0);
			
			System.out.println("Exit done");
			
			
			sc.close();	
			
			socketToServer.close();
			
			
		} catch (UnknownHostException e) {
			
			System.err.println("CLIENT: Server with this adress " + IP_SERVER +  " not found.");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.err.println("CLIENT: input/ouput ERROR");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("CLIENT: ERROR -> " + e);
			e.printStackTrace();
			
		}
		
		
		System.out.println("CLIENT: End of the program");
		
			
			
			
			
		
		
	}
	
	
	
	
	public static int menu() {
		
		
		int opcion = 0;
		
			
			
		System.out.println("Type an option from 1 to 4 or 0 to exit" + "\n");	
		
		System.out.println("1. Consult book by ISBN" );
			
		System.out.println("2. Consult book by title");
			
		System.out.println("3. Consult book by author");
		
		System.out.println("4. Add a book" + "\n");
			
		System.out.println("0. If you wish to exit the application");
		
			
			
		opcion = sc.nextInt();
		
		/*

		Consume the pending new line before reading user input. In this case, sc.nextLine() is added before the actual reading of the user input. This helps to consume the pending new line after the selected option in the menu.
		After doing this, you should be able to read the user's input correctly without the "You haven't typed anything" message appearing for no apparent reason.
		When working with standard input in Java, especially with Scanner objects, there may be new line characters ('\n') left hanging in the system buffer after reading a numeric value or string. This is common, for example, when you read a number with nextInt() and then perform an additional read with nextLine().

		The line "//Consume pending newline before reading user input" refers to adding an additional nextLine() call to explicitly consume that newline left in the buffer after reading the numeric menu option. This is necessary because after the user enters a number and presses "Enter", the new line character ('\n') remains in the system buffer.
		When you then call nextLine() to read user input (e.g. the ISBN code), if you don't consume that pending newline character, nextLine() could simply read that character and return an empty string.
		Therefore, adding sc.nextLine() before reading actual user input ensures that any outstanding newline characters are consumed before reading user input, preventing unexpected problems with user input.
		
		*/
			
		sc.nextLine();
		
		return opcion;	
		
		
		
	}	
	
	
	
}