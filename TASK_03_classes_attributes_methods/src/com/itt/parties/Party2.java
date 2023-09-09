
	
// Place the Party2 class in the com.itt.fiestas package.

package com.itt.parties;





public class Party2 {
	
	
	
	// 1. Creates a static attribute called PartyCounter, whose value will be incremented by one each time a new Party object is built.

	private static int partyCounter = 0;
	
	
	
	
	
	
	/*
	 
 	The project will have a class called Party with the following structure:
	2. All properties will be private.
    3. The type property indicates the type of party: children's, birthday, fancy dress, etc.
    4. The snacks property contains the number of snacks to buy for the party. Same with drinks.
    5. The exercise proposes to store the dateTime as a String to simplify the code. If you feel like investigating, you can try saving it as an object of the LocalDateTime class.
   
    */
	
	
	private String type;
	
	private int snacks;
	
	private int drinks;
	
	private String dateTime;
	
	private String address;
	
	private int guests;

	
	
	
	
	// 6. A constructor will be created, which will receive the type, dateTime, address, drinks and snacks by means of parameters. The guests property will be assigned the value 0 directly.
    
   	
	
	public Party2(String type, int snacks, int drinks, String dateTime, String address) {
		super();
		this.type = type;
		this.snacks = snacks;
		this.drinks = drinks;
		this.dateTime = dateTime;
		this.address = address;
		this.guests = 0;
		this.partyCounter = ++partyCounter;
	}
	
	


	// 7. Another constructor will be created that does not take any parameters. Assign invented values ​​to ach property.
	   


	public Party2() {
		super();
		this.partyCounter = ++partyCounter;
	}	
	
	
	
	
	
	
	// 8. All properties will be accessible via get/set methods.
	
	
		
	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public int getSnacks() {
		return snacks;
	}





	public void setSnacks(int snacks) {
		this.snacks = snacks;
	}





	public int getDrinks() {
		return drinks;
	}





	public void setDrinks(int drinks) {
		this.drinks = drinks;
	}





	public String getDateTime() {
		return dateTime;
	}





	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public int getGuests() {
		return guests;
	}





	public void setGuests(int guests) {
		this.guests = guests;
	}
	
	
	
	// 9. In this case it will not have a set method so that it cannot be modified. It will only have "get"
		
	
	public static int getPartyCounter() {
		return partyCounter;
	}
	
	
      
   // 10. The query() method will return a string with all the party data.    
   	
	
	public String consult(){		
				
		return   "Type of party: " + type + ", date and time: " + dateTime + ", adress: " + address + ", guests number: " + guests + ", drinks: " + drinks + ", snacks: " + snacks;
			
	}
	
	
	
	// 11. The invite() method will add 1 to the guest count.	
	
	
	public void invite(){
		
		guests ++;
		
	}
	
	
	
	
	// 12. Overloads the invite method so that the user can make more than one invitation at a time by indicating the number of guests as an argument.


	public void invite(int guestNumber){
		
		this.guests += guestNumber;
		
	}
	
	
	
	// 13. The cancelInvitation() method will subtract 1 from the guest count.
		
	
	public void cancel() {
		
		guests --;
		
	}
	
	
	
	// 14. The PartyPrice() method will return the price of the party calculated as follows: 5 euros for each guest, 2 euros for each drink and 3 euros for each sandwich.

	
	public String price() {
		
		return "Price: " + (5*guests + 2*drinks + 3*snacks) + " euros";
		
	}
	
	
	
	// 15. EXTRA. The guestsNumber() method will return the number of guests
	
	
	public int guestNumber() {
		
		return guests;
		
	}




	@Override
	public String toString() {
		return "Party2 [type=" + type + ", snacks=" + snacks + ", drinks=" + drinks + ", dateTime=" + dateTime
				+ ", address=" + address + ", guests=" + guests + "]";
	}
	
	
	
	
	
	
	

}
