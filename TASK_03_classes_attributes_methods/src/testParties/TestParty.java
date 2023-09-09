package testParties;

import party.Party;


/*

Create a Main class (with main method) where you will create several objects of the Party class using several different constructors. 
Put into practice all the methods you have created (invite, consult, cancelInvitation and partyprice).

*/


public class TestParty {

	public static void main(String[] args) {
		
		
		Party party1 = new Party("pajamas", 9, 30, "12.04/20:00", "Avd. Segunda Aguada, 4");
		
		Party party2 = new Party("children's", 30, 75, "07.06/17:00", "Calle Balaidos, 69");
		
		Party party3 = new Party("birthday", 25, 60, "22.10/22:00", "Rúa Príncipe, 33");
		
		
		
		
		System.out.println("-------------PARTY1---------------\n");
		
		party1.invite();
		party1.invite();
		party1.invite();
		party1.invite();
		party1.invite();
		party1.invite();
		party1.invite();
		party1.invite();
		party1.invite();
		
		System.out.println("Guests number before canceling: " + party1.guestNumber());
		
		party1.cancel();
		
		System.out.println("Guests number after canceling: " + party1.guestNumber());
		
		
		System.out.println(party1.consult());
		
		System.out.println(party1.price());
		
		
		
		
		System.out.println("\n-------------PARTY2---------------\n");
		
		party2.invite();
		party2.invite();
		party2.invite();
		party2.invite();
		party2.invite();
		party2.invite();
		party2.invite();
		party2.invite();
		party2.invite();
		party2.invite();
		party2.invite();		
		party2.invite();
		party2.invite();
		
		System.out.println("Guests number before canceling: " + party2.guestNumber());
		
		party2.cancel();
		
		System.out.println("Guests number after canceling: " + party2.guestNumber());
		
		System.out.println(party2.consult());
		
		System.out.println(party2.price());
		
		
		
		
		System.out.println("\n-------------PARTY3---------------\n");
		
		party3.invite();
		party3.invite();
		party3.invite();
		party3.invite();
		party3.invite();
		
		System.out.println("Guests number before canceling: " + party3.guestNumber());
		
		party3.cancel();
		
		System.out.println("Guests number after canceling: " + party3.guestNumber());
		
		
		System.out.println(party3.consult());
		
		System.out.println(party3.price());
		

	}

}
