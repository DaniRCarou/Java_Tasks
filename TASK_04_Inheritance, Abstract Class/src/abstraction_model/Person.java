package abstraction_model;

public abstract class Person {
	
	
	
	
	private String nif;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	




	public Person() {
		super();
	}



	public Person(String nif, String name, String address, String phone) {
		super();
		this.nif = nif;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}



	public String getNif() {
		return nif;
	}



	public void setNif(String nif) {
		this.nif = nif;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	// Class methods
	
	
	public String call(Person p) {
		
		return name + " calling " + p.name;	
		
	}
	
	
	
	public abstract String work();
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Person [nif=" + nif + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}

	
	
	
	
	
	
	
	
	

}
