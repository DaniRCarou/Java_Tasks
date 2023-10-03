package abstraction_model;

public class Administrative extends Person {
	
	
	
	
	
	private String tasks;
	
	
	
	
	
	
	
	public Administrative(String nif, String name, String address, String phone, String tasks) {
		super(nif, name, address, phone);
		this.tasks = tasks;
	}




	public String getTasks() {
		return tasks;
	}
	
	
	

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

	
	
	
	
	@Override
	public String work() {
		
		return "Administrative " + getName() + " will do the tasks: " + tasks;
		
	}

	
	
	
	
	
	
	
	// Class methods
	
	public String registrationManage() {
				
		return "Administrative " + getName() + " is going to manage a registration";
	
	}




	
	
	@Override
	public String toString() {
		return "Administrative [Nif: " + getNif() + ", Name: " + getName() + ", Address: "
				+ getAddress() + ", Phone: " + getPhone() + " Tasks: " + tasks + "]";
	}
	
	
	
	
 	 
	
	
	
	
	

}
