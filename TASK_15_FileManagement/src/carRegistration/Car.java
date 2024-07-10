package carRegistration;

import java.io.Serializable;

public class Car implements Serializable{
	
	
	
	
	// This is generated when I put the mouse arrow over the number of the line, over the exclamation mark.
	
	private static final long serialVersionUID = 1277783534064510947L;

	
	
	
	
	
	private int id;
	
	private String plate;
	
	private String brand;
	
	private String model;
	
	private String color;
	
	
	
	
	
	public Car() {
		super();
	}
	
	
	


	public Car(int id, String plate, String brand, String model, String color) {
		super();
		this.id = id;
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
