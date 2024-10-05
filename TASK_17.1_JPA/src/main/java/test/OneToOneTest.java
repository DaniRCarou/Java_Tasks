package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.entity.Airport;
import model.entity.Tower;

public class OneToOneTest {

	public static void main(String[] args) {


		// It is always necessary the EntityManager object

		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = factoria.createEntityManager();
		
		
		Airport apt = new Airport(null, "BCN", null, null);
		Tower twr = new Tower(null, "Torre principal", null);
		
		
		apt.setTower(twr);
		twr.setAirport(apt);
		
		
		EntityTransaction et = em.getTransaction(); 
		et.begin();
		
		
		
		
		em.persist(apt);
		em.persist(twr);
		
		
		
		
		et.commit();
		
		em.close();

	}

}
