package model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="Publishers")
public class Publisher {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "publisher")
	private List<Book> books = new ArrayList<>();;

	
	public Publisher() {
		super();
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


	public Address getAdress() {
		return address;
	}


	public void setAdress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", adress=" + address + ", books=" + books + "]";
	}
		
	
	
	
	
	

}
