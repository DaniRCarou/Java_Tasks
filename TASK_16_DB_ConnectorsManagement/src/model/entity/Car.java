package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Car {
	
	
	
	
	public List<Passenger> passengerList;
	
	
	
	
	
	
	private int id;
	
	private String plate;
	
	private String brand;
	
	private String model;
	
	private String color;
	
	
	
	
	
	public Car() {
		super();
		
		passengerList = new ArrayList<Passenger>();
		
	}
	
	
	


	public Car(String plate, String brand, String model, String color) {
		super();
		
		passengerList = new ArrayList<Passenger>();
		this.plate = plate;
		this.brand = brand;
		this.model = model;
		this.color = color;
		
	}
	
	
			
		



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "id= " + id + ", plate= " + plate + ", brand= " + brand + ", model= " + model + ", color= " + color;
	}

	
	
	
	
	
	
	
	
	
	

}
