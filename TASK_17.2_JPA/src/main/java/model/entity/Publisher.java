package model.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Publisher {
	
	
	
	
	private int id;
	
	private String name;	
	
	private Address address;
	
	
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

	@XmlElement(name = "library")
	@XmlElementWrapper(name = "libraries")
	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", adress=" + address + ", books=" + books + "]";
	}
		
	
	
	
	
	

}
