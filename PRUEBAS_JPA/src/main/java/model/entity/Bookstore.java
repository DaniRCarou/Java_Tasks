package model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name="bookstores")
public final class Bookstore {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String owner;
	private String adress;
	private List<Book> books = new ArrayList<>();;
	
	
	
	
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




	public String getAdress() {
		return adress;
	}




	public void setAdress(String adress) {
		this.adress = adress;
	}




	public List<Book> getBooks() {
		return books;
	}




	public void setBooks(List<Book> books) {
		this.books = books;
	}




	@Override
	public String toString() {
		return "Bookstore [id=" + id + ", name=" + name + ", owner=" + owner + ", adress=" + adress + ", books=" + books
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
}
