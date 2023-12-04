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
	
	public static final int PUERTO = 2018;
	
	public static final String IP_SERVER = "localhost";
	
	
	
	public static void main(String[] args) {
		
		
		
		
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);	
		
		
		
		try{	
			
			
			sc = new Scanner(System.in);
			
			
			
			Socket socketAlServidor = new Socket();					
			
			socketAlServidor.connect(direccionServidor);		
			
			
			
			
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());		
			
			BufferedReader entradaBuffer = new BufferedReader(entrada);	
			
			
			
			
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			
			
			
			int opcion = 0;
			
			String texto = "";	
			
			do {
				
				
				opcion = menu(); // Se muestra el men� en pantalla, se elige una opci�n y esa opci�n se guarda en esta variable.
				
				
				
			switch(opcion) {
			
			
					
				
				case 1:				
					
					System.out.println("Opci�n seleccionada: " + opcion + " -> Por favor, introduzca el c�digo ISBN");
									
										
					/*
					 Consumir la nueva l�nea pendiente antes de leer la entrada del usuario. En este caso, se agrega sc.nextLine() antes de la lectura real de la entrada del usuario. Esto ayuda a consumir la nueva l�nea pendiente despu�s de la opci�n seleccionada en el men�. 
					 Despu�s de hacer esto, deber�as poder leer la entrada del usuario correctamente sin que aparezca el mensaje "No has escrito nada" sin motivo aparente. 
					 Cuando se trabaja con la entrada est�ndar en Java, especialmente con objetos Scanner, es posible que queden caracteres de nueva l�nea ('\n') pendientes en el b�fer del sistema despu�s de leer un valor num�rico o una cadena. Esto es com�n, por ejemplo, cuando lees un n�mero con nextInt() y luego realizas una lectura adicional con nextLine().

					 La l�nea "// Consumir la nueva l�nea pendiente antes de leer la entrada del usuario" se refiere a agregar una llamada a nextLine() adicional para consumir expl�citamente esa nueva l�nea que queda en el b�fer despu�s de leer la opci�n num�rica del men�. Esto es necesario porque despu�s de que el usuario ingrese un n�mero y presione "Enter", el car�cter de nueva l�nea ('\n') queda en el b�fer del sistema.
					 Cuando luego llamas a nextLine() para leer la entrada del usuario (por ejemplo, el c�digo ISBN), si no consumes ese car�cter de nueva l�nea pendiente, nextLine() podr�a simplemente leer ese car�cter y devolver una cadena vac�a.
					 Por lo tanto, agregar sc.nextLine() antes de leer la entrada real del usuario garantiza que cualquier car�cter de nueva l�nea pendiente se consuma antes de leer la entrada del usuario, evitando problemas inesperados con las entradas del usuario.
					
					*/
					
					// sc.nextLine();
					
					texto = sc.nextLine();
					
					String datos = opcion + "-" + texto;
					
					salida.println(datos);					
					
					break;
					
				case 2:				
					
					System.out.println("Opci�n seleccionada: " + opcion + " -> Por favor, introduzca el t�tulo del libro");
					
					// sc.nextLine();
					
					texto = sc.nextLine();
					
					datos = opcion + "-" + texto;
					
					salida.println(datos);	
					
					break;
					
				case 3:				
										
					System.out.println("Opci�n seleccionada: " + opcion + " -> Por favor, introduzca el autor del libro");
					
					// sc.nextLine();
					
					texto = sc.nextLine();
					
					datos = opcion + "-" + texto;
					
					salida.println(datos);
					
					break;
					
				case 4:				
					
					System.out.println("Opci�n seleccionada: " + opcion + " -> Por favor, introduzca los datos del libro");
					
					System.out.println("\nISBN: ");
					
					String isbn = sc.nextLine();
					
					System.out.println("\nPRECIO: ");
					
					int precio = sc.nextInt();
					
					System.out.println("\nTITULO: ");
					
					String titulo = sc.nextLine();
					
					System.out.println("\nAUTOR: ");
					
					String autor = sc.nextLine();
					
					
					datos = opcion + "-" + isbn + precio + titulo + autor;
					
					salida.println(datos);
					
					break;
					
				case 0: // Este caso no hace nada, se lo salta, porque as� est� indicado en el "while"
					
					salida.println(opcion);				
					
					break;					
					
								
					default: 
						
						System.out.println("Opci�n incorrecta");
				
				
			}
			
			
							
			String respuesta = entradaBuffer.readLine(); // ENTRADA	
			
			
			
			if(respuesta.trim().equalsIgnoreCase("OK"))	{
				
			System.out.println( respuesta + ", Comunicaci�n cerrada"); // CONSOLA	
			
			}else if (respuesta.trim().equalsIgnoreCase("NO")) {	
				
				System.out.println("\nEL LIBRO SOLICITADO NO EXISTE\n"); // CONSOLA	
			
			}else	
				
				System.out.println("\nEl libro solicitado es: " + respuesta + "\n"); // CONSOLA		
			
				
			}while(opcion!=0);
			
			System.out.println("Salida realizada");
			
			
			sc.close();	
			
			socketAlServidor.close();
			
			
		} catch (UnknownHostException e) {
			
			System.err.println("CLIENTE: No encuentro el servidor en la direcci�n" + IP_SERVER);
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
			
		}
		
		
		System.out.println("CLIENTE: Fin del programa");
		
			
			
			
			
		
		
	}
	
	
	
	
	public static int menu() {
		
		
		int opcion = 0;
		
			
			
		System.out.println("Teclea una opcion de 1 a 4 o 0 para salir" + "\n");	
		
		System.out.println("1. Consultar libro por ISBN" );
			
		System.out.println("2. Consultar libro por titulo");
			
		System.out.println("3. Consultar libro por autor");
		
		System.out.println("4. A�adir libro" + "\n");
			
		System.out.println("0. Si desea salir de la aplicaci�n");
		
			
			
		opcion = sc.nextInt();
		
		/*
		 Consumir la nueva l�nea pendiente antes de leer la entrada del usuario. En este caso, se agrega sc.nextLine() antes de la lectura real de la entrada del usuario. Esto ayuda a consumir la nueva l�nea pendiente despu�s de la opci�n seleccionada en el men�. 
		 Despu�s de hacer esto, deber�as poder leer la entrada del usuario correctamente sin que aparezca el mensaje "No has escrito nada" sin motivo aparente. 
		 Cuando se trabaja con la entrada est�ndar en Java, especialmente con objetos Scanner, es posible que queden caracteres de nueva l�nea ('\n') pendientes en el b�fer del sistema despu�s de leer un valor num�rico o una cadena. Esto es com�n, por ejemplo, cuando lees un n�mero con nextInt() y luego realizas una lectura adicional con nextLine().

		 La l�nea "// Consumir la nueva l�nea pendiente antes de leer la entrada del usuario" se refiere a agregar una llamada a nextLine() adicional para consumir expl�citamente esa nueva l�nea que queda en el b�fer despu�s de leer la opci�n num�rica del men�. Esto es necesario porque despu�s de que el usuario ingrese un n�mero y presione "Enter", el car�cter de nueva l�nea ('\n') queda en el b�fer del sistema.
		 Cuando luego llamas a nextLine() para leer la entrada del usuario (por ejemplo, el c�digo ISBN), si no consumes ese car�cter de nueva l�nea pendiente, nextLine() podr�a simplemente leer ese car�cter y devolver una cadena vac�a.
		 Por lo tanto, agregar sc.nextLine() antes de leer la entrada real del usuario garantiza que cualquier car�cter de nueva l�nea pendiente se consuma antes de leer la entrada del usuario, evitando problemas inesperados con las entradas del usuario.
		
		*/
			
		sc.nextLine();
		
		return opcion;	
		
		
		
	}	
	
	
	
}