package exceptions;

import java.util.ArrayList;

public class BankAccount {	
	

        private int accountNumber;

        private String customer;

        private double balance;

        private ArrayList<Movement> movements;
        
        
        

        public BankAccount(int accountNumber, String customer) {

                      this.accountNumber = accountNumber;

                      this.customer = customer;

                      this.balance = 0;

                      this.movements = new ArrayList();

         }
        
        
        
        

        public void addMovement(String concept, double amount) throws RedNumbersException {

            this.balance = this.balance + amount;

            if(balance<0) {
         	   
         	   throw new RedNumbersException(amount);
         	   
            }else {
            
            this.movements.add(new Movement(concept, amount, balance));
            
            }

}
         
         
         
         
         public String listMovements() {

             String list = "";

             for (Movement mov : this.movements) {

                      list = list + mov.toString()+"\n";

             }                          

             return list;

         }          
         
         
         
         

       @Override

       public String toString() {

                     return "Number=" + accountNumber + ", Customer=" + customer + "Balance=" + balance;

       }

       
}

