package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionTest {

	public static void main(String[] args) {


		
		// This example is to test the connection
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest"); // JPATest is the name of the persistence
		
		
		
		/*
		 
		To work with the database, we need a JPA object (the most important one), which is the Entity Manager. 
		This object will open connections and transactions to the database, and as long as it is not closed, 
		it will also cache the queries we have made to avoid sending repeated requests to the database.

		To create this object, we will rely on a factory that will create the object for us. 
		This factory is associated with a persistence unit defined in the META-INF/persistence.xml file.
		
		*/		
		
		EntityManager em = emf.createEntityManager();
		
		
		
		
	
		
		

	}

}
