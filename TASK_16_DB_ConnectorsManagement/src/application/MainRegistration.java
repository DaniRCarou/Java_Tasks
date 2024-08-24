package application;


import java.util.List;
import java.util.Scanner;

import model.entity.Car;
import model.entity.Passenger;
import model.persistences.DaoCarMySql;
import model.persistences.DaoPassengerMySql;
import model.persistence.interfaces.DaoCar;
import model.persistence.interfaces.DaoPassenger;

public class MainRegistration {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		
		int id;
		
		String plate;
		
		String brand;
		
		String model;
		
		String color;
		
		int passengerId;
		
		String name;
		
		int age;
		
		double weight;
		
		int carId;
		

		DaoCar dc = new DaoCarMySql(); // I need a this object type to use its methods and store them in the array
		
		DaoPassenger dp = new DaoPassengerMySql();
		
		
		
		
		Scanner sc = new Scanner(System.in); // I need this object to start the writing through the console
		
		int option = 0; // It is necessary to access to the command menú which will be showed in the console		
		
		
		
		
		
		
		do {
			
			// These are the options that will be displayed
			
			System.out.println("ENTER AN OPTION: \n");
			
			System.out.println("0. Close the programm");
			
			System.out.println("1. Add a new car: ");
			
			System.out.println("2. Delete a car by id: ");
			
			System.out.println("3. Consult a car by id: ");
			
			System.out.println("4. Modify a car by id: ");
			
			System.out.println("5. Car's list: ");
			
			System.out.println("6. Passenger management: ");
			
			System.out.println("\nOption? ");
			
			
			
			
			// To entered the option
			
			option = sc.nextInt();
			
			sc.nextLine();
			
			
			
			
			
			switch(option) {
			
			
			
			case 0: 					
			
				
				System.out.println("Bye bye...");
				
				
				break;
			
			
			
			case 1: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				
				
				System.out.println("Enter the Plate: ");
				
				plate = sc.nextLine();				
				
				System.out.println("Enter the brand: ");
				
				brand = sc.nextLine();
				
				System.out.println("Enter the model: ");
				
				model = sc.nextLine();
				
				System.out.println("Enter the color: ");
				
				color = sc.nextLine();				
				
				
				
				
				
				Car carOu = new Car();
				
				carOu.setPlate(plate);
				
				carOu.setBrand(brand);
				
				carOu.setModel(model);
				
				carOu.setColor(color);
				
				
				
				
				
				boolean register = dc.register(carOu); // I will save it in a variable to use it to know if it was registered
				
				if(register){
					
					System.out.println("The car was registered");
				
				}else{
					
					System.out.println("The car was not registered");
				
				}
				
				
				
				
				break;
			
				
				
			case 2: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				System.out.println("Enter the id: ");
				
				id = sc.nextInt();
				
				sc.nextLine();
				
				
				boolean delete = dc.delete(id);
				
				if(delete){
					
					System.out.println("The car was deleted");
				
				}else{					
					
					System.out.println("The car was not deleted");
				
				}		
				
				
				
				break;
				
				
			case 3: 
				
				
				System.out.println("Option " + option + " selected");
				
				
				System.out.println("Enter the id: ");
				
				id = sc.nextInt();
				
				sc.nextLine();
				
				
				
				Car car = dc.read(id);
					
				System.out.println(car);	
				
	
	
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
			    
			    
			    Car carOu2 = new Car();				
				
			    carOu2.setId(id);
			    
				carOu2.setPlate(plate);
				
				carOu2.setBrand(brand);
				
				carOu2.setModel(model);
				
				carOu2.setColor(color);
				
				
				
				
				boolean modify = dc.update(carOu2);
				
				if(modify){
					
					System.out.println("The car was registered");
				
				}else{
					
					System.out.println("The car was not registered");
				
				}
				
				
				
				
				
				
				break;
				
				
				
			case 5: 
				
				
				
				List<Car> carList = dc.list();
				
				for(Car c : carList){
					
					System.out.println(c);
					
				}
				
				
						
				
				break;		
			
				
			
				
				
			case 6: 	
				
				
				
				
				int option2 = 0;
				
				do {					
					
					
					System.out.println("\nOPTION 6 IS SELECTED, PLEASE ENTER THE NEXT OPTION: \n");
					
					System.out.println("0. Close the programm");
					
					System.out.println("1. Add a passenger: ");
					
					System.out.println("2. Delete a passenger by id: ");
					
					System.out.println("3. Consult a passenger by id: ");
					
					System.out.println("4. Passenger´s list: ");
					
					System.out.println("5. Add passenger to a car: ");
					
					System.out.println("6. Remove passenger from a car: ");
					
					System.out.println("7. List all passengers in a car.: ");
					
					System.out.println("\nOption? ");
					
					
					
					
					option2 = sc.nextInt();
					
					sc.nextLine();
					
										
					switch(option2) {
					
					
					
					case 0: 					
					
						
						System.out.println("Bye bye...");
						
						
						break;
					
					
					case 1: 					
						
						System.out.println("Option " + option2 + " from submenu was selected");
						
						
						
						System.out.println("Please, enter the passenger's name: ");
						
						name = sc.nextLine();
						
						System.out.println("Please, enter the passenger's age: ");
						
						age = sc.nextInt();sc.nextLine();						
						
						System.out.println("Please, enter the passenger's weight: ");
						
						weight = sc.nextDouble();sc.nextLine();
						
						
						Passenger psn = new Passenger();
						
						psn.setName(name);
						psn.setAge(age);
						psn.setWeight(weight);
						
						
						boolean register1 = dp.register(psn); // I will save it in a variable to use it to know if it was registered
						
						if(register1){
							
							System.out.println("The passenger was registered");
						
						}else{
							
							System.out.println("The passenger was not registered");
						
						}
						
						
						
						break;
						
					case 2: 

						System.out.println("Option " + option2 + " from submenu was selected");
						
						System.out.println("Please, enter the passenger id: ");
					
						passengerId = sc.nextInt();sc.nextLine();					 
						
						
						boolean delete1 = dp.delete(passengerId);
						
						if(delete1){
							
							System.out.println("The passenger was deleted");
						
						}else{					
							
							System.out.println("The passenger was not deleted");
						
						}		
						
						
						break;
						
					case 3: 

						System.out.println("Option " + option2 + " from submenu was selected");
						
						System.out.println("Please, enter the passenger id: ");
					
						passengerId = sc.nextInt();sc.nextLine();
						
						Passenger p = dp.read(passengerId);
						
						System.out.println(p);
						
						break;
						
					case 4:
						
						System.out.println("Option " + option2 + " from submenu was selected");						
												
						List<Passenger> pList = dp.list();
						
						if( pList.isEmpty()) {
							
							System.out.println("\n THERE IS NO PASSENGER");
							
						}else {
						
						for(Passenger p1 : pList){
							
							System.out.println(p1);
							
						}
						
						}
						break;
						
					case 5:
						
						
						System.out.println("Option " + option2 + " selected");
						
						System.out.println("Please, enter the passenger id: ");
					
						passengerId = sc.nextInt();sc.nextLine();
						
						System.out.println("These are the cars available, please enter the car id: ");
						
						
						List<Car> carList1 = dc.list();
						
						for(Car c : carList1){
							
							System.out.println(c);
							
						}
						
						System.out.println("\nEnter the car id: ");
						
						carId = sc.nextInt();sc.nextLine();
						
						
						boolean update = dp.addPassToCar(passengerId, carId);
						
						if(update){
							
							System.out.println("The passenger was added");
						
						}else{					
							
							System.out.println("The passenger was not added");
						
						}	
						
						break;
						
						
					case 6:
						
						
						System.out.println("Option " + option2 + " selected");
						
						
						System.out.println("\nTHESE ARE THE PASSENGERS IN EVERY CAR");
						
						List<Car> carList2 = dc.list();						
						
						
						
						
						for(Car c : carList2){																
							
							List<Passenger> pList1 = dp.listPassFromCar(c.getId());
							
							if( pList1.isEmpty()) {
								
								System.out.println("\nThere is no passenger in this car");
								
								System.out.println("CAR: " + c);
								
							}else {
								System.out.println("\nThese are the passengers in this car: ");
								
							System.out.println("CAR: " + c);
							
							for(Passenger p1 : pList1){
								
								System.out.println(p1);
								
							}
							
							}			
							
							
						}
						
						
						
						
						
						
						System.out.println("\nPlease, enter the passenger id: ");
					
						passengerId = sc.nextInt();sc.nextLine();
						
						System.out.println("Please, enter the car id: ");
						
						carId = sc.nextInt();sc.nextLine();
						
						
						boolean delete2 = dp.deletePassFromCar(passengerId, carId);
						
						if(delete2){
							
							System.out.println("The passenger was deleted");
						
						}else{					
							
							System.out.println("The passenger was not deleted");
						
						}	
						
						
						
						break;
						
						
					case 7:
						
						
						System.out.println("Option " + option2 + " selected");
						
						System.out.println("Please, enter the car id: ");
					
						carId = sc.nextInt();sc.nextLine();					
						
						
						List<Passenger> pList1 = dp.listPassFromCar(carId);
						
						if( pList1.isEmpty()) {
							
							System.out.println("\n THERE IS NO PASSENGER");
							
						}else {
						
						for(Passenger p1 : pList1){
							
							System.out.println(p1);
							
						}
						
						}
						
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
