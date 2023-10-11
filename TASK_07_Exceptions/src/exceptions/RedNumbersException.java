package exceptions;

public class RedNumbersException extends Exception {
	
	
	
	private double amount; // it´s the same type as the money input, through Scanner reader in the main class.

	
	
	
	
	public RedNumbersException(double amount) {
		super("The selected value is bigger than your account content"); // This is the message I want to show if the value is bigger than the account content. You can see this message through the getMessage method.
		this.amount = amount;
	}





	@Override
	public String toString() {
		return "RedNumbersException [amount=" + amount + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
