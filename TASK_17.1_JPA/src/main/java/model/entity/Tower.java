package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Towers")
public class Tower {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "fk_id_airport", referencedColumnName = "id")	
	private Airport airport;


	public Tower() {
		super();
	}
	
	

	public Tower(Integer id, String name, Airport airport) {
		super();
		this.id = id;
		this.name = name;
		this.airport = airport;
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


	public Airport getAirport() {
		return airport;
	}


	public void setAirport(Airport airport) {
		this.airport = airport;
	}


	@Override
	public String toString() {
		return "Tower [id=" + id + ", name=" + name + ", airport=" + airport + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
