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
				
				
				opcion = menu(); // Se muestra el menú en pantalla, se elige una opción y esa opción se guarda en esta variable.
				
				
				
			switch(opcion) {
			
			
					
				
				case 1:				
					
					System.out.println("Opción seleccionada: " + opcion + " -> Por favor, introduzca el código ISBN");
									
										
					/*
					 Consumir la nueva línea pendiente antes de leer la entrada del usuario. En este caso, se agrega sc.nextLine() antes de la lectura real de la entrada del usuario. Esto ayuda a consumir la nueva línea pendiente después de la opción seleccionada en el menú. 
					 Después de hacer esto, deberías poder leer la entrada del usuario correctamente sin que aparezca el mensaje "No has escrito nada" sin motivo aparente. 
					 Cuando se trabaja con la entrada estándar en Java, especialmente con objetos Scanner, es posible que queden caracteres de nueva línea ('\n') pendientes en el búfer del sistema después de leer un valor numérico o una cadena. Esto es común, por ejemplo, cuando lees un número con nextInt() y luego realizas una lectura adicional con nextLine().

					 La línea "// Consumir la nueva línea pendiente antes de leer la entrada del usuario" se refiere a agregar una llamada a nextLine() adicional para consumir explícitamente esa nueva línea que queda en el búfer después de leer la opción numérica del menú. Esto es necesario porque después de que el usuario ingrese un número y presione "Enter", el carácter de nueva línea ('\n') queda en el búfer del sistema.
					 Cuando luego llamas a nextLine() para leer la entrada del usuario (por ejemplo, el código ISBN), si no consumes ese carácter de nueva línea pendiente, nextLine() podría simplemente leer ese carácter y devolver una cadena vacía.
					 Por lo tanto, agregar sc.nextLine() antes de leer la entrada real del usuario garantiza que cualquier carácter de nueva línea pendiente se consuma antes de leer la entrada del usuario, evitando problemas inesperados con las entradas del usuario.
					
					*/
					
					// sc.nextLine();
					
					texto = sc.nextLine();
					
					String datos = opcion + "-" + texto;
					
					salida.println(datos);					
					
					break;
					
				case 2:				
					
					System.out.println("Opción seleccionada: " + opcion + " -> Por favor, introduzca el título del libro");
					
					// sc.nextLine();
					
					texto = sc.nextLine();
					
					datos = opcion + "-" + texto;
					
					salida.println(datos);	
					
					break;
					
				case 3:				
										
					System.out.println("Opción seleccionada: " + opcion + " -> Por favor, introduzca el autor del libro");
					
					// sc.nextLine();
					
					texto = sc.nextLine();
					
					datos = opcion + "-" + texto;
					
					salida.println(datos);
					
					break;
					
				case 4:				
					
					System.out.println("Opción seleccionada: " + opcion + " -> Por favor, introduzca los datos del libro");
					
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
					
				case 0: // Este caso no hace nada, se lo salta, porque así está indicado en el "while"
					
					salida.println(opcion);				
					
					break;					
					
								
					default: 
						
						System.out.println("Opción incorrecta");
				
				
			}
			
			
							
			String respuesta = entradaBuffer.readLine(); // ENTRADA	
			
			
			
			if(respuesta.trim().equalsIgnoreCase("OK"))	{
				
			System.out.println( respuesta + ", Comunicación cerrada"); // CONSOLA	
			
			}else if (respuesta.trim().equalsIgnoreCase("NO")) {	
				
				System.out.println("\nEL LIBRO SOLICITADO NO EXISTE\n"); // CONSOLA	
			
			}else	
				
				System.out.println("\nEl libro solicitado es: " + respuesta + "\n"); // CONSOLA		
			
				
			}while(opcion!=0);
			
			System.out.println("Salida realizada");
			
			
			sc.close();	
			
			socketAlServidor.close();
			
			
		} catch (UnknownHostException e) {
			
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
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
		
		System.out.println("4. Añadir libro" + "\n");
			
		System.out.println("0. Si desea salir de la aplicación");
		
			
			
		opcion = sc.nextInt();
		
		/*
		 Consumir la nueva línea pendiente antes de leer la entrada del usuario. En este caso, se agrega sc.nextLine() antes de la lectura real de la entrada del usuario. Esto ayuda a consumir la nueva línea pendiente después de la opción seleccionada en el menú. 
		 Después de hacer esto, deberías poder leer la entrada del usuario correctamente sin que aparezca el mensaje "No has escrito nada" sin motivo aparente. 
		 Cuando se trabaja con la entrada estándar en Java, especialmente con objetos Scanner, es posible que queden caracteres de nueva línea ('\n') pendientes en el búfer del sistema después de leer un valor numérico o una cadena. Esto es común, por ejemplo, cuando lees un número con nextInt() y luego realizas una lectura adicional con nextLine().

		 La línea "// Consumir la nueva línea pendiente antes de leer la entrada del usuario" se refiere a agregar una llamada a nextLine() adicional para consumir explícitamente esa nueva línea que queda en el búfer después de leer la opción numérica del menú. Esto es necesario porque después de que el usuario ingrese un número y presione "Enter", el carácter de nueva línea ('\n') queda en el búfer del sistema.
		 Cuando luego llamas a nextLine() para leer la entrada del usuario (por ejemplo, el código ISBN), si no consumes ese carácter de nueva línea pendiente, nextLine() podría simplemente leer ese carácter y devolver una cadena vacía.
		 Por lo tanto, agregar sc.nextLine() antes de leer la entrada real del usuario garantiza que cualquier carácter de nueva línea pendiente se consuma antes de leer la entrada del usuario, evitando problemas inesperados con las entradas del usuario.
		
		*/
			
		sc.nextLine();
		
		return opcion;	
		
		
		
	}	
	
	
	
}