package model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Airlines")
public class Airline {
	
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	
	@Id
	private String name;
	
	
	// THIS IS THE OWNING SIDE
	@ManyToMany
	@JoinTable(name="airlines_terminals",
		joinColumns= { @JoinColumn(name="fk_airline_name", referencedColumnName="name") }, 
		inverseJoinColumns= { @JoinColumn(name="fk_terminal_id", referencedColumnName="id")})
	private List<Terminal> terminals;
	
	
	

	public Airline() {
		super();
	}
	


	public Airline(Integer cod, String name, List<Terminal> terminals) {
		super();
		this.cod = cod;
		this.name = name;
		this.terminals = terminals;
	}



	public int getCod() {
		return cod;
	}




	public void setCod(int cod) {
		this.cod = cod;
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




	@Override
	public String toString() {
		return "Airline [cod=" + cod + ", name=" + name + ", terminals=" + terminals + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
