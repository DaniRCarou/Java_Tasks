package test;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.entity.Address;
import model.entity.Author;
import model.entity.Book;
import model.entity.Bookstore;
import model.entity.Publisher;





/*

1. RELACION BIDIRECCIONAL Y LADO PROPIETARIO DE LA RELACIÓN:

En JPA, las relaciones bidireccionales tienen un concepto clave: el lado propietario (owning side) y el lado inverso (inverse side). 
El lado propietario es el responsable de mantener la relación en la base de datos. Solo los cambios en el lado propietario son reflejados en la base de datos, mientras que el lado inverso simplemente refleja los cambios que se hacen en el lado propietario.
En ambos ejemplos (Bookstore-Book y Airline-Terminal), al parecer el comportamiento de la relación es diferente porque la configuración de las entidades puede estar definida de manera distinta.




2. CONFIGURACIÓN DE LA RELACIÓN Bookstore-Book:

En el caso de Bookstore-Book, la razón por la cual parece que no hay problema es que el lado propietario de la relación está bien definido. 
Lo más probable es que:

    Bookstore sea el lado propietario de la relación.
    Book sea el lado inverso.

Si la relación está configurada correctamente con la anotación mappedBy en el lado de Book, entonces JPA entiende que las actualizaciones solo deben ser gestionadas desde el lado de Bookstore. 
Por eso, cuando asignas los libros a las librerías y persistes las librerías, JPA actualiza automáticamente la tabla intermedia sin necesidad de que actualices el lado inverso (es decir, no necesitas asignar las librerías a los libros).
 
*/






/*
 
 1. Bidirectional Relationship and Owning Side:

In JPA, bidirectional relationships have a key concept: the owning side and the inverse side. 
The owning side is responsible for maintaining the relationship in the database. Only changes made to the owning side are reflected in the database, while the inverse side simply reflects changes made on the owning side.
In both examples (Bookstore-Book and Airline-Terminal), the behavior of the relationships might seem different because the entity configurations may be defined differently.



2. Configuration of the Bookstore-Book Relationship:

In the case of Bookstore-Book, the reason it seems to work without issues is that the owning side of the relationship is well-defined.
Most likely:

    Bookstore is the owning side of the relationship.
    Book is the inverse side.

If the relationship is configured correctly with the mappedBy annotation on the Book side, then JPA understands that updates only need to be managed from the Bookstore side. Therefore, when you assign books to bookstores and persist the bookstores, JPA automatically updates the join table without needing to update the inverse side (i.e., you don’t need to assign bookstores to the books).
 
*/


public class BookstoresChainTest {

	public static void main(String[] args) {


		
		// It is always necessary the EntityManager object

		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = factoria.createEntityManager();
		
		
		
		// REGISTER 3 AUTHORS		
		
		Author a = new Author();
		a.setName("Mortadelo");
		a.setSurname("Garcia");		
		a.setBirthday(1, 10 , 1929);
		
		Author a1 = new Author();
		a1.setName("Filemon");
		a1.setSurname("Pi");		
		a1.setBirthday(12, 9 , 1970);
		
		Author a2 = new Author();
		a2.setName("Danielito");
		a2.setSurname("Carocito");		
		a2.setBirthday(9, 8 , 1988);
		
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(a);
		em.persist(a1);
		em.persist(a2);
		
		et.commit();
		
		


		
			
		// REGISTER 2 PUBLISHERS
		
		
		// Address 1
		Address ad = new Address();
		ad.setStreetType("Calle");
		ad.setStreetName("Portugalete");
		ad.setNumber(16);
		ad.setCity("Madrid");
		
		// Publisher 1
		Publisher p = new Publisher();
		p.setName("Santillana");
		p.setAdress(ad);
		
		
		// Address 2
		Address ad1 = new Address();
		ad1.setStreetType("Avd.");
		ad1.setStreetName("Balaidos");
		ad1.setNumber(69);
		ad1.setCity("Vigo");
		
		// Publisher 2
		Publisher p1 = new Publisher();
		p1.setName("Edelvives");
		p1.setAdress(ad1);
		
		
		et.begin();
		
		em.persist(p);
		em.persist(p1);
		
		et.commit();
		
	
		// REGISTER 8 BOOKS 
		// Each book will be written by one of the previously registered authors 
		// and will belong to one of the previously registered publishers.
						
		
		// Book 1
		Book b1 = new Book();
		b1.setAuthor(a);
		b1.setPublisher(p);
		b1.setTitle("Holy wassa");
		b1.setPrice(10.2);
			
		
		// Book 2
		Book b2 = new Book();
		b2.setAuthor(a1);
		b2.setPublisher(p1);
		b2.setTitle("The way you are");
		b2.setPrice(15);
		
				
		// Book 3
		Book b3 = new Book();
		b3.setAuthor(a1);
		b3.setPublisher(p1);
		b3.setTitle("I want you");
		b3.setPrice(18);
		
		
		// Book 4
		Book b4 = new Book();
		b4.setAuthor(a2);
		b4.setPublisher(p);
		b4.setTitle("It always remind me of you");
		b4.setPrice(3.8);
		
						
		// Book 5
		Book b5 = new Book();
		b5.setAuthor(a);
		b5.setPublisher(p1);
		b5.setTitle("Gaga");
		b5.setPrice(9.75);
		
						
		// Book 6
		Book b6 = new Book();
		b6.setAuthor(a2);
		b6.setPublisher(p);
		b6.setTitle("The soldier without eyes");
		b6.setPrice(16.4);
		
		
		// Book 7
		Book b7 = new Book();
		b7.setAuthor(a2);
		b7.setPublisher(p);
		b7.setTitle("Miracle at the sky");
		b7.setPrice(22.2);
		
				
		// Book 8
		Book b8 = new Book();
		b8.setAuthor(a1);
		b8.setPublisher(p1);
		b8.setTitle("How to work without boss");
		b8.setPrice(32.99);
		
		et.begin();
		
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		em.persist(b5);
		em.persist(b6);
		em.persist(b7);
		em.persist(b8);
		
		et.commit();

		
		
		
		
		
		// REGISTER 2 BOOKSTORES
		// Each bookstore will have 4 books previously registered
		
		// Bookstore1
		
		Bookstore bs1 = new Bookstore();
		bs1.setName("Rolland business");
		bs1.setOwner("John Doe");
		List<Book> booksBs1 = new ArrayList<Book>();
		booksBs1.add(b1);
		booksBs1.add(b4);
		booksBs1.add(b5);		
		booksBs1.add(b8);
		bs1.setBooks(booksBs1); 
		
		// Bookstore2
		
		Bookstore bs2 = new Bookstore();
		bs2.setName("Balaidos");
		bs2.setOwner("María del Rocío");
		List<Book> booksBs2 = new ArrayList<Book>();
		booksBs2.add(b2);
		booksBs2.add(b3);
		booksBs2.add(b6);
		booksBs2.add(b7);
		bs2.setBooks(booksBs2); 
		
		et.begin();
		
		
		System.out.println("Persisting Bookstore..."); // This is to Know where is the Point where the Bookstores are persisted
		
		em.persist(bs1);
		em.persist(bs2);
		
		et.commit();	
		
		
		
		em.close();
		
		
		
		
		
		
		

	}

}
