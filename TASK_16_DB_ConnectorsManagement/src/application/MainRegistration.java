package application;


import java.util.Scanner;

import model.entity.Car;

//import model.Persistence.DaoCar;


public class MainRegistration {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		
		int id;
		
		String plate;
		
		String brand;
		
		String model;
		
		String color;
		
		

		// DaoCar warehouse = new DaoCar(); // I need a this object type to use its methods and store them in the array
		
		Scanner sc = new Scanner(System.in); // I need this object to start the writing through the console
		
		int option = 0; // It is necessary to access to the command menú which will be showed in the console		
		
		
		
		
		
		
		do {
			
			
			
			System.out.println("ENTER AN OPTION: \n");
			
			System.out.println("0. Close the programm");
			
			System.out.println("1. Add a new car: ");
			
			System.out.println("2. Delete a car by id: ");
			
			System.out.println("3. Consult a car by id: ");
			
			System.out.println("4. Modify a car by id: ");
			
			System.out.println("5. Car's list: ");
			
			System.out.println("6. Passenger management: ");
			
			System.out.println("\nOption? ");
			
			
			
			
			
			// In this variable will be stored what it is wrote through the console
			
			option = sc.nextInt();
			
			sc.nextLine();
			
			
			
			
			
			switch(option) {
			
			
			
			case 0: 					
			
				
				System.out.println("Bye bye...");
				
				
				break;
			
			
			
			case 1: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				
				/* boolean	control2;
				
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
				
				
				Car carOu = new Car(plate, brand, model, color);
				
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
				
				
				
				// warehouse.deleteCarById(id);			
				
				
				
				break;
				
				
			case 3: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				System.out.println("Enter the id: ");
				
				id = sc.nextInt();
				
				sc.nextLine();
				
				
				
				// warehouse.consultCarById(id);
					
					
				
	
	
				break;
				
				
			case 4:
				
				
				System.out.println("Option " + option + " selected");
				
				System.out.println("Please, enter the id of the car to modify:");
				
			    id = sc.nextInt();sc.nextLine();

			    System.out.println("Please, enter the plate:");
			    
			    plate = sc.nextLine();
			 	
			    System.out.println("Please, enter the brand:");
			    
			    brand = sc.nextLine();

			    System.out.println("Please, enter the model: ");
			    
			    model = sc.nextLine();
			    
			    System.out.println("Please, enter the color: ");
			    
			    color = sc.nextLine();
			    
			    
			    Car cModify = new Car();				
				
			    cModify.setId(id);
			    
				cModify.setPlate(plate);
				
				cModify.setBrand(brand);
				
				cModify.setModel(model);
				
				cModify.setColor(color);
				
				
				
				//warehouse.update(cModify);
				
				
				
				break;
				
				
				
			case 5: 
				
				//warehouse.consultList();
				
				
				break;		
			
				
			
				
				
			case 6: 	
				
				
				
				
				int option2 = 0;
				
				do {					
					
					
					System.out.println("ENTER AN OPTION: \n");
					
					System.out.println("0. Close the programm");
					
					System.out.println("1. Add a passenger: ");
					
					System.out.println("2. Delete a passenger by id: ");
					
					System.out.println("3. Consult a passenger by id: ");
					
					System.out.println("4. Passenger´s list: ");
					
					System.out.println("\nOption? ");
					
					
					
					
					option2 = sc.nextInt();
					
					sc.nextLine();
					
					int pId;
					
					int cId;
					
					
					switch(option2) {
					
					
					
					case 0: 					
					
						
						System.out.println("Bye bye...");
						
						
						break;
					
					
					case 1: 					
						
						System.out.println("Option " + option2 + " selected");
						
						System.out.println("Please, enter the passenger id: ");
					
						pId = sc.nextInt();sc.nextLine();
						
						System.out.println("Please, enter the car id: ");
						
						cId = sc.nextInt();sc.nextLine();
						
						break;
						
					case 2: 

						System.out.println("Option " + option2 + " selected");
						
						System.out.println("Please, enter the passenger id: ");
					
						pId = sc.nextInt();sc.nextLine();
						
						System.out.println("Please, enter the car id: ");
						
						cId = sc.nextInt();sc.nextLine();
						
						break;
						
					case 3: 

						System.out.println("Option " + option + " selected");
						
						System.out.println("Please, enter the passenger id: ");
					
						pId = sc.nextInt();sc.nextLine();
						
						
						
						break;
						
					case 4:
						
						System.out.println("Option " + option + " selected");						
												
						System.out.println("Please, enter the car id: ");
						
						cId = sc.nextInt();sc.nextLine();
						
						break;
						
						
					default: 
						
						System.out.println("wrong option");
						
					}
					
				
				}while(option2!=0);
				
				
							
				
				break;
							
				
				default: 
					
					System.out.println("wrong option");
			
			
			
			
			}			
			
			
			
			
		}while(option!=0);
		
		
		sc.close();			
		
		
		

	}	
		


}
