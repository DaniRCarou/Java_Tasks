package socket_server_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;



public class Library implements Runnable{

	
	
	private ArrayList<Book> biblioteca = new ArrayList<>();
	
	private Thread hilo;
	
	private Socket socketAlCliente;
	
	
	
	
	public Library(Socket socketAlCliente) {		
		super();		
		
		cargarLibros();
		
		this.socketAlCliente = socketAlCliente;
		
		hilo = new Thread(this);
		
		hilo.start();
		
	}
	
	
	
	
	private void cargarLibros() {
	
	biblioteca.add(new Book("1234", 20, "Ricardo falacias", "El día de la bestia"));
	
	biblioteca.add(new Book("5678", 30, "Alba Nada", "Schreck"));
	
	biblioteca.add(new Book("9012", 40, "Juan Todo", "La ruta"));
	
	biblioteca.add(new Book("3456", 50, "María Roca", "Los 4 jarrones"));
	
	biblioteca.add(new Book("7890", 60, "Juan Todo", "La galleta de la mala suerte"));
	
	}
	
	
	
	
	
	
	
	
	@Override
	public void run() {	
		
		
		
		try {
			
			
			PrintStream salida = new PrintStream(socketAlCliente.getOutputStream());
			
			InputStreamReader entrada = new InputStreamReader(socketAlCliente.getInputStream());
			
			BufferedReader entradaBuffer = new BufferedReader(entrada);
			
			
			
			
			
			boolean continuar = true;				
			
			while (continuar) {	
				
				
				
				String stringRecibido = entradaBuffer.readLine();	
				
				String[] datos = stringRecibido.split("-");	
				
				
				
				int caso = Integer.parseInt(datos[0]); 			
				
				String complement = datos[1];	
				
						
				
				int price = Integer.parseInt(datos[2]);        // PROBLEM
								
				String author = datos[3];
				
				String title = datos[4];
						
				
								
				if (caso == 0) {	
					
					
					salida.println("OK");
					
					System.out.println(hilo.getName() + " ha cerrado la comunicacion");
					
					continuar = false;
					
					
				} else if (caso == 1) {		
					

					ArrayList<Book> estanteria = new ArrayList<Book>();
					
					
					for(Book libro: biblioteca) {
						
						if(libro.getIsbn().equalsIgnoreCase(complement)) 						
							
							estanteria.add(libro);						
						
					}
					
					
					salida.println(estanteria);
					
					
				  } else if (caso == 2) {
					  
					  ArrayList<Book> estanteria = new ArrayList<Book>();
					  
						for(Book libro: biblioteca) {
							
							if(libro.getTitulo().equalsIgnoreCase(title))						
							
								estanteria.add(libro);						
							
						}
						
						
						salida.println(estanteria);
						
						
				  }	else if (caso == 3) {	
					  
					  ArrayList<Book> estanteria = new ArrayList<Book>();
							
							for(Book libro: biblioteca) {
								
								if(libro.getNombre().equalsIgnoreCase(author)) 						
								
									estanteria.add(libro);						
								
							}
							
							
							salida.println(estanteria);
							
					
				  }	else if (caso == 4) {									 		
							
								biblioteca.add(new Book(complement, price, author, title));
								
								salida.println("added");							
							
								
					
				  } else
					  
					  salida.println("El número seleccionado no está disponible");
					
					
				
				
			
			
			}
			
			
			
			
			socketAlCliente.close();
			
			
			
			
		} catch (IOException e) {
			
			System.err.println("HiloContadorLetras: Error de entrada/salida");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.err.println("HiloContadorLetras: Error");
			e.printStackTrace();
			
		}		
		
		
		
	}



}
