package model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Terminals")
public class Terminal {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_id_airport", referencedColumnName = "id")
	private Airport airport;
	
	
	
	// THIS IS THE INVERSE SIDE
	@ManyToMany(mappedBy = "terminals")
	private List<Airline> airlines;
	
	
	
	
	
	public Terminal() {
		super();
	}
	
	
	
	
	
	
	

	public Terminal(Integer id, String name, Airport airport, List<Airline> airlines) {
		super();
		this.id = id;
		this.name = name;
		this.airport = airport;
		this.airlines = airlines;
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




	public List<Airline> getAirlines() {
		return airlines;
	}




	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}



	@Override
	public String toString() {
		return "Terminal [id=" + id + ", name=" + name + ", airport=" + airport + ", Airlines=" + airlines + "]";
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
