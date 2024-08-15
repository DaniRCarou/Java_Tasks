package model.persistence.interfaces;

import java.util.List;

import model.entity.Car;

public interface DaoCar {
	
	
	
	boolean register(Car c);
	
	Car read(int id);	
	
	boolean update(Car c);
	
	boolean delete(int id);
	
	public List<Car> list();
	
	

}
