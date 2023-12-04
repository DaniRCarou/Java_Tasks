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
	
	biblioteca.add(new Book("1234", 20, "El día de la bestia", "Ricardo falacias"));
	
	biblioteca.add(new Book("5678", 30, "Schreck", "Alba Nada"));
	
	biblioteca.add(new Book("9012", 40, "La ruta", "Juan Todo"));
	
	biblioteca.add(new Book("3456", 50, "Los 4 jarrones", "María Roca"));
	
	biblioteca.add(new Book("7890", 60, "La galleta de la mala suerte", "Juan Todo"));
	
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
				
				String complemento = datos[1]; 			
				
				
				if (caso == 0) {	
					
					
					salida.println("OK");
					
					System.out.println(hilo.getName() + " ha cerrado la comunicacion");
					
					continuar = false;
					
					
				} else if (caso == 1) {		
					

					ArrayList<Book> estanteria = new ArrayList<Book>();
					
					
					for(Book libro: biblioteca) {
						
						if(libro.getIsbn().equalsIgnoreCase(complemento)) 						
							
							estanteria.add(libro);						
						
					}
					
					
					salida.println(estanteria);
					
					
				  } else if (caso == 2) {
					  
					  ArrayList<Book> estanteria = new ArrayList<Book>();
					  
						for(Book libro: biblioteca) {
							
							if(libro.getTitulo().equalsIgnoreCase(complemento))						
							
								estanteria.add(libro);						
							
						}
						
						
						salida.println(estanteria);
						
						
				  }	else if (caso == 3) {	
					  
					  ArrayList<Book> estanteria = new ArrayList<Book>();
							
							for(Book libro: biblioteca) {
								
								if(libro.getNombre().equalsIgnoreCase(complemento)) 						
								
									estanteria.add(libro);						
								
							}
							
							
							salida.println(estanteria);
							
					
				  }	else if (caso == 4) {						
						
								Book addedBook = new Book(complemento, caso, complemento, complemento);		
							
								biblioteca.add(addedBook);
								
								salida.println("Libro añadido");							
							
								
					
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
