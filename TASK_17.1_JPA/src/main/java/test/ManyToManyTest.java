package test;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.entity.Airline;
import model.entity.Airport;
import model.entity.Terminal;
import model.entity.Tower;


/*
 
1. RELACION BIDIRECCIONAL Y LADO PROPIETARIO DE LA RELACIÓN:

En JPA, las relaciones bidireccionales tienen un concepto clave: el lado propietario (owning side) y el lado inverso (inverse side). 
El lado propietario es el responsable de mantener la relación en la base de datos. Solo los cambios en el lado propietario son reflejados en la base de datos, mientras que el lado inverso simplemente refleja los cambios que se hacen en el lado propietario.
En ambos ejemplos (Bookstore-Book y Airline-Terminal), al parecer el comportamiento de la relación es diferente porque la configuración de las entidades puede estar definida de manera distinta.




2. CONFIGURACIÓN DE LA RELACIÓN Bookstore-Book:

En el caso de Airline-Terminal, la razón por la cual parece que no hay problema es que el lado propietario de la relación está bien definido. 
Lo más probable es que:

    Airline sea el lado propietario de la relación.
    Terminal sea el lado inverso.

Si la relación está configurada correctamente con la anotación mappedBy en el lado de Terminal, entonces JPA entiende que las actualizaciones solo deben ser gestionadas desde el lado de Airline. 
Por eso, cuando asignas las terminals a las airlines y persistes las airlines, JPA actualiza automáticamente la tabla intermedia sin necesidad de que actualices el lado inverso (es decir, no necesitas asignar las airlines a las terminals).
 
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


public class ManyToManyTest {

	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = factory.createEntityManager();
		
		
		Airport apt = new Airport(null, "BCN", null, null);
		Tower twr = new Tower(null, "Torre principal", null);
		
		
		apt.setTower(twr);
		twr.setAirport(apt);
		
		
		
		
		
		// TERMINALS
		
		Terminal terminal1 = new Terminal(null, "Terminal 1", apt, null);
		
		Terminal terminal2 = new Terminal(null, "Terminal 2", apt, null);
		
		Terminal terminal3 = new Terminal(null, "Terminal 3", apt, null);
		
		
		
		// AIRLINES
		
		Airline eurowings = new Airline(null, "Eurowings", null);
		
		Airline iberia = new Airline(null, "Iberia", null);
		
		Airline tap = new Airline(null, "TAP Portugal", null);
		
		
		
		
		
		
		// ASIGNAMOS LAS TERMINALES A LAS AEROLINEAS, PORQUE LAS AEROLINAS SON EL LADO PROPIETARIO (EXPLICADO ARRIBA DE TODO)
		// EL LADO PROPIETARIO ES EL RESPONSABLE DE MANTENER LA RELACIÓN EN LA BASE DE DATOS, SI NO NO SE GUARDARÍAN LOS DATOS EN LA TABLA INTERMEDIA 
		// SI NO LO HACEMOS DE ESTA MANERA, TENDRÍAMOS QUE ASIGNAR LAS AIRLINES A LAS TERMINALES Y ASIGNAR LAS TERMINALES A LAS AIRLINES.
		// DE ESTA MANERA SOLO ASIGNAMOS LAS TERMINALES A LAS AIRLINES
		
		// WE ASSIGN THE TERMINALS TO THE AIRLINES BECAUSE THE AIRLINES ARE THE OWNERSHIP SIDE (EXPLAINED ABOVE). 
		// THE OWNERSHIP SIDE IS RESPONSIBLE FOR MAINTAINING THE RELATIONSHIP IN THE DATABASE; OTHERWISE, THE DATA WOULD NOT BE SAVED IN THE INTERMEDIATE TABLE.
		// IF WE DO NOT DO IT THIS WAY, WE WOULD HAVE TO ASSIGN THE AIRLINES TO THE TERMINALS AND ASSIGN THE TERMINALS TO THE AIRLINES. 
		// THIS WAY, WE ONLY ASSIGN THE TERMINALS TO THE AIRLINES.		
		
		// AIRLINES LIST Airline eurowings
		
		List<Terminal> terminalsAirline1 = new ArrayList<Terminal>();
		
		
		terminalsAirline1.add(terminal1);
		terminalsAirline1.add(terminal3);
		
		eurowings.setTerminals(terminalsAirline1);
		
		
		// AIRLINES LIST Airline iberia			
		
		List<Terminal> terminalsAirline2 = new ArrayList<Terminal>();
		
		
		terminalsAirline2.add(terminal2);
		terminalsAirline2.add(terminal3);
		
		iberia.setTerminals(terminalsAirline2);
				
		
		// AIRLINES LIST Airline tap
		
		List<Terminal> terminalsAirline3 = new ArrayList<Terminal>();
		
		
		terminalsAirline3.add(terminal1);
		terminalsAirline3.add(terminal2);
		
		tap.setTerminals(terminalsAirline3);
		
		
		
		
		
		EntityTransaction et = em.getTransaction(); 
		et.begin();
		
		
		em.persist(apt);
		em.persist(twr);	
		
		
		em.persist(terminal1);
		em.persist(terminal2);
		em.persist(terminal3);
		
		em.persist(eurowings);
		em.persist(iberia);
		em.persist(tap);
		
		
		
		

		et.commit();
		
		em.close();
		
		
		

	}

}
