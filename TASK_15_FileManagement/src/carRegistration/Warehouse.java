package carRegistration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	
	
	private List<Car> carsList;	
	
	
	
	public Warehouse() {
		super();
		this.carsList = new ArrayList<Car>();
	}
	
	
	
	public void addCar(Car car) {
		
		this.carsList.add(car);		
		
	}
	
	
	
	public void deleteCarById(int id) {
		
		for(Car ele: carsList) {			
			
			if(ele.getId() == id){
				
			carsList.remove(ele);									
				
			}else {
				
				System.out.println("Car not found");
				
			}
		
		}	
	
	}	
	
	
	
	
	public String consultCarById(int id) {
		
		for(Car ele: carsList) {			
			
			if (ele.getId() == id) {
				
				System.out.println(ele); 
				
			}
		
		}
		
		return "Not found";
		
	}
	
	
	
	
	public void consultList() {
		
		for(Car ele: carsList) {
			
			System.out.println(ele);
				
				
		}
		
	}
	
	
	public void addCarObject(File fn) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(fn); try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(carsList);
		}
	}
	
	
	
	
	
	
}
