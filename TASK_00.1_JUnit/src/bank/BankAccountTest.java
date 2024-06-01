package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

		
	
	
	
	
	
	// -------------------------------------------------------------------testDeposit------------------------------------------------------------------------------------------------
	
	
	
	// - Deposit() method has to be tested at least two times, because it is possible to enter a positive quantity or a negative quantity.
	// - So, It has to be created two different methods one for a positive number and one for a negative number.
	// - THIS IS THE ENTERED POSITIVE AMOUNT-> At the beginning the name of this method was testDeposit(), now we will call it 'testDeposit_correctPositive()'
	
	@Test
	void testDeposit_Positive() {
		
		
		// fail("Not yet implemented"); // This is a fail line which produce a fail. It has to be changed by changing the code from the class 'BankAccount'
		
		
		
		// - To execute the method from another class, an object from the BankAccount class has to be created.
		
		BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password.
		
		int expectedResult = 3300; // This is what we are expecting
		
		int realResult = ba.deposit(500); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
		
		
				
		// - To compare the results, it is necessary to use the JUnit method, assertEquals.
		// - It is possible to do it, without using the variables, like this: assertEquals(3300, ba.deposit(500)); 
		
		assertEquals(expectedResult,realResult); // If both results are equals, it means that the method is ok
		
	}
	
	
	
	
	
	
	// - THIS IS THE ENTERED NEGATIVE AMOUNT-> At the beginning the name of this method was testDeposit(), now we will call it 'testDeposit_correctNegative()'
		
	@Test
	void testDeposit_Negative() {
		
		// fail("Not yet implemented"); // This is a fail line which produce a fail. It has to be changed by changing the code from the class 'BankAccount'
		
		
		
		
		BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password.
		
		int expectedResult = -1; // This is what we are expecting
		
		int realResult = ba.deposit(-500); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
		
		
				
		// - To compare the results, it is necessary to use the JUnit method, assertEquals.
		// - It is possible to do it, without using the variables, like this: assertEquals(3300, ba.deposit(500)); 
		
		assertEquals(expectedResult,realResult); // If both results are equals, it means that the method is ok		
		
	}
	
	
	
	// ---------------------------------------------------------------------testWithrdraw-------------------------------------------------------------------------------------------------
	
	
	
	// - This method has to be tested, three times at least, because it is possible to have three results. 
	// Cases:
	// 1. If the password is correct and balance >= amount
	// 2. If the password is correct and balance < amount
	// 3. If the password is not correct
	

	@Test
	void testWithrdraw_case1() {
		
		// fail("Not yet implemented");
		
		
		BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password.
		
		int expectedResult =2300; // This is what we are expecting
		
		int realResult = ba.withrdraw(500,"pass"); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
		
		
		assertEquals(expectedResult,realResult);
		
		
	}

	
	
	
	
	@Test
	void testWithrdraw_case2() {
		
		// fail("Not yet implemented");

		
		BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password.
		
		int expectedResult =-1; // This is what we are expecting
		
		int realResult = ba.withrdraw(3000,"pass"); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
		
		
		assertEquals(expectedResult,realResult);
		
				
	}
	
	
	
	
	
	@Test
	void testWithrdraw_case3() {
		
		// fail("Not yet implemented");

		
		BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password.
				
		int expectedResult =-2; // This is what we are expecting
				
		int realResult = ba.withrdraw(3000,"false"); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
				
				
		assertEquals(expectedResult,realResult);
				
				
	}
	
	
	
	// ----------------------------------------------password-----------------------------------------------------------------------------------------------------------------
	
	
	
	// - This method has to be tested two times , because it is possible to have two results, true or false, depending on the password 
	// Cases:
	// 1. If the password is correct. 
	// 3. If the password is not correct.
		
	
	@Test
	void testCorrectPassword_case1() {
		
		// fail("Not yet implemented");
		
		
		BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password.
		
		// boolean expectedResult = true ; // In this case, the result has to be boolean, like it is indicated in the method. In this case must be 'true'
		
		// boolean realResult = ba.correctPassword("pass"); // In this case, the result has to be boolean, like it is indicated in the method. In this case must be 'true'
			
		
		
		// In this case it is compared directly the realResult, with true
		
		assertTrue(ba.correctPassword("pass"));
		
		
		// assertEquals(expectedResult,realResult); -> This is possible too. Here is compared both results
		
		
	}
	
	
	
	
	@Test
	void testCorrectPassword_case2() {
		
		// fail("Not yet implemented");
		
		
		BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password.
		
		// boolean expectedResult = false ; // In this case, the result has to be boolean, like it is indicated in the method. In this case must be 'true'
		
		// boolean realResult = ba.correctPassword("hola"); // In this case, the result has to be boolean, like it is indicated in the method. In this case must be 'true'
		
		
		
		// In this case it is compared directly the realResult, with false
		
		assertFalse(ba.correctPassword("hola"));
				
				
		// assertEquals(expectedResult,realResult); -> This is possible too. Here is compared both results
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
