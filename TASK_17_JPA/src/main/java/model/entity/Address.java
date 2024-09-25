package model.entity;

import jakarta.persistence.Embeddable;

// It is not necessary that this class is a new table. It won´t be mapped to an independent table in the database.
// These attributes will be part of the fields or columns of another table.  
// In this case for Bookstores table and Publishers table, with the annotation: @embedded in both classes
// In this class it only has to be used the annotation: @Embeddable

@Embeddable
public class Address {

	
	private String streetType;
	private String streetName;
	private int number;
	private String city;
	
	
	public Address() {
		super();
	}
	

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Adress [streetType=" + streetType + ", streetName=" + streetName + ", number=" + number + ", city="
				+ city + "]";
	}
	
	
	
	
	
	
		
	
}
