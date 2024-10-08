package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



/*

- The @Entity and @Table annotations are crucial for mapping ("Mapping" in the context of programming, especially when talking about databases and ORM (Object-Relational Mapping), 
refers to the process of establishing a correspondence or connection between two different structures, 
typically between objects in a program and tables in a relational database.) Java classes to tables in a relational database. 
These annotations are part of the JPA specification and are used to define how a class is mapped to a database table. 

*/



//The class must follow the JavaBean convention in order to be an entity. It must have a public no-argument constructor (default constructor), private attributes and public get and set methods.
@Entity


//The @Table annotation in JPA (Java Persistence API) is used to specify the table in the database that an entity class is mapped to. 
//This annotation is part of the JPA standard and helps define the relationship between the entity class and the corresponding database table.
@Table(name="books")

public class Book {

	// All tables should have a unique identifier. With @Id it is indicated that the attribute id would be a primary key. Name could be a primary key. We have to use @Id
	@Id		
		
	// The @GeneratedValue annotation in JPA (Java Persistence API) is used to specify how the values for a primary key field or property are generated. 
	// It is commonly used in conjunction with the @Id annotation to indicate that the primary key value is automatically generated by the persistence provider, rather than being assigned manually.
	// The @GeneratedValue(strategy = GenerationType.IDENTITY) annotation in JPA specifies that the primary key values should be automatically generated by the database using an identity column. 
	// This strategy is commonly used when you want the database to handle the generation of unique primary key values, often through an auto-increment feature.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private double price;
	private Publisher publisher;
	private Author author;
	
	
	public Book() {
		super();
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


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", publisher=" + publisher + ", author="
				+ author + "]";
	}
	
		
	
	
		
}
