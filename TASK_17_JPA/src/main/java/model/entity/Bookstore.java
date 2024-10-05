package model.entity;

import java.util.List;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;



@Entity
@Table(name="bookstores")
public final class Bookstore {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String owner;
	
	
	// With the following annotation, we indicate that the address will not have its own table but will instead be in a column of the bookstores table.
	// The Address class will not be its own entity, therefore it will not have the @Entity annotation.
	// The Address class will be @embeddable
	@Embedded
	private Address address;
	
	
	
	// THIS IS THE OWNING SIDE	
	@ManyToMany	
	@JoinTable(name="bookstores_books",
	   joinColumns= { @JoinColumn(name="fk_bookstore_id", referencedColumnName="id") }, 
	   inverseJoinColumns= { @JoinColumn(name="fk_book_id", referencedColumnName="id")})   
	private List<Book> books;
	
	
	
	
	public Bookstore() {
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




	public List<Book> getBooks() {
		return books;
	}




	public void setBooks(List<Book> books) {
		this.books = books;
	}




	@Override
	public String toString() {
		return "Bookstore [id=" + id + ", name=" + name + ", owner=" + owner + ", adress=" + address + ", books=" + books
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
}
