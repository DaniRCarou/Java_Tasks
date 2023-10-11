package exceptions;

import java.time.LocalDate;

public class Movement {
	

        private LocalDate date;

        private String concept;

        private double amount;

        private double balance;
        
        
        

        public Movement(String concept, double amount, double balance) {

                      this.concept = concept;

                      this.amount = amount;

                      this.balance = balance;

                      this.date = LocalDate.now();

       }
        
        
        
        
        
        
        

       @Override

       public String toString() {

                     return date + " Concept=" + concept + ", Amount=" + amount + ", Balance=" + balance;

       }
       
       
       
       
       
       
       
       

}
	
	
	
	
	


