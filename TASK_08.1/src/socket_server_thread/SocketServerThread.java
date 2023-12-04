package socket_server_thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;




 // En este caso, vamos a abrir un hilo por cada peticion que haga el servidor
 // para así poder procesar varias peticiones simultaneas de diferentes clientes



public class SocketServerThread {
	
	
	
	public static final int PUERTO = 2018;
	
	
	
	public static void main(String[] args) {
		
		
		 
		
		try (ServerSocket socketServidor = new ServerSocket()){		
			
			
			
			
			InetSocketAddress direccion = new InetSocketAddress(PUERTO);  		
			
			
		
			
			socketServidor.bind(direccion); 			
			
			
			
			
			while (true) {				
				
				
				
				
				Socket socketAlCliente = socketServidor.accept();											
							
				
				
				
				new Library(socketAlCliente);
				
				
			}	
			
			
			
		} catch (IOException e) {
			
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("SERVIDOR: Error");
			e.printStackTrace();
			
		}
	}
}
