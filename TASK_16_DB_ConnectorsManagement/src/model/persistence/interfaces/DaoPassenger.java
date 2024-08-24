package model.persistence.interfaces;

import java.util.List;

import model.entity.Passenger;

public interface DaoPassenger {
	
	
	
	boolean register(Passenger p);
	
	boolean delete(int id);
	
	Passenger read(int id);
	
	public List<Passenger> list();
	
	boolean addPassToCar(int pId, int cId);
	
	boolean deletePassFromCar(int pId, int cId);
	
	public List<Passenger> listPassFromCar(int id);	
	
	
	

}
