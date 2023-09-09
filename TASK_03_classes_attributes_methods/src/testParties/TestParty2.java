package testParties;

import com.itt.parties.Party2;

import party.Party;


/*

Create a Main class (with main method) where you will create several objects of the Party class using several different constructors. 
Put into practice all the methods you have created (invite, consult, cancelInvitation and partyprice).
Modify the Main class so that you can implement the changes introduced in this version 2.

*/


public class TestParty2 {

	public static void main(String[] args) {
		
		
		Party2 party1 = new Party2("pajamas", 9, 30, "12.04/20:00", "Avd. Segunda Aguada, 4");
		
		Party2 party2 = new Party2("children's", 30, 75, "07.06/17:00", "Calle Balaidos, 69");
		
		Party2 party3 = new Party2("birthday", 25, 60, "22.10/22:00", "Rúa Príncipe, 33");
		
		
		
		
		
		System.out.println("-------------PARTIES---------------\n");
		
		System.out.println("Total party number: " + party3.getPartyCounter() + "\n");
		
		
		
		System.out.println("-------------GUESTS PARTY1---------------\n");
		
		party1.invite(30);
		
		System.out.println("Guest number party1: " + party1.getGuests() + "\n");
		
		
		
		
		System.out.println("-------------GUESTS PARTY2---------------\n");
		
		party2.invite(10);
		
		System.out.println("Guest number party1: " + party2.getGuests() + "\n");
		
		
		
		
		System.out.println("-------------GUESTS PARTY3---------------\n");
		
		party3.invite(200);
		
		System.out.println("Guest number party1: " + party3.getGuests());

	}

}
