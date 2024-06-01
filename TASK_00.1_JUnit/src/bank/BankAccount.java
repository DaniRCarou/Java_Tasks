package bank;

public class BankAccount {
	
	
	private int balance;
	private String password;
	
	
	
	
	
	public BankAccount(int balance, String password) {
		super();
		
		this.balance = balance;
		
		this.password = password;
		
	}
	
	
	
	public int deposit(int amount) {
		
		if(amount > 0) {
			
			balance += amount;
			
			return balance;
			
			
		} else
			
			return -1;
		
		
	}
	
	
	
	
	
	public int  withrdraw(int amount, String pass) {
		
		if (correctPassword(pass)) {
			
			if(balance >= amount) {
				
				balance -= amount;
				
				return balance;
				
			}else 
				
				return -1;
			
			
		}else 
			
			return -2;
		
	
	}	
		
	



	public boolean correctPassword(String pass) {
		
		return password.equals(pass);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
