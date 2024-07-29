package model.Persistence;

import java.util.ArrayList;
import java.util.List;

import model.entity.Car;






 // DAO (Data Access Object), repository or persistence class. 
 // This DAO object will allow doing the persistence. 
 // In this case the DAO is simulated, created at the same DAO class
 


public class DaoCar {
	
	
 
	public List<Car> carsList;
	
	public int counter;
	
	
	
	
	
	

	public DaoCar() {
	super();	
	
		
		// carList has to be initialized
		
		carsList = new ArrayList<Car>();
		
		
		
		
		// Five objects will be created to be added to the carList		
		
		Car c1 = new Car("1111", "opel", "corsa", "black"); // ID: 0
		Car c2 = new Car("2468", "ford", "focus", "blue"); // ID: 1
		Car c3 = new Car("3579", "fiat", "600", "white"); // ID: 2
		Car c4 = new Car("4680", "vw", "golf", "red"); // ID: 3
		
		
		
		// Every Car will be added at the carList
		
		addCar(c1);
		addCar(c2);
		addCar(c3);
		addCar(c4);
	
		
		
	}
	
	
	
	
	
	
	// Getter method
	
	
	
	public List<Car> getCarsList() {
		return carsList;
	}


	
	// Setter method

	public void setCarsList(List<Car> carsList) {
		this.carsList = carsList;
	}
	
	
	
	
	  
	
	
	
	
	
	// This method enters a car at the end of the list.
	
	public void addCar(Car c) {
		
		c.setId(counter++);
		
		carsList.add(c);
		
	}
	
	
	
	// This method deletes a car by introducing the id .
	
	
	public void deleteCarById(int id) {
		
		for(Car ele: carsList) {			
			
			if(ele.getId() == id){
				
				carsList.remove(ele);									
				
			}else {
				
				System.out.println("Car not found");
				
			}
		
		}	
	
	}	
	
	
	// This method compares the id it is introduced and check if the car is in the list.
	
	
	public String consultCarById(int id) {
		
		for(Car ele: carsList) {			
			
			if (ele.getId() == id) {
				
				System.out.println(ele); 
				
			}
		
		}
		
		return "Not found";
		
	}
	
	
	
	
	
	// This method modifies a Car by id. 
	// I introduce a new car with all its new information, but with the ID from the car I want to update from the list.
		
	public Car update(Car c) {
			
		try {
			
			Car vAux = carsList.get(c.getId()); // With the ID, I should know which one I want to update, when I introduce the new video game, the Video game is located and saved in vAux variable. 
			
			vAux.setId(c.getId());
			
			vAux.setPlate(c.getPlate());
				
			vAux.setBrand(c.getBrand());
				
			vAux.setModel(c.getModel());	
			
			vAux.setColor(c.getColor());
					
			return vAux;		
			
		}catch(IndexOutOfBoundsException iobe) {
			
			System.out.println("Update -> Car out of range");
			
			return null;	
			
			}	
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	public void consultList() {
			
		for(Car ele: carsList) {
				
			System.out.println(ele);
					
					
		}
			
	}
		
		
		
		
		
		
		
		
		
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	