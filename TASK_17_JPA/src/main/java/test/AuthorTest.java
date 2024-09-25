package test;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.entity.Author;

public class AuthorTest {

	public static void main(String[] args) {

		// It is always necessary the EntityManager object

		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = factoria.createEntityManager();

		// It is not necessary to add the id because the database will assign it

		Author author = new Author();
		author.setName("Bud");
		author.setSurname("Spencer");		
		author.setBirthday(31, 10 ,1929);

		// For any operation that changes the data in the database, it's important to
		// manage it within a transaction to ensure data integrity and consistency.

		EntityTransaction et = em.getTransaction();

		// Starting the transaction

		et.begin();

		// With this method will be saved the Author object in the database

		em.persist(author);

		// Changes are persisted

		et.commit();

		// Closing the EntityManager

		em.close();

		// Once the person is saved, we can see their database ID.

		System.out.println("Persona creada con id: " + author.getId());

	}

}
