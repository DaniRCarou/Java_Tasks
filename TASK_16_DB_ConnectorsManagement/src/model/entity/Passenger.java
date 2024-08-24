package model.entity;

public class Passenger {
	
	
	
	
	private int id;
	private String name;
	private int age;
	private double weight;
	private int carId;
	
	
	public Passenger() {
		super();
	}



	public Passenger(int id, String name, int age, double weight, int carId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.carId = carId;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getWeight() {
		return weight;
	}



	public void setWeight(double weight) {
		this.weight = weight;
	}


	
	public int getCarId() {
		return carId;
	}



	public void setCarId(int id) {
		this.carId = id;
	}

	
	
	
	
	
	
	

	@Override
	public String toString() {
		return "Passenger: id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + ", carId=" + carId ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
