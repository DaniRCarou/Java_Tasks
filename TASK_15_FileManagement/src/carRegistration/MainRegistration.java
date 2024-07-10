package carRegistration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class MainRegistration {

	public static void main(String[] args) {
		
		
		
		int id;
		
		String plate;
		
		String brand;
		
		String model;
		
		String color;
		
		

		Warehouse warehouse = new Warehouse(); // Necesito un objeto de este tipo para poder utilizar sus métodos y guardarlos en el array
		
		Scanner sc = new Scanner(System.in); // Necesito este objeto para arrancar la escritura por consola
		
		int option = 0; // Esto lo necesitaré para acceder al menú de comandos que se mostrará en consola
		
		
		
		File fn = new File("cars.dat"); // This is the file I want to work. This is a relative way  to classpath. 			
		
		
		
		
		
		
		
		
		
		
		
		if(fn.exists()) { // Si existe el fichero leerá los objetos que contenga y los guardará en el arraylist de warehouse
			
			
			
			
			
		try(FileInputStream file = new FileInputStream(fn); ObjectInputStream buffer = new ObjectInputStream(file)) {
			
			
			boolean eof = false; // Esto indica que el final de fichero es falso, por tanto debe leer
			
			Car car; // Necesito este objeto paraguardar el objeto que lea
			
			
			while(!eof) {	// leeremos hasta el final de fichero			
				
				try {
					
					
					car = (Car) buffer.readObject(); // leo el objeto mientras eof sea true
					
					
					warehouse.addCar(car);
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			
				}
				
				
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
do {
			
			
			
			System.out.println("ENTER AN OPTION: \n");
			
			System.out.println("0. Close the programm : ");
			
			System.out.println("1. Add a new car: ");
			
			System.out.println("2. Delete a car by id: ");
			
			System.out.println("3. Consult a car by id: ");
			
			System.out.println("4. Car's list: ");
			
			System.out.println("\nOption? ");
			
			
			
			
			
			
			
			option = sc.nextInt();
			
			sc.nextLine();
			
			
			
			
			
			switch(option) {
			
			
			
			case 0: 					
				
				try {
					
					warehouse.addCarObject(fn);
					
				} catch (IOException e) {					
					
					e.printStackTrace();
					
				}
				
				System.out.println("Bye bye...");
				
				
				break;
			
			
			
			case 1: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				
				System.out.println("Enter the id: ");
				
				id = sc.nextInt();
				
				sc.nextLine();
				
				System.out.println("Enter the plate: ");
				
				plate = sc.nextLine();
				
				System.out.println("Enter the brand: ");
				
				brand = sc.nextLine();
				
				System.out.println("Enter the model: ");
				
				model = sc.nextLine();
				
				System.out.println("Enter the color: ");
				
				color = sc.nextLine();				
				
				
				Car carOu = new Car(id, plate, brand, model, color);
				
				
				warehouse.addCar(carOu);
				
				
				break;
			
				
				
			case 2: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				System.out.println("Enter the id: ");
				
				id = sc.nextInt();
				
				sc.nextLine();
				
				
				
				warehouse.deleteCarById(id);			
				
				
				
				break;
				
				
			case 3: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				System.out.println("Enter the id: ");
				
				id = sc.nextInt();
				
				sc.nextLine();
				
				
				
				warehouse.consultCarById(id);
					
					
				
	
	
				break;
				
				
			case 4: 
				
				warehouse.consultList();
				
				
				break;		
				
							
				default: 
					
					System.out.println("wrong option");
			
			
			
			
			}			
			
			
			
			
		}while(option!=0);
		
		
		sc.close();			
		
		
		

	}	
		


}
