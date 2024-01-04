package socket_server_thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;




 // En este caso, vamos a abrir un hilo por cada peticion que haga el servidor
 // para así poder procesar varias peticiones simultaneas de diferentes clientes



public class SocketServerThread {
	
	
	
	public static final int PORT = 2018;
	
	
	
	public static void main(String[] args) {
		
		
		 
		
		try (ServerSocket serverSocket = new ServerSocket()){		
			
			
			
			
			InetSocketAddress address = new InetSocketAddress(PORT);  		
			
			
		
			
			serverSocket.bind(address); 			
			
			
			
			
			while (true) {				
				
				
				
				
				Socket socketToClient = serverSocket.accept();											
							
				
				
				
				new Library(socketToClient);
				
				
			}	
			
			
			
		} catch (IOException e) {
			
			System.err.println("SERVER: Input/output ERROR");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("SERVER: ERROR");
			e.printStackTrace();
			
		}
	}
}
