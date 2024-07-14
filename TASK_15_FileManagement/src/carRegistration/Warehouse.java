package carRegistration;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	
	
	private List<Car> carsList;	
	
	
	
	public Warehouse() {
		super();
		this.carsList = new ArrayList<Car>();
	}
	
	
	
	public List<Car> getCarsList() {
		return carsList;
	}



	public void setCarsList(List<Car> carsList) {
		this.carsList = carsList;
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
	
	
	
	
	

	@Override
	public String toString() {
		return "Warehouse [carsList=" + carsList + "]";
	}
	
	
	
	
}
