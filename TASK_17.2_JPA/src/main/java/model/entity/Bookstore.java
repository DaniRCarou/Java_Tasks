package model.entity;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;




@XmlRootElement
public final class Bookstore {
	
	
	
	
	
	private int id;
	
	private String name;
	private String owner;	
	private Address address;	
	 
	private List<Book> library;
	
	
	
	
	public Bookstore() {
		super();
	}




	public Bookstore(int id, String name, String owner, Address address, List<Book> library) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.address = address;
		this.library = library;
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




	public String getOwner() {
		return owner;
	}




	public void setOwner(String owner) {
		this.owner = owner;
	}




	public Address getAddress() {
		return address;
	}




	public void setAddress(Address address) {
		this.address = address;
	}



	@XmlElement(name = "library")
	@XmlElementWrapper(name = "libraries")
	public List<Book> getLibrary() {
		return library;
	}




	public void setLibrary(List<Book> books) {
		this.library = books;
	}




	@Override
	public String toString() {
		return "Bookstore [id=" + id + ", name=" + name + ", owner=" + owner + ", adress=" + address + ", books=" + library
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
}
