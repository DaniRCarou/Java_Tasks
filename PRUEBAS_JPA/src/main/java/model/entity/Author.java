package model.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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



// The class must follow the JavaBean convention in order to be an entity. It must have a public no-argument constructor (default constructor), private attributes and public get and set methods.
// With this annotation, it is indicated that this class will be a database table. By default, the table will be named after the class in lowerCamelCase (author).
@Entity


// The @Table annotation in JPA (Java Persistence API) is used to specify the table in the database that an entity class is mapped to. 
// This annotation is part of the JPA standard and helps define the relationship between the entity class and the corresponding database table.
@Table(name="Authors")


public class Author {
	
	
	
	// All tables should have a unique identifier. With @Id it is indicated that the attribute id would be a primary key. Name could be a primary key. We have to use @Id
	@Id		
	
	// The @GeneratedValue annotation in JPA (Java Persistence API) is used to specify how the values for a primary key field or property are generated. 
	// It is commonly used in conjunction with the @Id annotation to indicate that the primary key value is automatically generated by the persistence provider, rather than being assigned manually.
	// The @GeneratedValue(strategy = GenerationType.IDENTITY) annotation in JPA specifies that the primary key values should be automatically generated by the database using an identity column. 
	// This strategy is commonly used when you want the database to handle the generation of unique primary key values, often through an auto-increment feature.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	// The others attributes will be regular fields in the database.	
	private String name;	
	private String surname;	
	private LocalDate birthday;		
	private List<Book> books = new ArrayList<>();
	
	
	
	
	

	public Author() {
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


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(int day, int month, int year) {
        this.birthday = LocalDate.of(day, month, year);
    }


	@Override
	public String toString() {
		return "Author: id=" + id + "\nname=" + name + "\nsurname=" + surname + "\nbirthday=" + birthday + "\nbooks="
				+ books + "";
	}


	
	
	
		
	

}
