package test;

import java.util.Scanner;

import exceptions.BankAccount;
import exceptions.RedNumbersException;

public class Main {

	public static void main(String[] args){
		
		

		 	Scanner reader = new Scanner(System.in);
	        
	        
	        
	        

	        System.out.println("-------------------------We are going to create an account and make the first deposit of 100 euros---------------------");
	        
	        
	        

	      
			
	        BankAccount myAccount = new BankAccount(38143, "Amelia González"); 
	        
	        
	        
	      
	    	   
			try {
				
				myAccount.addMovement("Initial income", 100);
				
			} catch (RedNumbersException e1) {
				
				e1.printStackTrace();
			}
			
	       
	       
	       
	       
	       
	       
	       

	       System.out.println("--------------------------------------How much money do you want to withdraw?----------------------------------------- ");
	       
	       
	       

	       int money= 0;

	       try {
	    	   
	       money = Integer.parseInt(reader.nextLine());
	       
	       } catch (NumberFormatException e) {
	    	   
	    	   e.printStackTrace();
	    	   
	       }
	       
	       
	       
	       
	       
	       
	       try {
	    	   
			myAccount.addMovement("withdrawal of funds", money);
			
	       } catch (RedNumbersException e) {

			e.printStackTrace();
			
	       }

	       reader.close();

	       System.out.println(myAccount);

	       System.out.println(myAccount.listMovements());


}

}
