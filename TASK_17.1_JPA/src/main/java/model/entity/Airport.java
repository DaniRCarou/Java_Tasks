package model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="Airports")
public class Airport {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	
	
	@OneToMany(mappedBy = "airport")
	private List<Terminal> terminals;
	
	
	@OneToOne(mappedBy = "airport")
	private Tower tower;



	public Airport() {
		super();
	}


	/*
	 
	 * Integer id
	 
	 The difference lies in how data types work in Java, specifically between primitive types (such as int) and wrapper types (such as Integer).
	 int is a primitive data type in Java, and it cannot hold a null value (null).
	 Primitive types must always contain a valid value, so they can never be null. If you try to pass null to a parameter of type int, Java will throw a compilation error because null is not a valid value for a primitive type.
	
	*/
	

	public Airport(Integer id, String name, List<Terminal> terminals, Tower tower) {
		super();
		this.id = id;
		this.name = name;
		this.terminals = terminals;
		this.tower = tower;
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



	public List<Terminal> getTerminals() {
		return terminals;
	}



	public void setTerminals(List<Terminal> terminals) {
		this.terminals = terminals;
	}



	public Tower getTower() {
		return tower;
	}



	public void setTower(Tower tower) {
		this.tower = tower;
	}



	@Override
	public String toString() {
		return "Airport [id=" + id + ", name=" + name + ", terminals=" + terminals + ", tower=" + tower + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
