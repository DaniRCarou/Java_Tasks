package carRegistration;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainRegistration {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		
		int id;
		
		String plate;
		
		String brand;
		
		String model;
		
		String color;
		
		

		Warehouse warehouse = new Warehouse(); // Necesito un objeto de este tipo para poder utilizar sus métodos y guardarlos en el array
		
		Scanner sc = new Scanner(System.in); // Necesito este objeto para arrancar la escritura por consola
		
		int option = 0; // Esto lo necesitaré para acceder al menú de comandos que se mostrará en consola
		
		
		
		File fn = new File("cars.dat"); // This is the file I want to work. This is a relative way  to classpath. 			
		
		
		File fn2 = new File("cars.csv");
		
		
		
		
		
		
		
		
		if(fn.exists()) { // Si existe el fichero leerá los objetos que contenga y los guardará en el arraylist de warehouse
			
			
			
			
			try(FileInputStream fis = new FileInputStream(fn); ObjectInputStream buffer = new ObjectInputStream(fis)){
			
			boolean eof = false;
			
			
			
			
			while(!eof) {
				
				
				try {
					
                    Car c = (Car) buffer.readObject();
                    
                    System.out.println(c);  // Just for testing
                    
                    warehouse.addCar(c);
                    
                } catch (EOFException e) {
                	
                    eof = true; //  eof = true; or "break;" The end of the file has been reached
                    
                }			
				
				
				
			}
			
			
			
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			
			
		
			
		}
		
		
		
		
		
		
		
		
		
do {
			
			
			
			System.out.println("ENTER AN OPTION: \n");
			
			System.out.println("0. Close the programm : ");
			
			System.out.println("1. Add a new car: ");
			
			System.out.println("2. Delete a car by id: ");
			
			System.out.println("3. Consult a car by id: ");
			
			System.out.println("4. Add to a CSV file: ");
			
			System.out.println("5. Car's list: ");
			
			System.out.println("\nOption? ");
			
			
			
			
			
			
			
			option = sc.nextInt();
			
			sc.nextLine();
			
			
			
			
			
			switch(option) {
			
			
			
			case 0: 					
				
				
				
				
				try {
					fn.createNewFile();
					
					
				try(FileOutputStream fios = new FileOutputStream(fn); ObjectOutputStream ois = new ObjectOutputStream(fios)){
					

					for(Car car: warehouse.getCarsList()) {
						
						ois.writeObject(car);
						
					}
					
					
				}
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				
				
				
			
				
				System.out.println("Bye bye...");
				
				
				break;
			
			
			
			case 1: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				
				boolean	control;
				
				do {
					
				control = true;	
					
				System.out.println("Enter the id: ");
				
				id = sc.nextInt();
				
				sc.nextLine();
				
				
				
				for (Car car : warehouse.getCarsList()) {
					
		            if (car.getId() == id) {
		            	
		                System.out.println("Car already exists!");
		                
		                control = false;
		                
		                break; // Exit the for loop
		                
		            }
				
				}
				
				
				
				
				}while(control == false);
				
				
				
				
						
				
				
				
				boolean	control2;
				
				do {
					
				control2 = true;	
					
				System.out.println("Enter the Plate: ");
				
				plate = sc.nextLine();			
				
				
				
				
				for (Car car : warehouse.getCarsList()) {
					
		            if (car.getPlate().equals(plate)) {
		            	
		                System.out.println("Car already exists!");
		                
		                control2 = false;
		                
		                break; // Exit the for loop
		                
		            }
				
				}
				
				
				
				
				}while(control2 == false);
				
				
				
				
				
				
				System.out.println("Enter the brand: ");
				
				brand = sc.nextLine();
				
				System.out.println("Enter the model: ");
				
				model = sc.nextLine();
				
				System.out.println("Enter the color: ");
				
				color = sc.nextLine();				
				
				
				Car carOu = new Car(id, plate, brand, model, color);
				
				warehouse.addCar(carOu);
				
				
				/*
				
				// THIS IS JUST FOR TESTING
				
				Car carOu1 = new Car(1111, "A1357", "ford", "focus", "red");
				Car carOu2 = new Car(2222, "B2468", "opel", "corsa", "grey");
				Car carOu3 = new Car(3333, "C3579", "fiat", "600", "white");
				
				warehouse.addCar(carOu1);
				warehouse.addCar(carOu2);
				warehouse.addCar(carOu3);
				
				*/
				
				
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
				
				
				try {
					
					
					fn2.createNewFile();
					
					
				try(FileOutputStream fios = new FileOutputStream(fn2); DataOutputStream ois = new DataOutputStream(fios)){
					
					
					ois.writeUTF("Id; Plate; Brand; Model; Color\n");

					for(Car car: warehouse.getCarsList()) {
						
						ois.writeUTF(car.getId() + ";" + car.getPlate() + ";" + car.getBrand() + ";" + car.getModel() + ";" + car.getColor()+ "\n");
						
						
					}
					
					
				}
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				break;
				
				
				
			case 5: 
				
				warehouse.consultList();
				
				
				break;		
				
							
				default: 
					
					System.out.println("wrong option");
			
			
			
			
			}			
			
			
			
			
		}while(option!=0);
		
		
		sc.close();			
		
		
		

	}	
		


}
