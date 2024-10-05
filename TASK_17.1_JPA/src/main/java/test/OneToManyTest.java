package test;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.entity.Airport;
import model.entity.Terminal;
import model.entity.Tower;

public class OneToManyTest {

	public static void main(String[] args) {
		
		
		
		
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = factoria.createEntityManager();
		
		
		Airport apt = new Airport(null, "BCN", null, null);
		Tower twr = new Tower(null, "Torre principal", null);
		
		
		apt.setTower(twr);
		twr.setAirport(apt);
		
		
		List<Terminal> terminals = new ArrayList<>();
		
		Terminal t1 = new Terminal(null, "Terminal 1", apt, null);
		
		Terminal t2 = new Terminal(null, "Terminal 2", apt, null);
		
		Terminal t3 = new Terminal(null, "Terminal South_1", apt, null);
		
		Terminal t4 = new Terminal(null, "Terminal South_2", apt, null);
		
		Terminal t5 = new Terminal(null, "Terminal North_1", apt, null);
		
		Terminal t6 = new Terminal(null, "Terminal North_2", apt, null);
		
		
		
		
		terminals.add(t1);
		
		terminals.add(t2);
		
		terminals.add(t3);
		
		terminals.add(t4);
		
		terminals.add(t5);
		
		terminals.add(t6);
		
		
		
		apt.setTerminals(terminals);
		
		
		
		
		
		
		EntityTransaction et = em.getTransaction(); 
		et.begin();
		
		
		
		
		em.persist(apt);
		em.persist(twr);
		
		
		// Since we have not created a 'cascade' in the list of airport terminals, we must persist each of its terminals
		// If we had created the 'cascade' we could also do it like this although it would not be necessary
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
		em.persist(t5);
		em.persist(t6);
		
		
		
		
		
		
		
		et.commit();
		
		em.close();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
