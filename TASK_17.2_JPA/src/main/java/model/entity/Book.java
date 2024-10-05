package model.entity;


import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Book {

	
	private int id;
	private String title;
	private double price;	
	private Publisher publisher;
	private Author author;
	private List<Bookstore> bookstores;
	
	
	public Book() {
		super();
	}
	
	
	
	public Book(int id, String title, double price, Publisher publisher, Author author, List<Bookstore> bookstores) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.author = author;
		this.bookstores = bookstores;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	
	public Publisher getPublisher() {
		return publisher;
	}


	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}

	
	public void setBookstores(List<Bookstore> bookstores) {
		this.bookstores = bookstores;
	}
	
	@XmlElement(name = "bookshop")
	@XmlElementWrapper(name = "bookshops")
	public List<Bookstore> getBookstores() {
		return bookstores;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", publisher=" + publisher + ", author="
				+ author + "]";
	}
	
		
	
	
		
}
